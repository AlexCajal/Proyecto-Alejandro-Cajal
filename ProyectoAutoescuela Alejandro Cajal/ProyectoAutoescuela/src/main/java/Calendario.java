import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class Calendario extends JFrame implements ActionListener {
    private JButton volver;
    private Alumno a;
    private Profesor p;
    private ArrayList<Reserva> listaReserva;

    public Calendario(Alumno a, ArrayList<Reserva> listaReserva, Profesor p) {
        this.a = a;
        this.listaReserva = listaReserva;
        this.p = p;

        setTitle(LocalDate.now().getMonth().toString());
        setSize(1200, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        String[] dSemana = {"Lunes", "Martes", "Miercoles", "Juves", "Viernes", "Sabado", "Domingo"};

        JPanel panel = new JPanel();
        JPanel botones = new JPanel();
        JTable tabla;

        if (p == null){
            tabla = new JTable(organizarDatosAlumno(listaReserva, a.getIdAlumno()), dSemana);
        }else {
            tabla = new JTable(organizarDatosProfesor(listaReserva, p.getIdProfesor()), dSemana);
        }
        JScrollPane sPanel = new JScrollPane(tabla);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        botones.setLayout(new BoxLayout(botones, BoxLayout.X_AXIS));

        tabla.setRowHeight(60);

        volver = new JButton("Volver");
        volver.addActionListener(this);

        botones.add(volver);
        panel.add(sPanel);
        panel.add(botones);
        add(panel);

        setVisible(true);
    }

    public static String[][] organizarDatosAlumno(ArrayList<Reserva> listaReserva, String idAlumno) {
        String[][] lista = new String[6][7];

        LocalDate fecha = LocalDate.now();
        LocalDate inicioMes = fecha.withDayOfMonth(1);
        int primerDiaSemana = inicioMes.getDayOfWeek().getValue();
        int diasEnMes = fecha.lengthOfMonth();


        int dia = 1;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j < primerDiaSemana - 1) {
                    lista[i][j] = "";
                } else if (dia <= diasEnMes) {

                    String celda = String.valueOf(dia);


                    for (Reserva r : listaReserva) {
                        if (r.getIdAlumno().equals(idAlumno)
                                && r.getDiaReserva().getMonthValue() == fecha.getMonthValue()
                                && r.getDiaReserva().getYear() == fecha.getYear()
                                && r.getDiaReserva().getDayOfMonth() == dia) {
                            celda += " Pf: " + (DataBase.obtenerProfesorPorId(r.getIdProfesor()).getNombre()) + " " + (DataBase.obtenerProfesorPorId(r.getIdProfesor()).getApellidos());
                            break;
                        }
                    }

                    lista[i][j] = celda;
                    dia++;
                } else {
                    lista[i][j] = "";
                }
            }
        }

        return lista;
    }
    public static String[][] organizarDatosProfesor(ArrayList<Reserva> listaReserva, String idProfesor) {
        String[][] lista = new String[6][7];

        LocalDate fecha = LocalDate.now();
        LocalDate inicioMes = fecha.withDayOfMonth(1);
        int primerDiaSemana = inicioMes.getDayOfWeek().getValue();
        int diasEnMes = fecha.lengthOfMonth();

        int dia = 1;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j < primerDiaSemana - 1) {
                    lista[i][j] = "";
                } else if (dia <= diasEnMes) {

                    String celda = String.valueOf(dia);

                    for (Reserva r : listaReserva) {
                        if (r.getIdProfesor().equals(idProfesor)
                                && r.getDiaReserva().getMonthValue() == fecha.getMonthValue()
                                && r.getDiaReserva().getYear() == fecha.getYear()
                                && r.getDiaReserva().getDayOfMonth() == dia) {
                            celda += " Al: " + DataBase.obtenerAlumnoPorId(r.getIdAlumno()).getNombre() + " " + DataBase.obtenerAlumnoPorId(r.getIdAlumno()).getApellidos();
                            break;
                        }
                    }

                    lista[i][j] = celda;
                    dia++;
                } else {
                    lista[i][j] = "";
                }
            }
        }

        return lista;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == volver) {
            setVisible(false);
            new MenuPrincipal(a, p);
        }
    }

}
