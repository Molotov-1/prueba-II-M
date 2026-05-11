package com.example.prueba2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.prueba2.repository.TiendaRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.ArrayList;
import com.example.prueba2.DTO.TiendaDTO;
import com.example.prueba2.model.Tienda;

@Slf4j
@Service
@Transactional
public class TiendaService {

    @Autowired
    private TiendaRepository TiendaRepository;

    public List<TiendaDTO> listarTiendas(){
        log.info("Listando tiendas");
        List<Tienda> tiendas = TiendaRepository.findAll();
        List<TiendaDTO> tiendaDTOs = new ArrayList<>();
        for(Tienda tienda : tiendas){
            TiendaDTO tiendaDTO = new TiendaDTO();
            tiendaDTO.setNombre(tienda.getNombre_tienda());
            tiendaDTO.setDireccion(tienda.getDireccion_tienda());
            tiendaDTOs.add(tiendaDTO);
        }
        return tiendaDTOs;
    }

    public TiendaDTO convertirADTO(Tienda tienda){
        TiendaDTO tiendaDTO = new TiendaDTO();
        tiendaDTO.setId_tienda(tienda.getId_tienda());
        tiendaDTO.setNombre(tienda.getNombre_tienda());
        tiendaDTO.setDireccion(tienda.getDireccion_tienda());
        return tiendaDTO;
    }
}
