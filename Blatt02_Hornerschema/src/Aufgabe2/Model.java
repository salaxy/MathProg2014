package Aufgabe2;
import java.util.Observable;
import java.lang.Integer;

public class Model extends Observable{

	public static final int MAX_VALUE = 2147483647;
	
	private String eingabe;
	private String dualZahl;
	private int basis1;
	private int basis2;
	private String ausgabe;
	
	
	public void setEingabe(String eingabe) {
		this.eingabe = new String (eingabe);
	}
	
	public void setDualzahl(String dualZahl) {
		this.dualZahl = new String(dualZahl);
	}
	
	public void setAusgabe(String ausgabe) {
		this.ausgabe = new String(ausgabe);
	}
	
	public String getAusgabe() {
		return ausgabe;
	}
	
	
	//Umwandlung zu dual
	public void createAusgabe() {
		int a = 0;
		int number = Integer.parseInt(eingabe);
		StringBuffer ergebnis = new StringBuffer("");
		if(number == 0) {
			//TODO: Exception
		}
		while (number != 0) {
			a = number % basis2;
			number = number / basis2;
			ergebnis.append(a);
		}
		setAusgabe(ergebnis.reverse().toString());
	}
}