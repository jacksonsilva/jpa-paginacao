package br.com.estudo.jpa.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.jpa.filters.Filter;
import br.com.estudo.jpa.filters.PaginationFilter;
import br.com.estudo.jpa.model.Usuario;
import br.com.estudo.persistence.AbstractJpaDAO;

@Repository
public class UsuarioRepositoryImpl extends AbstractJpaDAO<Usuario> implements UsuarioRepository<Usuario> {

	@Transactional
	public void saveUser(Usuario entity) {
		save(entity);
		
	}

	public List<Usuario> findAllUser(Filter filters) {
		
		/*final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> cq = cb.createQuery(clazz);
        final Root<T> rootEntry = cq.from(clazz);
        final CriteriaQuery<T> all = cq.select(rootEntry);
        final TypedQuery<T> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();*/
		
		int pageSize = 20;
		
		final CriteriaBuilder cb= getEntityManager().getCriteriaBuilder();
		
		CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
		Root<Usuario> userRoot = cq.from(Usuario.class);
		CriteriaQuery<Usuario> selectAll = cq.select(userRoot);
		
		TypedQuery<Usuario> allQuery = getEntityManager().createQuery(selectAll);
		
		int pageNumber = (((PaginationFilter)filters).pageNumber()<1 ? 1 : ((PaginationFilter)filters).pageNumber());
		
		allQuery.setFirstResult((pageNumber - 1) * pageSize);
		allQuery.setMaxResults(pageSize);
		
		List<Usuario> usuarios = allQuery.getResultList();
		
		
		
       return usuarios;
	}

	
}
