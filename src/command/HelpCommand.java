package command;

import interfaces.CommandExecute;

import java.io.IOException;

/**
 * Created by bluedog on 12/21/2016.
 */
public class HelpCommand implements CommandExecute {
    @Override
    public void execute(String command) throws IOException {

    }

    @Override
    public String output() {
        return "new train <id> (creating trains)\nnew wagon <id> (creating wagons with default seats)\nnew wagon <id> numseats <int>(creating wagons with variable numseats)\nadd <wagon id> to <train id>(adding a wagon to a train)\ngetnumseats train <id> (getseats of the whole train)\ngetnumseats wagon <id> (get seats of wagon)\ndelete train <id> (delete a train from the system)\nremove <wagon id> from <train id>(remove a wagon from a train)\ndelete wagon <id>(delete a wagon from the system)";
    }
}
