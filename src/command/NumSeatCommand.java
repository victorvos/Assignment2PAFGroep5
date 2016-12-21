package command;

import java.io.IOException;
import java.util.ArrayList;

import domain.Trein;
import domain.Wagon;
import gui.Log;
import interfaces.CommandExecute;

public class NumSeatCommand implements CommandExecute {

	Log l = new Log();

	@Override
	public void execute(String command) throws IOException {
		String type = command.split("\\s+")[1];
		String typeName = command.split("\\s+")[2];
		Object thisObj = null;

		if (typeName.equals("trein")){
			thisObj = (Trein)thisObj;
		}
		else if (typeName.equals("wagon")){
			thisObj = (Wagon)thisObj;
		}

		try {
			if (thisObj != null) {
				thisObj.getNumSeats();
			}
			else {
				l.makeLog("Error - getNumSeats Failed");
			}
		}
		catch (Exception exception){
			l.makeLog("Error - getNumSeats failed");
		}
	}

}
