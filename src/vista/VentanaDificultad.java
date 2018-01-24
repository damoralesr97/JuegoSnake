/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaDificultad;
import controlador.GestionDato;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author DavidMorales
 */

public class VentanaDificultad extends JFrame {
    private JPanel panel;
    private JComboBox comboDif;
    private String[] datosCombo;
    private JButton nuevoJuego;
    private GestionDato gD;
    private String difSelec;

    
    
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
    public VentanaDificultad(GestionDato gD) throws HeadlessException {
        this.setTitle("Dificultad");
        this.setSize(300, 150);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(2);
        this.gD=gD;
        
        this.panel = new JPanel(new GridLayout(2, 1));
        this.panel.setBackground(Color.LIGHT_GRAY);

        this.datosCombo = new String[3];
        datosCombo[0] = "Facil";
        datosCombo[1] = "Normal";
        datosCombo[2] = "Dificil";
        this.comboDif = new JComboBox(datosCombo);
        this.comboDif.setBackground(Color.green);
        this.comboDif.setName("Dificultad");
        
        this.nuevoJuego = new JButton("Nuevo Juego");
        this.nuevoJuego.setBackground(Color.GREEN);

        this.nuevoJuego.addActionListener(new EventoVentanaDificultad(this));
        sonido("fx04");
        this.panel.add(this.nuevoJuego);
        this.panel.add(this.comboDif);

        this.add(this.panel);
        
        this.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JComboBox getComboDif() {
        return comboDif;
    }

    public void setComboDif(JComboBox comboDif) {
        this.comboDif = comboDif;
    }

    public String[] getDatosCombo() {
        return datosCombo;
    }

    public void setDatosCombo(String[] datosCombo) {
        this.datosCombo = datosCombo;
    }

    public JButton getNuevoJuego() {
        return nuevoJuego;
    }

    public void setNuevoJuego(JButton nuevoJuego) {
        this.nuevoJuego = nuevoJuego;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    public String getDifSelec() {
        return difSelec;
    }

    public void setDifSelec(String difSelec) {
        this.difSelec = difSelec;
    }
    
}
