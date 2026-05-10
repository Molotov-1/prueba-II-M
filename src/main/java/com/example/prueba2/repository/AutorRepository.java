package com.example.prueba2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba2.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

List<Autor> findByNombre(String nombre);
}
