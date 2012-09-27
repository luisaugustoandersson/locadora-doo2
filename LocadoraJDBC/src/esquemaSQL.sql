CREATE SEQUENCE seq_cliente;

CREATE TABLE Cliente (
cod_cliente  numeric(6) PRIMARY KEY,
nome varchar(20),
sobrenome varchar(20),
email varchar(20),
telefone varchar(12),
username varchar(10) unique,
senha varchar(10),
CPF numeric(11) unique,
CNH numeric(11) unique,
endereco varchar(40),
bairro varchar(20),
complemento varchar(20),
uf varchar(2),
cidade varchar(20));

CREATE SEQUENCE seq_marca;

CREATE TABLE Marca (
cod_marca numeric(6) PRIMARY KEY,
marca varchar(20));

CREATE SEQUENCE seq_modelo;

CREATE TABLE Modelo (
cod_modelo numeric(6) PRIMARY KEY,
modelo varchar(20),
cod_marca numeric(6),
FOREIGN KEY(cod_marca) REFERENCES Marca (cod_marca));

CREATE SEQUENCE seq_veiculo;

CREATE TABLE Veiculo (
cod_veiculo numeric(6) PRIMARY KEY,
cor varchar(20),
motor varchar(20),
cap_malas numeric(4),
lugares numeric(2),
ano numeric(4),
diaria numeric(12,2),
info varchar(100),
foto varchar(100),
disponivel boolean,
cod_modelo numeric(6),
cod_marca numeric(6),
FOREIGN KEY(cod_modelo) REFERENCES Modelo (cod_modelo),
FOREIGN KEY(cod_marca) REFERENCES Marca (cod_marca));

CREATE SEQUENCE seq_aluguel;

CREATE TABLE Aluguel (
cod_aluguel numeric(6) PRIMARY KEY,
dt_inicio timestamp,
dt_fim timestamp,
cod_cliente numeric(6),
cod_veiculo numeric(6),
FOREIGN KEY(cod_cliente) REFERENCES Cliente (cod_cliente),
FOREIGN KEY(cod_veiculo) REFERENCES Veiculo (cod_veiculo));