package com.example.prueba2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.prueba2.DTO.PagoDTO;
import com.example.prueba2.model.Pago;
import com.example.prueba2.repository.PagoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;


    public PagoDTO buscarPorId(Integer id) {
        Pago pago = pagoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Pago no encontrado!"));
        return convertirADTO(pago);
    }

    public String eliminar(Integer id) {
        try {
            Pago pago = pagoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar! El pago con ID " + id + " no existe."));
            pagoRepository.delete(pago);
            return "El pago '" + pago.getDescripcion() + "' ha sido eliminado exitosamente.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public Pago guardarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago actualizarPago(Integer id, Pago pagoActualizado) {
        Pago pagoExistente = pagoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Pago no encontrado!"));
        pagoExistente.setDescripcion(pagoActualizado.getDescripcion());
        pagoExistente.setMonto_total(pagoActualizado.getMonto_total());
        return pagoRepository.save(pagoExistente);
    }


    private PagoDTO convertirADTO(Pago pago){
        PagoDTO pagoDTO = new PagoDTO();
        pagoDTO.setId_pago(pago.getId_pago());
        pagoDTO.setDescripcion(pago.getDescripcion());
        pagoDTO.setMonto_total(pago.getMonto_total());
        return pagoDTO;
    }

}