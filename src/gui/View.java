package gui;


import javax.swing.*;

import controller.Controller;

public abstract class View extends JPanel {
	public View()
	{
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public abstract void update(Controller controller);
}
