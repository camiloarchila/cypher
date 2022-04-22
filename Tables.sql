--TABLES
CREATE TABLE usuarios(

documento INT NOT NULL,
nombre VARCHAR(20) NOT NULL,
contrasena VARCHAR(16) NOT NULL,
correo VARCHAR(20) NOT NULL,
telefono VARCHAR(20),
tipousuario INT NOT NULL
);

CREATE TABLE recursos(

id_recursos INT NOT NULL,
nombre VARCHAR(20) NOT NULL,
ubicacion VARCHAR(20) NOT NULL,
capacidad INT NOT NULL,
tiporecurso VARCHAR(20) NOT NULL,
horario INT NOT NULL
);

CREATE TABLE horarios(

id_horario INT NOT NULL,
fecha DATE NOT NULL,
horario_inicial TIME NOT NULL,
horario_final TIME NOT NULL,
disponibilidad BOOLEAN NOT NULL
);

CREATE TABLE TipoUsuario(
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
ALTER TABLE usuarios  
ADD FOREIGN KEY (tipousuario) REFERENCES tipousuario (id);
ALTER TABLE recursos  
ADD FOREIGN KEY (horario) REFERENCES horarios (id_horario);

--POBLAR
INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,tiporecurso,fecha,horario_inicial,horario_final)
VALUES (1,'libro','biblioteca1',1,'libro','2020-11-11','05:00:00','06:00:00');

INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,tiporecurso,fecha,horario_inicial,horario_final)
VALUES (3,'Computador','biblioteca2',1,'computador','2020-11-11','10:00:00','12:00:00');

INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,tiporecurso,fecha,horario_inicial,horario_final)
VALUES (2,'libro2','biblioteca2',1,'libro','2020-11-11','07:00:00','10:00:00');

INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,tiporecurso,fecha,horario_inicial,horario_final)
VALUES (4,'sala','bibliotecaa1',8,'sala','2020-11-11','13:00:00','15:00:00');

--DROP 
DROP TABLE usuarios;
DROP TABLE recursos;
DROP TABLE tipousuario;

--DELETE 
Delete from recursos;
delete from usuarios;