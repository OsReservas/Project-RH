CREATE SCHEMA `bancotech` DEFAULT CHARACTER SET utf8mb4 ;

use bancotech;

CREATE TABLE vaga(
id int not null auto_increment,
titulo    varchar (100) not null,
cargo     varchar(100) not null,
formacao  varchar(100) not null,
periodo   varchar (30) not null,
regime    varchar(15) not null,
descricao varchar (500) not null,
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
nascimento     varchar (20) not null,
nacionalidade  varchar(50) not null,
sexo   varchar (15) not null,
raca   varchar(15) not null,
linkedin   varchar(100) not null,
telefone  varchar (15) ,
celular varchar (15) not null unique,
cep varchar (15) not null,
logadouro varchar (100) not null,
endereco varchar (100) not null,
numero varchar(30) not null,
cidade varchar (50) not null,
complemento  varchar (30),
idusuario int,
foreign key(idusuario) references usuario(id),
primary key (idcandidato)
);

CREATE TABLE formacao(
idformacao int not null auto_increment,
tipo    varchar (20) not null,
nomeformacao     varchar (50) not null,
instituicao  varchar(50) not null,
inicio   varchar (15) not null,
termino   varchar(15) not null,
situacao   varchar(30) not null, 
idcandidato int,
foreign key(idcandidato) references candidato(idcandidato),
primary key (idformacao)
);

CREATE TABLE curso(
idcurso int not null auto_increment,
nomecurso varchar (100) not null,
instituicao  varchar(100) not null,
conclusao   varchar (30) not null,
nivel   varchar(30) not null,
idioma   varchar(50) not null,
idcandidato int,
foreign key(idcandidato) references candidato(idcandidato),
primary key (idcurso)
);

CREATE TABLE experiencia(
idexperiencia int not null auto_increment,
empresa    varchar (100) not null,
cargo     varchar (50) not null,
segmento  varchar(50) not null,
inicio   varchar (15) not null,
termino   varchar(15),
atual   varchar(15) not null,  
descricao   varchar(500) not null,
idcandidato int,
foreign key(idcandidato) references candidato(idcandidato),  
primary key (idexperiencia)
);

CREATE TABLE aplicado(
idaplicado int not null auto_increment,
dia timestamp default current_timestamp,
idcandidato int,
idvaga int,
titulovaga varchar(100),
andamento varchar(50),
observacao varchar(255),
foreign key(idcandidato) references candidato(idcandidato),
foreign key(idvaga) references vaga(id),
unique (idcandidato, idvaga),
primary key (idaplicado));

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

insert into vaga (titulo, cargo, formacao, periodo, regime, descricao, salario, ativo) values ('Desenvolvedor Java','Dev Sr', 'Banco de Dados', '9h as 17h', 'PJ', 'Trabalhar em equipe', '9999,00', 'SIM');
insert into vaga (titulo, cargo, formacao, periodo, regime, descricao, salario, ativo) values ('Desenvolvedor Python','Dev Jr', 'Analise e Dev de Sistemas', '10h as 19h', 'CLT', 'Trabalhar muiti', '8999,00', 'SIM');
insert into vaga (titulo, cargo, formacao, periodo, regime, descricao, salario, ativo) values ('Desenvolvedor C++','Dev Pleno', 'Banco de Dados', '9h as 17h', 'Freelancer', 'Trabalhar em equipe', '1000,00', 'SIM');
