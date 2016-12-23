package controller;

// GUI
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import domain.Wagon;
import domain.Trein;


import command.CommandLine;
import command.NewTrainCommand;
import command.DeleteWagonCommand;
import command.GetNumSeatsTrainCommand;
import command.GetNumSeatsWagonCommand;

import gui.View;
import gui.Observer;


public class Controller implements Observer {
    private ArrayList<View> views;
    private ArrayList<Trein> trains = new ArrayList<Trein>();
    private ArrayList<Wagon> wagons = new ArrayList<Wagon>();
    private ArrayList<CommandLine> CommandLine;
    private ArrayList<String> logcommands;

    public void addLogcommand(String logcommand) {
        logcommands.add(logcommand);
    }

    public void removeLogcommand(String logcommand) {
        if (logcommands.contains(logcommand)) {
            logcommands.remove(logcommand);
        }
    }

    public void addView(View view) {
        views.add(view);
    }

    public ArrayList<View> getViews() {
        return views;
    }

    public void split(String commandString) throws IOException {

        String[] receivedString = commandString.split(" ");
        if (receivedString[0].equals("new") || receivedString[0].equals("add") || receivedString[0].equals("remove")
                || receivedString[0].equals("delete") || receivedString[0].equals("getnumseats")) {
            if (commandString.substring(commandString.length() - 1).equals(";")) {
                if (receivedString[0].equals("new")) {
                    if (receivedString[1].equals("train")) {
                        Trein c = new Trein(receivedString[2].substring(0, receivedString[2].length() - 1));
                    }
                    else if (receivedString[1].equals("wagon")) {
                        Wagon w = new Wagon(receivedString[2].substring(0, receivedString[2].length() - 1));
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
                    System.out.println(receivedString.length);
                    // Tijdelijk object
                    Trein t = new Trein("temp");
                    // Get Train Object by name
                    t = t.getTrein(receivedString[3].substring(0, receivedString[3].length() - 1));
                    // Return Wagon object by name
                    Wagon w = t.getWagon(receivedString[1]);

                    // Add this wagon to train
                    t.addWagon(w);
                } else if (receivedString[0].equals("delete")) {
                    if (receivedString[1].equals("train")) {
                        // Tijdelijk object
                        Trein t = new Trein("temp");
                        // Get Train Object by name
                        t = t.getTrein(receivedString[1]);
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
