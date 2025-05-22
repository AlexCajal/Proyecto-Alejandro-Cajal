import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class InicioSesion extends JFrame implements ActionListener {
    private JButton iniciarSesion,atras;
    private JTextField nombre, contrasenia;
    private boolean isProfesor;
    private JPanel datosIncorrectos;

    public InicioSesion(){
        setTitle("Autoescuela cruce de caminos");
        setSize(300,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        JPanel orden = new JPanel();
        JPanel botones = new JPanel();
        JPanel datos = new JPanel();
        JPanel info = new JPanel();
        JPanel texto = new JPanel();
        datosIncorrectos = new JPanel();


        datosIncorrectos.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        orden.setLayout(new BoxLayout(orden,BoxLayout.Y_AXIS));
        info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
        datos.setLayout(new BoxLayout(datos,BoxLayout.X_AXIS));
        texto.setLayout(new BoxLayout(texto,BoxLayout.Y_AXIS));
        botones.setLayout(new BoxLayout(botones,BoxLayout.X_AXIS));

        JLabel nom = new JLabel("DNI");
        nom.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel psw = new JLabel("Contraseña");
        psw.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel datosMal = new JLabel("Datos Incorrectos");
        datosMal.setAlignmentX(Component.CENTER_ALIGNMENT);

        datosIncorrectos.add(datosMal);

        info.add(nom);
        info.add(Box.createRigidArea(new Dimension(0,20)));
        info.add(psw);

        nombre = new JTextField();
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        contrasenia = new JTextField();
        contrasenia.setAlignmentX(Component.CENTER_ALIGNMENT);

        texto.add(nombre);
        texto.add(Box.createRigidArea(new Dimension(0,20)));
        texto.add(contrasenia);

        datos.add(info);
        datos.add(Box.createRigidArea(new Dimension(20,0)));
        datos.add(texto);

        iniciarSesion = new JButton("Inicar Sesión");
        iniciarSesion.addActionListener(this);
        atras = new JButton("Volver");
        atras.addActionListener(this);

        JCheckBox casilla = new JCheckBox("Inicio como Profesor?");
        casilla.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (casilla.isSelected()) {
                    isProfesor = true;
                } else {
                    isProfesor = false;
                }
            }
        });
        casilla.setAlignmentX(Component.CENTER_ALIGNMENT);

        botones.add(iniciarSesion);
        botones.add(Box.createRigidArea(new Dimension(20,0)));
        botones.add(atras);

        orden.add(datos);
        orden.add(Box.createRigidArea(new Dimension(0,10)));
        orden.add(casilla);
        orden.add(Box.createRigidArea(new Dimension(0,10)));
        orden.add(botones);

        panel.add(orden);
        panel.add(datosIncorrectos);
        datosIncorrectos.setVisible(false);
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Alumno a = null;
        Profesor p = null;
        if (actionEvent.getSource() == atras){
            setVisible(false);
            new mainFrame();
        }
        if (actionEvent.getSource() == iniciarSesion){
            boolean datosCorrectos = true;
            try{
                if (isProfesor){
                    p = DataBase.inicioSesionDatosProfesor(nombre.getText(),contrasenia.getText());
                    if (p == null) datosCorrectos = false;
                }else {
                    a = DataBase.inicioSesionDatosAlumno(nombre.getText(),contrasenia.getText());
                    if (a == null) datosCorrectos = false;
                }
            }catch (Exception e){
                System.out.println("caca");
            }
            if (datosCorrectos){
                new MenuPrincipal(a,p);
                setVisible(false);
            }else {
                datosIncorrectos.setVisible(true);
            }
        }
    }
}
