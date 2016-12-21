package command;

import java.io.IOException;
import java.util.ArrayList;

import domain.Trein;
import gui.Log;
import interfaces.CommandExecute;

public class NewTrainCommand implements CommandExecute {
//Voert command uit en zet de trein in een lijst met alle treinen.
	Log l = new Log();
	Trein t;
	private String commandReturn = "Error - Unknown command. Please type !help for a list of commands.";
	@Override
	public void execute(String command) throws IOException {
		String trainName = command.split("\\s+")[3];
		ArrayList<Trein> trainList = t.trainList();
		//Checkt of er al een trein bestaat met dezelfde naam
		for (Trein t : trainList){
			if (!t.getTrnm().equals(trainName)){
				Trein train = new Trein(trainName);
				commandReturn = "Train with name:"+trainName+" created";
				l.makeLog("Train with name:"+trainName+" created");
			}
			else{
				l.makeLog("Trein bestaat al");
				commandReturn = "Trein bestaat al";
			}
		}
	}

	@Override
	public String output() {
		return commandReturn;
	}
}
