package gui;

import java.awt.GridLayout;

import java.util.ArrayList;

import javax.swing.JTextArea;

/*import logic.Controller;*/
import controller.Controller;
import domain.Trein;
import domain.Wagon;

public class ConsoleView extends View {
	ArrayList<Trein> trains;
	ArrayList<Wagon> wagons;
	JTextArea outputpanel;

	public ConsoleView() {
		trains = new ArrayList<Trein>();
		outputpanel = new JTextArea();

		this.setLayout(new GridLayout(1, 1));

		outputpanel.setSize(350, 250);
		outputpanel.setEditable(false);
		outputpanel.setVisible(true);

		this.add(outputpanel);

		this.setSize(350, 250);
		this.setVisible(true);
	}

	public void printText(ArrayList<Trein> trains, ArrayList<Wagon> wagons) {
		
		String wagonsOutput = "";
		String trainsOutput = "";
		outputpanel.setText("");
		
		for (Wagon w1 : wagons) {
			wagonsOutput = wagonsOutput + "(" + w1.getWgNaam() + ":"
			+ w1.getWgNaam() + ") ";
		}

		for (Trein t : trains) {
			trainsOutput = trainsOutput + "(" + t.getTrnm() + ")";
			for (Wagon w : t.getWagons()) {
				trainsOutput = trainsOutput + "-(" + w.getWgNaam() + ")";
			}
			trainsOutput = trainsOutput + "\n";
		}

		outputpanel.setText("--Wagons--\n" + wagonsOutput + "\n--Trains--\n"
				+ trainsOutput);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Controller controller) {

		this.trains = controller.getTrains();
		this.wagons = controller.getWagons();
		printText(trains, wagons);

	}
}