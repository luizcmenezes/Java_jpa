package br.com.caelum.livraria.webservice;

import java.rmi.RemoteException;

public class TesteRequestSoap {

	public static void main(String[] args) throws RemoteException {

		LivrariaWS cliente = new LivrariaWSProxy();

		Livro[] livros = cliente.getLivrosPeloTilulo("Arquitetura");

		for (Livro livro : livros) {
			System.out.println("*************Livros*************");
			System.out.println("Titulo: " + livro.getTitulo());
			System.out.println("Autor: " + livro.getAutor().getNome());
		}
	}

}
