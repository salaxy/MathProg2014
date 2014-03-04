import java.util.Observable;
import java.lang.Integer;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Model extends Observable {

	public static final int MAX_VALUE = 2 ^ 31 - 1;
	private int input;
	private int output;
	private int basis1, basis2;
	private int number = 0;

	StringBuffer inbetween = new StringBuffer();

	public void setInput(int eingabeZahl) {
		this.input = eingabeZahl;
	}

	public void setBasis1(int eingabeBasisVon) {
		this.basis1 = eingabeBasisVon;
	}

	public void setBasis2(int eingabeBasisZu) {
		this.basis2 = eingabeBasisZu;
	}

	public void setOutput(String output) {
		this.output = Integer.parseInt(output);
	}
	
	public int getOutput() {
		return output;
	}

	public Model(int eingabeZahl, int eingabeBasisVon, int eingabeBasisZu) {
		super();
		this.input = eingabeZahl;
		this.basis1 = eingabeBasisVon;
		this.basis2 = eingabeBasisZu;
	}

	public Model() {
		super();
		input = 0;
		basis1 = 0;
		basis2 = 0;
	}

	// Umwandlung String: 1021 -> Integer: 34
	public int createNumber(String string) {
		int ergebnis = 0;
		char[] chars = string.toCharArray();
		int[] numbers = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
		}
		// Berechnung
		// x = (( 1 * 3 + 0 ) * 3 + 2 ) * 3 + 1
		ergebnis = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			ergebnis = ergebnis * basis1 + numbers[i];
			if (ergebnis > ((MAX_VALUE - numbers[i]) / basis1)) {
				// TODO: throw exception
			}
		}
		return ergebnis;
	}

	public void createOutput() {
		String zwitsch = String.valueOf(input);
		number = createNumber(zwitsch);
		number = input;
		StringBuffer erg = new StringBuffer("");
		int a = 0;
		while (number != 0) {
			a = number % basis2;
			number = number / basis2;
			erg.append(a);
		}
		setOutput(erg.reverse().toString());
		setChanged();
		notifyObservers();
	}

	public void ausgabeZahl() {
		output = 0;
		inbetween.append(input);
		for (int i = 0; i < inbetween.capacity(); i++) {
			output = inbetween.codePointAt(i) * basis1
					+ inbetween.codePointAt(i + 1);
		}
	}
}
/*
 * 
 * public ZahlenUmwandeln() { this.input = "1021"; this.basis1 = 3; this.basis2
 * = 5; }
 * 
 * public static void main(String args[]) {
 * 
 * // String 1021->3 // Hornerschema // int 34 // div & mod // 114->5
 * ZahlenUmwandeln money; money = new ZahlenUmwandeln(); } }
 */