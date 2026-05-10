package com.example.prueba2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba2.model.Cliente;
import com.example.prueba2.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //Mostrar los clientes
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> todosLosClientes(){
        List<ClienteDTO> clientes = clienteService.obtenerTodos();
        if(clientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    //Buscar por Id
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer id){
        try {
            ClienteDTO cliente = clienteService.buscarPorId(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Buscar por Rut
    @GetMapping("/rut/{rut}")
    public ResponseEntity<ClienteDTO> buscarPorRut(@PathVariable String rut){
        List<ClienteDTO> clientes = clienteService.buscarPorRut(rut);
        if(clientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }    
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }  
    
    //Guardar cliente
    @PostMapping
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente guardado = clienteService.guardarCliente(cliente);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    //Editar Cliente
    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> editarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        try {
            Cliente editado = clienteService.guardarCliente(cliente);
            return new ResponseEntity<>(editado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Actualizar cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente){
        try{
            Cliente newCliente = clienteService.actualizarclientes( id, cliente);
            return new ResponseEntity<>(newCliente, HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Integer id) {
        String resultado = clienteService.eliminarcliente(id);
        
        // Si el mensaje contiene "exitosamente", es un éxito
        if (resultado.contains("exitosamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }


}
