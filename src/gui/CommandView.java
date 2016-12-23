package gui;

import controller.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

/*import logic.Controller;*/

public class CommandView extends View implements ActionListener {
	Controller controller;
	JPanel executepanel;
	JTextArea txtarea;
	JTextField input;
	JButton execute;
	
	public CommandView() {
		executepanel = new JPanel();
		txtarea = new JTextArea();
		input = new JTextField(20);
		
		txtarea.setText("command");
		txtarea.setEditable(false);
		
		execute = new JButton("execute");
		execute.addActionListener(this);
		
		executepanel.add(txtarea);
		executepanel.add(input);
		executepanel.add(execute);
		executepanel.setSize(350,250);
		executepanel.setVisible(true);
		
		this.add(executepanel);
		this.setSize(350,250);

//		JRootPane rootPane = SwingUtilities.getRootPane(execute);
//		rootPane.setDefaultButton(execute);
	}
	
	public void setController(Controller controller)
	{
		this.controller = controller;
	}
	
	public void actionPerformed(ActionEvent e) {
		// en hier het gedeelte om via een command iets toe te voegen of te verwijderen etc.
		if(e.getSource() == execute)
		{
			if(controller != null)
			{
				try {
					controller.split(input.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(Controller controller) {
		//TODO
	}
}
