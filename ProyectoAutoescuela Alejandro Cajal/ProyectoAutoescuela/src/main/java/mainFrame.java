import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame implements ActionListener {
    private JButton registrarse,iniciarSesion;

    public mainFrame(){
        setTitle("Autoescuela cruce de caminos");
        setSize(600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        JPanel regis = new JPanel();
        JPanel inSes = new JPanel();
        JPanel orden = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        inSes.setLayout(new BoxLayout(inSes,BoxLayout.Y_AXIS));
        regis.setLayout(new BoxLayout(regis,BoxLayout.Y_AXIS));
        orden.setLayout(new BoxLayout(orden,BoxLayout.X_AXIS));

        registrarse = new JButton("Registrarse");
        registrarse.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrarse.addActionListener(this);
        iniciarSesion = new JButton("Iniciar Sesíon");
        iniciarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
        iniciarSesion.addActionListener(this);

        JLabel textoR1 = new JLabel("Puedes registrarte para acceder a nuestro");
        JLabel textoR2 = new JLabel("servicios y solicitar clases y examenes");
        textoR1.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoR2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textoI1 = new JLabel("Puedes acceder a tu estado en la");
        JLabel textoI2 = new JLabel("autoescuela y ver las clases pendientes");
        textoI1.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoI2.setAlignmentX(Component.CENTER_ALIGNMENT);

        regis.add(textoR1);
        regis.add(textoR2);
        regis.add(Box.createRigidArea(new Dimension(0,20)));
        regis.add(registrarse);

        inSes.add(textoI1);
        inSes.add(textoI2);
        inSes.add(Box.createRigidArea(new Dimension(0,20)));
        inSes.add(iniciarSesion);

        JLabel texto = new JLabel("Bienvenido a la Autoescuela curuce de caminos ");

        panel.add(texto);
        orden.add(regis);
        orden.add(Box.createRigidArea(new Dimension(30,0)));
        orden.add(inSes);
        panel.add(orden);
        add(panel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrarse){
            dispose();
            new RegistrarUsuario().pantalla();
        }
        if (e.getSource() == iniciarSesion){
            setVisible(false);
            new InicioSesion();
        }

    }
}
