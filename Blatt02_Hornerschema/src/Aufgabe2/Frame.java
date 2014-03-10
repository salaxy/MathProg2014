package Aufgabe2;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Alexandra M�ller
 * @author Sebastian R�der
 * 
 * Aufgabenblatt 02 Zahlendarstellung
 */


public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	public Frame(){
		super("Hornerschema");
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		Model model = new Model();
		View view = new View(model);
		getContentPane().add(view);
		setSize(500,200);
		pack();
	}
	
	public static void main(String[] args)  {
		Frame ef = new Frame();
		ef.setVisible(true);
	}
}
