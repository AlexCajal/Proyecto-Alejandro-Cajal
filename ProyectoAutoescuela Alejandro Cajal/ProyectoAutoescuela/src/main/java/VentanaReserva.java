import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

public class VentanaReserva extends JFrame implements ActionListener {

    private JTextField fechaTF, idAlumnoTF, idProfesorTF;
    private JButton reservar, limpiar, volver;
    private Alumno a;
    private Profesor p;
    private JLabel reservaHecha,errorReserva;

    public VentanaReserva(Alumno a,Profesor p) {
        this.p = p;
        this.a = a;
        setTitle("Reservar clase");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        JPanel texto = new JPanel();
        JPanel datos = new JPanel();
        JPanel orden = new JPanel();
        JPanel botones = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        texto.setLayout(new BoxLayout(texto, BoxLayout.Y_AXIS));
        datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));
        orden.setLayout(new BoxLayout(orden, BoxLayout.X_AXIS));
        botones.setLayout(new BoxLayout(botones, BoxLayout.X_AXIS));

        reservar = new JButton("Reservar");
        reservar.addActionListener(this);
        limpiar = new JButton("Limpiar");
        limpiar.addActionListener(this);
        volver = new JButton("Volver");
        volver.addActionListener(this);

        botones.add(volver);
        botones.add(Box.createRigidArea(new Dimension(5, 0)));
        botones.add(limpiar);
        botones.add(Box.createRigidArea(new Dimension(5, 0)));
        botones.add(reservar);

        JLabel fechaLbl = new JLabel("Fecha:");
        JLabel idAlumnoLbl = new JLabel("ID Alumno:");
        JLabel idProfesorLbl = new JLabel("ID Profesor:");
        reservaHecha = new JLabel("Se ha guardado la reserva correctamente");
        errorReserva = new JLabel("Datos Incorrectos");


        texto.add(fechaLbl);
        texto.add(Box.createRigidArea(new Dimension(0, 15)));
        texto.add(idAlumnoLbl);
        texto.add(Box.createRigidArea(new Dimension(0, 15)));
        texto.add(idProfesorLbl);

        fechaTF = new JTextField("0000-00-00", 9);
        idAlumnoTF = new JTextField("A001", 9);
        idProfesorTF = new JTextField("P001", 9);

        datos.add(fechaTF);
        datos.add(Box.createRigidArea(new Dimension(0, 10)));
        datos.add(idAlumnoTF);
        datos.add(Box.createRigidArea(new Dimension(0, 10)));
        datos.add(idProfesorTF);

        panel.add(new JLabel("Realiza tu reserva"));
        panel.add(new JLabel("Introduce los siguientes datos:"));
        orden.add(texto);
        orden.add(datos);
        panel.add(orden);
        panel.add(Box.createRigidArea(new Dimension(0, 70)));
        panel.add(botones);
        panel.add(errorReserva);
        panel.add(reservaHecha);
        errorReserva.setVisible(false);
        reservaHecha.setVisible(false);

        add(panel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reservar) {
            String fecha = fechaTF.getText();
            String idAlumno = idAlumnoTF.getText();
            String idProfesor = idProfesorTF.getText();
            LocalDate fechaLD;
            try {
                fechaLD = LocalDate.parse(fecha);
                DataBase.insertarReserva(fechaLD,idAlumno,idProfesor);
                reservar.setEnabled(false);
                errorReserva.setVisible(false);
                reservaHecha.setVisible(true);
            }catch (Exception ex){
                errorReserva.setVisible(true);
            }
        }

        if (e.getSource() == limpiar) {
            fechaTF.setText("0000-00-00");
            idAlumnoTF.setText("A001");
            idProfesorTF.setText("P001");
        }

        if (e.getSource() == volver) {
            setVisible(false);
            new MenuPrincipal(a,p);
        }

    }

}
