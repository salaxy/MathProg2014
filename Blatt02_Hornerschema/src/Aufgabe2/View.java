package Aufgabe2;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class View extends JPanel implements ActionListener, Observer {
	
	private static final long serialVersionUID = 1L;
	
	Model model;
	
	JButton compute = new JButton("compute");

	JTextField a = new JTextField("",10);
	JTextField n = new JTextField("",5);
	JTextField m = new JTextField("",5);
	JTextField ergebnis = new JTextField("",10);
	
	public View(Model model)  {
		this.model = model;
		model.addObserver(this);
		setBackground(Color.lightGray);
	
				
		//Eingabefelder
				Box box = Box.createVerticalBox();
				box.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 50));
				JLabel label1 = new JLabel("  a");
				label1.setAlignmentY(TOP_ALIGNMENT);
				box.add(label1);
				box.add(Box.createVerticalStrut(5));
				a.setAlignmentX(LEFT_ALIGNMENT);
				box.add(a);
				
				box.add(Box.createVerticalStrut(20));
				box.add(new JLabel("  n"));
				box.add(Box.createVerticalStrut(5));
				n.setAlignmentX(LEFT_ALIGNMENT);
				box.add(n);
				
				box.add(Box.createVerticalStrut(20));
				box.add(new JLabel("  m"));
				box.add(Box.createVerticalStrut(5));
				m.setAlignmentX(LEFT_ALIGNMENT);
				box.add(m);
		
		// Button
				box.add(Box.createVerticalStrut(15));
				compute.addActionListener(this);
				compute.setAlignmentX(LEFT_ALIGNMENT);
				box.add(compute);
				add(box);		
				
		//Ausgabefelder
				Box box2 = Box.createVerticalBox();
				box2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
				box2.add(new JLabel("  ergebnis"));		
				box2.add(Box.createVerticalStrut(5));
				ergebnis.setAlignmentX(LEFT_ALIGNMENT);
				ergebnis.setEditable(false);
				box2.add(ergebnis);
				add(box2);		
			}
	
	private void readInput() {
		model.setA(Integer.valueOf(a.getText()));
		model.setN(Integer.valueOf(n.getText()));
		model.setM(Integer.valueOf(m.getText()));
		model.formel();
		model.getErgebnis();
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == compute) readInput();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ergebnis.setText(model.getErgebnis()+"");
	}
}
