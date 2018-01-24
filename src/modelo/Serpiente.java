package modelo;


import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DavidMorales
 */
public class Serpiente {
    private ArrayList<JLabel> serpiente = new ArrayList<JLabel>();
    private JLabel aux;
    private int x;
    private int y;
    private int desplazamiento=20;
    private Rectangle serp;

    public Serpiente() {
        this.aux = new JLabel();
        this.aux.setLocation(240, 240);
        this.aux.setSize(20, 20);
        this.aux.setIcon(new ImageIcon("imagenes/caraDer.png"));
        this.aux.setVisible(true);
        this.serpiente.add(this.aux);
        this.serp = new Rectangle(this.serpiente.get(0).getBounds());
    }

    public ArrayList<JLabel> getSerpiente() {
        return serpiente;
    }

    public void setSerpiente(ArrayList<JLabel> serpiente) {
        this.serpiente = serpiente;
    }
    

    public JLabel getAux() {
        return aux;
    }

    public void setAux(JLabel aux) {
        this.aux = aux;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDesplazamiento() {
        return desplazamiento;
    }

    public void setDesplazamiento(int desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public Rectangle getSerp() {
        return serp;
    }

    public void setSerp(Rectangle serp) {
        this.serp = serp;
    }
    
}
