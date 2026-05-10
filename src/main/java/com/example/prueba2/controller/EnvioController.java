package com.example.prueba2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba2.DTO.EnvioDTO;
import com.example.prueba2.model.Envio;
import com.example.prueba2.service.EnvioService;

@RestController
@RequestMapping("/api/v1/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    //Mostrar Los Envios
    @GetMapping
    public ResponseEntity<List<EnvioDTO>> todosLosEnvios(){
        List<EnvioDTO> envios = envioService.obtenerTodos();
        if(envios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(envios, HttpStatus.OK);
    }

    //Buscar por Id
    @GetMapping("/{id}")
    public ResponseEntity<EnvioDTO> buscarPorId(@PathVariable Integer id){
        try {
            EnvioDTO envio = envioService.buscarPorId(id);
            return new ResponseEntity<>(envio, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    
    //Guardar Envio
    @PostMapping
    public ResponseEntity<Envio> agregarEnvio(@RequestBody Envio envio) {
        try {
            Envio guardado = envioService.guardarEnvio(envio);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    //Editar Envio
    @PatchMapping("/{id}")
    public ResponseEntity<Envio> editarCliente(@PathVariable Integer id, @RequestBody Envio envio) {
        try {
            Envio editado = envioService.guardarEnvio(envio);
            return new ResponseEntity<>(editado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Actualizar Envio
    @PutMapping("/{id}")
    public ResponseEntity<Envio> actualizarEnvio(@PathVariable Integer id, @RequestBody Envio envio){
        try{
            Envio newEnvio = envioService.actualizarEnvio(id, envio);
            return new ResponseEntity<>(newEnvio, HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar Envio
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEnvio(@PathVariable Integer id) {
        String resultado = envioService.eliminarEnvio(id);
        
        // Si el mensaje contiene "exitosamente", es un éxito
        if (resultado.contains("exitosamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }


}

