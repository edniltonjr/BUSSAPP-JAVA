CREATE DATABASE busapp;
USE busapp;

INSERT INTO tipo_cnh VALUE(0,"A");

CREATE TABLE tipos_cnh(
	id_tipo_cnh INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(100)
);

INSERT INTO motorista VALUE(0, "José Carlos", "46939417869", "524258430", 1);

CREATE TABLE motoristas(
	id_motorista INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200),
    cpf VARCHAR(15),
    rg VARCHAR(15),
    id_tipo_cnh INTEGER NOT NULL,
    FOREIGN KEY(id_tipo_cnh) REFERENCES tipo_cnh(id_tipo_cnh)
);

INSERT INTO cargo VALUE (0, "Motorista pleno 3");

CREATE TABLE cargos(
	id_cargo INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200)
);

INSERT INTO filial value (0, "Filial 1");

CREATE TABLE filiais(
	id_filial INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200)
);

INSERT  INTO funcionario value (0, "Donizete Vida", "46939417869", 1, 1);

CREATE TABLE funcionarios(
	id_funcionario INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    nome VARCHAR(200),
    cpf VARCHAr(15), 
    id_cargo INTEGER NOT NULL,
    id_filial INTEGER NOT NULL,
    FOREIGN KEY(id_cargo) REFERENCES cargo(id_cargo),
    FOREIGN KEY(id_filial) REFERENCES filial(id_filial)
); 

INSERT INTO veiculo value (0, "Peugeot 306", "EWA9023");

CREATE TABLE veiculos(
	id_veiculo INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    modelo VARCHAR(200),
    placa CHAR(7)
);

INSERT INTO viagem VALUE(0, 1, 1, "VTA", CURRENT_TIMESTAMP());

CREATE TABLE viagens(
	id_viagem INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_motorista INTEGER NOT NULL,
    id_veiculo INTEGER NOT NULL,
    tipo_viagem CHAR(3),
    data_viagem TIMESTAMP NOT NULL,
    FOREIGN KEY(id_motorista) REFERENCES motorista(id_motorista),
    FOREIGN KEY (id_veiculo) REFERENCES veiculo(id_veiculo)
);

INSERT INTO viagem_conteudo VALUE (2, 1);

SELECT * FROM viagem_conteudo WHERE id_viagem = 2;


CREATE TABLE viagens_conteudo(
	id_viagem INTEGER NOT NULL,
    id_funcionario INTEGER NOT NULL,
    FOREIGN KEY(id_viagem) REFERENCES viagem(id_viagem),
    FOREIGN KEY(id_funcionario)REFERENCES funcionario(id_funcionario)
);
    