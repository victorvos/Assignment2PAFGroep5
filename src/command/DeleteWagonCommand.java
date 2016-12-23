package command;

import domain.Trein;
import domain.Wagon;
import interfaces.CommandExecute;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by bluedog on 12/21/2016.
 */
public class DeleteWagonCommand implements CommandExecute {

    private ArrayList<String> input = new ArrayList<String>();
    private Trein t;
    private String commandReturn = "Error - Unknown command. Please type !help for a list of commands.";

    public void execute(String command, String command2) throws IOException {
        boolean b = false;
        Trein t = new Trein("temp");
        for(Wagon w	: t.getWagons()) {
            if(w.getWgNaam().equals(s)) {
                t.removeWagon(w.getWgNaam());
                commandReturn = "Wagon " +w.getWgNaam()+" removed";
                b = true;
                return;
            }
        }
        if(!b){
            commandReturn = "Wagon does not exist";
            return;
        }
    }



    public String output() {
        return commandReturn;
    }

}

