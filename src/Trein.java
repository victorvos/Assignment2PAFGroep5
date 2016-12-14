import java.util.ArrayList;

/**
 * Created by Eigenaar on 14-12-2016.
 */
public class Trein implements TrainBuilder {
    private Wagon w;
    private ArrayList<Trein> treinen = new ArrayList();

    public Trein(){

    }

    @Override
    public void draw() {

    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }

    @Override
    public TrainBuilder select(int index) {
        Trein trein = treinen.get(index);
        return trein;
    }

    @Override
    public int getNumSeats() {
        return 0;
    }
}
