package mx.alfredoul.petagram.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alfredoul on 18/01/17.
 */


public class Pet {

    private int id;
    private String nombre;
    private int rate;
    private int photo;

    public Pet(String nombre, int rate, int photo) {
        this.nombre = nombre;
        this.rate = rate;
        this.photo = photo;
    }

    public Pet() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRate() { return rate; }

    public void setRate(int rate) { this.rate = rate; }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}