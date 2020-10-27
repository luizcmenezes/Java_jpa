package br.com.alura.exception;

import java.util.ArrayList;
import java.util.List;

public class BusinessExecption extends Exception {

	private List<String> mensagens;

	public BusinessExecption() {
		super();
		mensagens = new ArrayList<>();
	}

	public BusinessExecption(String mensagem) {
		super(mensagem);
		mensagens = new ArrayList<>();
		mensagens.add(mensagem);
	}

	public List<String> getMensagens() {
		return mensagens;
	}

	public void addMensagem(String mensagem) {
		this.mensagens.add(mensagem);
	}

}
