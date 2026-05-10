package com.example.prueba2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba2.model.Comic;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Integer> {
}