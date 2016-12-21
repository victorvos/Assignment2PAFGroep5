package domain;
import java.io.IOException;
import java.util.ArrayList;

import gui.Log;
import interfaces.TrainBuilder;
/**
 * Created by Eigenaar on 14-12-2016.
 */
public class Trein implements TrainBuilder {
    private Wagon w;
    private Log l;
    public ArrayList<Wagon> trein = new ArrayList();

    public Trein(String trnm) throws IOException {
        l.makeLog(l.logDate(), "train: " + trnm + " has been created");
    }

    @Override
    public void draw() {

    }

    public void addWagon(Wagon w) {
        trein.add(w);
    }

    public void deleteWagon(Wagon w) {
        if (trein.contains(w)){
            int o = trein.indexOf(w);
            trein.remove(o);
        }
        else{
            System.out.println("Wagon bestaat niet in deze trein");
        }
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
