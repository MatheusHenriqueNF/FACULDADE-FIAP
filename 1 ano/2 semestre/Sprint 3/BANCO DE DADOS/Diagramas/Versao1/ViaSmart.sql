CREATE TABLE Challenge_Estacao(
    id_estacao NUMBER(11),
    nome_estacao VARCHAR2(30),
    status CHAR(1),
    id_usuario NUMBER(11)
);

ALTER TABLE Challenge_Estacao ADD PRIMARY KEY (id_estacao);
ALTER TABLE Challenge_Estacao MODIFY id_estacao NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Estacao MODIFY nome_estacao VARCHAR2(30) NOT NULL;
ALTER TABLE Challenge_Estacao MODIFY status CHAR(1) NOT NULL;
ALTER TABLE Challenge_Estacao MODIFY id_usuario NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Estacao ADD CONSTRAINT FK_ID_ESTACAO FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);
ALTER TABLE Challenge_Estacao ADD UNIQUE (nome_estacao);

CREATE TABLE Challenge_Linha(
    id_linha NUMBER(11),
    nome_linha VARCHAR2(30),
    status CHAR(1),
    id_usuario NUMBER(11)
);

ALTER TABLE Challenge_Linha ADD PRIMARY KEY (id_linha);
ALTER TABLE Challenge_Linha MODIFY id_linha NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Linha MODIFY nome_linha VARCHAR2(30) NOT NULL;
ALTER TABLE Challenge_Linha MODIFY status CHAR(1) NOT NULL;
ALTER TABLE Challenge_Linha MODIFY id_usuario NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Linha ADD CONSTRAINT FK_ID_USUARIO_LINHA FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);
ALTER TABLE Challenge_Linha ADD UNIQUE (nome_linha);

CREATE TABLE Challenge_Historico_Busca(
    id_busca NUMBER(11),
    origem VARCHAR2(30),
    destino VARCHAR2(30),
    id_estacao NUMBER(11)
);

ALTER TABLE Challenge_Historico_Busca ADD PRIMARY KEY (id_busca);
ALTER TABLE Challenge_Historico_Busca MODIFY id_busca NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Historico_Busca MODIFY origem VARCHAR2(30) NOT NULL;
ALTER TABLE Challenge_Historico_Busca MODIFY destino VARCHAR2(30) NOT NULL;
ALTER TABLE Challenge_Historico_Busca MODIFY id_estacao NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Historico_Busca ADD CONSTRAINT FK_ID_ESTACAO_BUSCA FOREIGN KEY (id_estacao) REFERENCES Challenge_Estacao(id_estacao);

CREATE TABLE Challenge_Estacao_Linha(
    id_estacao_linha NUMBER(11),
    id_estacao NUMBER(11),
    id_linha NUMBER(11),
    id_usuario NUMBER(11)
);

ALTER TABLE Challenge_Estacao_Linha ADD PRIMARY KEY (id_estacao_linha);
ALTER TABLE Challenge_Estacao_Linha MODIFY id_estacao_linha NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Estacao_Linha MODIFY id_estacao NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Estacao_Linha MODIFY id_linha NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Estacao_Linha MODIFY id_usuario NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Estacao_Linha ADD CONSTRAINT FK_ID_ESTACAO_LINHA FOREIGN KEY (id_estacao) REFERENCES Challenge_Estacao(id_estacao);
ALTER TABLE Challenge_Estacao_Linha ADD CONSTRAINT FK_ID_LINHA_LINHA FOREIGN KEY (id_linha) REFERENCES Challenge_Linha(id_linha);
ALTER TABLE Challenge_Estacao_Linha ADD CONSTRAINT FK_ID_USER_LINHA FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);

CREATE TABLE Challenge_Tipo_Usuario(
    id_tipo_usuario NUMBER(11),
    nome_tipo_usuario VARCHAR2(20),
    status CHAR(1)
);

ALTER TABLE Challenge_Tipo_Usuario ADD PRIMARY KEY (id_tipo_usuario);
ALTER TABLE Challenge_Tipo_Usuario MODIFY id_tipo_usuario NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Tipo_Usuario MODIFY nome_tipo_usuario VARCHAR2(20) NOT NULL;
ALTER TABLE Challenge_Tipo_Usuario MODIFY status CHAR(1) NOT NULL;
ALTER TABLE Challenge_Tipo_Usuario ADD UNIQUE (nome_tipo_usuario);

CREATE TABLE Challenge_Usuario(
    id_usuario NUMBER(11),
    nome_usuario VARCHAR2(11),
    senha VARCHAR2(255),
    ultimo_acesso DATE,
    id_tipo_usuario NUMBER(11)
);

