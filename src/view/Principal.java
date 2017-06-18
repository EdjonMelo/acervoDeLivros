package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 355);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarLivro = new JButton("Livros");
		btnCadastrarLivro.setForeground(new Color(255, 255, 255));
		btnCadastrarLivro.setBackground(new Color(0, 153, 204));
		btnCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Livro l = new Livro();
				l.setVisible(true);
				dispose();
			}
		});
		btnCadastrarLivro.setBounds(180, 55, 176, 43);
		contentPane.add(btnCadastrarLivro);
		
		JLabel lblNewLabel = new JLabel("Acervo de Livros");
		lblNewLabel.setForeground(new Color(0, 153, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(196, 11, 176, 33);
		contentPane.add(lblNewLabel);
	}
}
