import java.time.LocalDate;

public class Alumno {
    private String idAlumno;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private LocalDate fechaInscripcion;
    private String direccion;
    private int telefono;
    private String idProfesorAsignado;
    private String contrasenia;

    public Alumno(String idAlumno, String nombre, String apellidos, LocalDate fechaNacimiento, LocalDate fechaInscripcion, String direccion, int telefono, String idProfesorAsignado, String contrasenia) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInscripcion = fechaInscripcion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idProfesorAsignado = idProfesorAsignado;
        this.contrasenia = contrasenia;
    }

    public String getIdAlumno() {
        return idAlumno;
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

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
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


