CREATE DATABASE IF NOT EXISTS pee;

USE pee;

CREATE TABLE IF NOT EXISTS produtos (
	idProdutos INT AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(254) NOT NULL,
    valor DOUBLE NOT NULL, 
	CONSTRAINT pk_idProdutos PRIMARY KEY(idProdutos)
);

CREATE TABLE IF NOT EXISTS vendas(
	idVendas INT AUTO_INCREMENT,
    dataVenda CHAR(10) NOT NULL,
    valorTotal DOUBLE NOT NULL,
    CONSTRAINT pk_vendas PRIMARY KEY(idVendas)
);

CREATE TABLE IF NOT EXISTS produtosVendidos(
	idProdutos INT,
    idVendas INT,
    CONSTRAINT pk_ProdutosVendidos PRIMARY KEY(idProdutos, idVendas),
    CONSTRAINT fk_ProdutosVendidos_idProdutos 
		FOREIGN KEY (idProdutos) 
			REFERENCES produtos (idProdutos) 
            ON DELETE NO ACTION
			ON UPDATE NO ACTION,
	CONSTRAINT fk_ProdutosVendidos_idVendas 
		FOREIGN KEY (idVendas) 
			REFERENCES vendas (idVendas) 
            ON DELETE NO ACTION
			ON UPDATE NO ACTION
);