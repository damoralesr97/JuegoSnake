/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaAyuda;
import vista.VentanaDificultad;
import vista.VentanaMenu;
import vista.VentanaRanking;

/**
 *
 * @author DavidMorales
 */
public class EventoVentanaMenu implements ActionListener {
    private VentanaMenu ventanaMenu;

    public EventoVentanaMenu(VentanaMenu ventanaMenu) {
        this.ventanaMenu = ventanaMenu;
    }

    public VentanaMenu getVentanaMenu() {
        return ventanaMenu;
    }

    public void setVentanaMenu(VentanaMenu ventanaMenu) {
        this.ventanaMenu = ventanaMenu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.ventanaMenu.getJugar())){
            VentanaDificultad vD = new VentanaDificultad(this.ventanaMenu.getgD());
            ventanaMenu.getClip().stop();
            this.ventanaMenu.dispose();
        }
        else if(e.getSource().equals(this.ventanaMenu.getRanking())){
            VentanaRanking vR = new VentanaRanking(this.ventanaMenu.getgD());
        }
        else if(e.getSource().equals(this.ventanaMenu.getAyuda())){
            VentanaAyuda vA = new VentanaAyuda(this.ventanaMenu.getgD());
            ventanaMenu.getClip().stop();
            this.ventanaMenu.dispose();
        }
        
    }
    
}
