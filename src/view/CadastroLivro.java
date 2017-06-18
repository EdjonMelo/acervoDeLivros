package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import facade.Facade;
import model.Livro;
import singleton.Inventory;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CadastroLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeLivro;
	private JTextField textAutor;
	private JTextField textEditora;
	private JTextField textAno;
	private JTextField textCategoria;

	public static Inventory in;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroLivro frame = new CadastroLivro();
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
	public CadastroLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 363);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeLivros = new JLabel("Cadastro de Livros");
		lblCadastroDeLivros.setForeground(new Color(0, 153, 204));
		lblCadastroDeLivros.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCadastroDeLivros.setBounds(180, 11, 188, 28);
		contentPane.add(lblCadastroDeLivros);

		JLabel lblNomeDoLivro = new JLabel("Nome do Livro:");
		lblNomeDoLivro.setBounds(10, 74, 86, 14);
		contentPane.add(lblNomeDoLivro);

		textNomeLivro = new JTextField();
		textNomeLivro.setBounds(103, 71, 161, 20);
		contentPane.add(textNomeLivro);
		textNomeLivro.setColumns(10);

		JLabel lblNomeDoAutor = new JLabel("Nome do Autor:");
		lblNomeDoAutor.setBounds(10, 99, 97, 14);
		contentPane.add(lblNomeDoAutor);

		textAutor = new JTextField();
		textAutor.setColumns(10);
		textAutor.setBounds(103, 96, 161, 20);
		contentPane.add(textAutor);

		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setBounds(274, 74, 63, 14);
		contentPane.add(lblEditora);

		textEditora = new JTextField();
		textEditora.setColumns(10);
		textEditora.setBounds(333, 71, 161, 20);
		contentPane.add(textEditora);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(277, 99, 70, 14);
		contentPane.add(lblAno);

		textAno = new JTextField();
		textAno.setBounds(333, 96, 161, 20);
		contentPane.add(textAno);
		textAno.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(10, 124, 97, 14);
		contentPane.add(lblCategoria);

		textCategoria = new JTextField();
		textCategoria.setColumns(10);
		textCategoria.setBounds(103, 121, 161, 20);
		contentPane.add(textCategoria);

		JLabel lblMensagem = new JLabel("");
		lblMensagem.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensagem.setBounds(10, 249, 497, 40);
		contentPane.add(lblMensagem);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(0, 153, 204));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				in = in.getInstance();

				Facade f = new Facade();
				if (f.initializeInventory(textNomeLivro.getText(), textAutor.getText(), textEditora.getText(),
						Integer.parseInt(textAno.getText()), textCategoria.getText())) {
					lblMensagem.setText("Cadastro realizado com sucesso.");
					lblMensagem.setForeground(new Color(0, 153, 0));
				} else {
					lblMensagem.setText("Problemas ao realizar cadastro do livro.");
					lblMensagem.setForeground(new Color(255, 0, 0));
				}
			}
		});
		btnCadastrar.setBounds(159, 178, 107, 28);
		contentPane.add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNomeLivro.setText("");
				textEditora.setText("");
				textCategoria.setText("");
				textAutor.setText("");
				textAno.setText("");
			}
		});
		btnLimpar.setForeground(new Color(255, 255, 255));
		btnLimpar.setBackground(new Color(0, 153, 204));
		btnLimpar.setBounds(274, 178, 107, 28);
		contentPane.add(btnLimpar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.Livro livro = new view.Livro();
				livro.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(0, 153, 204));
		btnVoltar.setBounds(408, 16, 86, 23);
		contentPane.add(btnVoltar);

	}
}
