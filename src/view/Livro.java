package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import componentes.LivroJTable;
import singleton.Inventory;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class Livro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6361900709809552833L;
	private JPanel contentPane;

	public static Inventory in;
	public boolean foiSelecionado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Livro frame = new Livro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Livro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setVisible(true);

		JLabel lblLivros = new JLabel("Livros");
		lblLivros.setForeground(new Color(0, 153, 204));
		lblLivros.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLivros.setBounds(210, 11, 176, 33);
		contentPane.add(lblLivros);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroLivro c = new CadastroLivro();
				c.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(0, 153, 204));
		btnCadastrar.setBounds(10, 56, 105, 23);
		contentPane.add(btnCadastrar);

		JLabel lblLivroSelecionado = new JLabel("Livro");
		lblLivroSelecionado.setBounds(10, 338, 302, 14);
		contentPane.add(lblLivroSelecionado);

		JLabel lblAutorSelecionado = new JLabel("Autor");
		lblAutorSelecionado.setBounds(10, 358, 302, 14);
		contentPane.add(lblAutorSelecionado);

		LivroJTable tblLivros = new LivroJTable();
		tblLivros.setBounds(10, 102, 498, 196);
		carregarTabela(tblLivros);

		tblLivros.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					foiSelecionado = true;
					// abrir view com informaçoes do livro
					model.Livro livroSelecionado = tblLivros.getLivroSelecionado();
					lblLivroSelecionado.setText(livroSelecionado.getNome());
					lblAutorSelecionado.setText(livroSelecionado.getAutor());
				}
			}
		});

		JLabel lblMensagem = new JLabel("");
		lblMensagem.setBounds(10, 393, 486, 28);
		contentPane.add(lblMensagem);

		JScrollPane scroll = new JScrollPane(tblLivros);
		scroll.setBounds(10, 113, 498, 185);
		contentPane.add(scroll, BorderLayout.CENTER);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!foiSelecionado) {
					JOptionPane.showMessageDialog(null, "Você deve seleciona um livro para excluir!");
				} else {
					model.Livro pessoaDeletada = new model.Livro();
					pessoaDeletada.setNome(lblLivroSelecionado.getText());

					try {
						if (in.delete(pessoaDeletada)) {
							lblMensagem.setText("Livro excluido com sucesso.");
							lblMensagem.setForeground(new Color(0, 153, 0));
							lblLivroSelecionado.setText("");
							lblAutorSelecionado.setText("");
							carregarTabela(tblLivros);
							foiSelecionado = false;

						} else {
							lblMensagem.setText("Problemas ao excluir livro.");
							lblMensagem.setForeground(new Color(255, 0, 0));
						}
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(new Color(0, 153, 204));
		btnExcluir.setBounds(125, 56, 105, 23);
		contentPane.add(btnExcluir);

		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal p = new Principal();
				p.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 153, 204));
		button.setBounds(422, 18, 86, 23);
		contentPane.add(button);
		
		JLabel lblLivroSelecionado_1 = new JLabel("Livro Selecionado");
		lblLivroSelecionado_1.setForeground(new Color(0, 153, 204));
		lblLivroSelecionado_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLivroSelecionado_1.setBounds(190, 309, 176, 33);
		contentPane.add(lblLivroSelecionado_1);

	}

	@SuppressWarnings("static-access")
	private void carregarTabela(LivroJTable tabela) {
		try {
			in = in.getInstance();
			tabela.load(in.all());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Houve um erro ao carregar os livros do banco de dados!");
		}
	}
}
