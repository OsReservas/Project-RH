create database bancotech;

CREATE TABLE login(
id int not null auto_increment primary key,
email varchar(50) unique, 
senha varchar(50),
acesso varchar(20)
);

CREATE TABLE vaga(
id int not null auto_increment primary key,
titulo    varchar (50),
cargo     varchar(50),
formacao  varchar(40),
periodo   varchar (20),
regime    varchar(15),
descricao varchar (500),
salario   decimal(7,2)
);



