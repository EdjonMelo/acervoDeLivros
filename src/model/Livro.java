package model;

import controller.*;

 public class Livro {
	
	private String nome;
	private String autor;
	private String editora;
	private int ano;
	private String categoria;
	public Livro(){
		
	}
	
	public String getNome () {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getAutor() {
		return autor;
	} 
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getEditora() {
		return editora;
	} 
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


}


