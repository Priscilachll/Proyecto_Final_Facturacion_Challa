package com.proyecto2.API.Rest;

import jakarta.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio; // Cambiado a "precio"
    private int stock;

    // Constructores (vacío y con parámetros)
    public Producto() {}

    public Producto(String nombre, double precio, int stock) { // Cambiado a "precio"
        this.nombre = nombre;
        this.precio = precio; // Cambiado a "precio"
        this.stock = stock;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() { // Cambiado a "precio"
        return precio;
    }

    public void setPrecio(double precio) { // Cambiado a "precio"
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}