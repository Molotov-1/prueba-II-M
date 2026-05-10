package com.example.prueba2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.prueba2.model.Editorial;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
}