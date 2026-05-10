package com.example.prueba2.service;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.prueba2.repository.TiendaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.ArrayList;
import com.example.prueba2.DTO.TiendaDTO;
import com.example.prueba2.model.Tienda;

@Service
@Transactional
public class TiendaService {

    @Autowired
    private TiendaRepository TiendaRepository;

    public List<TiendaDTO> listarTiendas(){
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
=======
public class TiendaService {

>>>>>>> 19cda1a08d176aedcdcc4694562632ca14c9a1bb
}
