package com.example.producto.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.producto.dao.ProductoDao;
import com.example.producto.entity.Producto;
import com.example.producto.repository.ProductoRepository;

@Component
public class ProductoDaoImpl implements ProductoDao{

	@Autowired
private ProductoRepository productorepository;
	@Override
	public Producto create(Producto a) {
		// TODO Auto-generated method stub
		return productorepository.save(a);
	}

	@Override
	public Producto update(Producto a) {
		// TODO Auto-generated method stub
		return productorepository.save(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productorepository.deleteById(id);
	}

	@Override
	public Optional <Producto> read(Long id) {
		// TODO Auto-generated method stub
		return productorepository.findById(id);
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		return productorepository.findAll();
	}

}

