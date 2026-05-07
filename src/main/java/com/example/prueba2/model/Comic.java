package com.example.prueba2.model;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comics")
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank (message = "El titulo es obligatorio")
    @Size(min = 3, max = 100, message = "El titulo debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotBlank (message = "El ISBN es obligatorio")
    @Size(min = 10, max = 13, message = "El ISBN debe tener entre 10 y 13 caracteres")
    @Column(nullable = false, length = 13)
    private String ISBN;

    @NotBlank (message = "El genero es obligatorio")
    @Size(min = 3, max = 100, message = "El genero debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String genero;

    @NotBlank (message = "El precio es obligatoria")
    @Size(min = 4, max = 50, message = "El precio debe tener al menos 4 caracteres")
    @Column(nullable = false, length = 50)
    private Double precio;

    @NotBlank (message = "la fecha de publicacion es obligatoria")
    @Column(nullable = false)
    private LocalDate fechaPublicacion;

    @NotBlank (message = "El stock es obligatorio")
    @Column(nullable = false)
    private Integer stock;

    @ManyToMany(mappedBy = "comics")
    @ToString.Exclude
    private List<Editorial> editoriales;
    
    @ManyToMany(mappedBy = "comics")
    @ToString.Exclude
    private List<Tienda> tiendas;

    @ManyToMany(mappedBy = "comics")
    @ToString.Exclude
    private List<Categoria> categorias;

    @ManyToMany
    @JoinTable(
    name = "autor-comic",
    joinColumns = @JoinColumn(name = "id_comic"),
    inverseJoinColumns = @JoinColumn(name = "id_autor")
    )
    private List<Autor> autores;
}

