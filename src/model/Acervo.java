package model;

import java.util.LinkedList;
import java.util.List;

import view.Observer;

public class Acervo implements Subject {
	private List observers;
	private List autores;

	public Acervo() {
		observers = new LinkedList();
		autores = new LinkedList();
	}

	public void notifyObserversAdd() {
	}

	public void notifyObserversSearch(List result) {
	}

	public void buscarLivro(String texto) {
	}

	public void addAutor(String nome) {
		Autor aut = new Autor(nome);
		autores.add(aut);
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

}