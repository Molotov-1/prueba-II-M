package com.example.prueba2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.prueba2.model.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

    @Query("SELECT t FROM Tienda t WHERE t.nombre_tienda = :nombre")
    Tienda buscarPorNombreExacto(@Param("nombre") String nombre);
}
