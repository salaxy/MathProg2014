import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class View extends JPanel implements ActionListener, Observer {

	private static final long serialVersionUID = 1L;

	private IsbnModel model;

	private JButton compute = new JButton("compute");

	private JTextField eingabeISBN = new JTextField("", 10);
	private JTextField ausgabeISBN = new JTextField("", 10);
	private JTextField ausgabeISBNGuelt = new JTextField("", 10);

	public View(IsbnModel model) {
		this.model = model;
		model.addObserver(this);
		setBackground(Color.green);

		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 50));

		// Eingabefesnster
		JLabel label1 = new JLabel("  Eingabe der ISBN");
		label1.setAlignmentY(TOP_ALIGNMENT);
		box.add(label1);
		box.add(Box.createVerticalStrut(5));
		eingabeISBN.setAlignmentX(LEFT_ALIGNMENT);
		box.add(eingabeISBN);

		// Button
		box.add(Box.createVerticalStrut(15));
		compute.addActionListener(this);
		compute.setAlignmentX(LEFT_ALIGNMENT);
		box.add(compute);
		add(box);

		// Ausgabefenster
		Box box2 = Box.createVerticalBox();
		box2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		box2.add(new JLabel("  Ausgabe"));
		box2.add(Box.createVerticalStrut(5));
		ausgabeISBN.setAlignmentX(LEFT_ALIGNMENT);
		ausgabeISBN.setEditable(false);
		box2.add(ausgabeISBN);
		add(box2);
		
		box2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		box2.add(new JLabel("  G�ltig?: "));
		box2.add(Box.createVerticalStrut(5));
		ausgabeISBNGuelt.setAlignmentX(LEFT_ALIGNMENT);
		ausgabeISBNGuelt.setEditable(false);
		box2.add(ausgabeISBNGuelt);
		add(box2);
	}

	private void readInput1() {
		try {
			this.model.setIsbn(this.eingabeISBN.getText());
			this.model.testISBN();
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Falsches Zahlenformat",
					"Eingabefehler", JOptionPane.ERROR_MESSAGE);
		} catch (ISBNException ee) {
			JOptionPane.showMessageDialog(this, ee.getMessage(),
					"Eingabefehler", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == compute)
			readInput1();
	}

	@Override
	public void update(Observable o, Object arg) {
		ausgabeISBN.setText(model.getAusgabe() + "");
		this.ausgabeISBNGuelt.setText(this.model.getGuelt() + "");
	}
}