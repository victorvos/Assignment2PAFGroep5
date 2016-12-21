package command;

/**
 * Created by bluedog on 12/21/2016.
 */

import domain.Trein;
import domain.Wagon;
import interfaces.CommandExecute;

import java.io.IOException;
import java.util.ArrayList;

public class GetNumSeatsWagonCommand implements CommandExecute{
    private ArrayList<String> words;
    private Wagon w;
    private Trein t;
    private String commandReturn = "Error - Unknown command. Please type !help for a list of commands.";

    @Override
    public void execute(String command) {
        String wagonname;
        try {
            wagonname = words.get(2);
        } catch (Exception e){
            wagonname = "";
        }
        if(wagonname.equals("")) {
            commandReturn = "Please enter a wagon name.";
            return;
        }
        boolean thisExists = false;
        for(Wagon g: t.wagonList() ) {
            if(wagonname.equals(g.getWgNaam())) {
                thisExists=true;
                w = g;
            }
        }
        if(!thisExists) {
            commandReturn = "Wagon " + wagonname + " doesn't exist";
            return;
        }
        commandReturn = "number of seats in wagons " + w.getWgNaam() + ": " + w.getNumSeats();
    }
}

