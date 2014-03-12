package Aufgabe1;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class View extends JPanel implements ActionListener, Observer {

	private static final long serialVersionUID = 1L;

	Model model;

	JButton compute = new JButton("computeDezi");
	JButton comp = new JButton("computeDual");

	JTextField dezimalZahl = new JTextField("", 10);
	JTextField dualZahl = new JTextField("", 10);
	JTextField ausgabeDezimal = new JTextField("", 10);
	JTextField ausgabeDual = new JTextField("", 10);

	public View(Model model) {
		this.model = model;
		model.addObserver(this);
		setBackground(Color.lightGray);

		// Eingabefelder
		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 50));
		JLabel label1 = new JLabel("  Dezimal-Zahl");
		label1.setAlignmentY(TOP_ALIGNMENT);
		box.add(label1);
		box.add(Box.createVerticalStrut(5));
		dezimalZahl.setAlignmentX(LEFT_ALIGNMENT);
		box.add(dezimalZahl);

		box.add(Box.createVerticalStrut(20));
		box.add(new JLabel("  Dual-Zahl"));
		box.add(Box.createVerticalStrut(5));
		dualZahl.setAlignmentX(LEFT_ALIGNMENT);
		box.add(dualZahl);

		// Button
		box.add(Box.createVerticalStrut(15));
		compute.addActionListener(this);
		compute.setAlignmentX(LEFT_ALIGNMENT);
		box.add(compute);
		add(box);

		box.add(Box.createVerticalStrut(15));
		comp.addActionListener(this);
		comp.setAlignmentX(LEFT_ALIGNMENT);
		box.add(comp);
		add(box);

		// Ausgabefelder
		Box box2 = Box.createVerticalBox();
		box2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		box2.add(new JLabel("  ausgabeDezimal"));
		box2.add(Box.createVerticalStrut(5));
		ausgabeDezimal.setAlignmentX(LEFT_ALIGNMENT);
		ausgabeDezimal.setEditable(false);
		box2.add(ausgabeDezimal);
		add(box2);

		box2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		box2.add(new JLabel("  ausgabeDual"));
		box2.add(Box.createVerticalStrut(5));
		ausgabeDual.setAlignmentX(LEFT_ALIGNMENT);
		ausgabeDual.setEditable(false);
		box2.add(ausgabeDual);
		add(box2);
	}

	private void readInput() {
		try {
			model.setDualZahl(String.valueOf(dualZahl.getText()));
			model.createDezimalzahl();
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Falsches Zahlenformat",
					"Eingabefehler", JOptionPane.ERROR_MESSAGE);
		} catch (ZD1Exception zde) {
			JOptionPane.showMessageDialog(this, zde.getMessage(),
					"Eingabefehler", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void readInput2() {
		try {
			model.setDezimalZahl(Integer.valueOf(dezimalZahl.getText()));
			model.createDualzahl();
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Falsches Zahlenformat",
					"Eingabefehler", JOptionPane.ERROR_MESSAGE);
		} catch (Exception zde) {
			JOptionPane.showMessageDialog(this, zde.getMessage(),
					"Eingabefehler", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == compute)
			readInput();
		if (e.getSource() == comp)
			readInput2();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ausgabeDezimal.setText(model.getDezimalOut() + "");
		ausgabeDual.setText(model.getDualOut() + "");
	}
}