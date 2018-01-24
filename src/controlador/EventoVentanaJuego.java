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
import javax.swing.ImageIcon;
import modelo.Serpiente;
import vista.VentanaDificultad;
import vista.VentanaGameOver;
import vista.VentanaJuego;



/**
 *
 * @author DavidMorales
 */

//Cada vez que inicia el timer
public class EventoVentanaJuego implements ActionListener {
    private VentanaJuego ventanaJuego;
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
    
    public EventoVentanaJuego(VentanaJuego ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
    }

    

    public VentanaJuego getVentanaJuego() {
        return ventanaJuego;
    }

    public void setVentanaJuego(VentanaJuego ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Pierde al tocarse la serpiente con si misma
        for(int i=this.ventanaJuego.getSerpiente().getSerpiente().size()-1;i>0;i--){
            if(this.ventanaJuego.getSerpiente().getSerpiente().get(0).getLocation().equals(this.ventanaJuego.getSerpiente().getSerpiente().get(i).getLocation())){
                this.ventanaJuego.getTiempo().stop(); 
                VentanaGameOver gO = new VentanaGameOver(this.ventanaJuego.getgD(),this.ventanaJuego); 
                sonido("fin");
                this.ventanaJuego.dispose();
            }
        }              
        this.ventanaJuego.getComida().getComi().setBounds(this.ventanaJuego.getComida().getComida().getBounds());
        this.ventanaJuego.getSerpiente().getSerp().setBounds(this.ventanaJuego.getSerpiente().getSerpiente().get(0).getBounds());
        
        //Pierde al pasarse de un borde
        if(this.ventanaJuego.getSerpiente().getSerpiente().get(0).getX() > 460){ //borde derecho
            this.ventanaJuego.setPerdio(1);
        }
        if(this.ventanaJuego.getSerpiente().getSerpiente().get(0).getX() < 20){ //borde izquierdo
            this.ventanaJuego.setPerdio(1);
        }
        if(this.ventanaJuego.getSerpiente().getSerpiente().get(0).getY() > 420){ //borde inferior
            this.ventanaJuego.setPerdio(1);
        }
        if(this.ventanaJuego.getSerpiente().getSerpiente().get(0).getY() < 100){ //borde superior
            this.ventanaJuego.setPerdio(1);
        }
        if(this.ventanaJuego.getPerdio()==1){
            VentanaGameOver gO = new VentanaGameOver(this.ventanaJuego.getgD(),this.ventanaJuego);
            sonido("fin");
            this.ventanaJuego.getTiempo().stop();
            this.ventanaJuego.dispose();
        }
        
        //Al comer la manzana
        if(this.ventanaJuego.getComida().getComi().intersects(this.ventanaJuego.getSerpiente().getSerp())){
            this.ventanaJuego.getComida().setX(this.ventanaJuego.getComida().getAleatorio().nextInt(460));
            while(this.ventanaJuego.getComida().getX()<20){
                this.ventanaJuego.getComida().setX(this.ventanaJuego.getComida().getAleatorio().nextInt(460));
            }
            this.ventanaJuego.getComida().setY(this.ventanaJuego.getComida().getAleatorio().nextInt(420));
            while(this.ventanaJuego.getComida().getY()<100){
                this.ventanaJuego.getComida().setY(this.ventanaJuego.getComida().getAleatorio().nextInt(420));
            }
            this.ventanaJuego.getComida().getComida().setLocation(this.ventanaJuego.getComida().getX(),this.ventanaJuego.getComida().getY());
            sonido("saperror");        
            //Se crea un nuevo objeto serpiente para agregar el cuerpo en la serpiente principal        
            //INSERTAR AUIDIO
            this.ventanaJuego.getComida().getComida().repaint();
            Serpiente s = new Serpiente();
            s.getAux().setLocation(200,200);
            s.getAux().setSize(20,20);
            s.getAux().setIcon(new ImageIcon("imagenes/cuerpo.png"));
            s.getAux().setVisible(true);
            this.ventanaJuego.getSerpiente().getSerpiente().add(s.getAux());
            this.getVentanaJuego().getPanelJuego().add(this.ventanaJuego.getSerpiente().getSerpiente().get(this.ventanaJuego.getSerpiente().getSerpiente().size()-1),0);
            this.ventanaJuego.setPuntaje(this.ventanaJuego.getPuntaje()+1);   //Se incrementa el puntaje                 
            this.ventanaJuego.getScore().setText(Integer.toString(this.ventanaJuego.getPuntaje()));
                    
        }
                
                
        //Volver a dibujar la serpiente cada vez que come una manzana        
        for(int i=this.ventanaJuego.getSerpiente().getSerpiente().size()-1;i>0;i--){
            this.ventanaJuego.getSerpiente().getSerpiente().get(i).setLocation(this.ventanaJuego.getSerpiente().getSerpiente().get(i-1).getLocation());
            this.ventanaJuego.getSerpiente().getSerpiente().get(i).repaint();
        }
        this.ventanaJuego.getSerpiente().getSerpiente().get(0).setLocation(this.ventanaJuego.getSerpiente().getSerpiente().get(0).getX()+this.ventanaJuego.getSerpiente().getX(), this.ventanaJuego.getSerpiente().getSerpiente().get(0).getY()+this.ventanaJuego.getSerpiente().getY());
    }
    
    
}
