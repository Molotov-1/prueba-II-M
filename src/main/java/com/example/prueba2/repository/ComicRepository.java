package com.example.prueba2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.prueba2.model.Comic;
import java.util.List;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Integer> {
    
    Comic findByISBN(String ISBN);

    List<Comic> findByGenero(String genero);

    List<Comic> findByTitulo(String titulo);
}