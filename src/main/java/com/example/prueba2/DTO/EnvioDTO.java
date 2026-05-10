package com.example.prueba2.DTO;




import java.time.LocalDate;

import lombok.Data;

@Data
public class EnvioDTO {

    private Integer idEnvio;
    private LocalDate fechaSalida;
    private LocalDate fechaEntrega;
    private String tipoEnvio;
    private String sucursal;


}