import java.time.LocalDate;

public class Profesor {
    private String idProfesor;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String direccion;
    private int telefono;
    private String contrasenia;

    public Profesor(String idProfesor, String nombre, String apellidos, LocalDate fechaNacimiento,
                    String direccion, int telefono, String contrasenia) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
