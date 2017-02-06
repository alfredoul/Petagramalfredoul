package mx.alfredoul.petagram.pojo;

/**
 * Created by alfredoul on 18/01/17.
 */


public class Mypet {

    private int rate;
    private int photo;

    public Mypet(int rate, int photo) {
        this.rate = rate;
        this.photo = photo;
    }

    public int getRate() { return rate; }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

}