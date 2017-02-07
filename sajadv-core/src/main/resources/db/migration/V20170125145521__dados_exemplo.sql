-- as situaçoes presentes no documento
insert into Situacao(idsituacao,nome,finalizado) values(1,'Em andamento',false);
insert into Situacao(idsituacao,nome,finalizado) values(2,'Desmembrado' ,false);
insert into Situacao(idsituacao,nome,finalizado) values(3,'Em Recurso'  ,false);
insert into Situacao(idsituacao,nome,finalizado) values(4,'Finalizado'  ,true );
insert into Situacao(idsituacao,nome,finalizado) values(5,'Arquivado'   ,true );

-- responsáveis fictícios
insert into Responsavel(cpf,nome) values('111.222.333-44','Maria');
insert into Responsavel(cpf,nome) values('222.333.444-55','Marina');
insert into Responsavel(cpf,nome) values('333.444.555-66','Mariana');
insert into Responsavel(cpf,nome) values('444.555.666-77','Pedro');
insert into Responsavel(cpf,nome) values('555.666.777-88','Paulo');
insert into Responsavel(cpf,nome) values('666.777.888-99','Saulo');
insert into Responsavel(cpf,nome) values('777.888.999-00','Alfredo');
insert into Responsavel(cpf,nome) values('888.999.000-11','Marcos');
insert into Responsavel(cpf,nome) values('999.000.111-22','Xuxa');
insert into Responsavel(cpf,nome) values('000.111.222-33','Eliane');

-- processos fictítios que serão pai dos outros
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao) values('1234567-89.2017.01.25.0001','2017-01-24',true,'/PASTA0001','é uma longa história.',1);
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao) values('1234567-89.2017.01.25.0002','2017-01-24',true,'/PASTA0001','é uma longa história.',2);
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao) values('1234567-89.2017.01.25.0003','2017-01-24',false,'/PASTA0001','é uma longa história.',3);
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao) values('1234567-89.2017.01.25.0004','2017-01-24',true,'/PASTA0001','é uma longa história.',4);

-- processos fictícios com pai
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0005','2017-01-25',true,'/PASTA0001','é uma longa história.',5,'1234567-89.2017.01.25.0001');
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0006','2017-01-25',true,'/PASTA0001','é uma longa história.',1,'1234567-89.2017.01.25.0001');
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0007','2017-01-25',true,'/PASTA0001','é uma longa história.',2,'1234567-89.2017.01.25.0001');
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0008','2017-01-26',false,'/PASTA0001','é uma longa história.',3,'1234567-89.2017.01.25.0002');
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0009','2017-01-26',true,'/PASTA0001','é uma longa história.',4,'1234567-89.2017.01.25.0002');
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0010','2017-01-26',true,'/PASTA0001','é uma longa história.',5,'1234567-89.2017.01.25.0003');
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0011','2017-01-26',true,'/PASTA0001','é uma longa história.',1,'1234567-89.2017.01.25.0003');
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0012','2017-01-27',false,'/PASTA0001','é uma longa história.',2,'1234567-89.2017.01.25.0003');
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0013','2017-01-27',true,'/PASTA0001','é uma longa história.',3,'1234567-89.2017.01.25.0004');
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0014','2017-01-27',true,'/PASTA0001','é uma longa história.',4,'1234567-89.2017.01.25.0005');
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0015','2017-01-27',true,'/PASTA0001','é uma longa história.',5,'1234567-89.2017.01.25.0005');
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0016','2017-01-27',false,'/PASTA0001','é uma longa história.',1,'1234567-89.2017.01.25.0006');
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0017','2017-01-28',true,'/PASTA0001','é uma longa história.',2,'1234567-89.2017.01.25.0014');
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao,numeroProcessopai) values('1234567-89.2017.01.25.0018','2017-01-28',true,'/PASTA0001','é uma longa história.',3,'1234567-89.2017.01.25.0014');

-- processos fictícios nem filhos nem pais de ninguém
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao) values('1234567-89.2017.01.25.0019','2017-01-29',true,'/PASTA0001','é uma longa história.',4);
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao) values('1234567-89.2017.01.25.0020','2017-01-29',false,'/PASTA0001','é uma longa história.',5);
insert into Processo(numeroprocessounificado,dataDistribuicao,segredoJustica,pastaFisicaCliente,descricao,idsituacao) values('1234567-89.2017.01.25.0021','2017-01-29',true,'/PASTA0001','é uma longa história.',1);

-- relacionar alguns responsáveis com alguns processos

insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0001','111.222.333-44');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0002','222.333.444-55');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0003','333.444.555-66');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0004','444.555.666-77');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0004','555.666.777-88');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0004','666.777.888-99');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0005','777.888.999-00');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0006','888.999.000-11');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0007','999.000.111-22');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0008','111.222.333-44');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0009','222.333.444-55');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0010','333.444.555-66');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0011','444.555.666-77');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0012','555.666.777-88');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0013','666.777.888-99');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0014','777.888.999-00');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0015','888.999.000-11');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0016','999.000.111-22');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0017','111.222.333-44');
insert into Processo_Responsavel(numeroprocessounificado,cpf) values('1234567-89.2017.01.25.0018','222.333.444-55');

