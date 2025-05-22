import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private LocalDate diaReserva;
    private String idAlumno;
    private String idProfesor;

    public Reserva(int idReserva, LocalDate diaReserva, String idAlumno, String idProfesor) {
        this.idReserva = idReserva;
        this.diaReserva = diaReserva;
        this.idAlumno = idAlumno;
        this.idProfesor = idProfesor;
    }


    public int getIdReserva() {
        return idReserva;
    }

    public LocalDate getDiaReserva() {
        return diaReserva;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public String getIdProfesor() {
        return idProfesor;
    }
}