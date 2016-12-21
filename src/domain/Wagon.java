package domain;
import java.util.ArrayList;
import gui.Observable;
import gui.Observer;

/**
 * Created by Eigenaar on 14-12-2016.
 */
public class Wagon implements Observable {
    private int numSeats;
    private String wgNaam;
    private Type type;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    //Standaard is de default value van de wagon 20
    //Je hebt dus bijvoorbeeld een command new wagon x;
    //--Deze wordt aangemaakt met een default numseats van 20 en zonder TREIN toegekend te hebben

    public Wagon(String wagonNaam, Type tp) {
        this.wgNaam = wagonNaam;
        this.numSeats = 20;
        this.type = tp;
    }

    public Wagon(String wagonNaam, int numSeats) {
        this.wgNaam = wagonNaam;
        this.numSeats = numSeats;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public String getWgNaam() {
        return wgNaam;
    }

    public void setWgNaam(String wgNaam) {
        this.wgNaam = wgNaam;
    }

    public int getNumSeats() {
        return numSeats;
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

//    public void setNumSeats(int numOfSeats) {
//        this.numSeats = numOfSeats;
//    }
}
