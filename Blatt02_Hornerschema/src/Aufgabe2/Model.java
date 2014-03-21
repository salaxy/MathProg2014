package Aufgabe2;
import java.util.Observable;
import java.lang.Integer;


public class Model extends Observable{

	public static final int MAX_VALUE = 2147483647;
	
	private String eingabe;
	private int basis1;
	private int intZahl;
	private int basis2;
	private String ausgabe;
	
	
	//Getter und Setter
	public void setEingabe(String eingabe) {
		this.eingabe = new String (eingabe);
	}
	
	public void setBasis1(int basis) throws ZD2Exception{
		if((basis < 2) || (basis > 16)) {
			throw new ZD2Exception("Eingabe der ersten Basis ist falsch");
		} else {
			this.basis1 = basis;
		}
	}
	
	public void setBasis2(int basis) throws ZD2Exception{
		if(basis < 2) {
			throw new ZD2Exception("Die zweite Basis ist zu klein gewaehlt!");
		} else if(basis > 16) {
			throw new ZD2Exception("Die zweite Basis ist zu groß gewaehlt!");
		} else {
			this.basis2 = basis;
		}
	}
	
	public void setIntZahl(int zahl) {
		this.intZahl = zahl;
	}
	
	public void setAusgabe(String ausgabe) {
		this.ausgabe = new String(ausgabe);
	}
	
	public String getAusgabe() {
		return ausgabe;
	}
	
	//Hornerschema
	//String to Integer
	public int createInteger(String eingabe, int basis) throws ZD2Exception{
		int ergebnis;
		int test = 0;
		char[] chars = eingabe.toCharArray();
		int[] numbers = new int[chars.length +1];
		//Umwandlung der Buchstaben zu Zahlen
		numbers[0] = 0;
		if(basis < 11) {
			for (int i = 0; i < chars.length; i++) {
				numbers[i+1] = Integer.parseInt(String.valueOf(chars[i]));
			}
		} else if(basis > 10) {
			for (int i = 0; i < chars.length; i++) {
				switch(chars[i]) {
					case '1':
						numbers[i+1] = 1;
						break;
					case '2':
						numbers[i+1] = 2;
						break;
					case '3':
						numbers[i+1] = 3;
						break;
					case '4':
						numbers[i+1] = 4;
						break;
					case '5':
						numbers[i+1] = 5;
						break;
					case '6':
						numbers[i+1] = 6;
						break;
					case '7':
						numbers[i+1] = 7;
						break;
					case '8':
						numbers[i+1] = 8;
						break;
					case '9':
						numbers[i+1] = 9;
						break;
					case 'A':
						numbers[i] = numbers[i] +1;
						break;
					case 'B':
						numbers[i] = numbers[i] +1;
						numbers[i+1] = 1 ;
						break;
					case 'C':
						numbers[i] = numbers[i] +1;
						numbers[i+1] = 2;
						break;
					case 'D':
						numbers[i] = numbers[i] +1;
						numbers[i+1] = 3;
						break;
					case 'E':
						numbers[i] = numbers[i] +1;
						numbers[i+1] = 4;
						break;
					case 'F':
						numbers[i] = numbers[i] +1;
						numbers[i+1] = 5;
						break;
					default:
						throw new ZD2Exception("Falsche Eingabe");	
				}
			}
		}
		// eigentliche Berechnung
		ergebnis = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			test = MAX_VALUE - ergebnis;
			ergebnis = ergebnis * basis + numbers[i];
			if(test > (MAX_VALUE - ergebnis)) {
				throw new ZD2Exception("Der eingegebene Wert ist zu groß!");
			}
		}
		setIntZahl(ergebnis);
		return ergebnis;
		}
		
		//div & mod
		//Integer to String
		public String createAusgabe(int eingabe, int basis) throws ZD2Exception{
			int a = 0;
			StringBuffer zahl = new StringBuffer("");
			//für Basen <= 10
			if(basis < 11) {
				while (eingabe != 0) {
					a = eingabe % basis;
					eingabe = eingabe / basis;
					zahl.append(a);
				}
			} else {
			//für Basen der Größe 11 - 16
				while (eingabe != 0) {
					a = eingabe % basis;
					eingabe = eingabe / basis;
					if (a > 9) {
						switch(a) {
							case 10:
								zahl.append("A");
								break;
							case 11:
								zahl.append("B");
								break;
							case 12:
								zahl.append("C");
								break;
							case 13:
								zahl.append("D");
								break;
							case 14:
								zahl.append("E");
								break;
							case 15:
								zahl.append("F");
								break;
						}
					} else {
						zahl.append(a);
					}
				}	
			}
			zahl = zahl.reverse();
			setAusgabe(zahl.toString());
			return zahl.toString();
			}
	
	//durch View aufgerufene Methode
	public void createZahl() throws ZD2Exception {
		
		if(basis1 == 10) {
			intZahl = Integer.parseInt(eingabe);
		} else {
			intZahl = createInteger(eingabe, basis1);
		}
		
		if(basis2 == 10) {
			setAusgabe(String.valueOf(intZahl));
		} else {
			createAusgabe(intZahl, basis2);
		}
		
		setChanged();
		notifyObservers();
	}
}