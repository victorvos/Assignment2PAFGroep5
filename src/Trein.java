import java.util.ArrayList;

/**
 * Created by Eigenaar on 14-12-2016.
 */
public class Trein implements TrainBuilder {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    private Wagon w;
    private Log l;
    public ArrayList<Wagon> trein = new ArrayList();

    public Trein(String trnm){
        l.makeLog(now, "train: " + trnm + " has been created");
    }

    @Override
    public void draw() {

    }


    public void add(Wagon w) {
        trein.add(w);
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
        int amountSeats = 0;
        for (Wagon w : trein){
            amountSeats += w.getNumSeats();
        }
        return amountSeats;
    }
}
