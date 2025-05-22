import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuTest extends JFrame implements ActionListener {
    private JButton empezar,volver;
    private Alumno a;
    private Profesor p;
    public MenuTest(Alumno a,Profesor p){
        this.p = p;
        this.a = a;

        setSize(250,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        JPanel botones = new JPanel();

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        botones.setLayout(new BoxLayout(botones,BoxLayout.X_AXIS));

        JLabel texto = new JLabel("El test consta de 10 preguntas");
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);


        empezar = new JButton("Empezar Test");
        empezar.addActionListener(this);
        empezar.setAlignmentX(Component.CENTER_ALIGNMENT);
        volver = new JButton("Volver");
        volver.addActionListener(this);
        volver.setAlignmentX(Component.CENTER_ALIGNMENT);

        botones.add(empezar);
        botones.add(Box.createRigidArea(new Dimension(10,0)));
        botones.add(volver);

        panel.add(texto);
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        panel.add(botones);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == volver) {
            setVisible(false);
            new MenuPrincipal(a, p);
        }
        if (e.getSource() == empezar){
            setVisible(false);
            new PreguntasTest(a,p);
        }
    }
}
