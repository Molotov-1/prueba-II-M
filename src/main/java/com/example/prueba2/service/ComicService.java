package com.example.prueba2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba2.DTO.ComicDTO;
import com.example.prueba2.model.Comic;
import com.example.prueba2.repository.ComicRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComicService {

    @Autowired
    private ComicRepository comicRepository;
    
    //Mostrar todos los comics
    public List<ComicDTO> obtenerTodos() {
        return comicRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    //Eliminar por Id
    public String eliminarComic(Integer id){
        try {
            Comic comic = comicRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Imposible eliminar el comic! El Comic con ID " + id + "no existe"));
            comicRepository.delete(comic);
            return "El Comic '" + comic.getTitulo() + "' ha sido eliminado correctamente. ";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
    
    //Guardar comic
    public Comic guardarComic(Comic comic){
        return comicRepository.save(comic);
    }


    //Actualizar comic
    public Comic actualizarComics(Integer id, Comic comic){
        Comic comic1 = comicRepository.findById(id).orElseThrow(() -> new RuntimeException("¡El Comic no existe en los registros!"));
        if(comic1.getTitulo() != null){
            comic1.setTitulo(comic1.getTitulo());
        }
        if(comic1.getISBN() != null){
            comic1.setISBN(comic1.getISBN());
        }
        if(comic1.getGenero() != null){
            comic1.setGenero(comic1.getGenero());
        }
        if(comic1.getPrecio() != null){
            comic1.setPrecio(comic1.getPrecio());
        }
        if(comic1.getFechaPublicacion() != null){
            comic1.setFechaPublicacion(comic1.getFechaPublicacion());
        }
        if(comic1.getStock() != null){
            comic1.setStock(comic1.getStock());
        }
        return comicRepository.save(comic1);
    }

    //Buscar por Nombre
    public List<ComicDTO> buscarPorTitulo(String titulo){
        return comicRepository.findByTitulo(titulo).stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    //Buscar por id
    public ComicDTO buscarPorId(Integer id) {
        Comic comic = comicRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Comic no encontrado!"));
        return convertirADTO(comic);
    }


    //convertir a dto
    private ComicDTO convertirADTO(Comic comic){
        ComicDTO dto = new ComicDTO();
        dto.setId(comic.getId());
        dto.setTitulo(comic.getTitulo());
        dto.setISBN(comic.getISBN());
        dto.setGenero(comic.getGenero());
        dto.setPrecio(comic.getPrecio());
        dto.setFechaPublicacion(comic.getFechaPublicacion());
        dto.setStock(comic.getStock());
        return dto;
    }



}