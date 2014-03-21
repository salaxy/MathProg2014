import java.util.Observable;

public class Model extends Observable {

	int a, b, x, y, ggt;

	public void setA(int a) throws EuException {

		if (a < 0) {
			throw new EuException("Eingabe darf nicht kleiner als 0 sein!");
		}
		this.a = a;
	}

	public void setB(int b) throws EuException {
		if (b < 0) {
			throw new EuException("Eingabe darf nicht kleiner als 0 sein!");
		}
		this.b = b;
	}

	public int getGgt() {
		return ggt;
	}
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Model(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public Model() {
		super();
		a = 0;
		b = 0;
	}

	// Formel für GGT
	public void ggt() throws EuException {

		if (a == 0 && b == 0) {
			throw new EuException("GGT von 0, 0 ist undefiniert");
		}

		ggt = 0;
		if (a == 0)
			ggt = b;
		else if (b == 0)
			ggt = a;
		else {
			while (b != 0) {
				if (a > b)
					a = a - b;
				else
					b = b - a;
			}
		}
		ggt = a;
		setChanged();
		notifyObservers();
	}

	// Formel für Bezout Koeffizienten
	// erweiterter Euklid'scher Algorithmus
	public void ggtPlusBezout() throws EuException {
		if ((a == 0 && b == 0) || (a < 0) || (b < 0)) {
			throw new EuException("Eingabe muss größer Null sein");
		} else {

			int q, r, s, t;
			x = t = 1;
			y = s = 0;
			while (b > 0) {
				q = a / b;
				r = a - q * b;
				a = b;
				b = r;
				r = x - q * s;
				x = s;
				s = r;
				r = y - q * t;
				y = t;
				t = r;
			}
			ggt = a;
		}
		setChanged();
		notifyObservers();
	}
}
