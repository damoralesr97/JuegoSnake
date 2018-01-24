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
import vista.VentanaAyuda;
import vista.VentanaMenu;

/**
 *
 * @author stali
 */
public class EventoAyuda implements ActionListener{
    
    private VentanaAyuda ventana;
    public Clip clip;
    public String ruta="/sonido/";
    private VentanaMenu ventanamenu;
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

    public EventoAyuda(VentanaAyuda ventana) {
        this.ventana = ventana;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.ventana.getBoton())){
            sonido("fx03");
            this.ventana.dispose();
            VentanaMenu vM = new VentanaMenu(this.ventana.getgD());
            
        }
        
    }
    
}
