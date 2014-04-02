

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor der klasse
	 */
	public MainFrame(){
		super("Mathematische Programmierung WS 2010/11");
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		MainView view = new MainView();
		getContentPane().add(view);
		setSize(786,506);
		
		pack();
	}
	
	/**
	 * programmstart methode
	 * @param args
	 */
	public static void main(String[] args)  {
		MainFrame zf = new MainFrame();
		zf.setVisible(true);
		zf.setResizable(false);
	}
	

}
