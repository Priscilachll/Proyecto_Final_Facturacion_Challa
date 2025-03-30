package com.proyecto2.API.Rest;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaccion;

    private int cantidad;

    private LocalDateTime fechaCompra;

    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "venta")
    private List<LineaDeVenta> lineas;

    private double total; // Nuevo atributo
    private int cantidadProductos; // Nuevo atributo

    // Constructores (vacío y con parámetros)
    public Ventas() {
    }

    public Ventas(int cantidad, LocalDateTime fechaCompra, BigDecimal precioUnitario, Producto producto, Cliente cliente, List<LineaDeVenta> lineas, double total, int cantidadProductos) {
        this.cantidad = cantidad;
        this.fechaCompra = fechaCompra;
        this.precioUnitario = precioUnitario;
        this.producto = producto;
        this.cliente = cliente;
        this.lineas = lineas;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
    }

    // Getters y setters
    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<LineaDeVenta> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaDeVenta> lineas) {
        this.lineas = lineas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }
}