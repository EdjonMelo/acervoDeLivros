package view;

//TELA DE CADASTRO DE LIVROS
import java.util.Scanner;

import model.Livro;
import singleton.Inventory;

import java.util.ArrayList;

public class Launch {

	public static Inventory in;

	private static Scanner l;

	public static void main(String[] args) {
		
		in = in.getInstance();

		in.cadastrarLivro(new Livro());
		
		int x;
		int z;

		l = new Scanner(System.in);
		ArrayList<Livro> livros2 = new ArrayList<Livro>();
		Livro livros;
		livros = new Livro();

		/*
		 * System.out.
		 * println("Aperte 1 para Cadastrar ou 2 para Buscar um Livro: "); x =
		 * l.nextInt();
		 */

		System.out.println("Tela de Cadastro de livros");
		System.out.println("Titulo: ");
		String nome = l.nextLine();
		System.out.println("Autor: ");
		String autor = l.nextLine();
		System.out.println("Categoria: ");
		String categoria = l.nextLine();
		System.out.println("Editora: ");
		String editora = l.nextLine();
		System.out.println("Ano de Publicação: ");
		int ano = l.nextInt();

		livros.setNome(nome);
		livros.setAutor(autor);
		livros.setCategoria(categoria);
		livros.setEditora(editora);
		livros.setAno(ano);

		livros2.add(livros);
		System.out.println("\n" + "\n" + "\n" + "\n" + "Titulo: " + livros.getNome() + "\n" + "Autor: "
				+ livros.getAutor() + "\n" + "Categoria: " + livros.getCategoria() + "\n" + "Editora: "
				+ livros.getEditora() + "\n" + "Ano: " + livros.getAno());
	}
}
