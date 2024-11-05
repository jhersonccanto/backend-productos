package com.example.producto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.producto.entity.Cliente;
import com.example.producto.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
	@Autowired
	private ClienteService clienteservice;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> readAll(){
		try {
			List<Cliente> Cliente = clienteservice.readAll();
			if(Cliente.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Cliente, HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@PostMapping
     public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente ac){
    	 try {
    		 Cliente a = clienteservice.create(ac);
    		 return new ResponseEntity<>(a, HttpStatus.CREATED);
    	 } catch (Exception e) {
    		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	 }
     }
     
     @GetMapping("/{id}")
     public ResponseEntity<Cliente> getClienteId(@PathVariable("id")Long id){
    	 try {
    		 Cliente a = clienteservice.read(id).get();
    		 return new ResponseEntity<>(a, HttpStatus.CREATED);
    	 } catch (Exception e) {
    		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	 }
     }
     
     @DeleteMapping("/{id}")
     public ResponseEntity<Cliente> delClienteId(@PathVariable("id")Long id){
    	 try {
    		 clienteservice.delete(id);
    		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	 } catch (Exception e) {
    		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	 }
     }
     
     @PutMapping("/{id}")
     public ResponseEntity<?> updateCliente(@PathVariable("id") Long id, @Valid @RequestBody Cliente ac){
    	 Optional <Cliente> a = clienteservice.read(id);
    		 if(!a.isEmpty()) {
    			 return new ResponseEntity<>(clienteservice.update(ac), HttpStatus.OK); 
    		 } else {
    			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    		 }
     }

}
