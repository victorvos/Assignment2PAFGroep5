package command;

import domain.Trein;
import domain.Wagon;
import interfaces.CommandExecute;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by bluedog on 12/21/2016.
 */
public class DeleteTrainCommand implements CommandExecute {

    private ArrayList<String> input = new ArrayList<String>();
    private Trein t;
    private String commandReturn = "Error - Unknown command. Please type !help for a list of commands.";

    public void execute(String command) throws IOException {
        String wagonName = command.split("\\s+")[0];
        String trainName = command.split("\\s+")[1];

        boolean isDeleted = false;
        Trein t = new Trein("temp");
        t = t.getTrein(trainName);

        for(Trein thisTrein : t.alleTreinen) {
            if(thisTrein.getTrein(trainName).equals(trainName)) {
                thisTrein.removeTrain(trainName);
                commandReturn = "Train " +trainName+" removed";
                isDeleted = true;
                return;
            }
        }
        if(!isDeleted){
            commandReturn = "Train does not exist and could not be deleted!";
            return;
        }
    }



    public String output() {
        return commandReturn;
    }

}

