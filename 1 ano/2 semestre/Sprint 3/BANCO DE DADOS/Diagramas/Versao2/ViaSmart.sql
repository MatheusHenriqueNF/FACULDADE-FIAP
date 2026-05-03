-- 1. CRIAÇÃO DE TODAS AS TABELAS
CREATE TABLE Challenge_Estacao(
    id_estacao NUMBER(11),
    nome_estacao VARCHAR2(30),
    status CHAR(1),
    id_usuario NUMBER(11)
);

CREATE TABLE Challenge_Linha(
    id_linha NUMBER(11),
    nome_linha VARCHAR2(30),
    status CHAR(1),
    id_usuario NUMBER(11)
);

CREATE TABLE Challenge_Historico_Busca(
    id_busca NUMBER(11),
    origem VARCHAR2(30),
    destino VARCHAR2(30),
    id_estacao NUMBER(11)
);

CREATE TABLE Challenge_Estacao_Linha(
    id_estacao_linha NUMBER(11),
    id_estacao NUMBER(11),
    id_linha NUMBER(11),
    id_usuario NUMBER(11)
);

CREATE TABLE Challenge_Tipo_Usuario(
    id_tipo_usuario NUMBER(11),
    nome_tipo_usuario VARCHAR2(20),
    status CHAR(1)
);

CREATE TABLE Challenge_Usuario(
    id_usuario NUMBER(11),
    nome_usuario VARCHAR2(11),
    senha VARCHAR2(255),
    ultimo_acesso DATE,
    id_tipo_usuario NUMBER(11)
);

CREATE TABLE Challenge_Logs(
    id_log NUMBER(11),
    acao VARCHAR2(20),
    data_hora_acao DATE,
    id_usuario NUMBER(11)
);

CREATE TABLE Challenge_Pergunta_Frequente(
    id_pergunta NUMBER(11),
    pergunta VARCHAR2(50),
    resposta VARCHAR2(100),
    id_idioma NUMBER(11),
    id_estacao NUMBER(11),
    id_categoria NUMBER(11),
    status CHAR(1),
    id_usuario NUMBER(11)
);

CREATE TABLE Challenge_Idioma(
    id_idioma NUMBER(11),
    nome_idioma VARCHAR2(30),
    status CHAR(1),
    id_usuario NUMBER(11)
);

CREATE TABLE Challenge_Categoria(
    id_categoria NUMBER(11),
    nome_categoria VARCHAR2(30),
    descricao_categoria VARCHAR2(20),
    status CHAR(1),
    id_usuario NUMBER(11)
);

-- 2. ADIÇÃO DE TODAS AS CHAVES PRIMÁRIAS
ALTER TABLE Challenge_Estacao ADD PRIMARY KEY (id_estacao);

ALTER TABLE Challenge_Linha ADD PRIMARY KEY (id_linha);

ALTER TABLE Challenge_Historico_Busca ADD PRIMARY KEY (id_busca);

ALTER TABLE Challenge_Estacao_Linha ADD PRIMARY KEY (id_estacao_linha
);
ALTER TABLE Challenge_Tipo_Usuario ADD PRIMARY KEY (id_tipo_usuario);

ALTER TABLE Challenge_Usuario ADD PRIMARY KEY (id_usuario);

ALTER TABLE Challenge_Logs ADD PRIMARY KEY (id_log);

ALTER TABLE Challenge_Pergunta_Frequente ADD PRIMARY KEY (id_pergunta);

ALTER TABLE Challenge_Idioma ADD PRIMARY KEY (id_idioma);

ALTER TABLE Challenge_Categoria ADD PRIMARY KEY (id_categoria);

-- 3. DEFINIÇÃO DE NOT NULL NAS COLUNAS
ALTER TABLE Challenge_Estacao MODIFY id_estacao NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Estacao MODIFY nome_estacao VARCHAR2(30) NOT NULL;
ALTER TABLE Challenge_Estacao MODIFY status CHAR(1) NOT NULL;
ALTER TABLE Challenge_Estacao MODIFY id_usuario NUMBER(11) NOT NULL;

ALTER TABLE Challenge_Linha MODIFY id_linha NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Linha MODIFY nome_linha VARCHAR2(30) NOT NULL;
ALTER TABLE Challenge_Linha MODIFY status CHAR(1) NOT NULL;
ALTER TABLE Challenge_Linha MODIFY id_usuario NUMBER(11) NOT NULL;

ALTER TABLE Challenge_Historico_Busca MODIFY id_busca NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Historico_Busca MODIFY origem VARCHAR2(30) NOT NULL;
ALTER TABLE Challenge_Historico_Busca MODIFY destino VARCHAR2(30) NOT NULL;
ALTER TABLE Challenge_Historico_Busca MODIFY id_estacao NUMBER(11) NOT NULL;

ALTER TABLE Challenge_Usuario MODIFY id_usuario NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Usuario MODIFY nome_usuario VARCHAR2(11) NOT NULL;
ALTER TABLE Challenge_Usuario MODIFY senha VARCHAR2(255) NOT NULL;
ALTER TABLE Challenge_Usuario MODIFY id_tipo_usuario NUMBER(11) NOT NULL;

-- 4. ADIÇÃO DE CHAVES ESTRANGEIRAS
ALTER TABLE Challenge_Estacao ADD CONSTRAINT FK_ID_ESTACAO FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);

ALTER TABLE Challenge_Linha ADD CONSTRAINT FK_ID_USUARIO_LINHA FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);

