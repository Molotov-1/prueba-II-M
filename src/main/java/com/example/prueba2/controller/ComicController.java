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

import com.example.prueba2.DTO.ComicDTO;
import com.example.prueba2.model.Comic;
import com.example.prueba2.service.ComicService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/comics")
public class ComicController {

    @Autowired
    private ComicService comicService;

    @GetMapping
    public ResponseEntity<List<ComicDTO>> todosLosComic(){
        log.info("Obteniendo todos los comics");
        List<ComicDTO> comics = comicService.obtenerTodos();
        if(comics.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(comics, HttpStatus.OK);
    }

    //Buscar por Id
    @GetMapping("/{id}")
    public ResponseEntity<ComicDTO> buscarPorId(@PathVariable Integer id){
        log.info("Buscando comic con ID: {}", id);
        try {
            ComicDTO comic = comicService.buscarPorId(id);
            return new ResponseEntity<>(comic, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Error al buscar comic con ID: {}: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    //Buscar por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ComicDTO> buscarPorTitulo(@PathVariable String titulo){
        log.info("Buscando comic con título: {}", titulo);
        List<ComicDTO> comics = comicService.buscarPorTitulo(titulo);
        if(comics.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }    
        return new ResponseEntity<>(HttpStatus.OK);
    }  
    
    //Guardar comic
    @PostMapping
    public ResponseEntity<Comic> agregarComic(@Valid @RequestBody Comic comic) {
        log.info("Agregando nuevo comic: {}", comic);
        try {
            Comic guardado = comicService.guardarComic(comic);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al agregar comic: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    //Editar comic
    @PatchMapping("/{id}")
    public ResponseEntity<Comic> editarComic(@PathVariable Integer id, @Valid @RequestBody Comic comic) {
        log.info("Editando comic con ID: {}", id);
        try {
            Comic editado = comicService.guardarComic(comic);
            return new ResponseEntity<>(editado, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Error al editar comic con ID: {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Actualizar comic
    @PutMapping("/{id}")
    public ResponseEntity<Comic> actualizarComic(@PathVariable Integer id, @Valid @RequestBody Comic comic){
        log.info("Actualizando comic con ID: {}", id);
        try{
            Comic newComic = comicService.actualizarComics(id, comic);
            return new ResponseEntity<>(newComic, HttpStatus.OK);
        }catch (RuntimeException e) {
            log.error("Error al actualizar comic con ID: {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar comic
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Integer id) {
        log.info("Eliminando comic con ID: {}", id);
        String resultado = comicService.eliminarComic(id);

        if (resultado.contains("exitosamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }


}