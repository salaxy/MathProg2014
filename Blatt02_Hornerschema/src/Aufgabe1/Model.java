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
	public void createDualzahl() throws ZD1Exception {
		int basis = 2;
		int a = 0;
		int number = dezimalZahl;
		StringBuffer ergebnis = new StringBuffer("");
		if(dezimalZahl == 0) {
			throw new ZD1Exception("Es ist keine Werte eingetragen");
		}
		while (number != 0) {
			a = number % basis;
			number = number / basis;
			ergebnis.append(a);
		}
		setDualOut(ergebnis.reverse().toString());
		
		setChanged();
		notifyObservers();
	}
	

	// Umwandlung von dual zu dezimal
	public void createDezimalzahl() throws ZD1Exception {
		int ergebnis = 0;
		int basis = 2;
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
			ergebnis = ergebnis * basis + numbers[i];
		}	
		setDezimalOut(ergebnis);
		
		setChanged();
		notifyObservers();
	}
}
