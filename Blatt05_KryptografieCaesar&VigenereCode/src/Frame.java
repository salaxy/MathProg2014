import java.awt.event.*;

import javax.swing.*;

public class Frame extends JFrame {

//}
	
	private static final long serialVersionUID = 1L;

	public Frame(){
		super("Kryptografie Caesar & Vignere Code");
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		Model model = new Model();
		View view = new View(model);
		getContentPane().add(view);
		setSize(700,500);
		pack();
	}
	
	public static void main(String[] args)  {
		Frame ef = new Frame();
		ef.setVisible(true);
	}

}