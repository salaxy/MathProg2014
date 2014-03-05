package Aufgabe2;

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
		
		public void setN(int n) {
			this.n = n;
		}
		
		public void setM(int m) {
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
		
		
		// a^n mod m
		public void formel() {
			int exponent = n;
			int temp2 = a;
			int temp3 = 1;
			while(exponent > 0) {
				if(exponent%2 != 0) {
					temp3 = (temp3 * temp2) % m;
				}
				temp2 = (temp2 * temp2) % m;
				exponent = exponent / 2;
			}
			//System.out.println(temp3 % m);
			this.ergebnis = temp3 % m;
			
			setChanged();
			notifyObservers();
		}
		
}
