/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import vista.VentanaDificultad;
import vista.VentanaJuego;

/**
 *
 * @author DavidMorales
 */
public class EventoVentanaDificultad implements ActionListener {

    private VentanaDificultad ventanaDificultad;
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
    
    
    public EventoVentanaDificultad(VentanaDificultad ventanaDificultad) {
        this.ventanaDificultad = ventanaDificultad;
    }

    public VentanaDificultad getVentanaDificultad() {
        return ventanaDificultad;
    }

    public void setVentanaDificultad(VentanaDificultad ventanaDificultad) {
        this.ventanaDificultad = ventanaDificultad;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        this.ventanaDificultad.setDifSelec(this.ventanaDificultad.getComboDif().getSelectedItem().toString());
        sonido("fx03");
        VentanaJuego vJ = new VentanaJuego(this.ventanaDificultad.getgD(),this.ventanaDificultad.getDifSelec());
        sonido("fx03");
        this.ventanaDificultad.dispose();
        
        //this.ventanaDificultad.setVisible(false);
    }
    
}
