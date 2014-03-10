package Aufgabe2;

import java.util.Observable;

public class Model extends Observable {

	private String plainText;
	private int key;
	
	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public Model(String plainText, int key) {
		super();
		this.plainText = plainText;
		this.key = key;
	}
	
	public Model() {
		super();
		plainText = new String("");
		key = 0;
	}
	
	public void doSTH() {
		setChanged();
		notifyObservers();
	}
	
	
			//Normalisieren Sie den Klartext:
			//Sonderzeichen inkl. Leerzeichen entfernen
			//Alles in Kleinbuchstaben umwandeln
			//Umlaute und „ß“ umwandeln: „ä“ wird „ae“ usw.
		
			//Der Chiffretext erscheint in Großbuchstaben.
		
			//Denken Sie an mögliche Eingabefehler. An welcher Stelle sind diese überhaupt nur möglich?
		
			//Erweitern Sie Ihr Programm von Aufgabe 1, sodass die Chiffrierung/Dechiffrierung
			//nach dem Vigenère-Code durchgeführt wird.
	
	
}
