package com.example.prueba2.DTO;

import java.sql.Date;
import java.time.LocalDate;


public class EnvioDTO {

    private Integer idEnvio;
    private Date fechaSalida;
    private Date fechaEntrega;
    private String tipoEnvio;
    private String sucursal;

    public void setIdEnvio(Integer idEnvio) {
        throw new UnsupportedOperationException("Unimplemented method 'setIdEnvio'");
    }
    public void setFechaSalida(LocalDate fechaSalida) {
        throw new UnsupportedOperationException("Unimplemented method 'setFechaSalida'");
    }
    public void setFechaEntrega(LocalDate fechaEntrega) {
        throw new UnsupportedOperationException("Unimplemented method 'setFechaEntrega'");
    }
    public void setTipoEnvio(String tipoEnvio) {
        throw new UnsupportedOperationException("Unimplemented method 'setTipoEnvio'");
    }
    public void setSucursal(String sucursal) {
        throw new UnsupportedOperationException("Unimplemented method 'setSucursal'");
    }

}