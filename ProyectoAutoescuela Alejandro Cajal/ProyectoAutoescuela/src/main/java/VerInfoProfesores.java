import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerInfoProfesores extends JFrame implements ActionListener {
    private Profesor p;
    private Alumno a;
    private JButton volver;
    public VerInfoProfesores(Alumno a,Profesor p) {
        this.p = p;

        setSize(300, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel idProfesor = new JLabel("DNI: " + p.getIdProfesor());
        idProfesor.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel nombre = new JLabel("Nombre: " + p.getNombre());
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel apellidos = new JLabel("Apellidos: " + p.getApellidos());
        apellidos.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel fechaNacimiento = new JLabel("Fecha Nacimiento: " + p.getFechaNacimiento());
        fechaNacimiento.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel direccion = new JLabel("Dirección: " + p.getDireccion());
        direccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel telefono = new JLabel("Teléfono: " + p.getTelefono());
        telefono.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel contrasenia = new JLabel("Contraseña: " + p.getContrasenia());
        contrasenia.setAlignmentX(Component.CENTER_ALIGNMENT);

        volver = new JButton("Volver");
        volver.setAlignmentX(Component.CENTER_ALIGNMENT);
        volver.addActionListener(this);

        panel.add(idProfesor);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(nombre);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(apellidos);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(fechaNacimiento);
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
        setVisible(false);
    }
}
