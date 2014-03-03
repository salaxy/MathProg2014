package zwischenErgebnisse;
import java.lang.Integer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class ZahlenUmwandeln {

	public static final int MAX_VALUE = 2^31 -1;
	private String input;
	private int number;
	private String output;
	
	private int basis1, basis2;
	
	
	// Getter & Setter
	// von aussen muss nur erreichbar sein:
	// die eingegebene Zahl plus ihre Basis
	// bzw die auszugebene Zahl plus ihre Basis
	public void setInput(String input) {
		this.input = input;
	}
	
	public String getOutput() {
		return output;
	}
	
	public void setBasis1(int basis1) {
		this.basis1 = basis1;
	}
	
	public void setBasis2(int basis2) {
		this.basis2 = basis2;
	}
	
	public ZahlenUmwandeln() {
		this.input = "1021";
		this.basis1 = 3;
		this.basis2 = 5;
	}
	
	//Umwandlung String: 1021 -> Integer: 34
	public int createNumber(String string) {
		int ergebnis = 0;
		char[] chars = string.toCharArray();
		int[] numbers = new int[chars.length];
		for(int i= 0; i < chars.length; i++) {
			numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
		}
		// Berechnung
		// x = (( 1 * 3 + 0 ) * 3 + 2 ) * 3 + 1
		ergebnis = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			ergebnis = ergebnis * basis1 + numbers[i];
			if(ergebnis > ((MAX_VALUE-numbers[i])/basis1)) {
				//TODO: throw exception 
			}
		}
		return ergebnis;
	}
	
	public String createOutput() {
		StringBuffer erg = new StringBuffer("");
		int a = 0;
		while(number != 0) {
			a = number % basis2;
			number = number / basis2;
			erg.append(a);
		}
		return erg.reverse().toString();
	}
	
	public static void main(String args[]) {
		
		// String 1021->3
		// Hornerschema
		// int 34
		// div & mod
		// 114->5
		ZahlenUmwandeln money;
		money = new ZahlenUmwandeln();
		System.out.println(money.input);
		System.out.println(money.createNumber(money.input));
		System.out.println(money.createOutput());
	}
}
