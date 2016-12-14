/**
 * Created by Eigenaar on 14-12-2016.
 */
public class Wagon implements TrainBuilder {
    private int numSeats;
    private Wagon w;

    public Wagon(Trein t, int numSeats){
        this.numSeats = numSeats;
        t.add(w);
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
}
