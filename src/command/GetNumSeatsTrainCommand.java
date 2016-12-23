package command;

/**
 * Created by bluedog on 12/21/2016.
 */

import domain.Trein;
import gui.Log;
import interfaces.CommandExecute;

import java.io.IOException;
import java.util.ArrayList;

public class GetNumSeatsTrainCommand implements CommandExecute {
    private Log l;
    private Trein t;
    private String commandReturn = "Error - Unknown command. Please type !help for a list of commands.";

    @Override
    public void execute(String command) throws IOException {
		String trainName = command;
		ArrayList<Trein> trainList = t.trainList();
		boolean trainExists = false;
		for (Trein t : trainList) {
			if (t.getTrnm().equals(trainName)) {
				trainExists = true;
			}
		}
		if (!trainExists) {
			commandReturn = "No train found named " + trainName;
		} else if (trainExists) {
			int numseats = t.getNumSeats();
			l.makeLog("Train named " + trainName + " has " + numseats + " seats.");
			commandReturn = "Train named " + trainName + " has " + numseats + " seats.";
		}
	}
    
    
    @Override
    public String output() {
        return commandReturn;
    }
}

