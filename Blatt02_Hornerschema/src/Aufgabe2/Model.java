package Aufgabe2;
import java.util.Observable;
import java.lang.Integer;

import Aufgabe1.ZD1Exception;

public class Model extends Observable{

	public static final int MAX_VALUE = 2147483647;
	
	private String eingabe;
	private int basis1;
	private int basis2;
	private String ausgabe;
	private String dualZahl;
	
	
	//Getter und Setter
	public void setEingabe(String eingabe) {
		this.eingabe = new String (eingabe);
	}
	
	public void setBasis1(int basis) {
		this.basis1 = basis;
	}
	
	public void setBasis2(int basis) {
		this.basis2 = basis;
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
	
	// Umwandlung von dual
		public void createDezimalzahl() throws ZD1Exception {
			int ergebnis = 0;
			if(dualZahl.length() == 0) {
				throw new ZD1Exception("Es ist kein Wert eingetragen");
			}
			char[] chars = dualZahl.toCharArray();
			int[] numbers = new int[chars.length];
			for (int i = 0; i < chars.length; i++) {
				numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
			}
			for(int i = 0; i < chars.length; i++) {
				if((numbers[i] != 0) && (numbers[i] != 1)) {
					throw new ZD1Exception("Dies ist keine Dual-Zahl!");
				}
			}
		//Berechnung
			ergebnis = numbers[0];
			for (int i = 1; i < numbers.length; i++) {
				ergebnis = ergebnis * basis2 + numbers[i];
			}	
			setAusgabe(String.valueOf(ergebnis));
			
			setChanged();
			notifyObservers();
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