package br.com.estudo.jpa.service;

import java.util.List;

import br.com.estudo.jpa.filters.Filter;
import br.com.estudo.jpa.model.Usuario;

public interface UsuarioService {
	
	void save (Usuario usuario);
	List<Usuario> retornaTodosUsuarios(Filter filter);

}
