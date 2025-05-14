import java.sql.*;
import java.time.LocalDate;

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
    public static void inicioSesionDatos(String id, String contrasenia) {

        try{
            Connection con = conexion();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT id Alumno,contraseña FROM Alumno");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                if ((contrasenia == resultSet.getString("contraseña")) && (id == resultSet.getString("idAlumno"))){
                    PreparedStatement preparedStatement1 = con.prepareStatement("SELECT * FROM Alumno");
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    while (resultSet.next()){

                    }
                }
            }
        }catch (SQLException e){

        }

    }
    public static Connection conexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection("jdbc:mysql://database-1.cxiomu46ayj0.us-east-1.rds.amazonaws.com/Autoescuela", "admin", "AlexCajal8.");
        }
        return conexion;
    }
}
