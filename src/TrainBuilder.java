import java.util.ArrayList;

/**
 * Created by Eigenaar on 14-12-2016.
 */
public interface TrainBuilder extends Application {
    ArrayList<Trein> treinen = new ArrayList();
    void draw();

    TrainBuilder select(int index);
    int getNumSeats();
}
