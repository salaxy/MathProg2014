import java.awt.event.*;

import javax.swing.*;

public class Frame extends JFrame {


	private static final long serialVersionUID = 1L;

	public Frame() {
		super("Kryptografie Caesar & Vignere Code");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		CaesarModel caesarModel = new CaesarModel();
		VigenereModel vigenereModel = new VigenereModel();
		View view = new View(caesarModel, vigenereModel);
		getContentPane().add(view);
		setSize(500, 200);
		pack();
	}

	public static void main(String[] args) {
		Frame ef = new Frame();
		ef.setVisible(true);
	}

}