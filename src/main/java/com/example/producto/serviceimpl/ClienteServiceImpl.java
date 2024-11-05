package com.example.producto.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producto.dao.ClienteDao;
import com.example.producto.entity.Cliente;
import com.example.producto.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
@Autowired
private ClienteDao clientedao;
	@Override
	public Cliente create(Cliente a) {
		// TODO Auto-generated method stub
		return clientedao.create(a);
	}

	@Override
	public Cliente update(Cliente a) {
		// TODO Auto-generated method stub
		return clientedao.update(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clientedao.delete(id);
	}

	@Override
	public Optional <Cliente> read(Long id) {
		// TODO Auto-generated method stub
		return clientedao.read(id);
	}

	@Override
	public List<Cliente> readAll() {
		// TODO Auto-generated method stub
		return clientedao.readAll();
	}

}
