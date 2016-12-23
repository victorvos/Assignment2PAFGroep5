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
        String[] receivedString = commandString.split(" ");
        if (receivedString[0].equals("new") || receivedString[0].equals("add") || receivedString[0].equals("remove")
                || receivedString[0].equals("delete") || receivedString[0].equals("getnumseats")) {
            if (commandString.substring(commandString.length() - 1).equals(";")) {
                if (receivedString[0].equals("new")) {
                    if (receivedString[1].equals("train")) {
                        Trein c = new Trein(receivedString[2].substring(0, receivedString[2].length() - 1));
                    }

                    else {
                        if (receivedString[1].equals("wagon")) {
                            try {
                                if (receivedString[3].equals("numseats")) {
                                    Wagon w = new Wagon(receivedString[2]);
                                    w.setNumSeats(Integer.parseInt(receivedString[4]));
                                }
                            }
                            catch(Exception e){
                                Wagon w = new Wagon(receivedString[2]);
                                w.setNumSeats(Integer.parseInt(receivedString[2].substring(0, receivedString[2].length() - 1)));
                            }
                        }

                        else if (receivedString[1].equals("endwagon")) {
                            Wagon w = new Wagon(receivedString[2]);
                            w.setNumSeats(Integer.parseInt(receivedString[2].substring(0, receivedString[2].length() - 1)));
                        }
                    }
                }

                else if (receivedString[0].equals("getnumseats")) {

                    if (receivedString[1].equals("wagon")) {
                        GetNumSeatsWagonCommand CommandLine = new GetNumSeatsWagonCommand();
                        CommandLine.execute(receivedString[2].substring(0, receivedString[2].length() - 1));
                    }
                    else if (receivedString[1].equals("train")) {
                    	GetNumSeatsTrainCommand CommandLine = new GetNumSeatsTrainCommand();
                        CommandLine.execute(receivedString[2].substring(0, receivedString[2].length() - 1));
                    }
                } else if (receivedString[0].equals("add")) {
                    // Later voor debug
                    System.out.print.ln(receivedString.length);
                    // Tijdelijk object
                    Trein t = new Trein("temp");
                    // Get Train Object by name
                    t = t.getTrein(receivedString[2]);
                    // Return Wagon object by name
                    Wagon w = t.getWagon(receivedString[3].substring(0, receivedString[3].length() - 1));

                    // Add this wagon to train
                    t.addWagon(w);
                } else if (receivedString[0].equals("delete")) {
                    if (receivedString[1].equals("train")) {
                        // Tijdelijk object
                        Trein t = new Trein("temp");
                        // Get Train Object by name
                        t = t.getTrein(receivedString[2]);
                        // Remove from list alletreinen
                        t.removeTrain(t.getTrnm());


                    } else if (receivedString[1].equals("wagon")) {
                        Trein t = new Trein("temp");
                        // Remove wagon by ID
                        t.removeWagon(receivedString[3]);

                    }
                } else if (receivedString[0].equals("remove")) {
                    DeleteWagonCommand CommandLine = new DeleteWagonCommand();
                    String wagonIDandTrainID = receivedString[1] + " "+ receivedString[3];
                    CommandLine.execute(wagonIDandTrainID);
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
