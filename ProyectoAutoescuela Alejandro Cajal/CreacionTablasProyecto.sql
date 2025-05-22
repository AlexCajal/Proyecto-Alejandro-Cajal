/*Creacion de tablas*/
Drop database if exists Autoescuela;
create database Autoescuela;
use Autoescuela;
create table Profesor(
idProfesor varchar (15) primary key not null,
nombre varchar (15) not null,
apellidos varchar (25) not null,
fechaNacimiento date not null,
direccion varchar (50) not null,
telefono int not null,
contraseña varchar(15)
);
create table Alumno(
idAlumno varchar (15) primary key not null,
nombre varchar (15) not null,
apellidos varchar (25) not null,
fechaNacimiento date not null,
fechaInscripcion date not null,
direccion varchar (50) not null,
telefono int not null,
idProfesorAsignado varchar (15),
contraseña varchar (20) not null,
CONSTRAINT fk_profesor FOREIGN KEY (idProfesorAsignado)REFERENCES Profesor(idProfesor)
);
create table administrador(
idAdmin varchar (15) primary key not null,
nombre varchar (15) not null,
apellidos varchar (25) not null,
fechaNacimiento date not null,
direccion varchar (50) not null,
telefono int not null
);
create table clase(
idClase int auto_increment primary key not null,
idProfesorAsignado varchar (15) not null,
idAlumnoAsistente varchar (15) not null,
fecha date not null,
turno int not null,
CONSTRAINT fk_profesor_clase FOREIGN KEY (idProfesorAsignado) REFERENCES Profesor(idProfesor),
CONSTRAINT fk_alumno_clase FOREIGN KEY (idAlumnoAsistente) REFERENCES Alumno(idAlumno)
);
create table pregunta(
idPregunta int primary key not null,
pregunta varchar (200) not null,
respuesta1 varchar (200) not null,
respuesta2 varchar (200) not null,
respuesta3 varchar (200) not null,
respuestaCorrecta int not null
);
create table reserva(
idReserva int primary key not null auto_increment,
diaReserva Date not null,
idAlumno varchar(15) not null,
idProfesor varchar(15) not null,
constraint fk_reserva_alumno foreign key (idAlumno) references Alumno(idAlumno),
constraint fk_reserva_profesor foreign key (idProfesor) references Profesor(idProfesor)
);
