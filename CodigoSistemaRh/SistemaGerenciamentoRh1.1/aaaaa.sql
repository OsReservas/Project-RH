CREATE SCHEMA `bancotech` DEFAULT CHARACTER SET utf8mb4 ;

CREATE TABLE vaga(
id int not null auto_increment,
titulo    varchar (50) not null,
cargo     varchar(50),
formacao  varchar(40),
periodo   varchar (20),
regime    varchar(15),
descricao varchar (500),
salario   varchar(10),
ativo     varchar(5),
primary key (id)
);

CREATE TABLE usuario(
id int not null auto_increment,
nome    varchar (70) not null,
cpf     varchar (20) unique not null,
email  varchar(100) unique not null,
senha   varchar (260) not null,
acesso   varchar(15),
ativo   varchar(5),  
primary key (id)
);

CREATE TABLE candidato(
idcandidato int not null auto_increment,
nascimento     varchar (20),
nacionalidade  varchar(20),
sexo   varchar (15) not null,
raca   varchar(15),
linkedin   varchar(50),
telefone  varchar (15),
celular varchar (15) unique not null,
cep varchar (10),
logadouro varchar (10),
endereco varchar (50),
numero bigint,
cidade varchar (50),
complemento  varchar (30),
idusuario int,
idformacao int,
idcurso int,
idexperiencia int,
foreign key(idusuario) references usuario(id),
foreign key(idformacao) references formacao(idformacao),
foreign key(idcurso) references curso (idcurso),
foreign key(idexperiencia) references experiencia(idexperiencia),
primary key (idcandidato)
);

drop table candidato;

ALTER TABLE candidato change nascionalidade nacionalidade varchar(20);

describe candidato;

CREATE TABLE formacao(
idformacao int not null auto_increment,
tipo    varchar (20) not null,
nomeformacao     varchar (50) unique not null,
instituicao  varchar(50) unique not null,
inicio   varchar (15) not null,
termino   varchar(15),
situacao   varchar(15),  
primary key (idformacao)
);

CREATE TABLE curso(
idcurso int not null auto_increment,
nomecurso   varchar (20) not null,
instituicao  varchar(50) unique not null,
conclusao   varchar (15) not null,
nivel   varchar(15),
idioma   varchar(30),
primary key (idcurso)
);


CREATE TABLE experiencia(
idexperiencia int not null auto_increment,
empresa    varchar (20) not null,
cargo     varchar (50) unique not null,
segmento  varchar(50) unique not null,
inicio   varchar (15) not null,
termino   varchar(15),
atual   varchar(15),  
descricao   varchar(500),  
primary key (idexperiencia)
);

CREATE TABLE aplicado(
idaplicado int not null auto_increment,
dia varchar(15),
idcandidato int,
idvaga int,
foreign key(idcandidato) references candidato(idcandidato),
foreign key(idvaga) references vaga(id),
primary key (idaplicado));

Insert INTO aplicado (mesa)  VALUES ('quadrado');



select * from candidato;

CREATE USER 'pro4tech'@'localhost' identified BY '12345';

GRANT select, insert, update, delete ON bancotech.vaga to 'pro4tech'@'localhost';

GRANT select, insert, update, delete ON bancotech.usuario to 'pro4tech'@'localhost';

GRANT select, insert, update, delete ON bancotech.candidato to 'pro4tech'@'localhost';

GRANT select, insert, update, delete ON bancotech.formacao to 'pro4tech'@'localhost';

GRANT select, insert, update, delete ON bancotech.experiencia to 'pro4tech'@'localhost';

GRANT select, insert, update, delete ON bancotech.curso to 'pro4tech'@'localhost';

GRANT select, insert, update, delete ON bancotech.aplicado to 'pro4tech'@'localhost';

insert into usuario (nome, cpf, email, senha, acesso, ativo) values ('rhpro4tec','111.111.111-11', 'rh@pro4tech.com', '8d79c3c06582cede889341b2afcae2fe', 'Rh', 'SIM');
insert into usuario (nome, cpf, email, senha, acesso, ativo) values ('adm', '000.000.000-00','adm@pro4tech.com', '80177534a0c99a7e3645b52f2027a48b', 'Admin','SIM' );