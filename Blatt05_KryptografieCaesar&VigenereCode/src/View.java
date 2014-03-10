import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class View extends JPanel implements ActionListener, Observer {

	private static final long serialVersionUID = 1L;
	
	Model model;
	
	JButton encipher = new JButton("encipher");
	JButton decipher = new JButton("decipher");
	JButton clear = new JButton("clear");
	JButton laden = new JButton("Aus Datei Laden");

	JTextField plainText = new JTextField("",10);
	JTextField key = new JTextField("",10);
	JTextField cipherText = new JTextField("",10);
	JTextField output = new JTextField("",5);
	
	
	public View(Model model)  {
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
		plainText.setAlignmentX(LEFT_ALIGNMENT);
		box.add(plainText);
		
		box.add(Box.createVerticalStrut(20));
		box.add(new JLabel("  Schluessel"));
		box.add(Box.createVerticalStrut(5));
		key.setAlignmentX(LEFT_ALIGNMENT);
		box.add(key);
		
		//Buttons
		box.add(Box.createVerticalStrut(15));
		box.add(new JLabel("  Chiffretext"));
		cipherText.addActionListener(this);
		cipherText.setAlignmentX(LEFT_ALIGNMENT);
		box.add(cipherText);
		add(box);
			
		box.add(Box.createVerticalStrut(15));
		encipher.addActionListener(this);
		encipher.setAlignmentX(LEFT_ALIGNMENT);
		box.add(encipher);
		add(box);
		
		box.add(Box.createVerticalStrut(15));
		decipher.addActionListener(this);
		decipher.setAlignmentX(LEFT_ALIGNMENT);
		box.add(decipher);
		add(box);
		
		box.add(Box.createVerticalStrut(15));
		clear.addActionListener(this);
		clear.setAlignmentX(LEFT_ALIGNMENT);
		box.add(clear);
		add(box);		

		box.add(Box.createVerticalStrut(15));
		laden.addActionListener(this);
		laden.setAlignmentX(LEFT_ALIGNMENT);
		box.add(laden);
		add(box);
		
		//Ausgabefelde
		Box box2 = Box.createVerticalBox();
		box2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		box2.add(new JLabel("  AusgabeKlarText"));
		box2.add(Box.createVerticalStrut(5));
		output.setAlignmentX(LEFT_ALIGNMENT);
		output.setEditable(false);
		box2.add(output);
		add(box2);
	}


/*	private void readInput(){
		try {
			model.setA(Integer.valueOf(a.getText()));
			model.setB(Integer.valueOf(b.getText()));
			model.ggt();
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