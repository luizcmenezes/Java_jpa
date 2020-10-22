package br.com.caelum.livraria.bean;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

public class AutorService {

	@Inject
	AutorDao dao;

	public void adicionar(Autor autor) {
		dao.salva(autor);
	}

	public List<Autor> todosAutores() {
		return dao.todosAutores();
	}
}
