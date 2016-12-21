package command;

import java.io.IOException;
import java.util.ArrayList;

import domain.Trein;
import domain.Wagon;
import gui.Log;
import interfaces.CommandExecute;

public class NewWagonCommand implements CommandExecute {
    private String commandReturn = "Error - Unknown command. Please type !help for a list of commands.";
    Wagon w;
    Log l;
    Trein t;
	@Override
	public void execute(String command) throws IOException {
		String wagonName = command.split("\\s+")[2];
		ArrayList<Wagon> wagonList = t.wagonList();
		for (Wagon w : wagonList){
			if (!w.getWgNaam().equals(wagonName)){
				Wagon wagon = new Wagon(wagonName);
				l.makeLog("Wagon with name:"+wagonName+" created");
				commandReturn = "Wagon with name "+wagonName+" created";
				wagonList.add(wagon);
			}
			else{
				commandReturn = "Invalid Command";
			}
		}
		
	}

	@Override
	public String output() {
        return commandReturn;
    }


}
