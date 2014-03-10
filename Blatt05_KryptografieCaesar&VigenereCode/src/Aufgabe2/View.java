package Aufgabe2;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class View extends JPanel implements ActionListener, Observer {

	private static final long serialVersionUID = 1L;
	
	Model model;
	
	JButton nameButton = new JButton("name");
	
	JTextField nameText = new JTextField("",10);
	
	public View(Model model) {
		this.model = model;
		model.addObserver(this);
		setBackground(Color.lightGray);
		
		//Eingabefelder
		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 50));
		JLabel label1 = new JLabel("  Klartext");
		label1.setAlignmentY(TOP_ALIGNMENT);
		box.add(label1);
		box.add(Box.createVerticalStrut(5));
		nameText.setAlignmentX(LEFT_ALIGNMENT);
		box.add(nameText);
		
		//Buttons
				box.add(Box.createVerticalStrut(15));
				box.add(new JLabel("  nameButton"));
				nameButton.addActionListener(this);
				nameButton.setAlignmentX(LEFT_ALIGNMENT);
				box.add(nameButton);
				add(box);
				
				/*		//Ausgabefelde
				Box box2 = Box.createVerticalBox();
				box2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
				box2.add(new JLabel("  Ausgabe"));
				box2.add(Box.createVerticalStrut(5));
				output.setAlignmentX(LEFT_ALIGNMENT);
				output.setEditable(false);
				box2.add(output);
				add(box2);*/
	}
				@Override
				public void update(Observable o, Object arg) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
	}
}