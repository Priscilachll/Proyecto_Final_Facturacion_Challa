package com.proyecto2.API.Rest;

import jakarta.persistence.*;

@Entity
public class LineaDeVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineaId;
    @ManyToOne
    private Ventas venta;
    @ManyToOne
    private Producto producto;
    private int cantidad;

    // Getters y setters
    public Long getLineaId() {
        return lineaId;
    }

    public void setLineaId(Long lineaId) {
        this.lineaId = lineaId;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}