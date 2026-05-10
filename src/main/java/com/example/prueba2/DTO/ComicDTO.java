package com.example.prueba2.DTO;

import java.time.LocalDate;
import java.util.Date;

public class ComicDTO {
    public Integer id;
    public String titulo;
    public String editorial;
    public String autor;
    public String genero;
    public Double precio;
    public Integer stock;
    public Date fechaPublicacion;

    public void setFechaPublicacion(LocalDate fechaPublicacion2) {
        throw new UnsupportedOperationException("Unimplemented method 'setFechaPublicacion'");
    }
    public void setId(Integer id2) {
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
    public void setTitulo(String titulo2) {
        throw new UnsupportedOperationException("Unimplemented method 'setTitulo'");
    }
    public void setISBN(String isbn) {
        throw new UnsupportedOperationException("Unimplemented method 'setISBN'");
    }
    public void setGenero(String genero2) {
        throw new UnsupportedOperationException("Unimplemented method 'setGenero'");
    }
    public void setPrecio(Double precio2) {
        throw new UnsupportedOperationException("Unimplemented method 'setPrecio'");
    }
    public void setStock(Integer stock2) {
        throw new UnsupportedOperationException("Unimplemented method 'setStock'");
    }
}
