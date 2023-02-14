create database estudiantes;
use estudiantes;

CREATE TABLE `estudiantes`.`infoestudiantes` (
  `idestudiante` INT NOT NULL,
  `nombreEstudiante` VARCHAR(45) NOT NULL,
  `celularEstudiante` VARCHAR(45) NULL,
  `correoEstudiante` VARCHAR(45) NULL,
  PRIMARY KEY (`idestudiante`));
  
  CREATE TABLE `estudiantes`.`sexoestudiante` (
  `idsexoEstudiante` INT NOT NULL,
  `Sexo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idsexoEstudiante`));

CREATE TABLE `estudiantes`.`niveleducacionest` (
  `idnivelEducacionEst` INT NOT NULL,
  `nivelEstudio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idnivelEducacionEst`));
  

INSERT INTO `estudiantes`.`infoestudiantes` (`idestudiante`, `nombreEstudiante`, `celularEstudiante`, `correoEstudiante`) VALUES ('1', 'Alexis Chasi', '09364578936', 'chasi@gmail.com');
INSERT INTO `estudiantes`.`infoestudiantes` (`idestudiante`, `nombreEstudiante`, `celularEstudiante`, `correoEstudiante`) VALUES ('2', 'Elvis Guanoluisa', '09645878965', 'elvis@gmail.com');
INSERT INTO `estudiantes`.`infoestudiantes` (`idestudiante`, `nombreEstudiante`, `celularEstudiante`, `correoEstudiante`) VALUES ('3', 'Jared Valenzuela', '09632145648', 'jared@epn.edu.ec');
INSERT INTO `estudiantes`.`infoestudiantes` (`idestudiante`, `nombreEstudiante`, `celularEstudiante`, `correoEstudiante`) VALUES ('4', 'Joseph Yepez', '09654788884', 'yepez@epn.edu.ec');


INSERT INTO `estudiantes`.`sexoestudiante` (`idsexoEstudiante`, `Sexo`) VALUES ('1', 'M');
INSERT INTO `estudiantes`.`sexoestudiante` (`idsexoEstudiante`, `Sexo`) VALUES ('2', 'F');


INSERT INTO `estudiantes`.`niveleducacionest` (`idnivelEducacionEst`, `nivelEstudio`) VALUES ('1', 'Basico');
INSERT INTO `estudiantes`.`niveleducacionest` (`idnivelEducacionEst`, `nivelEstudio`) VALUES ('2', 'Basico superior');
INSERT INTO `estudiantes`.`niveleducacionest` (`idnivelEducacionEst`, `nivelEstudio`) VALUES ('3', 'Media');
INSERT INTO `estudiantes`.`niveleducacionest` (`idnivelEducacionEst`, `nivelEstudio`) VALUES ('4', 'Bachillerato');
INSERT INTO `estudiantes`.`niveleducacionest` (`idnivelEducacionEst`, `nivelEstudio`) VALUES ('5', 'Tercer nivel');



select*from infoestudiantes;
select*from sexoestudiante;
select*from niveleducacionest;
  



