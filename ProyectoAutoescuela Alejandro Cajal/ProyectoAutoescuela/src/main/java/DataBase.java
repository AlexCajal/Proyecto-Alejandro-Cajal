import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DataBase {
    private static Connection conexion;
    public static void insertRegistro(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String direccion, int telefono, String contrasenia) {
        try{
            Connection con = conexion();
            PreparedStatement PreparedStatement = con.prepareStatement("INSERT INTO Alumno VALUES(?,?,?,?,?,?,?,?,?)");

            PreparedStatement.setString(1,dni);
            PreparedStatement.setString(2,nombre);
            PreparedStatement.setString(3,apellidos);
            PreparedStatement.setDate(4,Date.valueOf(fechaNacimiento));
            PreparedStatement.setDate(5,Date.valueOf(LocalDate.now()));
            PreparedStatement.setString(6,direccion);
            PreparedStatement.setInt(7,telefono);
            PreparedStatement.setString(8,null);
            PreparedStatement.setString(9,contrasenia);


            PreparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void insertarReserva(LocalDate fecha, String idAlumno, String idProfesor) {
        try {
            Connection con = conexion();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO reserva (diaReserva, idAlumno, idProfesor, anotacion) VALUES (?, ?, ?, ?)"
            );

            ps.setDate(1, Date.valueOf(fecha));
            ps.setString(2, idAlumno);
            ps.setString(3, idProfesor);
            ps.setString(4, null);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Alumno inicioSesionDatosAlumno(String id, String contrasenia) {
        Alumno a = null;
        try {
            Connection con = conexion();

            PreparedStatement preparedStatement = con.prepareStatement(
                    "SELECT * FROM Alumno WHERE idAlumno = ? AND contraseña = ?"
            );
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, contrasenia);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String idAlumno = resultSet.getString("idAlumno");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellidos");
                Date fechaNacimiento = resultSet.getDate("fechaNacimiento");
                Date fechaInscripcion = resultSet.getDate("fechaInscripcion");
                String direccion = resultSet.getString("direccion");
                int telefono = resultSet.getInt("telefono");
                String idProfesorAsignado = resultSet.getString("idProfesorAsignado");
                String contraseniaNew = resultSet.getString("contraseña");

                a = new Alumno(idAlumno, nombre, apellido,
                        fechaNacimiento.toLocalDate(),
                        fechaInscripcion.toLocalDate(),
                        direccion, telefono,
                        idProfesorAsignado, contraseniaNew);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            a = null;
        }
        return a;
    }
    public static Profesor inicioSesionDatosProfesor(String id, String contrasenia) {
        Profesor p = null;
        try {
            Connection con = conexion();

            PreparedStatement preparedStatement = con.prepareStatement(
                    "SELECT * FROM Profesor WHERE idProfesor = ? AND contraseña = ?"
            );
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, contrasenia);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String idProfesor = resultSet.getString("idProfesor");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                Date fechaNacimiento = resultSet.getDate("fechaNacimiento");
                String direccion = resultSet.getString("direccion");
                int telefono = resultSet.getInt("telefono");
                String contraseniaNew = resultSet.getString("contraseña");

                p = new Profesor(idProfesor, nombre, apellidos,
                        fechaNacimiento.toLocalDate(),
                        direccion, telefono, contraseniaNew);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            p = null;
        }
        return p;
    }
    public static Profesor obtenerProfesorPorId(String idProfesor) {
        Profesor profesor = null;
        try {
            Connection con = conexion();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM Profesor WHERE idProfesor = ?"
            );
            ps.setString(1, idProfesor);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String id = rs.getString("idProfesor");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                String direccion = rs.getString("direccion");
                int telefono = rs.getInt("telefono");
                String contrasenia = rs.getString("contraseña");

                profesor = new Profesor(id, nombre, apellidos,
                        fechaNacimiento.toLocalDate(),
                        direccion, telefono, contrasenia);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesor;
    }
    public static Alumno obtenerAlumnoPorId(String idAlumno) {
        Alumno alumno = null;
        try {
            Connection con = conexion();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM Alumno WHERE idAlumno = ?"
            );
            ps.setString(1, idAlumno);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String id = rs.getString("idAlumno");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                Date fechaInscripcion = rs.getDate("fechaInscripcion");
                String direccion = rs.getString("direccion");
                int telefono = rs.getInt("telefono");
                String idProfesorAsignado = rs.getString("idProfesorAsignado");
                String contrasenia = rs.getString("contraseña");

                alumno = new Alumno(id, nombre, apellidos,
                        fechaNacimiento.toLocalDate(),
                        fechaInscripcion.toLocalDate(),
                        direccion, telefono, idProfesorAsignado, contrasenia);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumno;
    }
    public static ArrayList<Reserva> obtenerReservasAlumno(String idAlumno) {
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            Connection con = conexion();
            PreparedStatement preparedStatement = con.prepareStatement(
                    "SELECT * FROM reserva WHERE idAlumno = ?"
            );
            preparedStatement.setString(1, idAlumno);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idReserva = resultSet.getInt("idReserva");
                Date diaReserva = resultSet.getDate("diaReserva");
                String idProfesor = resultSet.getString("idProfesor");

                Reserva r = new Reserva(idReserva, diaReserva.toLocalDate(), idAlumno, idProfesor);
                reservas.add(r);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservas;
    }
    public static ArrayList<Reserva> obtenerReservasProfesor(String idProfesor) {
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            Connection con = conexion();
            PreparedStatement preparedStatement = con.prepareStatement(
                    "SELECT * FROM reserva WHERE idProfesor = ?"
            );
            preparedStatement.setString(1, idProfesor);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idReserva = resultSet.getInt("idReserva");
                Date diaReserva = resultSet.getDate("diaReserva");
                String idAlumno = resultSet.getString("idAlumno");

                Reserva r = new Reserva(idReserva, diaReserva.toLocalDate(), idAlumno, idProfesor);
                reservas.add(r);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservas;
    }
    public static ArrayList<Pregunta> obtenerTodasPreguntas() {
        ArrayList<Pregunta> preguntas = new ArrayList<>();

        try {
            Connection con = conexion();
            PreparedStatement preparedStatement = con.prepareStatement(
                    "SELECT * FROM pregunta"
            );

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idPregunta = resultSet.getInt("idPregunta");
                String pregunta = resultSet.getString("pregunta");
                String respuesta1 = resultSet.getString("respuesta1");
                String respuesta2 = resultSet.getString("respuesta2");
                String respuesta3 = resultSet.getString("respuesta3");
                int respuestaCorrecta = resultSet.getInt("respuestaCorrecta");

                Pregunta p = new Pregunta(idPregunta, pregunta, respuesta1, respuesta2, respuesta3, respuestaCorrecta);
                preguntas.add(p);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preguntas;
    }


    public static Connection conexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection("jdbc:mysql://database-1.cxiomu46ayj0.us-east-1.rds.amazonaws.com/Autoescuela", "admin", "AlexCajal8.");
        }
        return conexion;
    }
}
