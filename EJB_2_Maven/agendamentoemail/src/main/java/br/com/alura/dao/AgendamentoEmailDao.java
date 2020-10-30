package br.com.alura.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.alura.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<AgendamentoEmail> listarAgendamentoEmail() {
		return entityManager.createQuery("select a from AgendamentoEmail a", AgendamentoEmail.class).getResultList();
	}

	public void salvarAgendamentoEmail(AgendamentoEmail agendamentoEmail) {
		entityManager.persist(agendamentoEmail);
	}
	
	public void atualizarAgendamentoEmail(AgendamentoEmail agendamentoEmail) {
	    entityManager.merge(agendamentoEmail);
	}

	public List<AgendamentoEmail> listarAgendamentosEmailPorEmail(String email) {
		TypedQuery<AgendamentoEmail> query = entityManager.createQuery(
				"select a from AgendamentoEmail a where a.email = :pEmail and a.enviado = false",
				AgendamentoEmail.class);
		query.setParameter("pEmail", email);
		return query.getResultList();
	}
	
	public List<AgendamentoEmail> listarAgendamentosEmailNaoEnviados() {
        TypedQuery<AgendamentoEmail> query = entityManager.createQuery(
                "select a from AgendamentoEmail a where a.enviado = false",
                AgendamentoEmail.class);
        return query.getResultList();
    }
}