ALTER TABLE Challenge_Historico_Busca ADD CONSTRAINT FK_ID_ESTACAO_BUSCA FOREIGN KEY (id_estacao) REFERENCES Challenge_Estacao(id_estacao);

ALTER TABLE Challenge_Estacao_Linha ADD CONSTRAINT FK_ID_ESTACAO_LINHA FOREIGN KEY (id_estacao) REFERENCES Challenge_Estacao(id_estacao);
ALTER TABLE Challenge_Estacao_Linha ADD CONSTRAINT FK_ID_LINHA_LINHA FOREIGN KEY (id_linha) REFERENCES Challenge_Linha(id_linha);
ALTER TABLE Challenge_Estacao_Linha ADD CONSTRAINT FK_ID_USER_LINHA FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);

ALTER TABLE Challenge_Usuario ADD CONSTRAINT FK_ID_TIPO_USUARIO FOREIGN KEY (id_tipo_usuario) REFERENCES Challenge_Tipo_Usuario(id_tipo_usuario);

ALTER TABLE Challenge_Logs ADD CONSTRAINT FK_ID_USUARIO_LOGS FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);

ALTER TABLE Challenge_Pergunta_Frequente ADD CONSTRAINT FK_ID_IDIOMA_PERGUNTA FOREIGN KEY (id_idioma) REFERENCES Challenge_Idioma(id_idioma);
ALTER TABLE Challenge_Pergunta_Frequente ADD CONSTRAINT FK_ID_ESTACAO_PERGUNTA FOREIGN KEY (id_estacao) REFERENCES Challenge_Estacao(id_estacao);
ALTER TABLE Challenge_Pergunta_Frequente ADD CONSTRAINT FK_ID_CATEGORIA_PERGUNTA FOREIGN KEY (id_categoria) REFERENCES Challenge_Categoria(id_categoria);
ALTER TABLE Challenge_Pergunta_Frequente ADD CONSTRAINT FK_ID_USUARIO_PERGUNTA FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);

ALTER TABLE Challenge_Idioma ADD CONSTRAINT FK_ID_USUARIO_IDIOMA FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);

ALTER TABLE Challenge_Categoria ADD CONSTRAINT FK_ID_USUARIO_CATEGORIA FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);

-- 5. ADIÇÃO DE RESTRIÇÕES UNIQUE
ALTER TABLE Challenge_Estacao ADD UNIQUE (nome_estacao);

ALTER TABLE Challenge_Linha ADD UNIQUE (nome_linha);

ALTER TABLE Challenge_Usuario ADD UNIQUE (nome_usuario);

ALTER TABLE Challenge_Tipo_Usuario ADD UNIQUE (nome_tipo_usuario);

ALTER TABLE Challenge_Categoria ADD UNIQUE (nome_categoria);

CREATE SEQUENCE seq_estacao START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_linha START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_historico_busca START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_estacao_linha START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_tipo_usuario START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_usuario START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_logs START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_pergunta START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_idioma START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_categoria START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_estacao
BEFORE INSERT ON Challenge_Estacao
FOR EACH ROW
BEGIN
  SELECT seq_estacao.NEXTVAL INTO :NEW.id_estacao FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER trg_linha
BEFORE INSERT ON Challenge_Linha
FOR EACH ROW
BEGIN
  SELECT seq_linha.NEXTVAL INTO :NEW.id_linha FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER trg_historico_busca
BEFORE INSERT ON Challenge_Historico_Busca
FOR EACH ROW
BEGIN
  SELECT seq_historico_busca.NEXTVAL INTO :NEW.id_busca FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER trg_estacao_linha
BEFORE INSERT ON Challenge_Estacao_Linha
FOR EACH ROW
BEGIN
  SELECT seq_estacao_linha.NEXTVAL INTO :NEW.id_estacao_linha FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER trg_tipo_usuario
BEFORE INSERT ON Challenge_Tipo_Usuario
FOR EACH ROW
BEGIN
  SELECT seq_tipo_usuario.NEXTVAL INTO :NEW.id_tipo_usuario FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER trg_usuario
BEFORE INSERT ON Challenge_Usuario
FOR EACH ROW
BEGIN
  SELECT seq_usuario.NEXTVAL INTO :NEW.id_usuario FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER trg_logs
BEFORE INSERT ON Challenge_Logs
FOR EACH ROW
BEGIN
  SELECT seq_logs.NEXTVAL INTO :NEW.id_log FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER trg_pergunta
BEFORE INSERT ON Challenge_Pergunta_Frequente
FOR EACH ROW
BEGIN
  SELECT seq_pergunta.NEXTVAL INTO :NEW.id_pergunta FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER trg_idioma
BEFORE INSERT ON Challenge_Idioma
FOR EACH ROW
BEGIN
  SELECT seq_idioma.NEXTVAL INTO :NEW.id_idioma FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER trg_categoria
BEFORE INSERT ON Challenge_Categoria
FOR EACH ROW
BEGIN
  SELECT seq_categoria.NEXTVAL INTO :NEW.id_categoria FROM DUAL;
END;
/

INSERT INTO Challenge_Tipo_Usuario (nome_tipo_usuario, status) 
VALUES ('Administrador', 1);

INSERT INTO Challenge_Usuario (nome_usuario, senha, ultimo_acesso, id_tipo_usuario) 
VALUES ('admin', 'admin123', SYSDATE, 1);

commit;