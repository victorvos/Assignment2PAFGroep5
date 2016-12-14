/**
 * Created by Eigenaar on 14-12-2016.
 */
public class Wagon implements TrainBuilder {
    private int numSeats;
    private Wagon w; // Kan deze weg?
    private String wgNaam;

    //Standaard is de default value van de wagon 20
    //Je hebt dus bijvoorbeeld een command new wagon x;
    //--Deze wordt aangemaakt met een default numseats van 20 en zonder TREIN toegekend te hebben

    public Wagon(String wagonNaam) {
        this.wgNaam = wagonNaam;
        this.numSeats = 20;
    }

    public Wagon(String wagonNaam, int numSeats) {
        this.wgNaam = wagonNaam;
        this.numSeats = numSeats;
    }

    @Override
    public void draw() {

    }

    @Override
    public void delete() {

    }

    @Override
    public TrainBuilder select(int index) {
        return null;
    }

    @Override
    public int getNumSeats() {
        return 0;
    }

//    public void setNumSeats(int numOfSeats) {
//        this.numSeats = numOfSeats;
//    }
}
