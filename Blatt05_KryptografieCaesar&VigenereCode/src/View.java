import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.KeyException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class View extends JPanel implements ActionListener, Observer {

	private static final long serialVersionUID = 1L;

	private CaesarModel caesar;
	private VigenereModel vigenere;

	JButton encipher = new JButton("encipher");
	JButton decipher = new JButton("decipher");
	JButton clear = new JButton("clear");
	JButton laden = new JButton("Aus Datei Laden");
	// @ Alex todo einbinden
	JButton analyseButton = new JButton("Automatisches Entschlüsseln");

	JTextField text = new JTextField("", 10);
	JTextField key = new JTextField("", 10);
	JTextField cipherText = new JTextField("", 10);

	public View(CaesarModel caesar, VigenereModel vigenere) {

		setLayout(null);
		this.vigenere = vigenere;
		this.caesar = caesar;

		vigenere.addObserver(this);
		caesar.addObserver(this);
		setBackground(Color.magenta);

		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 50));
		JLabel label1 = new JLabel("  Klartext");
		label1.setAlignmentY(TOP_ALIGNMENT);
		box.add(label1);
		box.add(Box.createVerticalStrut(5));
		text.setAlignmentX(LEFT_ALIGNMENT);
		box.add(text);

		box.add(Box.createVerticalStrut(20));
		box.add(new JLabel("  Schluessel"));
		box.add(Box.createVerticalStrut(5));
		key.setAlignmentX(LEFT_ALIGNMENT);
		box.add(key);

		box.add(Box.createVerticalStrut(15));
		box.add(new JLabel("  Chiffretext"));
		cipherText.addActionListener(this);
		cipherText.setAlignmentX(LEFT_ALIGNMENT);
		box.add(cipherText);
		add(box);

		/*
		 * Box box2 = Box.createVerticalBox();
		 * box2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		 * box2.add(new JLabel("  Chiffretext"));
		 * box2.add(Box.createVerticalStrut(5));
		 * cipherText.setAlignmentX(LEFT_ALIGNMENT);
		 * cipherText.setEditable(false); box2.add(cipherText); add(box2);
		 */
		
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
	}

	@Override
	public void update(Observable o, Object arg) {
//		 TODO Alex: Unterscheidung zwischen ent und verschlüsseln
//		 if(arg0 instanceof CaesarModel){
//		 if(cipherIsOn){
//		 outArea.setText(caesar.getGeheimtext().toUpperCase());
//		 }else{
//		 outArea.setText(caesar.getKlartext());
//		 }
//		 }
//		
//		 if(arg0 instanceof VigenereModel){
//		 if(cipherIsOn){
//		 outArea.setText(vigenere.getGeheimtext().toUpperCase());
//		 }else{
//		 outArea.setText(vigenere.getKlartext());
//		 }
//		 }

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Verschlüsseln
		if (e.getSource() == encipher) {
			this.doCeasar(true);
			// this.doVigenere(true);
			// TODO Alex: unterscheidung zwischen Caesar und Vigenere
		}

		// Entschlüsseln
		if (e.getSource() == decipher) {
			this.doCeasar(false);
			// TODO Alex: unterscheidung zwischen Caesar und Vigenere
			// this.doVigenere(false);
		}

		if (e.getSource() == clear) {
			text.setText("");
		}

		if (e.getSource() == analyseButton) {
			// cipherIsOn=false;
			caesar.setSecretText(FileWork.filterString(text.getText()));
			caesar.autoDecode();
		}

		// laden des Eingabefeldes von Datei
		if (e.getSource() == laden) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Text-files", "txt");
			chooser.setFileFilter(filter);
			chooser.setAcceptAllFileFilterUsed(false);
			chooser.setDialogTitle("Load file to input");
			chooser.showOpenDialog(this);
			// nur wenn Datei auch auswegwählt wurde
			// falls dialog abbgebrochen wird
			if (chooser.getSelectedFile() != null) {
				String datname = chooser.getSelectedFile().getPath();
				String in;

				try {
					in = FileWork.loadStringFromFile(datname);
					text.setText(in);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(this,
							"Fehler beim Laden der Datei", "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

	private void doCeasar(boolean cipherIsOn) {
		try {
			if (key.getText().length() > 1) {
				throw new KeyException("Schlüssel ist zu lang!!");
			}
			caesar.setKey(key.getText().charAt(0));

			if (cipherIsOn) {
				caesar.setPlainText(FileWork.filterString(text.getText()));
				caesar.decode();
			} else {
				caesar.setSecretText(FileWork.filterString(text.getText()));
				caesar.encode();
			}
		} catch (StringIndexOutOfBoundsException se) {
			JOptionPane.showMessageDialog(this, "Kein Schlüssel eingegeben!",
					"Fehler", JOptionPane.ERROR_MESSAGE);
		} catch (Exception ke) {
			JOptionPane.showMessageDialog(this, ke.getMessage(), "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void doVigenere(boolean cipherIsOn) {
		try {

			vigenere.setKey(key.getText());

			if (cipherIsOn) {
				vigenere.setPlainText(FileWork.filterString(text.getText()));
				vigenere.decode();
			} else {
				vigenere.setSecretText(FileWork.filterString(text.getText()));
				vigenere.encode();
			}

		} catch (StringIndexOutOfBoundsException se) {
			JOptionPane.showMessageDialog(this,
					"Sie haben kein Schlüssel eingegeben!!", "Eingabefehler",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception ke) {
			JOptionPane.showMessageDialog(this, ke.getMessage(),
					"Eingabefehler", JOptionPane.ERROR_MESSAGE);
		}
	}
}