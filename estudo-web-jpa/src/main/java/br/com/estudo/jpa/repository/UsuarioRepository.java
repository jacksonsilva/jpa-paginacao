package br.com.estudo.jpa.repository;

import java.util.List;

import br.com.estudo.jpa.filters.Filter;

public interface UsuarioRepository<T> {

	void saveUser(T entity);
	List<T> findAllUser(Filter filter);
	
}
