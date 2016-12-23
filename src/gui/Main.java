package gui;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import domain.*;


public class Main {
	public static void main(String[] args) throws IOException {
		JFrame frame1 = new JFrame();
		frame1.setLayout(new GridLayout(2,1));
		frame1.setSize(1500, 1200);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel1.setLayout(new GridLayout(1,1));
		panel2.setLayout(new GridLayout(2,1));


		View v1 = new GraphicView();
		View v2 = new ConsoleView();
		View v3 = new LogView();
		CommandView v4 = new CommandView();

		Controller c = new Controller();
		v4.setController(c);
		
		panel1.add(v1);
		panel2.add(v2);
		panel2.add(v3);
		panel2.add(v4);
		frame1.add(panel1);
		frame1.add(panel2);
		
		c.addView(v1);
		c.addView(v2);
		c.addView(v3);
		c.addView(v4);


		Trein t = new Trein("HELLO WORLD");

		Wagon w = new Wagon("WAGON");


		t.addWagon(w);

		c.refreshData();


		c.split("new train tr1;");
	}
}