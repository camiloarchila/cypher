--TABLES
create table usuarios(

documento INT NOT NULL,
nombre VARCHAR(20) NOT NULL,
contrasena VARCHAR(16) NOT NULL,
correo VARCHAR(20) NOT NULL,
telefono VARCHAR(20),
tipousuario INT NOT NULL

);

create table recursos(

id_recursos INT NOT NULL,
nombre VARCHAR(20) NOT NULL,
ubicacion VARCHAR(20) NOT NULL,
capacidad INT NOT NULL,
tiporecurso VARCHAR(20) NOT NULL,
fecha DATE NOT NULL,
horario_inicial INT NOT NULL,
horario_final INT NOT NULL

);

create table TipoUsuario(
id INT not null,
nombre VARCHAR(10) not null
);

--PK
ALTER TABLE usuarios ADD CONSTRAINT pk_usuario PRIMARY KEY (documento);
ALTER TABLE recursos ADD CONSTRAINT pk_recursos PRIMARY KEY (id_recursos);
ALTER TABLE TipoUsuario  ADD CONSTRAINT pk_tipousuario PRIMARY KEY (id);


--UK
ALTER TABLE usuarios ADD CONSTRAINT uk_correo UNIQUE (correo);

--FK
alter TABLE usuarios  
add foreign key (tipousuario) references tipousuario (id);

--Poblar
insert into recursos (id_recursos,nombre,ubicacion,capacidad,tiporecurso,fecha,horario_inicial,horario_final)
values (1,'libro','biblioteca1',4,'sala','2020-11-11',5,6);

insert into recursos (id_recursos,nombre,ubicacion,capacidad,tiporecurso,fecha,horario_inicial,horario_final)
values (2,'libro2','campus',2,'sala','2020-11-11',7,8);

--drop 
drop table usuarios;
drop table recursos;

--Delete 
Delete from recursos;
delete from usuarios;