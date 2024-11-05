package com.example.producto.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.producto.dao.ClienteDao;
import com.example.producto.entity.Cliente;
import com.example.producto.repository.ClienteRepository;

@Component
public class ClienteDaoImpl implements ClienteDao{
	@Autowired
	private ClienteRepository clienterepository;
		@Override
		public Cliente create(Cliente a) {
			// TODO Auto-generated method stub
			return clienterepository.save(a);
		}

		@Override
		public Cliente update(Cliente a) {
			// TODO Auto-generated method stub
			return clienterepository.save(a);
		}

		@Override
		public void delete(Long id) {
			// TODO Auto-generated method stub
			clienterepository.deleteById(id);
		}

		@Override
		public Optional <Cliente> read(Long id) {
			// TODO Auto-generated method stub
			return clienterepository.findById(id);
		}

		@Override
		public List<Cliente> readAll() {
			// TODO Auto-generated method stub
			return clienterepository.findAll();
		}

}
