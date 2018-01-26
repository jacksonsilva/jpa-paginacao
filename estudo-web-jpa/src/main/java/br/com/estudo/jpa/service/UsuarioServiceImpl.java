package br.com.estudo.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.jpa.filters.Filter;
import br.com.estudo.jpa.model.Usuario;
import br.com.estudo.jpa.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository<Usuario> usuarioRepository;

	public List<Usuario> retornaTodosUsuarios(Filter filter) {
		
		return this.usuarioRepository.findAllUser(filter);
		
	}

	@Override
	public void save(Usuario usuario) {
		this.usuarioRepository.saveUser(usuario);
		
	}
	
	

}
