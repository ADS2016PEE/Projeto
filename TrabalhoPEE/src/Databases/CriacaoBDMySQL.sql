CREATE DATABASE IF NOT EXISTS pee;

USE pee;

CREATE TABLE IF NOT EXISTS produtos (
	idProdutos INT AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(254) NOT NULL,
        valor DOUBLE NOT NULL, 
	CONSTRAINT pk_idProdutos PRIMARY KEY(idProdutos)
);