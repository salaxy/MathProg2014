package zwischenErgebnisse;

public class Aufgabe2_3 {

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
	
	public Aufgabe2_3() {
		setA(3);
		setN(6001);
		setM(7);
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
		System.out.println(temp3 % m);
	}
	
	public static void main(String arg[]) {
		
		Aufgabe2_3 model;
		model = new Aufgabe2_3();
		System.out.println(Integer.toBinaryString(model.n));
		model.formel();
		//System.out.println(model.ergebnis);
		System.out.println(((int)(Math.pow(3.0, 6.0))) % model.m);
	}
	
}
