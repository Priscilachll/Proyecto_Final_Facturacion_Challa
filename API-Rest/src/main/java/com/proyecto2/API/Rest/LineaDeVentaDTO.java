package com.proyecto2.API.Rest;

public class LineaDeVentaDTO {
    private int cantidad;
    private ProductoDTO producto;

    //---------------getters y setters---------------------

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }
}
