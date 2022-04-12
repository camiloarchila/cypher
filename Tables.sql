--TABLES
create table usuarios(

documento INT NOT NULL,
nombre VARCHAR(20) NOT NULL,
contrasena VARCHAR(16) NOT NULL,
correo VARCHAR(20) NOT NULL,
telefono VARCHAR(20),
tipousuario VARCHAR(3) NOT NULL

);

create table tipo_usuario(

id_tipousuario VARCHAR(3) NOT NULL,
nombre VARCHAR(20) NOT NULL,
descripcion VARCHAR(150)

);

create table recursos(

id_recursos INT NOT NULL,
nombre VARCHAR(20) NOT NULL,
ubicacion VARCHAR(20) NOT NULL,
capacidad INT NOT NULL,
tiporecurso INT NOT NULL,
fecha DATE NOT NULL,
horario_inicial TIME NOT NULL,
horario_final TIME NOT NULL

);

create table tipo_recurso(

id_tiporecurso INT NOT NULL,
nombre VARCHAR(20) NOT NULL,
descripcion VARCHAR(22) NOT NULL

);

--PK
ALTER TABLE usuarios ADD CONSTRAINT pk_usuario PRIMARY KEY (documento);
ALTER TABLE tipo_usuario ADD CONSTRAINT pk_tipousuario PRIMARY KEY (id_tipousuario);
ALTER TABLE recursos ADD CONSTRAINT pk_recursos PRIMARY KEY (id_recursos);
ALTER TABLE tipo_recurso ADD CONSTRAINT pk_tipo_recurso PRIMARY KEY (id_tiporecurso);

--FK
ALTER TABLE usuarios ADD FOREIGN KEY (tipousuario) REFERENCES tipo_usuario(id_tipousuario);
ALTER TABLE recursos ADD FOREIGN KEY (tiporecurso) REFERENCES tipo_recurso(id_tiporecurso);

--UK
ALTER TABLE usuarios ADD CONSTRAINT uk_correo UNIQUE (correo);

--drop 
drop table usuarios;
drop table recursos;
drop table tipo_usuario;
drop table tipo_recurso;




