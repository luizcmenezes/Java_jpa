package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestaMediaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select avg(m.valor) from Movimentacao m";
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		Double somaDasMovimentacoes = query.getSingleResult();
		
		System.out.println();
		System.out.println("A m�dia das movimenta��es �: " + somaDasMovimentacoes);
	}

}
