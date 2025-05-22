/*Datos Del programa*/

INSERT INTO Profesor (idProfesor, nombre, apellidos, fechaNacimiento, direccion, telefono, contraseña)
VALUES 
('P001', 'Luis', 'García López', '1980-03-15', 'Calle Mayor 12', 600123456, 'luis123'),
('P002', 'María', 'Fernández Ruiz', '1975-07-22', 'Avenida Sol 45', 600234567, 'maria456'),
('P003', 'Carlos', 'Martínez Pérez', '1988-11-05', 'Plaza Norte 3', 600345678, 'carlos789');
INSERT INTO Alumno (idAlumno, nombre, apellidos, fechaNacimiento, fechaInscripcion, direccion, telefono, idProfesorAsignado, contraseña)
VALUES 
('A001', 'Ana', 'López Díaz', '2000-06-12', '2024-01-10', 'Calle Luna 7', 600987654, 'P001', 'passana'),
('A002', 'Pedro', 'Gómez Torres', '1999-09-30', '2024-02-05', 'Avenida Mar 10', 600876543, 'P002', 'passpedro'),
('A003', 'Lucía', 'Sánchez Vera', '2001-12-01', '2024-03-20', 'Calle Sol 9', 600765432, 'P003', 'passlucia');
INSERT INTO reserva (diaReserva, idAlumno, idProfesor)
VALUES 
('2025-05-22', 'A001', 'P001'),
('2025-05-23', 'A002', 'P002'),
('2025-05-24', 'A003', 'P003'),
('2025-05-20', 'A001', 'P001'),
('2025-05-21', 'A002', 'P001'),
('2025-05-22', 'A003', 'P001'),
('2025-05-23', 'A001', 'P001'),
('2025-05-24', 'A002', 'P001'),
('2025-05-25', 'A003', 'P001'),
('2025-05-26', 'A001', 'P001'),
('2025-05-27', 'A002', 'P001'),
('2025-05-28', 'A003', 'P001'),
('2025-05-29', 'A001', 'P001');
INSERT INTO pregunta (idPregunta, pregunta, respuesta1, respuesta2, respuesta3, respuestaCorrecta) VALUES
(1, '¿Cuál es la velocidad máxima permitida en autopistas para turismos en España?', '100 km/h', '120 km/h', '90 km/h', 2),
(2, '¿Qué documentación debe llevar obligatoriamente un conductor?', 'Permiso de conducir y permiso de circulación', 'Permiso de conducir y factura del vehículo', 'Permiso de circulación y justificante del seguro', 1),
(3, '¿Cuál es la tasa máxima de alcohol permitida en sangre para conductores noveles?', '0,5 g/l', '0,3 g/l', '0,8 g/l', 2),
(4, '¿Cuál de estos elementos no es obligatorio para circular?', 'Chaleco reflectante', 'Extintor de incendios', 'Triángulos de preseñalización de peligro', 2),
(5, '¿Está permitido utilizar un teléfono móvil mientras se conduce?', 'Sí, siempre', 'Sí, con dispositivo manos libres', 'No, salvo para emergencias', 2),
(6, '¿Cuándo se debe renovar el permiso de conducir clase B?', 'A los 5 años', 'Cada 10 años hasta los 65 y cada 5 después', 'Cada 15 años', 2),
(7, '¿Cuál es la posición correcta de las manos en el volante?', 'A las 10 y 10', 'A las 9 y 3', 'A las 8 y 20', 2),
(8, '¿Qué debe hacer si un vehículo le adelanta?', 'Acelerar', 'Mantener la velocidad o reducirla', 'Cambiar de carril', 2),
(9, '¿Qué indican las líneas discontinuas en la calzada?', 'Prohibición de adelantamiento', 'Posibilidad de adelantar si es seguro', 'Carril exclusivo para bicicletas', 2),
(10, '¿Cuál es la velocidad máxima permitida en vías urbanas con un solo carril por sentido?', '30 km/h', '50 km/h', '40 km/h', 1),
(11, '¿Está permitido adelantar en un paso de peatones?', 'Sí, siempre', 'No, salvo que esté regulado por semáforo', 'Nunca', 2),
(12, '¿Cuándo es obligatorio encender las luces de cruce?', 'Al anochecer y en túneles', 'Solo por la noche', 'Solo con lluvia', 1),
(13, '¿Qué prioridad tienen los peatones en un paso señalizado?', 'La misma que los vehículos', 'Prioridad absoluta', 'Prioridad solo si van en grupo', 2),
(14, '¿Cuándo se considera que una vía es interurbana?', 'Cuando atraviesa un núcleo urbano', 'Cuando está fuera de poblado', 'Cuando tiene más de dos carriles', 2),
(15, '¿Qué significa una luz amarilla intermitente en un semáforo?', 'Prohibición de paso', 'Precaución y continuar si es seguro', 'Obligación de detenerse', 2),
(16, '¿Cuál es la distancia mínima de seguridad entre vehículos en autopista?', '50 metros', '100 metros', 'Depende de la velocidad', 3),
(17, '¿Cuándo se puede realizar un cambio de sentido en vía urbana?', 'Siempre que no haya señal que lo prohíba y sea seguro', 'Solo en intersecciones', 'Solo con semáforo en verde', 1),
(18, '¿Está permitido estacionar en doble fila?', 'Sí, por un corto periodo', 'No, está prohibido', 'Solo si se deja el motor encendido', 2),
(19, '¿Cuál es la función del ABS en un vehículo?', 'Reducir consumo de combustible', 'Evitar el bloqueo de las ruedas al frenar', 'Aumentar la velocidad de frenado', 2),
(20, '¿En qué circunstancias es obligatorio el uso del cinturón de seguridad?', 'Solo en vías interurbanas', 'En todas las vías y para todos los ocupantes', 'Solo el conductor y copiloto', 2);

