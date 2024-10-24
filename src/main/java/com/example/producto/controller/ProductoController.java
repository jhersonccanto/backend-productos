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

import com.example.producto.entity.Producto;
import com.example.producto.service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
	@Autowired
	private ProductoService productoservice;
	
	@GetMapping
	public ResponseEntity<List<Producto>> readAll(){
		try {
			List<Producto> Producto = productoservice.readAll();
			if(Producto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Producto, HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@PostMapping
     public ResponseEntity<Producto> create(@Valid @RequestBody Producto ac){
    	 try {
    		 Producto a = productoservice.create(ac);
    		 return new ResponseEntity<>(a, HttpStatus.CREATED);
    	 } catch (Exception e) {
    		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	 }
     }
     
     @GetMapping("/{id}")
     public ResponseEntity<Producto> getProductoId(@PathVariable("id")Long id){
    	 try {
    		 Producto a = productoservice.read(id).get();
    		 return new ResponseEntity<>(a, HttpStatus.CREATED);
    	 } catch (Exception e) {
    		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	 }
     }
     
     @DeleteMapping("/{id}")
     public ResponseEntity<Producto> delProductoId(@PathVariable("id")Long id){
    	 try {
    		 productoservice.delete(id);
    		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	 } catch (Exception e) {
    		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	 }
     }
     
     @PutMapping("/{id}")
     public ResponseEntity<?> updateProducto(@PathVariable("id") Long id, @Valid @RequestBody Producto ac){
    	 Optional <Producto> a = productoservice.read(id);
    		 if(!a.isEmpty()) {
    			 return new ResponseEntity<>(productoservice.update(ac), HttpStatus.OK); 
    		 } else {
    			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    		 }
     }

	}

