--
-- Sistemas de migração são um meio eficiente de manter e evoluir o esquema 
-- relacional de um sistema. A principal vantagem do flyway é a simplicidade 
-- e a integração sem traumas com as especificações JEE vigentes.
--
-- https://flywaydb.org/documentation/
--

-- responsável
create table Responsavel(
  cpf varchar(255) not null primary key,
  nome varchar(255) not null
);

-- Situação, que poderia ser só um enum mas sendo entidade prevemos a evolução sadia dela
create table Situacao(
  idsituacao integer not null primary key,
  nome varchar(255) not null,
  finalizado boolean default false
);

-- Entidade principal do sistema
create table Processo(
  numeroprocessounificado varchar(255) not null primary key,
  dataDistribuicao date not null,
  segredoJustica boolean default false,
  pastaFisicaCliente varchar(255),
  descricao long varchar, -- https://db.apache.org/derby/docs/10.1/ref/rrefsqlj15147.html
  idsituacao integer not null default 1,
  numeroProcessopai varchar(255),
  foreign key(numeroProcessopai) references Processo(numeroprocessounificado),
  foreign key(idsituacao) references Situacao(idsituacao)
);

-- Tabela para carregarmos o relacionamento N:N entre responsável e processo
create table Processo_Responsavel(
  numeroprocessounificado varchar(255) not null,
  cpf varchar(255) not null,
  foreign key(numeroprocessounificado) references Processo(numeroprocessounificado),
  foreign key(cpf) references Responsavel(cpf),
  primary key(numeroprocessounificado,cpf)
);
