CREATE DATABASE bd_controle_de_feira;

CREATE TABLE local_de_compra(
	codigo INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(30) NOT NULL,
	endereco VARCHAR(50) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
	email VARCHAR(30),
	dia_de_promocao INT
)

CREATE TABLE grupo_familiar(
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    gastos DECIMAL NOT NULL
)

CREATE TABLE produto(
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    precoUnitario DECIMAL NOT NULL,
    quantidade INT NOT NULL,
    precoTotal DECIMAL NOT NULL,
    codigo_grupo_familiar INT NOT NULL,
    codigo_local_de_compra INT NOT NULL,
    CONSTRAINT fk_codigo_grupo_familiar FOREIGN KEY (codigo_grupo_familiar) REFERENCES grupo_familiar (codigo),
    CONSTRAINT fk_codigo_local_de_compra FOREIGN KEY (codigo_local_de_compra) REFERENCES local_de_compra (codigo)
)