create database madrugasoundsBD;
use madrugasoundsBD;

CREATE TABLE Gerente(
idGerente int not null auto_increment,
nome varchar(45),
dataNasc varchar(12),
telefone varchar(15),
endereco varchar(100),
salario varchar(20),
email varchar(45),
primary key (idGerente)
);
drop table Vendedor;
 delete  from Vendedor where idVendedor = 8 ;
 delete  from Gerente where idGerente = 9 ;
 delete  from Gerente where idGerente = 10 ;
 delete  from Gerente where idGerente = 11 ;
 delete  from Gerente where idGerente = 12 ;
 delete  from Gerente where idGerente = 13 ;
 delete  from Gerente where idGerente = 14 ;

create table Vendedor(
idVendedor int not null auto_increment,
nome varchar(45),
dataNasc varchar(12),
telefone varchar(15),
endereco varchar(100),
salario varchar(20),
email varchar(45),
Gerente_idGerente int,
primary key (idVendedor)
);

create table CategoriaProduto(
idCategoria int not null auto_increment,
categoriaNomeProduto varchar(45),
primary key (idCategoria)
);


create table Produto(
idProduto int not null auto_increment,
marca varchar(45),
CategoriaProduto_idCategoria int not null,
foreign key (CategoriaProduto_idCategoria) references CategoriaProduto(idCategoria),
valor float,
qtdProd int,
primary key (idProduto)
);

create table Cliente(
cpf varchar(12) not null,
rg varchar(10) not null,
nome varchar(45) not null,
endereco varchar(100) not null,
telefone varchar(15),
email varchar(45),
primary key (cpf)
);


create table Compra(
idCompra int not null auto_increment,
data Date,
Cliente_cpf varchar(12) not null,
Produto_idProduto int not null,
primary key (idCompra),
foreign key (Cliente_cpf) references Cliente(cpf),
foreign key (Produto_idProduto) references Produto(idProduto)
);

create table Atende(
codAtendimento int not null auto_increment,
data varchar(12),
Vendedor_idVendedor int not null,
Cliente_cpf varchar(12) not null,
primary key (codAtendimento),
foreign key (Vendedor_idVendedor) references Vendedor(idVendedor),
foreign key (Cliente_cpf) references Cliente(cpf)
);

create table Vende(
idVenda int not null auto_increment,
data varchar(12),
Vendedor_idVendedor int not null,
Produto_idProduto int not null,
primary key (idVenda),
foreign key (Vendedor_idVendedor) references Vendedor(idVendedor),
foreign key (Produto_idProduto) references Produto(idProduto)
);