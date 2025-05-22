import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class MenuPrincipal extends JFrame implements ActionListener {
    private Alumno a;
    private Profesor p;
    private JButton calendario,informacion, hacerReserva,hacerTest;

    public MenuPrincipal(Alumno a,Profesor p){
        this.p = p;
        this.a = a;
        setTitle("Autoescuela cruce de caminos");
        setSize(500,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        JPanel botones = new JPanel();

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        botones.setLayout(new BoxLayout(botones,BoxLayout.X_AXIS));

        JLabel info;
        if (p == null){
            info = new JLabel("Bienvenido" +" "+ a.getNombre() +" "+ a.getApellidos());
        }else {
            info = new JLabel("Bienvenido" + p.getNombre() + p.getApellidos());
        }
        info.setAlignmentX(Component.CENTER_ALIGNMENT);


        calendario = new JButton("Calendario");
        calendario.addActionListener(this);
        informacion = new JButton("Informacion");
        informacion.addActionListener(this);
        hacerReserva = new JButton("Hacer reserva");
        hacerReserva.addActionListener(this);
        hacerTest = new JButton("Test");
        hacerTest.addActionListener(this);

        JLabel aviso = new JLabel("¡Tienes clases dentro de poco!");
        aviso.setAlignmentX(Component.CENTER_ALIGNMENT);

        botones.add(calendario);
        botones.add(Box.createRigidArea(new Dimension(10,0)));
        if (p == null){
            botones.add(hacerReserva);
            botones.add(Box.createRigidArea(new Dimension(10,0)));
            botones.add(hacerTest);
        }
        botones.add(Box.createRigidArea(new Dimension(10,0)));
        botones.add(informacion);

        panel.add(info);
        panel.add(botones);
        panel.add(aviso);

        aviso.setVisible(false);

        if (p == null) {
            ArrayList<Reserva> lista = DataBase.obtenerReservasAlumno(a.getIdAlumno());
            LocalDate hoy = LocalDate.now();

            for (Reserva r : lista) {
                LocalDate fechaReserva = r.getDiaReserva();
                if (!fechaReserva.isBefore(hoy) && !fechaReserva.isAfter(hoy.plusDays(7))) {
                    aviso.setVisible(true);
                    break;
                }
            }
        }

        panel.add(aviso);
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calendario){
            setVisible(false);
            if (p == null) {
                new Calendario(a, DataBase.obtenerReservasAlumno(a.getIdAlumno()), p);
            } else {
                new Calendario(a, DataBase.obtenerReservasProfesor(p.getIdProfesor()),p);
            }
        }
        if (e.getSource() == hacerReserva){
            setVisible(false);
            new VentanaReserva(a,p);
        }
        if (e.getSource() == informacion){
            setVisible(false);
            if (p == null){
                new VerInfoAlumno(a,p);
            }else {
                new VerInfoProfesores(a,p);
            }

        }
        if (e.getSource() == hacerTest){
            setVisible(false);
            new MenuTest(a,p);

        }
    }
}
