package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setId(2L);
		String jpql = "select m from Movimentacao m where m.conta = :pConta";

		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		List<Movimentacao> resultList = query.getResultList();

		if (resultList.size() > 0) {
			System.out.println();
			System.out.println("**********----------**********");
			for (Movimentacao movimentacao : resultList) {
				System.out.println("Descrição: " + movimentacao.getDescriscao());
				System.out.println("Tipo: " + movimentacao.getTipoMvimentacao());
			}
		} else {
			System.out.println("Nenhum resultado.");
		}

	}

}
