import java.util.Observable;

public class Model extends Observable {

//}
		
	int a,
		n,
		d,
		ausgabe;
	
	
	public void setA(int a) {
		this.a = a;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public void setD(int d) {
		this.d = d;
	}

	public int getAusgabe() {
		return ausgabe;
	}
	
	public Model(int a, int n, int d) {
		super();
		this.a = a;
		this.n = n;
		this.d = d;
	}

	public Model() {
		super();
		a = 0;
		n = 0;
		d = 0;
	}

	public  void ausgabe() {
		ausgabe = 0;
	      setChanged();
	      notifyObservers();
	}
}
