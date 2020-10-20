package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		Categoria categoria = new Categoria();
		categoria.setId(2L);
		String sql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";

		TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);
		List<Movimentacao> resultList = query.getResultList();

		if (resultList.size() > 0) {
			System.out.println();
			for (Movimentacao movimentacao : resultList) {
				System.out.println("------------------------------------------");
				System.out.println("Categorias: " + movimentacao.getCategoria());
				System.out.println("Descrição: " + movimentacao.getDescriscao());
				System.out.println("Valor: " + movimentacao.getValor());
				System.out.println("Tipo: " + movimentacao.getTipoMvimentacao());
			}
		} else {
			System.out.println("Nenhum resultado.");
		}
	}
}
