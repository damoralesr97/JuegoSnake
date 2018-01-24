/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaJuego;
import controlador.GestionDato;
import modelo.Serpiente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import modelo.Comida;

/**
 *
 * @author DavidMorales
 */
public class VentanaJuego extends JFrame implements java.awt.event.KeyListener{
    
    private JPanel panelJuego;
    private JLabel fondo;
    private JLabel score;
    private Serpiente serpiente;
    private Timer tiempo;
    int ban = 0;
    private Comida comida;
    private GestionDato gD;
    private int perdio=0;
    private int puntaje = 0;
    private String dificultad;
  
    
    

    public VentanaJuego(GestionDato gD,String dificultad) {
        this.dificultad = dificultad;
        this.setTitle("Snake");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.addKeyListener(this);
        this.iniciaComponentes();
        this.gD=gD;
        
        this.setVisible(true);
    }
    
    public void iniciaComponentes(){
        this.panelJuego = new JPanel();
        this.panelJuego.setSize(this.getSize());
        this.panelJuego.setLayout(null);
        this.panelJuego.setVisible(true);
        
        this.fondo = new JLabel();
        this.fondo.setSize(this.panelJuego.getSize());
        this.fondo.setIcon(new ImageIcon("imagenes/fondo.png"));
        this.fondo.setVisible(true);
        this.panelJuego.add(this.fondo,0);
        
        this.score = new JLabel(Integer.toString(puntaje));
        this.score.setSize(50, 100);
        this.score.setLocation(130, -18);
        this.score.setFont(new Font("Serif", Font.PLAIN, 35));
        this.fondo.add(score);
        
        this.serpiente = new Serpiente();
        this.panelJuego.add(this.serpiente.getSerpiente().get(0),0);
        
        this.add(this.panelJuego);
        
        this.comida = new Comida();
        this.panelJuego.add(this.comida.getComida(),0);
        
        if(this.dificultad.equals("Facil")){
            this.tiempo = new Timer(150, new EventoVentanaJuego(this));
        } else if(this.dificultad.equals("Normal")){
            this.tiempo = new Timer(100, new EventoVentanaJuego(this));
        } else if(this.dificultad.equals("Dificil")){
            this.tiempo = new Timer(50, new EventoVentanaJuego(this));
        }
        
    }

    public JPanel getPanelJuego() {
        return panelJuego;
    }

    public void setPanelJuego(JPanel panelJuego) {
        this.panelJuego = panelJuego;
    }

    public JLabel getFondo() {
        return fondo;
    }

    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }

    public JLabel getScore() {
        return score;
    }

    public void setScore(JLabel score) {
        this.score = score;
    }

    public Serpiente getSerpiente() {
        return serpiente;
    }

    public void setSerpiente(Serpiente serpiente) {
        this.serpiente = serpiente;
    }

    public Timer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Timer tiempo) {
        this.tiempo = tiempo;
    }

    public int getBan() {
        return ban;
    }

    public void setBan(int ban) {
        this.ban = ban;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public int getPerdio() {
        return perdio;
    }

    public void setPerdio(int perdio) {
        this.perdio = perdio;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
    
    
    
    
    
    

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_UP){
                    //System.out.println("Arriba");
                    if(serpiente.getSerpiente().get(0).getY() > 0){
                        serpiente.setY(-(serpiente.getDesplazamiento()));
                        serpiente.setX(0);
                        serpiente.getSerpiente().get(0).setIcon(new ImageIcon("imagenes/caraArriba.png"));
                    }
                    if(ban==0){
                        tiempo.start();
                        ban=1;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    //System.out.println("Abajo");
                    if(serpiente.getSerpiente().get(0).getY() < 500){
                        serpiente.setY(serpiente.getDesplazamiento());
                        serpiente.setX(0);
                        serpiente.getSerpiente().get(0).setIcon(new ImageIcon("imagenes/caraAbajo.png"));
                    }
                    if(ban==0){
                        tiempo.start();
                        ban=1;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    //System.out.println("Izquierda");
                    if(serpiente.getSerpiente().get(0).getX() > 0){
                        serpiente.setY(0);
                        serpiente.setX(-(serpiente.getDesplazamiento()));
                        serpiente.getSerpiente().get(0).setIcon(new ImageIcon("imagenes/caraIzq.png"));
                    }
                    if(ban==0){
                        tiempo.start();
                        ban=1;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    //System.out.println("Derecha");
                    if(serpiente.getSerpiente().get(0).getX() < 500){
                        serpiente.setY(0);
                        serpiente.setX(serpiente.getDesplazamiento());
                        serpiente.getSerpiente().get(0).setIcon(new ImageIcon("imagenes/caraDer.png"));
                    }
                    if(ban==0){
                        tiempo.start();
                        ban=1;
                    }
                }}

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
    
    
    
}
