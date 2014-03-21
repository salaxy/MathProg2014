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

	JTextField eingabeZahl = new JTextField("",10);
	JTextField eingabeBasisVon = new JTextField("",5);
	JTextField eingabeBasisZu = new JTextField("",5);
	JTextField ausgabeZahl = new JTextField("",10);
	
	public View(Model model)  {
		this.model = model;
		model.addObserver(this);
		setBackground(Color.lightGray);
		
		//Eingabefelder
		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 50));
		JLabel label1 = new JLabel("  eingabeZahl");
		label1.setAlignmentY(TOP_ALIGNMENT);
		box.add(label1);
		box.add(Box.createVerticalStrut(5));
		eingabeZahl.setAlignmentX(LEFT_ALIGNMENT);
		box.add(eingabeZahl);
		
		box.add(Box.createVerticalStrut(20));
		box.add(new JLabel("  eingabeBasisVon"));
		box.add(Box.createVerticalStrut(5));
		eingabeBasisVon.setAlignmentX(LEFT_ALIGNMENT);
		box.add(eingabeBasisVon);
		
		box.add(Box.createVerticalStrut(20));
		box.add(new JLabel("  eingabeBasisZu"));
		box.add(Box.createVerticalStrut(5));
		eingabeBasisZu.setAlignmentX(LEFT_ALIGNMENT);
		box.add(eingabeBasisZu);
		
		// Button
		box.add(Box.createVerticalStrut(15));
		compute.addActionListener(this);
		compute.setAlignmentX(LEFT_ALIGNMENT);
		box.add(compute);
		add(box);		
		
		//Ausgabefelder
		Box box2 = Box.createVerticalBox();
		box2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		box2.add(new JLabel("  ausgabeZahl"));		
		box2.add(Box.createVerticalStrut(5));
		ausgabeZahl.setAlignmentX(LEFT_ALIGNMENT);
		ausgabeZahl.setEditable(false);
		box2.add(ausgabeZahl);
		add(box2);		
	}
	
	private void readInput() {
		model.setEingabe(eingabeZahl.getText());
		try {
			model.setBasis1(Integer.valueOf(eingabeBasisVon.getText()));
			model.setBasis2(Integer.valueOf(eingabeBasisZu.getText()));
			model.createZahl();
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this,
					"Falsches Zahlenformat","Eingabefehler",JOptionPane.ERROR_MESSAGE);
		} catch (ZD2Exception zd2) {
			JOptionPane.showMessageDialog(this, zd2.getMessage(),
					"Eingabefehler", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == compute) readInput();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ausgabeZahl.setText(model.getAusgabe()+"");
	}
}