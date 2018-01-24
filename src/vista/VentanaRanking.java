/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Jugador;

/**
 *
 * @author DavidMorales
 */
public class VentanaRanking extends JFrame {
    private GestionDato gD;
    private JPanel panel;
    private JScrollPane scroll;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private Object[] encabezado;
    private Object[][] datos;
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
    
    public VentanaRanking(GestionDato gD) throws HeadlessException {
        super("TOP JUGADORES");
        sonido("fx03");
        this.gD = gD;
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.iniciaComponentes();
        this.setVisible(true);
    }
    
    public void iniciaComponentes(){
        this.panel = new JPanel(new BorderLayout());
        
        this.encabezado = new Object[4];
        this.encabezado[0] = "#";
        this.encabezado[1] = "Nombre";
        this.encabezado[2] = "Nivel";
        this.encabezado[3] = "Puntaje";
        
        this.datos = cargarDatosTabla(this.gD.leerPersona().size(), 4);
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
        
        this.panel.add(scroll);
        this.add(this.panel);
    }
    
    public Object[][] cargarDatosTabla(int m, int n) {       
        Object[][] retorno = new Object[m][n];
        int i = 0;
        for(Jugador j: this.gD.leerPersona()) {
            retorno[i][0] = j.getId();
            retorno[i][1] = j.getNombre();
            retorno[i][2] = j.getDificultad();
            retorno[i][3] = j.getPuntaje();
            i++;
        } 
        return retorno; 
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }
    
    
    
}
