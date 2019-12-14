-- Base de datos: cine, usuario: root, password: none
-- Creamos tabla e insertamos datos

CREATE TABLE IF NOT EXISTS `pelicula` (
  id VARCHAR(10),
  director VARCHAR(128),
  titulo VARCHAR(128),
  fecha DATETIME 
);

INSERT INTO pelicula (id,director,titulo,fecha)
  VALUES (1,'Martin Scorsese','Taxi driver','1976-02-08');

INSERT INTO pelicula (id,director,titulo,fecha)
  VALUES (2,'Clint Eastwood','Los puentes de Madison','1995-10-11');

INSERT INTO pelicula (id,director,titulo,fecha)
  VALUES (3,'Stanley Kubrick','El resplandor','1980-12-19');

INSERT INTO pelicula (id,director,titulo,fecha)
  VALUES (4,'Steven Spielberg','Salvar al soldado Ryan','1998-09-18');
  
INSERT INTO pelicula (id,director,titulo,fecha)
  VALUES (5,'Martin Scorsese','Shutter Island','2010-02-19');
 
INSERT INTO pelicula (id,director,titulo,fecha)
  VALUES (6,'Clint Eastwood','Mystic River','2003-05-23');

INSERT INTO pelicula (id,director,titulo,fecha)
  VALUES (7,'Stanley Kubrick','2001: Una odisea del espacio','1968-10-17');
  
INSERT INTO pelicula (id,director,titulo,fecha)
  VALUES (8,'Steven Spielberg','Munich','2006-01-27');

-- tabla login para control de usuarios registrados e introducci�n de valores
CREATE TABLE `login` (
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`usuario`)
);

INSERT INTO login (username,password)
 VALUES ('root','root');
 
INSERT INTO login (usuario,clave)