package command;

/**
 * Created by bluedog on 12/21/2016.
 */

import domain.Trein;
import domain.Wagon;
import interfaces.CommandExecute;

import java.util.ArrayList;

public class GetNumSeatsTrainCommand implements CommandExecute {
    private ArrayList<String> words;
    private domain.Trein t;
    private String commandReturn = "Error - Unknown command. Please type !help for a list of commands.";

    @Override
    public void execute(String command) {
        String train;
        try {
            train = words.get(2);
        } catch (Exception e) {
            train ="";
        }
        if(train.equals("")) {
            commandReturn = "Please enter a train name";
        }
        boolean thisExists = false;
        for(domain.Trein t: t.trainList()) {
            if(t.getTrnm().equals(train)) {
                this.t=t;
                thisExists = true;
            }
        }
        if(!thisExists) {
            commandReturn = "train " + train + "doesn't exist";
        }
        commandReturn = "number of seats in train " + train + ": " + t.getNumSeats();
    }
    @Override
    public String output() {
        return commandReturn;
    }
}

