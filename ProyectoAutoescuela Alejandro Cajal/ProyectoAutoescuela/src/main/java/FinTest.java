import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinTest extends JFrame implements ActionListener {
    private Alumno a;
    private Profesor p;
    private int aciertos;
    private JButton boton;
    public FinTest(int aciertos,Alumno a,Profesor p){
        this.aciertos = aciertos;
        this.p = p;
        this.a = a;

        setSize(200,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        boton = new JButton("volver");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.addActionListener(this);

        JLabel texto = new JLabel("Has tenido " + aciertos +" Prguntas Correctas");
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(texto);
        panel.add(boton);

        add(panel);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton){
            new MenuPrincipal(a,p);
            setVisible(false);
        }
    }
}
