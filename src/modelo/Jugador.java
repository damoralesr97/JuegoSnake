/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author DavidMorales
 */
@Entity
public class Jugador implements Serializable {
    @Id
    private int id;
    private String nombre;
    private String dificultad;
    private int puntaje;

    public Jugador() {
    }
    
    

    public Jugador(int id, String nombre, String dificultad, int puntaje) {
        this.id = id;
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.puntaje = puntaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", nombre=" + nombre + ", dificultad=" + dificultad + ", puntaje=" + puntaje + '}';
    }
    
}
