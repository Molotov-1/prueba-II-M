package com.example.prueba2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.prueba2.DTO.TiendaDTO;
import com.example.prueba2.service.TiendaService;


@RestController
@RequestMapping("/api/v1/tienda")
public class TiendaController {
    @Autowired
    private TiendaService tiendaService;

    @GetMapping("/listar")
    public ResponseEntity<List<TiendaDTO>> listarTiendas(){
        List<TiendaDTO> tiendas = tiendaService.listarTiendas();
        return new ResponseEntity<>(tiendas, HttpStatus.OK);
    }
}