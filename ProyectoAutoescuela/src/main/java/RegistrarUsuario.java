import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RegistrarUsuario extends JFrame implements ActionListener {
    private String dni,nombre,apellidos,direccion,contrasenia,contraseniaC;
    private LocalDate fechaNacimiento;
    private int telefono;
    private JButton limpiar, registrar, atras;
    private JTextField dniTF,nombreTF,apellidosTF,direccionTF,contraseniaTF,contraseniaCTF,fechaNacmientoTF,telefonoTF;

    public void pantalla(){
        setTitle("Autoescuela cruce de caminos");
        setSize(300,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        JPanel texto = new JPanel();
        JPanel datos = new JPanel();
        JPanel orden = new JPanel();
        JPanel botones = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        texto.setLayout(new BoxLayout(texto,BoxLayout.Y_AXIS));
        datos.setLayout(new BoxLayout(datos,BoxLayout.Y_AXIS));
        orden.setLayout(new BoxLayout(orden,BoxLayout.X_AXIS));
        botones.setLayout(new BoxLayout(botones,BoxLayout.X_AXIS));

        registrar = new JButton("Registrarse");
        registrar.addActionListener(this);
        limpiar = new JButton("Limpiar");
        limpiar.addActionListener(this);
        atras = new JButton("Volver");
        atras.addActionListener(this);

        botones.add(atras);
        botones.add(Box.createRigidArea(new Dimension(5,0)));
        botones.add(limpiar);
        botones.add(Box.createRigidArea(new Dimension(5,0)));
        botones.add(registrar);

        JLabel nom = new JLabel("Nombre :");
        JLabel ape = new JLabel("Apellidos :");
        JLabel dir = new JLabel("Dirección :");
        JLabel DNI = new JLabel("DNI :");
        JLabel fechNa = new JLabel("Fecha Nacimiento :");
        JLabel tel = new JLabel("Teléfono :");
        JLabel con = new JLabel("Contraseña :");
        JLabel conC = new JLabel("Confirmar Contraseña :   ");

        texto.add(nom);
        texto.add(Box.createRigidArea(new Dimension(0,14)));
        texto.add(ape);
        texto.add(Box.createRigidArea(new Dimension(0,14)));
        texto.add(dir);
        texto.add(Box.createRigidArea(new Dimension(0,14)));
        texto.add(DNI);
        texto.add(Box.createRigidArea(new Dimension(0,14)));
        texto.add(fechNa);
        texto.add(Box.createRigidArea(new Dimension(0,14)));
        texto.add(tel);
        texto.add(Box.createRigidArea(new Dimension(0,14)));
        texto.add(con);
        texto.add(Box.createRigidArea(new Dimension(0,14)));
        texto.add(conC);

        nombreTF = new JTextField(9);
        apellidosTF = new JTextField(9);
        direccionTF = new JTextField(9);
        dniTF = new JTextField("12345678A",9);
        fechaNacmientoTF = new JTextField("00/00/0000",9);
        telefonoTF = new JTextField("123456789",9);
        contraseniaTF = new JTextField(9);
        contraseniaCTF = new JTextField(9);

        datos.add(nombreTF);
        datos.add(Box.createRigidArea(new Dimension(0,10)));
        datos.add(apellidosTF);
        datos.add(Box.createRigidArea(new Dimension(0,10)));
        datos.add(direccionTF);
        datos.add(Box.createRigidArea(new Dimension(0,10)));
        datos.add(dniTF);
        datos.add(Box.createRigidArea(new Dimension(0,10)));
        datos.add(fechaNacmientoTF);
        datos.add(Box.createRigidArea(new Dimension(0,10)));
        datos.add(telefonoTF);
        datos.add(Box.createRigidArea(new Dimension(0,10)));
        datos.add(contraseniaTF);
        datos.add(Box.createRigidArea(new Dimension(0,10)));
        datos.add(contraseniaCTF);

        panel.add(new JLabel("Introduce tu información"));
        panel.add(new JLabel("Para acceder a la aplicación"));
        panel.add(new JLabel("(Recuerda tu contraseña)"));
        orden.add(texto);
        orden.add(datos);
        panel.add(orden);
        panel.add(Box.createRigidArea(new Dimension(0,100)));
        panel.add(botones);
        add(panel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == limpiar){
            nombreTF.setText("");
            apellidosTF.setText("");
            direccionTF.setText("");
            dniTF.setText("12345678A");
            fechaNacmientoTF.setText("00/00/0000");
            telefonoTF.setText("123456789");
            contraseniaTF.setText("");
            contraseniaCTF.setText("");
        }
        if (e.getSource() == registrar){
            if (!(contraseniaTF.getText().equals(contraseniaCTF.getText()))){
            contraseniaTF.setText("Las contraseñas deben coincidir");
            contraseniaCTF.setText("");
            }
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(fechaNacmientoTF.getText(), formato);
            DataBase.insertRegistro(dniTF.getText(),nombreTF.getText(),apellidosTF.getText(),fecha,direccionTF.getText(),Integer.parseInt(telefonoTF.getText()),contraseniaTF.getText());
            setVisible(false);

        }
        if (e.getSource() == atras){
            setVisible(false);
            new mainFrame();
        }
    }
}
