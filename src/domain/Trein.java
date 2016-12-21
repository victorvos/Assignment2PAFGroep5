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
    public ArrayList<Wagon> wagonnen = new ArrayList();
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    public ArrayList<Trein> alleTreinen = new ArrayList();


    public Trein(String trnm) throws IOException {
        l.makeLog("train: " + trnm + " has been created");
        this.trnm = trnm;
        this.notifyObservers();
        alleTreinen.add(this);
    }

    public String getTrnm() {
        return trnm;
    }

    public ArrayList<Trein> trainList(){
    	return alleTreinen;
    }
    
    public void setTrnm(String trnm) {
        this.trnm = trnm;
    }

    public void deleteWagon(Wagon w) {
        if (wagonnen.contains(w)){
            int o = wagonnen.indexOf(w);
            wagonnen.remove(o);
        }
        else{
            System.out.println("Wagon bestaat niet in deze trein");
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
