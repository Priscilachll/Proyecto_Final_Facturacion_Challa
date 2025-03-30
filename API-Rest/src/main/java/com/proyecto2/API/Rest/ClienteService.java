package com.proyecto2.API.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerClientePorId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            throw new ClienteNotFoundException("Cliente no encontrado con ID: " + id);
        }
    }

    public Cliente crearCliente(Cliente cliente) {
        // Aquí puedes agregar validaciones si es necesario
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(Cliente cliente) {
        // Aquí puedes agregar validaciones si es necesario
        Optional<Cliente> clienteOptional = clienteRepository.findById(cliente.getIdCliente());
        if (clienteOptional.isPresent()) {
            return clienteRepository.save(cliente);
        } else {
            throw new ClienteNotFoundException("Cliente no encontrado con ID: " + cliente.getIdCliente());
        }
    }

    public void eliminarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new ClienteNotFoundException("Cliente no encontrado con ID: " + id);
        }
    }
}