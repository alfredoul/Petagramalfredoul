package mx.alfredoul.petagram.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alfredoul on 18/01/17.
 */


public class Pet {

    private String nombre;
    private String rate;
    private int photo;

    public Pet(String nombre, String rate, int photo) {
        this.nombre = nombre;
        this.rate = rate;
        this.photo = photo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

}