CREATE TABLE publicacao(
  issn VARCHAR(50) PRIMARY KEY,
  titulop VARCHAR(50) NOT NULL,
  editor VARCHAR(50),
  url VARCHAR(100));

CREATE TABLE area(
  area_id BIGINT PRIMARY KEY,
  descricaoa VARCHAR(50) NOT NULL);

CREATE TABLE artigo (
  artigo_id BIGINT PRIMARY KEY,
  tituloa VARCHAR(50) NOT NULL UNIQUE,
  issn VARCHAR(50),
  ano DATE,
  numero_de_paginas INT CHECK(numero_de_paginas > 0),
  area_id BIGINT,

  CONSTRAINT fk_area_id_area FOREIGN KEY(area_id) REFERENCES area(area_id),
  CONSTRAINT fk_issn_publicacao FOREIGN KEY(issn) REFERENCES publicacao(issn));

CREATE TABLE palavra_chave (
  pc BIGINT PRIMARY KEY,
  descricaopc VARCHAR(50));

CREATE TABLE artigo_pc (
  id BIGINT,
  artigo_id BIGINT,
  pc BIGINT,
  CONSTRAINT pk_artigo_pc PRIMARY KEY(id),
  CONSTRAINT fk_artigo_id_artigo FOREIGN KEY(artigo_id) REFERENCES artigo(artigo_id),
  CONSTRAINT fk_pc_palavra_chave FOREIGN KEY(pc) REFERENCES palavra_chave(pc));

INSERT INTO area VALUES (10, 'Banco de Dados');
INSERT INTO area VALUES (20, 'Inteligência Artificial');

INSERT INTO publicacao VALUES('2515-8761', 'Brazilian Journal of Development', 'Brazilian Journals Publicações', 'https://www.brazilianjournals.com/');
INSERT INTO publicacao VALUES('1041-4347', 'IEEE Transactions', 'IEEE', 'https://www.computer.org/csdl/journal/tk');
INSERT INTO publicacao VALUES('0007-6813', 'Business Horizons', 'Kelley School of Business', 'https://www.sciencedirect.com/journal/business-horizons/');

INSERT INTO artigo VALUES (1, 'ConceptER - Modelo Entidade-Relacionamento', '2515-8761', to_date('2020','YYYY'), null, 10);
INSERT INTO artigo VALUES (2, 'Database Meets Artificial Intelligence', '1041-4347', to_date('2020','YYYY'), 12, 10);
INSERT INTO artigo VALUES (3, 'Artificial intelligence: innovation typology', '0007-6813', to_date('2020','YYYY'), 9, 20);

INSERT INTO palavra_chave VALUES (100, 'Banco de Dados');
INSERT INTO palavra_chave VALUES (200, 'Inteligência Artificial');
INSERT INTO palavra_chave VALUES (300, 'DER');
INSERT INTO palavra_chave VALUES (400, 'SQL');
INSERT INTO palavra_chave VALUES (500, 'scripts');
INSERT INTO palavra_chave VALUES (600, 'Aprendizado de Máquina');
INSERT INTO palavra_chave VALUES (700, 'Tomada de Decisão');

INSERT INTO artigo_pc VALUES (1, 1, 100);
INSERT INTO artigo_pc VALUES (2, 1, 300);
INSERT INTO artigo_pc VALUES (3, 1, 400);
INSERT INTO artigo_pc VALUES (4, 1, 500);
INSERT INTO artigo_pc VALUES (5, 2, 100);
INSERT INTO artigo_pc VALUES (6, 2, 200);
INSERT INTO artigo_pc VALUES (7, 3, 200);
INSERT INTO artigo_pc VALUES (8, 3, 600);
INSERT INTO artigo_pc VALUES (9, 3, 700);
