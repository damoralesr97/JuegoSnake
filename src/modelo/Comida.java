/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author DavidMorales
 */
public class Comida {
    private JLabel comida;
    private int x;
    private int y;
    private Rectangle comi;
    private Random aleatorio;

    public Comida() {
        this.comida = new JLabel();
        this.comida.setSize(20, 20);
        this.comida.setIcon(new ImageIcon("imagenes/comida.png"));
        aleatorio = new Random();
        this.x=aleatorio.nextInt(460);
        while(this.x<20){
            this.x=aleatorio.nextInt(460);
        }
        this.y=aleatorio.nextInt(420);
        while(this.y<100){
            this.y=aleatorio.nextInt(420);
        }
        this.comida.setLocation(x, y);
        this.comida.setVisible(true);
        this.comi = new Rectangle(this.comida.getBounds());
    }
    
    

    public JLabel getComida() {
        return comida;
    }

    public void setComida(JLabel comida) {
        this.comida = comida;
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

    public Rectangle getComi() {
        return comi;
    }

    public void setComi(Rectangle comi) {
        this.comi = comi;
    }

    public Random getAleatorio() {
        return aleatorio;
    }

    public void setAleatorio(Random aleatorio) {
        this.aleatorio = aleatorio;
    }

}
