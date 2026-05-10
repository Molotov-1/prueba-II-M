package com.example.prueba2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba2.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {

    List<Pago> findByClienteId(Integer idCliente);

    List<Pago> findByEmpleadoId(Integer idEmpleado);
}
