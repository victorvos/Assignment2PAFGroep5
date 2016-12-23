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
    public ArrayList<Wagon> wagonnen = new ArrayList<Wagon>();
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    public ArrayList<Trein> alleTreinen = new ArrayList<Trein>();


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
        ArrayList<Wagon> allWagonList = new ArrayList<Wagon>();
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
        w = null;
    }

    public void addWagon(Wagon wagon) {
        this.wagonnen.add(wagon);
        notifyObservers();
    }

    public Trein getTrein(String trnm){
        Trein thisWagon = null;
        for (Trein t : alleTreinen){
            if(t.getTrnm().equals(trnm)){
                thisWagon = t;
            }
        }
        return thisWagon;
    }

    public void removeWagon(String wgnnm) {
        // Vang string op als parameter
        // Check ofm wagon naam gekoppeld is aan trein
        // Verwijder deze
        for (Wagon w : wagonnen) {
            if(w.getWgNaam().equals(wgnnm)){
                int i = wagonnen.indexOf(w);
                wagonnen.remove(i);
                deleteWagon(w);
            }
        }
    }

    public void removeTrain(String trnm){
        for (Trein t : alleTreinen) {
            if(t.getTrnm().equals(trnm)){
                int i = alleTreinen.indexOf(t);
                alleTreinen.remove(i);
                deleteTrain(t);
            }
        }
    }


    public void deleteTrain(Trein t) {
        t = null;
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

    public Wagon getWagon(String wagonnaam){
        Wagon thisWagon = null;
        for (Wagon w : wagonnen){
            if(w.getWgNaam().equals(wagonnaam)){
                thisWagon = w;
            }
        }
        return thisWagon;
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
