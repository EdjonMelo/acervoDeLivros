package facade;

import model.Livro;
import singleton.Inventory;

public class Facade {

	public static Inventory in;

	public Facade() {
		in = in.getInstance();
	}

	public boolean initializeInventory(String nome, String autor, String editora, int ano, String categoria) {
		Livro livro = new Livro();
		livro.setNome(nome);
		livro.setAutor(autor);
		livro.setEditora(editora);
		livro.setAno(ano);
		livro.setCategoria(categoria);
		return in.cadastrarLivro(livro);
	}
}
