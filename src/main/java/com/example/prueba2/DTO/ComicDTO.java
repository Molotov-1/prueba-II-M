package com.example.prueba2.DTO;


import java.time.LocalDate;

import lombok.Data;

@Data
public class ComicDTO {
    public Integer id;
    public String titulo;
    public String ISBN;
    public String editorial;
    public String autor;
    public String genero;
    public Double precio;
    public Integer stock;
    public LocalDate fechaPublicacion;


}
