package domain;
import java.io.IOException;
import java.util.ArrayList;
import gui.Observable;
import gui.Observer;

import gui.Log;

/**
 * Created by Eigenaar on 14-12-2016.
 */
public class Trein implements Observable {
    private String trnm;
    private Wagon w;
    private Log l;
    private Type type;
    public ArrayList<Wagon> wagonnen = new ArrayList();
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    public ArrayList<Trein> alleTreinen = new ArrayList();


    public Trein(String trnm) throws IOException {
        this.trnm = trnm;
        this.type = new Type("Trein");
        this.notifyObservers();
        alleTreinen.add(this);
    }

    public String getTrnm() {
        return trnm;
    }

    public ArrayList<Trein> trainList(){
    	return alleTreinen;
    }

    public ArrayList<Wagon> wagonList(){
        ArrayList<Wagon> allWagonList = new ArrayList();
        for (Trein t : alleTreinen){
            for (Wagon w: t.getWagons()){
                allWagonList.add(w);
            }
        }
        return allWagonList;
    }
    
    public void setTrnm(String trnm) {
        this.trnm = trnm;
    }

    public void deleteWagon(Wagon w) {

        // Vang string op als parameter
        // Check ofm wagon naam gekoppeld is aan trein
        // Verwijder deze

        if (wagonnen.contains(w)){
            int o = wagonnen.indexOf(w);
            wagonnen.remove(o);
        }

    }

    public void addWagon(Wagon wagon) {
        this.wagonnen.add(wagon);
        notifyObservers();
    }

    public void removeWagon(Wagon wagon) {
        this.wagonnen.remove(wagon);
    }

    public ArrayList<Wagon> getWagons() {
        return wagonnen;
    }

    public Boolean checkWagons(String id){
        for (Wagon w : wagonnen){
            if(w.getWgNaam().equals(id)){
                return true;
            }
        }
        return false;
    }

    public int getNumSeats() {
        int amountSeats = 0;
        for (Wagon w : wagonnen){
            amountSeats += w.getNumSeats();
        }
        return amountSeats;
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.refreshData();
        }
    }

    @Override
    public void register(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void unRegister(Observer obs) {
        observers.remove(obs);
    }
}
