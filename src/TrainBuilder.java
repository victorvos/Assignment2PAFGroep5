/**
 * Created by Eigenaar on 14-12-2016.
 */
public interface TrainBuilder extends Application {
    void draw();
    void add();
    void delete();
    TrainBuilder select();
    int getNumSeats();
}
