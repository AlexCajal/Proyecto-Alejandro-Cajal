import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerInfoAlumno extends JFrame implements ActionListener {
    private JButton volver;
    private Alumno a;
    private Profesor p;
    public VerInfoAlumno(Alumno a,Profesor p){
        this.p = p;
        this.a = a;

        setSize(300,350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        JLabel idAlumno = new JLabel("DNI: " + a.getIdAlumno());
        idAlumno.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel nombre = new JLabel("Nombre: " + a.getNombre());
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel apellidos = new JLabel("Apellidos: " + a.getApellidos());
        apellidos.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel fechaNacimiento = new JLabel("Fecha Nacimiento: " + a.getFechaNacimiento());
        fechaNacimiento.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel fechaInscripcion = new JLabel("Fecha Inscripción: " + a.getFechaInscripcion());
        fechaInscripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel direccion = new JLabel("Dirección: " + a.getDireccion());
        direccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel telefono = new JLabel("Teléfono: " + a.getTelefono());
        telefono.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel contrasenia = new JLabel("Contraseña: " + a.getContrasenia());
        contrasenia.setAlignmentX(Component.CENTER_ALIGNMENT);

        volver = new JButton("Volver");
        volver.setAlignmentX(Component.CENTER_ALIGNMENT);
        volver.addActionListener(this);

        panel.add(idAlumno);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(nombre);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(apellidos);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(fechaNacimiento);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(fechaInscripcion);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(direccion);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(telefono);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(contrasenia);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(volver);
        add(panel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == volver);
        setVisible(false);
        new MenuPrincipal(a,p);
    }
}
