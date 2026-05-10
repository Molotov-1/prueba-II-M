package com.example.prueba2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba2.DTO.EnvioDTO;
import com.example.prueba2.model.Envio;
import com.example.prueba2.repository.EnvioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;
    
    //Mostrar todos los Envios
    public List<EnvioDTO> obtenerTodos() {
        return envioRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    //Eliminar por Id
    public String eliminarEnvio(Integer id){
        try {
            Envio envio = envioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar el envio! El Envio con ID " + id + "no existe"));
            envioRepository.delete(envio);
            return "El Envio '" + envio.getIdEnvio() + "' ha sido eliminado correctamente. ";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
    
    //Guardar Envio
    public Envio guardarEnvio(Envio envio){
        return envioRepository.save(envio);
    }


    //Actualizar Envio
    public Envio actualizarEnvio(Integer id, Envio envio){
        Envio envio1 = envioRepository.findById(id).orElseThrow(() -> new RuntimeException("¡El Envio no existe en los registros!"));
        if(envio1.getFechaSalida() != null){
            envio1.setFechaSalida(envio1.getFechaSalida());
        }
        if(envio1.getFechaEntrega() != null){
            envio1.setFechaEntrega(envio1.getFechaEntrega());
        }
        if(envio1.getTipoEnvio() != null){
            envio1.setTipoEnvio(envio1.getTipoEnvio());;
        }
        if(envio1.getSucursal() != null){
            envio1.setSucursal(envio1.getSucursal());;
        }
        return envioRepository.save(envio1);
    }

    //Buscar por id
    public EnvioDTO buscarPorId(Integer id) {
        Envio envio = envioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Envio no encontrado!"));
        return convertirADTO(envio);
    }


    //convertir a dto
    private EnvioDTO convertirADTO(Envio envio){
        EnvioDTO dto = new EnvioDTO();
        dto.setIdEnvio(envio.getIdEnvio());
        dto.setFechaSalida(envio.getFechaSalida());
        dto.setFechaEntrega(envio.getFechaEntrega());
        dto.setTipoEnvio(envio.getTipoEnvio());
        dto.setSucursal(envio.getSucursal());
        return dto;
    }
    
}