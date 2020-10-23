package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class LivroDao {

	@PersistenceContext
	private EntityManager manager;

	@Inject
	UserTransaction tx;

	public void salva(Livro livro) {
		try {
			tx.begin();
			manager.persist(livro);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Livro> todosLivros() {
		return manager.createQuery("select l from Livro l", Livro.class).getResultList();
	}

	public List<Livro> getLivrosPeloTitulo(String titulo) {
		TypedQuery<Livro> query = manager.createQuery("select l from Livro l where l.titulo like :pTitulo", Livro.class);
		query.setParameter("pTitulo", "%" + titulo + "%");
		return query.getResultList();
	}

}
