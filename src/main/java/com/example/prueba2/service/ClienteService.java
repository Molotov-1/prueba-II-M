package com.example.prueba2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.prueba2.DTO.ClienteDTO;
import com.example.prueba2.model.Cliente;
import com.example.prueba2.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    public String eliminarcliente(Integer id){
        try {
            Cliente cliente = clienteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar al Cliente! El Cliente con ID " + id + "no existe"));
            clienteRepository.delete(cliente);
            return "El Cliente '" + cliente.getNombre() + "' ha sido eliminado correctamente. ";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
    
    public List<ClienteDTO> obtenerTodos() {
        return clienteRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }



    //Guardar comic
    public Cliente guardarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }


    //Actualizar comic
    public Cliente actualizarclientes(Integer id, Cliente cliente){
        Cliente cliente1 = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("¡El Cliente no existe en los registros!"));
        if(cliente1.getNombre() != null){
            cliente1.setNombre(cliente1.getNombre());
        }
        if(cliente1.getApellido() != null){
            cliente1.setApellido(cliente1.getApellido());
        }
        if(cliente1.getEdad() != null){
            cliente1.setEdad(cliente1.getEdad());
        }
        if(cliente1.getCorreo() != null){
            cliente1.setCorreo(cliente1.getCorreo());
        }
        if(cliente1.getTelefono() != null){
            cliente1.setTelefono(cliente1.getTelefono());
        }
        if(cliente1.getDireccion() != null){
            cliente1.setDireccion(cliente1.getDireccion());
        }
        return clienteRepository.save(cliente1);
    }

    //Buscar por Rut
    public List<ClienteDTO> buscarPorRut(String rut) {
        Cliente cliente = clienteRepository.findByRut(rut);
        if (cliente != null) {
            return List.of(convertirADTO(cliente));
        } else {
            return List.of();
        }
    }

    public ClienteDTO buscarPorId(Integer id) {
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Cliente no encontrado!"));
        return convertirADTO(cliente);
    }

    private ClienteDTO convertirADTO(Cliente cliente){
        ClienteDTO dto = new ClienteDTO();
        dto.setId_cliente(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setRut(cliente.getRut());
        dto.setCorreo(cliente.getCorreo());
        dto.setTelefono(cliente.getTelefono());
        dto.setDireccion(cliente.getDireccion());
        dto.setDv(cliente.getDv());
        return dto;
    }
}
