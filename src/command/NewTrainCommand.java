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
	@Override
	public void execute(String command) throws IOException {
		String trainName = command.split("\\s+")[3];
		ArrayList<Trein> trainList = t.trainList();
		//Checkt of er al een trein bestaat met dezelfde naam
		for (Trein t : trainList){
			if (!t.getTrnm().equals(trainName)){
				Trein train = new Trein(trainName);
				l.makeLog("Train with name:"+trainName+" created");
			}
		}
	}
}
