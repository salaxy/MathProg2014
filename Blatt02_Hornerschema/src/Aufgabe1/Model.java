package Aufgabe1;
import java.util.Observable;
import java.lang.Integer;


public class Model extends Observable {

	public static final int MAX_VALUE = 2147483647;
	
	private int dezimalZahl;
	private String dualZahl;
	private int dezimalOut;
	private String dualOut;

	
	//Setter und Getter
	public void setDezimalZahl(int dezimal) {
		this.dezimalZahl = dezimal;
	}

	public void setDualZahl(String dual) {
		this.dualZahl = dual;
	}

	public void setDezimalOut(int dezimal) {
		this.dezimalOut = dezimal;
	}
	
	public int getDezimalOut() {
		return dezimalOut;
	}
	
	public void setDualOut(String dual) {
		this.dualOut = new String(dual);
	}
	
	public String getDualOut() {
		return dualOut;
	}

	//
	public Model(int dezimal) {
		super();
		this.dezimalZahl = dezimal;
	}
	
	public Model(String dual) {
		super();
		this.dualZahl = new String(dual);
	}

	public Model() {
		super();
		dezimalZahl = 0;
		dualZahl = new String();
	}
	
	
	// Umwandlung von dezimal zu dual
	public void createDualzahl() {
		int basis = 2;
		int a = 0;
		int number = dezimalZahl;
		StringBuffer ergebnis = new StringBuffer("");
		while (number != 0) {
			a = number % basis;
			number = number / basis;
			ergebnis.append(a);
		}
		setDualOut(ergebnis.reverse().toString());
	}
	

	// Umwandlung von dual zu dezimal
	
	public void createDezimalzahl() {
		int ergebnis = 0;
		int basis = 2;
		char[] chars = dualZahl.toCharArray();
		int[] numbers = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
		}
	//Berechnung
		ergebnis = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			ergebnis = ergebnis * basis + numbers[i];
		}	
		setDezimalOut(ergebnis);
	}
	
/*	public int createDezimalzahl() throws ZD1Exception {
		int ergebnis = 0;
		int basis = 2;
		char[] chars = dualZahl.toCharArray();
		int[] numbers = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
		}
		
	// Berechnung
	//1021(3) --> 34(10)
	// x = (( 1 * 3 + 0 ) * 3 + 2 ) * 3 + 1
		ergebnis = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			ergebnis = ergebnis * basis + numbers[i];
		}	
		setDezimalOut(ergebnis);
		return ergebnis;
	}*/
	
	public void createOutput() {
		if (dezimalZahl == 0) {
			createDualzahl();
		} else if (dualZahl.length() == 0) {
			createDezimalzahl();
		}
	}
	
/*	public void createOutput() throws ZD1Exception {
		if (dezimalZahl == 0) {
			createDualzahl();
		} else if (dualZahl.length() == 0) {
			createDezimalzahl();
		} else {
			throw new ZD1Exception("Es sind keine Werte eingetragen");
		}
		setChanged();
		notifyObservers();
	}*/
}
