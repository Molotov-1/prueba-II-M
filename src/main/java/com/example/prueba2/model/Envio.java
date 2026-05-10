package com.example.prueba2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "envios")
public class Envio {

    @Size(min = 3, max = 10, message = "La fecha de salida debe tener entre 3 y 10 caracteres")
    @Column(nullable = false, length = 10)
    private String fecha_salida;

    @NotBlank(message = "La fecha de entrega es obligatoria")
    @Size(min = 3, max = 10, message = "La fecha de entrega debe tener entre 3 y 10 caracteres")
    @Column(nullable = false, length = 10)
    private String fecha_entrega;

    //fk id pago
    @OneToOne
    @JoinColumn(name = "id_pago")
    private Pago pago;

    @Size(min = 3, max = 20, message = "El tipo de envio debe tener entre 3 y 20 caracteres")
    @Column(nullable = false, length = 20)
    private String tipo_envio;

    @Size(min = 3, max = 20, message = "La Sucursal debe tener entre 3 y 20 caracteres")
    @Column(nullable = false, length = 20)
    private String sucursal;

}
