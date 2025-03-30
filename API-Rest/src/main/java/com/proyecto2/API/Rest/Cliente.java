package com.proyecto2.API.Rest; //UBICACION

import jakarta.persistence.*; //Importación de la biblioteca JPA

@Entity //transforma la clase Cliente en una tabla
public class Cliente {

    //---------------------------ATRIBUTOS--------------------------------------------
    @Id //indica que sera el id de la tabla Cliente
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que generará automáticamente el valor de la clave primaria
    private Long idCliente;

    private String nombre;

    private String apellido;

    private String dni;

    //---------------------Constructores (vacío y con parámetros lo requiere el JPA)------------------------------------
    public Cliente() {}

    //--------------------Constructor con parámetros-----------------------------------------
    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    // Getters y setters
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Long getClienteId() {
        return idCliente;
    }
}