-- Criação das tabelas
CREATE TABLE Curso(
    codigo INTEGER,
    nome VARCHAR(80),
    area VARCHAR(80),
    CONSTRAINT curso_pk PRIMARY KEY (codigo)
);

CREATE TABLE Professor(
    matricula INTEGER,
    nome VARCHAR(80),
    area VARCHAR(40),
    CONSTRAINT professor_pk PRIMARY KEY (matricula)
);

CREATE TABLE Aluno (
    matricula INTEGER  ,
    nome VARCHAR(80),
    rua VARCHAR(80),
    numero INTEGER,
    bairro VARCHAR(40),
    cidade VARCHAR(80),
    cod_curso INTEGER,
    CONSTRAINT aluno_pk PRIMARY KEY (matricula),
    CONSTRAINT aluno_curso_fk FOREIGN KEY (cod_curso) REFERENCES Curso(codigo)
);

CREATE TABLE disciplina (
    codigo INTEGER,
    nome VARCHAR(80),
    carga_horaria INTEGER,
    cod_curso INTEGER,
    cod_prof INTEGER,
    CONSTRAINT disciplina_pk PRIMARY KEY(codigo),
    CONSTRAINT disciplina_cur_fk FOREIGN KEY (cod_curso) REFERENCES Curso(codigo),
    CONSTRAINT disciplina_prof_fk FOREIGN KEY (cod_prof) REFERENCES Professor(matricula)
    );
    
CREATE TABLE matricula(
    matricula_aluno INTEGER,
    cod_disciplina INTEGER,
    periodo_matricula VARCHAR(10),
    CONSTRAINT matricula_pk PRIMARY KEY (matricula_aluno,cod_disciplina,periodo_matricula),
    CONSTRAINT matricula_aluno FOREIGN KEY (matricula_aluno) REFERENCES Aluno(matricula),
    CONSTRAINT matricula_disciplina FOREIGN KEY (cod_disciplina) REFERENCES Disciplina(codigo)
);

CREATE TABLE usuario (
    id BIGINT,
    username VARCHAR(60) NOT NULL,
    nome VARCHAR(60) NOT NULL,
    senha_hash VARCHAR(512) NOT NULL,
    status VARCHAR(30),
    CONSTRAINT usuario_pk PRIMARY KEY(id)  
);

CREATE TABLE perfil (
    id BIGINT,
    nome VARCHAR(60) NOT NULL,
    CONSTRAINT perfil_pk PRIMARY KEY(id)  
);

CREATE TABLE usuario_perfil(
    id_usuario BIGINT,
    id_perfil BIGINT,
    CONSTRAINT pk_usuario_perfil PRIMARY KEY (id_usuario,id_perfil),
    CONSTRAINT fk_u_perfil FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    CONSTRAINT fk_usuario_perfil FOREIGN KEY (id_perfil) REFERENCES perfil(id)
);

CREATE TABLE funcionalidade (
    id VARCHAR(30),
    url VARCHAR(256),
    nome VARCHAR(60),
    CONSTRAINT funcionalidade_pk PRIMARY KEY(id)  
);

CREATE TABLE funcionalidade_perfil(
    id_funcionalidade VARCHAR(30),
    id_perfil VARCHAR(30),
    CONSTRAINT pk_func_perfil PRIMARY KEY (id_funcionalidade,id_perfil),
    CONSTRAINT fk_f_perfil FOREIGN KEY (id_funcionalidade) REFERENCES Funcionalidade(id),
    CONSTRAINT fk_p_perfil FOREIGN KEY (id_perfil) REFERENCES perfil(id)
);

-- Criação das sequences
CREATE SEQUENCE aluno_seq
 START WITH     1
 INCREMENT BY   1
 CACHE 1
  NO CYCLE;
 
CREATE SEQUENCE aluno_seq
 START WITH     1
 INCREMENT BY   1
 CACHE 1
  NO CYCLE;
 

CREATE SEQUENCE curso_seq
 START WITH     1
 INCREMENT BY   1
 CACHE 1
  NO CYCLE;
 
CREATE SEQUENCE professor_seq
 START WITH     1
 INCREMENT BY   1
 CACHE 1
  NO CYCLE;

CREATE SEQUENCE disciplina_seq
 START WITH     1
 INCREMENT BY   1
 CACHE 1
  NO CYCLE;
 
 CREATE SEQUENCE matricula_seq
 START WITH     1
 INCREMENT BY   1
 CACHE 1
  NO CYCLE;
 
 CREATE SEQUENCE usuario_seq
  START WITH 1
  INCREMENT BY 1
  CACHE 1
  NO CYCLE;
 
 CREATE SEQUENCE perfil_seq
 START WITH     1
 INCREMENT BY   1
 CACHE 1
 NO CYCLE;

-- Inserts dos usuários e perfis
INSERT INTO usuario VALUES (1,'admin@suap.edu.br', 'Adm Master', '$2a$10$Ckqz5CKBEMXDu19vES8SCuOXspzairum4wWjmbOaq.pckZ6nUzvBq','Ativo');
INSERT INTO usuario VALUES (2,'coordenador@suap.edu.br', 'Coordenador', '$2a$10$Ckqz5CKBEMXDu19vES8SCuOXspzairum4wWjmbOaq.pckZ6nUzvBq','Ativo');
INSERT INTO usuario VALUES (3,'professor@suap.edu.br', 'Professor', '$2a$10$Ckqz5CKBEMXDu19vES8SCuOXspzairum4wWjmbOaq.pckZ6nUzvBq','Ativo');
INSERT INTO usuario VALUES (4,'aluno@suap.edu.br', 'Aluno', '$2a$10$Ckqz5CKBEMXDu19vES8SCuOXspzairum4wWjmbOaq.pckZ6nUzvBq','Ativo');
INSERT INTO perfil VALUES(1, 'ADMIN');
INSERT INTO perfil VALUES(2, 'COORDENADOR');
INSERT INTO perfil VALUES(3, 'PROFESSOR');
INSERT INTO perfil VALUES(4, 'ESTUDANTE');
INSERT INTO usuario_perfil VALUES (1, 1);
INSERT INTO usuario_perfil VALUES (2, 2);
INSERT INTO usuario_perfil VALUES (3, 3);
INSERT INTO usuario_perfil VALUES (4, 4);