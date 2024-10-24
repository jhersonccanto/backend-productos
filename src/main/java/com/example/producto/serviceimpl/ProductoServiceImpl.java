package com.example.producto.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producto.dao.ProductoDao;
import com.example.producto.entity.Producto;
import com.example.producto.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
@Autowired
private ProductoDao productodao;
	@Override
	public Producto create(Producto a) {
		// TODO Auto-generated method stub
		return productodao.create(a);
	}

	@Override
	public Producto update(Producto a) {
		// TODO Auto-generated method stub
		return productodao.update(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productodao.delete(id);
	}

	@Override
	public Optional <Producto> read(Long id) {
		// TODO Auto-generated method stub
		return productodao.read(id);
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		return productodao.readAll();
	}

}
