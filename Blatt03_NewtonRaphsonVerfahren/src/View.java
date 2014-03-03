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
	JTextField n = new JTextField("",10);
	JTextField d = new JTextField("",10);
	JTextField ausgabe = new JTextField("",5);
	
	
	public View(Model model)  {
		this.model = model;
		model.addObserver(this);
		setBackground(Color.gray);
		
		
		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 50));
		
		JLabel label1 = new JLabel("  nicht negative Zahl a");
		label1.setAlignmentY(TOP_ALIGNMENT);
		box.add(label1);
		box.add(Box.createVerticalStrut(5));
		a.setAlignmentX(LEFT_ALIGNMENT);
		box.add(a);
		
		box.add(Box.createVerticalStrut(20));
		box.add(new JLabel("  positive Zahl n"));
		box.add(Box.createVerticalStrut(5));
		n.setAlignmentX(LEFT_ALIGNMENT);
		box.add(n);
		
		box.add(Box.createVerticalStrut(20));
		box.add(new JLabel("  Genauigkeit d"));
		box.add(Box.createVerticalStrut(5));
		d.setAlignmentX(LEFT_ALIGNMENT);
		box.add(d);
		
		box.add(Box.createVerticalStrut(15));
		compute.addActionListener(this);
		compute.setAlignmentX(LEFT_ALIGNMENT);
		box.add(compute);
		add(box);		
		
		Box box2 = Box.createVerticalBox();
		box2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		box2.add(new JLabel("  ausgabe"));		
		box2.add(Box.createVerticalStrut(5));
		ausgabe.setAlignmentX(LEFT_ALIGNMENT);
		ausgabe.setEditable(false);
		box2.add(ausgabe);
		add(box2);		

	}

/*	private void readInput(){
		try {
			model.setA(Integer.valueOf(a.getText()));
			model.setN(Integer.valueOf(n.getText()));
			model.setD(Integer.valueOf(d.getText()));
			model.ausgabe();
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this,
					"Falsches Zahlenformat","Eingabefehler",JOptionPane.ERROR_MESSAGE);
		} 		
	}*/

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}