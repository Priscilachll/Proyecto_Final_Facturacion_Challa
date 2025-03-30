package com.proyecto2.API.Rest;

import java.util.List;

public class VentaRequestDTO {
    private ClienteDTO cliente;
    private List<LineaDeVentaDTO> lineas;

    //---------getters y setters------------------
    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public List<LineaDeVentaDTO> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaDeVentaDTO> lineas) {
        this.lineas = lineas;
    }
}
