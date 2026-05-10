package com.example.prueba2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba2.DTO.ClienteDTO;
import com.example.prueba2.model.Cliente;
import com.example.prueba2.model.Comic;
import com.example.prueba2.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepositoy; 
    
    
    public List<ClienteDTO> obtenerTodos() {
        return clienteRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    //Eliminar por Id
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
    



    //Guardar comic
    public Cliente guardarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }


    //Actualizar comic
    public Cliente actualizarclientes(Integer id, Cliente cliente){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("¡El Cliente no existe en los registros!"));
        if(cliente.getNombre() != null){
            cliente.setNombre(cliente.getNombre());
        }
        if(cliente.getApellido() != null){
            cliente.setApellido(cliente.getApellido());
        }
        if(cliente.getEdad() != null){
            cliente.setEdad(cliente.getEdad());
        }
        if(cliente.getCorreo() != null){
            cliente.setCorreo(cliente.getCorreo());
        }
        if(cliente.getTelefono() != null){
            cliente.setTelefono(cliente.getTelefono());
        }
        if(cliente.getDireccion() != null){
            cliente.setDireccion(cliente.getDireccion());
        }
        return clienteRepository.save(cliente);
    }

    //Buscar por Rut
    public List<ClienteDTO> buscarPorRut(String Rut){
        return clienteRepository.findByRut(Rut).stream()
                 .map(this::convertirADTO)
                 .toList();
    }

     //Buscar por id
    public ClienteDTO buscarPorId(Integer id) {
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Cliente no encontrado!"));
        return convertirADTO(cliente);
    }




    private ClienteDTO convertirADTO(Cliente cliente){
        ClienteDTO dto = new ClienteDTO();
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setEdad(cliente.getEdad());
        dto.setRut(cliente.getRut());
        dto.setDv(cliente.getDv());
    }
}
