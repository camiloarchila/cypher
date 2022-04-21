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
horario_inicial TIME NOT NULL,
horario_final TIME NOT NULL

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
values (1,'libro','biblioteca1',1,'libro','2020-11-11','05:00:00','06:00:00');

insert into recursos (id_recursos,nombre,ubicacion,capacidad,tiporecurso,fecha,horario_inicial,horario_final)
values (3,'Computador','biblioteca2',1,'computador','2020-11-11','10:00:00','12:00:00');

insert into recursos (id_recursos,nombre,ubicacion,capacidad,tiporecurso,fecha,horario_inicial,horario_final)
values (2,'libro2','biblioteca2',1,'libro','2020-11-11','07:00:00','10:00:00');

insert into recursos (id_recursos,nombre,ubicacion,capacidad,tiporecurso,fecha,horario_inicial,horario_final)
values (4,'sala','bibliotecaa1',8,'sala','2020-11-11','13:00:00','15:00:00');

insert into tipousuario values (1, 'admin');
insert into  tipousuario values(2, 'user');

insert into usuarios values (2167, 'camilo', '12345', 'estbean.archila','317516', 2);
insert into usuarios values (1, 'admin', 'admin', 'admin','0000', 1);

--drop 
drop table usuarios;
drop table recursos;
drop table tipousuario;

--Delete 
Delete from recursos;
delete from usuarios;