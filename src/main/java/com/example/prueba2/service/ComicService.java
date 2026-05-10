package com.example.prueba2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Comic comic = comicRepository.findById(id).orElseThrow(() -> new RuntimeException("¡El Comic no existe en los registros!"));
        if(comic.getTitulo() != null){
            comic.setTitulo(comic.getTitulo());
        }
        if(comic.getISBN() != null){
            comic.setISBN(comic.getISBN());
        }
        if(comic.getGenero() != null){
            comic.setGenero(comic.getGenero());
        }
        if(comic.getPrecio() != null){
            comic.setPrecio(comic.getPrecio());
        }
        if(comic.getFechaPublicacion() != null){
            comic.setFechaPublicacion(comic.getFechaPublicacion());
        }
        if(comic.getStock() != null){
            comic.setStock(comic.getStock());
        }
        return comicRepository.save(comic);
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
    }



}

>>>>>>> 19cda1a08d176aedcdcc4694562632ca14c9a1bb
