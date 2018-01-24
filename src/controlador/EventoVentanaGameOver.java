/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Jugador;
import vista.VentanaDificultad;
import vista.VentanaGameOver;
import vista.VentanaJuego;
import vista.VentanaMenu;

/**
 *
 * @author DavidMorales
 */
public class EventoVentanaGameOver implements ActionListener {
    private VentanaGameOver ventanaGameOver;   

    public EventoVentanaGameOver(VentanaGameOver ventanaGameOver) {
        this.ventanaGameOver = ventanaGameOver;
    }

    public VentanaGameOver getVentanaGameOver() {
        return ventanaGameOver;
    }

    public void setVentanaGameOver(VentanaGameOver ventanaGameOver) {
        this.ventanaGameOver = ventanaGameOver;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomb = this.ventanaGameOver.getNombre().getText();
        
        
        Jugador ju = new Jugador(this.ventanaGameOver.getgD().leerPersona().size()+1,nomb,this.ventanaGameOver.getVentanaJuego().getDificultad(),this.ventanaGameOver.getVentanaJuego().getPuntaje());
        this.ventanaGameOver.getgD().insertarJugador(ju);
        this.ventanaGameOver.dispose();
        VentanaMenu vM = new VentanaMenu(this.ventanaGameOver.getgD());
        
    }
    
    
}
