import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PreguntasTest extends JFrame implements ActionListener {
    private Alumno a;
    private Profesor p;
    private JButton siguiente;
    private int conteo = 0;
    private JCheckBox casilla1,casilla2,casilla3;
    private Pregunta primera,preguntaActual;
    private int aciertos = 0;
    private JLabel pregunta;
    public PreguntasTest(Alumno a,Profesor p){
        this.p = p;
        this.a = a;
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        primera = DataBase.obtenerTodasPreguntas().get((int)(Math.random()*20));

        pregunta = new JLabel(primera.getPregunta());
        casilla1 = new JCheckBox(primera.getRespuesta1());
        casilla1.setAlignmentX(Component.CENTER_ALIGNMENT);
        casilla2 = new JCheckBox(primera.getRespuesta2());
        casilla2.setAlignmentX(Component.CENTER_ALIGNMENT);
        casilla3 = new JCheckBox(primera.getRespuesta3());
        casilla3.setAlignmentX(Component.CENTER_ALIGNMENT);
        casilla1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (casilla1.isSelected()) {
                    casilla2.setSelected(false);
                    casilla3.setSelected(false);
                } else {

                }
            }
        });
        casilla2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (casilla2.isSelected()) {
                    casilla3.setSelected(false);
                    casilla1.setSelected(false);
                } else {

                }
            }
        });
        casilla3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (casilla3.isSelected()) {
                    casilla2.setSelected(false);
                    casilla1.setSelected(false);
                } else {

                }
            }
        });

        siguiente = new JButton("Siguiente Pregunta");
        siguiente.addActionListener(this);
        siguiente.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(pregunta);
        panel.add(Box.createRigidArea(new Dimension(0,40)));
        panel.add(casilla1);
        panel.add(Box.createRigidArea(new Dimension(0,40)));
        panel.add(casilla2);
        panel.add(Box.createRigidArea(new Dimension(0,40)));
        panel.add(casilla3);
        panel.add(Box.createRigidArea(new Dimension(0,40)));
        panel.add(siguiente);
        add(panel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == siguiente) {

            int dato = 0;
            if (casilla1.isSelected()) {
                dato = 1;
            } else if (casilla2.isSelected()) {
                dato = 2;
            } else if (casilla3.isSelected()) {
                dato = 3;
            } else {
                dato = 4;
            }


            if (dato == primera.getRespuestaCorrecta()) {
                aciertos++;
            }

            conteo++;

            if (conteo == 10) {

                new FinTest(aciertos, a, p);
                this.dispose();
                return;
            }


            primera = DataBase.obtenerTodasPreguntas().get((int)(Math.random()*20));


            for (Component comp : getContentPane().getComponents()) {
                if (comp instanceof JPanel) {
                    JPanel panel = (JPanel) comp;
                    for (Component c : panel.getComponents()) {
                        if (c instanceof JLabel) {
                            JLabel label = (JLabel) c;
                            if (label.getText().equals(primera.getPregunta()) || label == null) {
                                label.setText(primera.getPregunta());
                            }
                        }
                    }
                }
            }

            pregunta.setText(primera.getPregunta());
            casilla1.setText(primera.getRespuesta1());
            casilla1.setSelected(false);
            casilla2.setText(primera.getRespuesta2());
            casilla2.setSelected(false);
            casilla3.setText(primera.getRespuesta3());
            casilla3.setSelected(false);
        }
    }

}