ALTER TABLE Challenge_Usuario ADD PRIMARY KEY (id_usuario);
ALTER TABLE Challenge_Usuario MODIFY id_usuario NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Usuario MODIFY nome_usuario VARCHAR2(11) NOT NULL;
ALTER TABLE Challenge_Usuario MODIFY senha VARCHAR2(255) NOT NULL;
ALTER TABLE Challenge_Usuario MODIFY id_tipo_usuario NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Usuario ADD CONSTRAINT FK_ID_TIPO_USUARIO FOREIGN KEY (id_tipo_usuario) REFERENCES Challenge_Tipo_Usuario(id_tipo_usuario);
ALTER TABLE Challenge_Usuario ADD UNIQUE (nome_usuario);

CREATE TABLE Challenge_Logs(
    id_log NUMBER(11),
    acao VARCHAR2(20),
    data_hora_acao DATE,
    id_usuario NUMBER(11)
);

ALTER TABLE Challenge_Logs ADD PRIMARY KEY (id_log);
ALTER TABLE Challenge_Logs MODIFY id_log NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Logs MODIFY acao VARCHAR2(20) NOT NULL;
ALTER TABLE Challenge_Logs MODIFY data_hora_acao DATE NOT NULL;
ALTER TABLE Challenge_Logs MODIFY id_usuario NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Logs ADD CONSTRAINT FK_ID_USUARIO_LOGS FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);

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

ALTER TABLE Challenge_Pergunta_Frequente ADD PRIMARY KEY (id_pergunta);
ALTER TABLE Challenge_Pergunta_Frequente MODIFY id_pergunta NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Pergunta_Frequente MODIFY pergunta VARCHAR2(50) NOT NULL;
ALTER TABLE Challenge_Pergunta_Frequente MODIFY resposta VARCHAR2(100) NOT NULL;
ALTER TABLE Challenge_Pergunta_Frequente MODIFY status CHAR(1) NOT NULL;
ALTER TABLE Challenge_Pergunta_Frequente ADD CONSTRAINT FK_ID_IDIOMA_PERGUNTA FOREIGN KEY (id_idioma) REFERENCES Challenge_Idioma(id_idioma);
ALTER TABLE Challenge_Pergunta_Frequente ADD CONSTRAINT FK_ID_ESTACAO_PERGUNTA FOREIGN KEY (id_estacao) REFERENCES Challenge_Estacao(id_estacao);
ALTER TABLE Challenge_Pergunta_Frequente ADD CONSTRAINT FK_ID_CATEGORIA_PERGUNTA FOREIGN KEY (id_categoria) REFERENCES Challenge_Categoria(id_categoria);
ALTER TABLE Challenge_Pergunta_Frequente ADD CONSTRAINT FK_ID_USUARIO_PERGUNTA FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);

CREATE TABLE Challenge_Idioma(
    id_idioma NUMBER(11),
    nome_idioma VARCHAR2(30),
    status CHAR(1),
    id_usuario NUMBER(11)
);

ALTER TABLE Challenge_Idioma ADD PRIMARY KEY (id_idioma);
ALTER TABLE Challenge_Idioma MODIFY id_idioma NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Idioma MODIFY nome_idioma VARCHAR2(30) NOT NULL;
ALTER TABLE Challenge_Idioma MODIFY status CHAR(1) NOT NULL;
ALTER TABLE Challenge_Idioma ADD CONSTRAINT FK_ID_USUARIO_IDIOMA FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);

CREATE TABLE Challenge_Categoria(
    id_categoria NUMBER(11),
    nome_categoria VARCHAR2(30),
    descricao_categoria VARCHAR2(20),
    status CHAR(1),
    id_usuario NUMBER(11)
);

ALTER TABLE Challenge_Categoria ADD PRIMARY KEY (id_categoria);
ALTER TABLE Challenge_Categoria MODIFY id_categoria NUMBER(11) NOT NULL;
ALTER TABLE Challenge_Categoria MODIFY nome_categoria VARCHAR2(30) NOT NULL;
ALTER TABLE Challenge_Categoria MODIFY descricao_categoria VARCHAR2(20) NOT NULL;
ALTER TABLE Challenge_Categoria MODIFY status CHAR(1) NOT NULL;
ALTER TABLE Challenge_Categoria ADD CONSTRAINT FK_ID_USUARIO_CATEGORIA FOREIGN KEY (id_usuario) REFERENCES Challenge_Usuario(id_usuario);
ALTER TABLE Challenge_Categoria ADD UNIQUE (nome_categoria);


