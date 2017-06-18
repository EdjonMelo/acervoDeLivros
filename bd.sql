//Criar banco de dados:
create database acervo;

//Criar tabela livros:
use acervo;

create table livro(
	id int primary key auto_increment,
	nome varchar(255),
	autor varchar(255),
	editora varchar(255),
	ano int,
	categoria varchar(255)
);





