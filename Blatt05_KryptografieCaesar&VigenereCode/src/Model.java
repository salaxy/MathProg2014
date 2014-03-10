import java.util.Observable;

/**
 * Ver- und Entschl�sselung eines Textes mit der
 * CAESAR-Verschl�sselung
 * 
 * @author Alexandra M�ller
 * @author Sebastian R�der
 */

public class Model extends Observable {
		
	private String 	plainText;
	private String cipherText;
	private int key;
	
	
	public void setPlainText(String plainText) {
		this.plainText = new String(plainText);
	}

	public void setKey(char schluessel) {
		
		if((schluessel >= 65) && (schluessel <= 90)) {
			key = schluessel-65;
		}
		else if((schluessel >=97) && (schluessel <= 122)) {
			key = schluessel-97;
		}
		//TODO: Exception
	}
	
	public String getCipherText() {
		return cipherText;
	}
	
/*	public Model(String plainText, char key) {
		this.plainText = plainText;
		this.key = key;
	}*/

	public Model() {
		plainText = new String("");
		key = 0;
	}

	public  void cipherText() {
		cipherText = new String("");
	}
	
	//setChanged();
    //notifyObservers();
	
		//Normalisieren Sie den Klartext:
		//Sonderzeichen inkl. Leerzeichen entfernen
		//Alles in Kleinbuchstaben umwandeln
		//Umlaute und �ߓ umwandeln: �� wird �ae� usw.
	
		//Der Chiffretext erscheint in Gro�buchstaben.
	
		//Denken Sie an m�gliche Eingabefehler. An welcher Stelle sind diese �berhaupt nur m�glich?
	
		//Erweitern Sie Ihr Programm von Aufgabe 1, sodass die Chiffrierung/Dechiffrierung
		//nach dem Vigen�re-Code durchgef�hrt wird.
}
