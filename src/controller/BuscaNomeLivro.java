package controller;

import view.*;
import model.*;

public class BuscaNomeLivro implements Busca {
	
	private View view;
	private Subject model;
	
	public BuscaNomeLivro(View o, Subject s) {
		view = o;
		model = s;
	}
	
	public void buscarLivro() {
		
		view.displayBuscaPorNomeLivro();	
	}
	
}