CREATE DATABASE busapp;
USE busapp;


CREATE TABLE tipos_cnh(
	id_tipo_cnh INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100)
);

INSERT INTO tipos_cnh VALUE(0,"A");



CREATE TABLE motoristas(
	id_motorista INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200),
    cpf VARCHAR(15),
    rg VARCHAR(15),
    id_tipo_cnh INTEGER NOT NULL,
    FOREIGN KEY(id_tipo_cnh) REFERENCES tipos_cnh(id_tipo_cnh)
);

INSERT INTO motoristas VALUE(0, "José Carlos", "46939417869", "524258430", 1);



CREATE TABLE cargos(
	id_cargo INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200)
);

INSERT INTO cargos VALUE (0, "Motorista pleno 3");



CREATE TABLE filiais(
	id_filial INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200)
);

INSERT INTO filiais value (0, "Filial 1");



CREATE TABLE funcionarios(
	id_funcionario INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    nome VARCHAR(200),
    cpf VARCHAr(15), 
    id_cargo INTEGER NOT NULL,
    id_filial INTEGER NOT NULL,
    FOREIGN KEY(id_cargo) REFERENCES cargos(id_cargo),
    FOREIGN KEY(id_filial) REFERENCES filiais(id_filial)
); 

INSERT  INTO funcionarios value (0, "Donizete Vida", "46939417869", 1, 1);



CREATE TABLE veiculos(
	id_veiculo INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    modelo VARCHAR(200),
    placa CHAR(7)
);

INSERT INTO veiculos value (0, "Peugeot 306", "EWA9023");



CREATE TABLE viagens(
	id_viagem INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_motorista INTEGER NOT NULL,
    id_veiculo INTEGER NOT NULL,
    tipo_viagem CHAR(3),
    data_viagem TIMESTAMP NOT NULL,
    FOREIGN KEY(id_motorista) REFERENCES motoristas(id_motorista),
    FOREIGN KEY (id_veiculo) REFERENCES veiculos(id_veiculo)
);

INSERT INTO viagens VALUE(0, 1, 1, "VTA", CURRENT_TIMESTAMP());





CREATE TABLE viagens_conteudo(
	id_viagem INTEGER NOT NULL,
    id_funcionario INTEGER NOT NULL,
    FOREIGN KEY(id_viagem) REFERENCES viagens(id_viagem),
    FOREIGN KEY(id_funcionario)REFERENCES funcionarios(id_funcionario)
);

    