package controller;

import view.*;
import model.*;

public class BuscaAutor implements Busca {
	
	private View view;
	private Subject model;
	
	public BuscaAutor(View o, Subject s) {
		view = o;
		model = s;
	}
	
	public void buscarLivro() {
		view.displayBuscaPorNomeLivro();	
	}

}