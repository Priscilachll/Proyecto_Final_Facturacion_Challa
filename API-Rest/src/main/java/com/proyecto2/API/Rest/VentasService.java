package com.proyecto2.API.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private LineaDeVentaRepository lineaDeVentaRepository;

    public Ventas crearVenta(Ventas venta) {
        // Validar cliente
        Cliente cliente = clienteService.obtenerClientePorId(venta.getCliente().getIdCliente());
        if (cliente == null) {
            throw new ClienteNotFoundException("Cliente no encontrado");
        }

        // Validar productos y stock
        List<String> errores = new ArrayList<>();
        for (LineaDeVenta linea : venta.getLineas()) {
            Producto producto = productoService.obtenerProductoPorId(linea.getProducto().getId());
            if (producto == null) {
                errores.add("Producto no encontrado: " + linea.getProducto().getId());
            } else if (producto.getStock() < linea.getCantidad()) {
                errores.add("Stock insuficiente para el producto: " + producto.getId());
            }
        }

        if (!errores.isEmpty()) {
            // Manejar errores de validación
            // Puedes lanzar una excepción personalizada o devolver un objeto con los errores
            throw new RuntimeException("Errores de validación: " + errores);
        }

        // Obtener fecha del servicio externo
        LocalDateTime fecha;
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://worldclockapi.com/api/json/utc/now";
            String response = restTemplate.getForObject(url, String.class);
            // Parsear la respuesta para obtener la fecha
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            fecha = LocalDateTime.parse(response.substring(response.indexOf("datetime\":\"") + 11, response.indexOf("utc_offset\":\"") - 2), formatter);
        } catch (Exception e) {
            // Usar fecha local si falla el servicio externo
            fecha = LocalDateTime.now();
        }

        // Calcular total y cantidad de productos
        double total = 0;
        int cantidadProductos = 0;
        for (LineaDeVenta linea : venta.getLineas()) {
            Producto producto = productoService.obtenerProductoPorId(linea.getProducto().getId());
            total += producto.getPrecio() * linea.getCantidad();
            cantidadProductos += linea.getCantidad();
        }

        venta.setFechaCompra(fecha);
        venta.setTotal(total);
        venta.setCantidadProductos(cantidadProductos);

        // Guardar venta y líneas de venta
        Ventas ventaGuardada = ventasRepository.save(venta);
        for (LineaDeVenta linea : venta.getLineas()) {
            linea.setVenta(ventaGuardada);
            lineaDeVentaRepository.save(linea);
            // Reducir stock
            Producto producto = productoService.obtenerProductoPorId(linea.getProducto().getId());
            producto.setStock(producto.getStock() - linea.getCantidad());
            productoService.actualizarProducto(producto);
        }

        return ventaGuardada;
    }

    public List<Ventas> obtenerTodasLasVentas() {
        return ventasRepository.findAll();
    }

    public Ventas obtenerVentaPorId(Long id) {
        return ventasRepository.findById(id).orElse(null);
    }

    public Ventas actualizarVenta(Ventas venta) {
        return ventasRepository.save(venta);
    }

    public void eliminarVenta(Long id) {
        ventasRepository.deleteById(id);
    }


}