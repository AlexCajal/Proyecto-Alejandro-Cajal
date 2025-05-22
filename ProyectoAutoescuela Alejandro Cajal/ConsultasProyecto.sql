/*
-- Este Documento es unicamente la consultas utilizadas a lo largo del codigo --
*/
INSERT INTO Alumno VALUES(?,?,?,?,?,?,?,?,?)

INSERT INTO reserva (diaReserva, idAlumno, idProfesor, anotacion) VALUES (?, ?, ?, ?)

SELECT * FROM Alumno WHERE idAlumno = ? AND contraseña = ?

SELECT * FROM Profesor WHERE idProfesor = ? AND contraseña = ?

SELECT * FROM Profesor WHERE idProfesor = ?

SELECT * FROM reserva WHERE idAlumno = ?

SELECT * FROM reserva WHERE idProfesor = ?

SELECT * FROM pregunta