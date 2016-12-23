package controller;

// GUI
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import domain.Wagon;
import domain.Trein;
import domain.CreateEndWagon;

import command.CommandLine;
import command.NewTrainCommand;
import command.DeleteWagonCommand;
import command.GetNumSeatsTrainCommand;
import command.GetNumSeatsWagonCommand;

import gui.View;
import gui.Observer;
import logic.Writer;


public class Controller implements Observer {
    private ArrayList<View> views;
    private ArrayList<Trein> trains = new ArrayList<Trein>();
    private ArrayList<Wagon> wagons = new ArrayList<Wagon>();
    private ArrayList<CommandLine> CommandLine;
    private ArrayList<String> logcommands;

    public Controller() {
        this.views = new ArrayList<View>();
        this.CommandLine = new ArrayList<CommandLine>();
        this.setLogcommands(new ArrayList<String>());
    }

    public Controller(ArrayList<CommandLine> CommandLine) {
        this();
        this.CommandLine = CommandLine;
    }

    public ArrayList<View> getViews() {
        return views;
    }

    public ArrayList<Trein> getTrains() {
        return trains;
    }

    public ArrayList<Wagon> getWagons() {
        return wagons;
    }

    public ArrayList<CommandLine> getCommands() {
        return CommandLine;
    }

    public ArrayList<Writer> getWriters() {
        return writers;
    }

    public ArrayList<String> getLogcommands() {
        return logcommands;
    }

    public void setLogcommands(ArrayList<String> logcommands) {
        this.logcommands = logcommands;
    }

    public void setViews(ArrayList<View> views) {
        this.views = views;
    }

    public void setTrains(ArrayList<Trein> trains) {
        this.trains = trains;
    }

    public void setWagons(ArrayList<Wagon> wagons) {
        this.wagons = wagons;
    }

    public void setCommands(ArrayList<CommandLine> CommandLine) {
        this.CommandLine = CommandLine;
    }

    public void setWriters(ArrayList<Writer> writers) {
        this.writers = writers;
    }

    public void addView(View view) {
        views.add(view);
    }

    public void removeView(View view) {
        if (views.contains(view)) {
            views.remove(view);
        }
    }

    public void addTrain(Trein Trein) {
        trains.add(Trein);
        refreshData();
    }

    public void removeTrain(Trein Trein) {
        if (trains.contains(Trein)) {
            trains.remove(Trein);
            refreshData();
        }
    }

    public void addWagon(Wagon wagon) {
        wagons.add(wagon);
        refreshData();
    }

    public void removeWagon(Wagon wagon) {
        if (wagons.contains(wagon)) {
            wagons.remove(wagon);
            refreshData();
        }
    }

//    public void addWriter(Writer writer) {
//        writers.add(writer);
//    }
//
//    public void removeWriter(Writer writer) {
//        if (writers.contains(writer)) {
//            writers.remove(writer);
//        }
//    }

    public void addLogcommand(String logcommand) {
        logcommands.add(logcommand);
    }

    public void removeLogcommand(String logcommand) {
        if (logcommands.contains(logcommand)) {
            logcommands.remove(logcommand);
        }
    }

    public void split(String commandString) throws IOException {
        if (writers != null && writers.size() > 0) {
            for (Writer writer : writers) {
                writer.write(commandString);
            }
        }
        String[] word = commandString.split(" ");
        if (word[0].equals("new") || word[0].equals("add") || word[0].equals("remove")
                || word[0].equals("delete") || word[0].equals("getnumseats")) {
            if (commandString.substring(commandString.length() - 1).equals(";")) {
                if (word[0].equals("new")) {
                    if (word[1].equals("train")) {
                        Trein c = new Trein(word[2].substring(0, word[2].length() - 1));
                    }

                    else {
                        if (word[1].equals("wagon")) {
                            try {
                                if (word[3].equals("numseats")) {
                                    Wagon w = new Wagon(word[2]);
                                    w.setNumSeats(Integer.parseInt(word[2].substring(0, word[2].length() - 1)));
                                }
                            }
                            catch(Exception e){
                                Wagon w = new Wagon(word[2]);
                                w.setNumSeats(Integer.parseInt(word[2].substring(0, word[2].length() - 1)));
                            }
                        }

                        else if (word[1].equals("endwagon")) {
                            Wagon w = new Wagon(word[2]);
                            w.setNumSeats(Integer.parseInt(word[2].substring(0, word[2].length() - 1)));
                        }
                    }
                }

                else if (word[0].equals("getnumseats")) {

                    if (word[1].equals("wagon")) {
                        GetNumSeatsWagonCommand CommandLine = new GetNumSeatsWagonCommand();
                        CommandLine.execute(word[2].substring(0, word[2].length() - 1));
                    }
                    else if (word[1].equals("train")) {
                    	GetNumSeatsTrainCommand CommandLine = new GetNumSeatsTrainCommand();
                        CommandLine.execute(word[2].substring(0, word[2].length() - 1));
                    }
                } else if (word[0].equals("add")) {
                    // Later voor debug
                    System.out.println(word.length);
                    // Tijdelijk object
                    Trein t = new Trein("temp");
                    // Get Train Object by name
                    t = t.getTrein(word[2]);
                    // Return Wagon object by name
                    Wagon w = t.getWagon(word[3].substring(0, word[3].length() - 1));

                    // Add this wagon to train
                    t.addWagon(w);
                }
                else if (word[0].equals("remove")) {
                    for (Wagon w: getWagons()) {
                        if (w.getWgNaam() == word[1]) {
                            Wagon wagon = w;
                            removeWagon(wagon);
                        }
                    }
                    for (Trein t: getTrains()) {
                        if (t.getTrnm() == word[3]) {
                            Trein trein = t;
                        }
                    }

                }
                else if (word[0].equals("delete")) {
                    if (word[1].equals("train")) {
                        DeleteTrain CommandLine = new DeleteTrain();
                        CommandLine.setTrain(word[2].substring(0, word[2].length() - 1));
                        CommandLine.execute(this);
                    } else if (word[1].equals("wagon")) {
                        DeleteWagon CommandLine = new DeleteWagon();
                        CommandLine.setWagon(word[2].substring(0, word[2].length() - 1));
                        CommandLine.execute(this);
                    }
                } else if (word[0].equals("remove")) {
                    RemoveWagonFromTrain CommandLine = new RemoveWagonFromTrain();
                    CommandLine.setWagon(word[1]);
                    CommandLine.setTrain(word[3].substring(0, word[3].length() - 1));
                    CommandLine.execute(this);

                }
            } else
                JOptionPane.showMessageDialog(null,
                        "Invalid command. Missing ; at the end");

        } else
            JOptionPane
                    .showMessageDialog(null,
                            "Invalid command. Known commands are: add,remove,delete,getnumseats ");
    }


    @Override
    public void refreshData() {
//        for (View view : views) {
//            view.update(this);
//        }
    }
}
