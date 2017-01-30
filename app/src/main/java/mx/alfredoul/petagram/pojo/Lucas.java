package mx.alfredoul.petagram.pojo;

/**
 * Created by alfredoul on 18/01/17.
 */


public class Lucas {

    private String rate;
    private int photo;

    public Lucas(String rate, int photo) {
        this.rate = rate;
        this.photo = photo;
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