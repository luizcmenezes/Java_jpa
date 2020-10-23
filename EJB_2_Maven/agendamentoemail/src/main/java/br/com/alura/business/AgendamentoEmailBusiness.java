package br.com.alura.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class AgendamentoEmailBusiness {

	public List<String> listarAgendamentosEmail() {
		List<String> emails = new ArrayList<>();

		emails.add("lcmscontas@gmail.com");
		emails.add("flavimnhamenezes6@gmail.com");

		return emails;
	}
}
