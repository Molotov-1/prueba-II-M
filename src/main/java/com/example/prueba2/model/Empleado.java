package com.example.prueba2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank (message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El Nombre debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El Apellido tiene que ser obligatorio")
    @Size(min = 3, max = 100, message = "El Apellido debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String apellido;

    @Size(min = 1, max = 3, message = "La edad tiene que tener al menos un numero")
    @Column(nullable = false, length = 3)
    private Integer edad;

    @NotNull(message = "El Rut es obligatorio")
    @Size(min = 8, max = 8, message = "El Rut debe tener 8 digitos")
    @Column(nullable = false, length = 8)
    private Integer rut;

    @NotBlank(message = "El dv es obligatorio")
    @Size(min = 0, max = 1, message = "El Dv tiene que tener 1 digito")
    @Column(nullable = false, length = 1)
    private String dv;

    @NotBlank(message = "El correo es obligatorio")
    @Size(min = 15, max = 40, message = "El Correo debe tener entre 15 y 40 caracteres")
    @Column(nullable = false, length = 40)
    private String correo;

    @Size(min = 9, max = 9, message = "El numero de telefono tiene que tener 9 digitos")
    @Column(nullable = false, length = 9)
    private Integer telefono;
}
