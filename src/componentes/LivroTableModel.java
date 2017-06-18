package componentes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Livro;

public class LivroTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8993996497746246920L;
	private List<Livro> livros = new ArrayList<Livro>();
	private String[] columnNames = { "Nome", "Autor", "Editora", "Ano", "Categoria" };
	private Class<?>[] columnTypes = { String.class, String.class, String.class, Integer.class, String.class };

	public void load(List<Livro> livros) {
		this.livros = livros;
		fireTableDataChanged();
	}

	public Livro getLivroAt(int index) {
		if (this.livros.size() <= 0) {
			return null;
		}
		return this.livros.get(index);
	}
	
	public String getColumnName(int col) {
        return columnNames[col];
    }

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return this.livros.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if (this.livros.size() <= 0) {
			return null;
		}
		Livro p = this.livros.get(arg0);
		switch (arg1) {
		case 0:
			return p.getNome();
		case 1:
			return p.getAutor();
		case 2:
			return p.getEditora();
		case 3:
			return p.getAno();
		case 4:
			return p.getCategoria();
		}
		return null;
	}

}
