package command;

/**
 * Created by bluedog on 12/21/2016.
 */

import domain.Trein;
import domain.Wagon;
import gui.Log;
import interfaces.CommandExecute;

import java.io.IOException;
import java.util.ArrayList;

public class GetNumSeatsWagonCommand implements CommandExecute {
	private Wagon w;
	private Trein t;
	private Log l;
	private String commandReturn = "Error - Unknown command. Please type !help for a list of commands.";

	@Override
	public void execute(String command) throws IOException {
		String wagonName = command;
		ArrayList<Wagon> wagonList = t.wagonList();
		boolean wagonExists = false;
		for (Wagon w : wagonList) {
			if (w.getWgNaam().equals(wagonName)) {
				wagonExists = true;
			}
		}
		if (!wagonExists) {
			commandReturn = "No wagon found named " + wagonName;
		} else if (wagonExists) {
			int numseats = w.getNumSeats();
			l.makeLog("Wagon named " + wagonName + " has " + numseats + " seats.");
			commandReturn = "Wagon named " + wagonName + " has " + numseats + " seats.";
		}
	}

	@Override
	public String output() {
		return commandReturn;
	}

}
