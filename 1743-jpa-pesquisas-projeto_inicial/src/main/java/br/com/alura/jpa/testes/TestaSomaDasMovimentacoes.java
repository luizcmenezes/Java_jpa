package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		BigDecimal somaDasMovimentacoes = new MovimentacaoDao(em).getSomaDasMovimentacoes();
		
		System.out.println();
		System.out.println("A soma das movimentações é: " + somaDasMovimentacoes);
	}

}
