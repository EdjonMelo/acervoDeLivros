package view;

import java.util.*;
import controller.Busca;

public class View implements Observer {
	
	private Busca busca;
	private List encontradas = new LinkedList();
	
	public void updade(List l) {
		
	}
	
	public void setBusca(Busca b) {
		busca = b;
	}
	
	public void displayBuscaPorNomeLivro() {
		
	}
	
	public void displayBuscaPorNomeAutor() {
		
	}

}
