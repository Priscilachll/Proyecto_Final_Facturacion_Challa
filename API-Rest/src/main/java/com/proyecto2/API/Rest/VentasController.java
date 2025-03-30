package com.proyecto2.API.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    //----------------------------GET-------------------------------
    @GetMapping
    public ResponseEntity<List<Ventas>> obtenerTodasLasVentas() {
        List<Ventas> ventas = ventasService.obtenerTodasLasVentas();
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ventas> obtenerVentaPorId(@PathVariable Long id) {
        Ventas venta = ventasService.obtenerVentaPorId(id);
        if (venta == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(venta, HttpStatus.OK);
    }

    //----------------------------POST-------------------------------
    @PostMapping
    public ResponseEntity<Ventas> crearVenta(@RequestBody VentaRequestDTO ventaDTO) {
        // Mapear VentaRequestDTO a Ventas y LineaDeVenta
        Ventas venta = mapearVentaDTOaVentas(ventaDTO);
        Ventas ventaCreada = ventasService.crearVenta(venta);
        return new ResponseEntity<>(ventaCreada, HttpStatus.CREATED);
    }

    // Método auxiliar para mapear VentaRequestDTO a Ventas
    private Ventas mapearVentaDTOaVentas(VentaRequestDTO ventaDTO) {
        Ventas venta = new Ventas();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(ventaDTO.getCliente().getClienteid());
        venta.setCliente(cliente);

        List<LineaDeVenta> lineas = new java.util.ArrayList<>();
        for (LineaDeVentaDTO lineaDTO : ventaDTO.getLineas()) {
            LineaDeVenta linea = new LineaDeVenta();
            Producto producto = new Producto();
            producto.setId(lineaDTO.getProducto().getProductoid());
            linea.setProducto(producto);
            linea.setCantidad(lineaDTO.getCantidad());
            lineas.add(linea);
        }
        venta.setLineas(lineas);
        return venta;
    }

    //-----------------------PUT-------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<Ventas> actualizarVenta(@PathVariable Long id, @RequestBody Ventas venta) {
        venta.setIdTransaccion(id);
        Ventas ventaActualizada = ventasService.actualizarVenta(venta);
        if (ventaActualizada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ventaActualizada, HttpStatus.OK);
    }

    //----------------------DELETE------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id) {
        ventasService.eliminarVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}