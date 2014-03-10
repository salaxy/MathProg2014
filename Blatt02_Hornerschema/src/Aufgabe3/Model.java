package Aufgabe3;

import java.util.Observable;



public class Model extends Observable {

	private int a;
	private int n;
	private int m;
	
	private int ergebnis;
	
	// Getter & Setter
		public void setA(int a) {
			this.a = a;
		}
		
		public void setN(int n) throws A2Exception {
			if (n < 0) {
				throw new A2Exception("Eingabe darf nichkleiner als 0 sein!");
			}
			this.n = n;
		}
		
		public void setM(int m) throws A2Exception {
			if (m < 0) {
				throw new A2Exception("Eingabe darf nicht kleiner als 0 sein!");
			}
			this.m = m;
		}
		
		public int getErgebnis() {
			return ergebnis;
		}
		
		
		public Model(int a, int n, int m) {
			super();
			this.a = a;
			this.n = n;
			this.m = m;
		}

		public Model() {
			super();
			a = 0;
			n = 0;
			m = 0;
		}
		
		
		// Berechnung: a^n mod m
		public void formel() {
			int exponent = n;
			int basis = a;
			int temp3 = 1;
			while(exponent > 0) {
				if(exponent%2 != 0) {
					temp3 = (temp3 * basis) % m;
				}
				basis = (basis * basis) % m;
				exponent = exponent / 2;
			}
			this.ergebnis = temp3 % m;
			
			setChanged();
			notifyObservers();
		}
		
}
