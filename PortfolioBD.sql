create database portfolioDB;
USE porfolioDB; 

CREATE TABLE fotografo (
	idFotografo  INT  NOT  NULL  AUTO_INCREMENT,
	nome  VARCHAR(255),
	descricao  VARCHAR(255), 
	fotoPerfil VARCHAR(255),
	login VARCHAR(255),
	senha VARCHAR(255),
	PRIMARY KEY (idFotografo)
	);

	CREATE TABLE foto (
	idFoto  INT  NOT  NULL  AUTO_INCREMENT,
	titulo  VARCHAR(255),
	caminho VARCHAR(255),
	descricao  VARCHAR(255), 
	idFotografo INT,
	PRIMARY KEY (idFoto),
	FOREIGN KEY (idFotografo) REFERENCES fotografo(idFotografo));


CREATE TABLE contato (
	idContato  INT  NOT  NULL  AUTO_INCREMENT,
	telefone  VARCHAR(255),
	email  VARCHAR(255), 
	facebook VARCHAR(255),
	instagram VARCHAR(255),
	idFotografo INT,
	PRIMARY KEY (idContato),
	FOREIGN KEY (idFotografo) REFERENCES fotografo(idFotografo));

CREATE TABLE tags (
	idFoto INT,
	tag  VARCHAR(255),
	PRIMARY KEY (idFoto),
	FOREIGN KEY (idFoto ) REFERENCES foto(idFoto)
	);
		
