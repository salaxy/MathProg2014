import java.util.Observable;

public class Model extends Observable {
		
	String 	plainText,
			key,
			cipherText;
	
	
	public void setPlainText(String plainText) {
		this.plainText = new String(plainText);
	}

	public void setKey(String key) {
		this.key = new String(key);
	}

	public String getCipherText() {
		return cipherText;
	}
	
	public Model(String plainText, String key) {
		super();
		this.plainText = plainText;
		this.key = key;
	}

	public Model() {
		super();
		plainText = new String("");
		key = new String("");
	}

	public  void cipherText() {
		cipherText = new String("");
	      setChanged();
	      notifyObservers();
	}
}
