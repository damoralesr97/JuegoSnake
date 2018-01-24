/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaGameOver;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author DavidMorales
 */
public class VentanaGameOver extends JFrame {
    private JPanel panel;
    private JLabel fondo;
    private JButton guardar;
    private JTextField nombre;
    private GestionDato gD;
    private VentanaJuego ventanaJuego;

    public VentanaGameOver(GestionDato gD, VentanaJuego ventanaJuego) throws HeadlessException {
        this.setTitle("GUARDAR PUNTUACION");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(2);
        this.setResizable(false);
        this.ventanaJuego = ventanaJuego;
        this.iniciaComp();
        this.gD=gD;
        this.setVisible(true);
    }
    
    public void iniciaComp(){
        //Panel
        this.panel=new JPanel();              
        this.panel.setLayout(null);
        this.panel.setSize(this.getSize());
        //Fondo
        this.fondo=new JLabel();
        this.fondo.setSize(this.getSize());
        this.fondo.setIcon(new ImageIcon("imagenes/GameOver.png"));
        this.fondo.setVisible(true);
        this.panel.add(this.fondo);
        //Boton
        this.guardar=new JButton("Guardar Puntuacion");
        this.guardar.setBorder(new LineBorder(Color.WHITE));
        this.guardar.setFont(new Font("Arial",Font.PLAIN,20));
        this.guardar.setForeground(Color.white);
        this.guardar.setBounds(165,400,180,30);    
        this.guardar.setBackground(Color.gray);
        //Texto con el nombre
        this.nombre=new JTextField();
        this.nombre.setBounds(180,360,150,25);
        
        //ActionListener Botones
        this.guardar.addActionListener(new EventoVentanaGameOver(this));
        
        //Agregar a la ventana
        this.panel.add(this.nombre,0);
        this.panel.add(this.guardar,0);
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

    public JButton getGuardar() {
        return guardar;
    }

    public void setGuardar(JButton guardar) {
        this.guardar = guardar;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    public VentanaJuego getVentanaJuego() {
        return ventanaJuego;
    }

    public void setVentanaJuego(VentanaJuego ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
    }
    
    
    
    
}
