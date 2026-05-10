package com.example.prueba2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba2.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{ 
    Cliente findByRut(String rut);
    Cliente findByCorreo(String correo);
}