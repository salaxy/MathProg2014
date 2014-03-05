import java.util.Observable;


public class IsbnModel extends Observable{

	private String isbn, guelt, zahl;

	public String getAusgabe() {
		return this.zahl;
	}

	public void setIsbn(String isbn) throws ISBNException {

		this.isbn = isbn;
	}

	public String getGuelt() {
		return this.guelt;
	}

	public IsbnModel() {
		super();
		this.isbn = null;
		this.zahl = null;
	}

	public void testISBN() throws ISBNException {
		int i, j, stelle = 0, hilf = 0, erg = 0, zahl = 0, stars = 0;
		
		if (isbn.length() > 10){
			throw new ISBNException("Die Eingabe muss min. 9 Zahlen  haben.");			
		}
		
		if (isbn.length() == 9){
			isbn = new StringBuffer(isbn).append("*").toString();
		}

		for (i = 1, j = 0; i <= 10; i++, j++) {
			if (this.isbn.charAt(j) == '*') {
				stelle = i;
				stars++;
			} else {
				if (j == 9 && this.isbn.charAt(j) == 'X') {
					erg += 100;
				} else
					erg += Integer.parseInt("" + this.isbn.charAt(j)) * i;
			}
		}
		if (stars > 1)
			throw new ISBNException(
					"Zu viele Sterne! Bitte nur einen eingeben.");

		this.guelt = (isCorrect(erg)) ? "gültig" : "nicht gültig";

		if (stelle != 0) {
			zahl = erg % 11;
			if (zahl != 0) {
				hilf = 11 - zahl;
				erg = hilf + erg;
				while ((hilf % stelle != 0) || (erg % 11 != 0)) {
					hilf = hilf + 11;
				}
			}

			this.guelt = ("");
			this.zahl = ("" + hilf / stelle);
			if (this.zahl.equals("10"))
				this.zahl = "X";
		} else
			this.zahl = ("");
		
		setChanged();
		notifyObservers();
	}

	private boolean isCorrect(int zahl) {
		return (zahl % 11 == 0) ? true : false;
	}

}