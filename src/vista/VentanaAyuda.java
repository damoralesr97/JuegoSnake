package vista;

import controlador.EventoAyuda;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class VentanaAyuda extends JFrame{
    private JPanel panel;
    private JLabel fondo;
    private JLabel texto;
    private JButton boton;
    private GestionDato gD;
    private VentanaMenu vm;
    public Clip clip;
    public String ruta="/sonido/";
   
    
    public void sonido(String archivo)
    {
        try
        {
            clip= AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResource(ruta+archivo+".wav")));
            clip.start();
        }
        catch(Exception e)
        {
            
        }
        
    }

    public VentanaAyuda(GestionDato gD){
        sonido("fx03");
        this.gD = gD;
        this.setTitle("SNAKE AYUDA");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(2);
        this.setResizable(false);
        this.initComp();
        this.setVisible(true);
    }
    
    public void initComp(){
        //Panel
        this.panel=new JPanel(new BorderLayout());              
        this.panel.setSize(this.getSize());
        //Fondo
        this.fondo=new JLabel();
        this.fondo.setIcon(new ImageIcon("imagenes/Ayuda.png"));
        this.panel.add(this.fondo);
        //Label con texto
        this.texto=new JLabel("<html>SNAKE este juego consisten en el recorrido de una serpiente, la cual se controla mendiante un joystick o por el teclado; cuando se alimenta de una manzana aumenta el tamaño de su cuerpo."
                            + "<br>Cada Manzana tiene el valor de 1 punto; hay que tomar en cuenta que la serpiente no puede tocar los bordes y mucho menos comerse a si misma, ya que perderas"
                + "            <br>A mas de ello debes saber que solo te puedes mover en una unica direccion y girar en 90 grados, es decir que no puedes ir a la izquierda y luego tratar de ir a la derecha ya que igual perderas."
                + "            <br>Ahora solo queda decir DISFRUTA EL JUEGO!!!!! <html>");
        this.texto.setBounds(85,100,330,300);
        //Boton
        this.boton=new JButton("ENTENDIDO");
        this.boton.setBorder(new LineBorder(Color.BLACK));
        this.boton.setFont(new Font("Arial",Font.PLAIN,18));
        this.boton.setForeground(Color.white);
        this.boton.setBounds(187,400,120,30);    
        this.boton.setBackground(Color.gray);
        //ActionListener del boton
        this.boton.addActionListener(new EventoAyuda(this));
        //Agregacion
        this.add(this.boton);
        this.add(this.texto);
        this.add(this.panel);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getFondo() {
        return fondo;
    }

    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }

    public JLabel getTexto() {
        return texto;
    }

    public void setTexto(JLabel texto) {
        this.texto = texto;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
    
    
    
}
