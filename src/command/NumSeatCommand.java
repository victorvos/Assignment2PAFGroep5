package command;

import java.io.IOException;
import java.util.ArrayList;

import domain.Trein;
import interfaces.CommandExecute;

public class NumSeatCommand implements CommandExecute {
//Returns the number of seats in a train
	@Override
	public void execute(String command) throws IOException {
		String type = command.split("\\s+")[2];	
		String typeName = command.split("\\s+")[3];	
		if(type.equals("train")){
			
		}
		else if(type.equals("wagon")){
			
		}

	}

}
