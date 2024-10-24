package com.example.producto.service;

import java.util.List;
import java.util.Optional;

import com.example.producto.entity.Producto;

public interface ProductoService {
	Producto create(Producto a);
	Producto update(Producto a);
	void delete(Long id);
	Optional <Producto> read(Long id);
	List<Producto> readAll();
}
