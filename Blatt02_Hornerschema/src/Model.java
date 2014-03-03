import java.util.Observable;

public class Model extends Observable {

	
	private int		input,
					basis1,
					basis2,
					output;
	StringBuffer		inbetween = new StringBuffer();
	
	
	public void setInput(int eingabeZahl) {
		this.input = eingabeZahl;
	}
	
	public void setBasis1(int eingabeBasisVon) {
		this.basis1 = eingabeBasisVon;
	}
	
	public void setBasis2(int eingabeBasisZu) {
		this.basis2 = eingabeBasisZu;
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

	public  void ausgabeZahl() {
		output = 0;
		inbetween.append(input);
		for(int i = 0; i < inbetween.capacity(); i++) {
			output = inbetween.codePointAt(i) * basis1 + inbetween.codePointAt(i + 1);
		}
	      setChanged();
	      notifyObservers();
	}
}
