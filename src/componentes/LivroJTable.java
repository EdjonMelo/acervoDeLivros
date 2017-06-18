package componentes;

import java.util.List;

import javax.swing.JTable;

import model.Livro;

public class LivroJTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2779778910554419347L;
	private LivroTableModel tableModel;

	public LivroJTable() {
		this.tableModel = new LivroTableModel();
		setModel(this.tableModel);
	}

	public void load(List<Livro> livros) {
		this.tableModel.load(livros);
	}

	public Livro getLivroSelecionado() {
		int index = getSelectedRow();
		return this.tableModel.getLivroAt(index);
	}

}
