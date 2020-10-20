package br.com.alura.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class MovimentacaoDao {
	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes() {
		TypedQuery<MediaComData> query = em.createNamedQuery("media", MediaComData.class);
		return query.getResultList();
	}

	public BigDecimal getSomaDasMovimentacoes() {
		TypedQuery<BigDecimal> query = em.createNamedQuery("soma", BigDecimal.class);
		return query.getSingleResult();
	}
}
