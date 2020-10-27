package br.com.alura.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.dao.AgendamentoEmailDao;
import br.com.alura.entity.AgendamentoEmail;
import br.com.alura.exception.BusinessExecption;
import br.com.alura.interception.Logger;

@Stateless
@Logger
public class AgendamentoEmailBusiness {

	@Inject
	private AgendamentoEmailDao agendamentoEmailDao;

	public List<AgendamentoEmail> listarAgendamentosEmail() {
		return agendamentoEmailDao.listarAgendamentoEmail();
	}

	public void salvarAgendamentoEmail(@Valid AgendamentoEmail agendamentoEmail) throws BusinessExecption {
		if (!agendamentoEmailDao.listarAgendamentosEmailPorEmail(agendamentoEmail.getEmail()).isEmpty()) {
			throw new BusinessExecption("Email já está agendado!");
		}
		agendamentoEmail.setEnviado(false);
		agendamentoEmailDao.salvarAgendamentoEmail(agendamentoEmail);
	}
}
