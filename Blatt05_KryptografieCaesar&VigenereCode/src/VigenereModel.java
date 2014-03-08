import java.util.Observable;

public class VigenereModel extends Observable {

	private String plainText;
	private String secretText;
	private String key;

	public VigenereModel() {
		plainText = "";
		secretText = "";
		key = "A";
	}

	public void setPlainText(String s) {
		plainText = s;
	}

	public void setKey(String s) throws Exception {

		// Normalisieren des Schl�ssels nur Buchstaben a bis z
		StringBuffer buffer = new StringBuffer();
		int c = 0;

		for (int i = 0; i < s.length(); i++) {

			c = s.charAt(i);

			if ((c >= 65) && (c <= 90)) {
				buffer.append((char) c);
			} else {
				// konvertiert zu Gro�buchstaben
				if ((c >= 97) && (c <= 122)) {
					buffer.append((char) (c - 32));
				} else {
					throw new Exception("Nicht erlaubter Schl�ssel!");
				}

			}

		}

		key = buffer.toString();
	}

	public String getSecretText() {
		return secretText;
	}

	public void setSecretText(String s) {
		secretText = s;
	}

	public String getPlainText() {
		return plainText;
	}

	public void decode() throws Exception {
		// schl�sselwort in Gro�Buchstaben

		if (key.length() == 0) {
			throw new Exception("Leerer Schl�ssel!");
		}

		// Buffer f�r das Ergebnis erstellen
		StringBuffer ergebnis = new StringBuffer();
		// l�nge des Sch�sselwortes
		int lang = key.length();
		// Stelle der Verschl�sselung
		int statuslang = 0;
		// f�r die L�nge des Textes text verschl�sseln
		for (int n = 0; n < plainText.length(); n++) {

			// wenn stelle der Verschl�sselung gr��er als l�nge des
			// Schl�sselwortes
			if (statuslang == lang) {
				statuslang = statuslang - lang;
			}

			// errechne schl�ssel dieses Zeichens
			int schluessel = key.charAt(statuslang) - 65;

			// wandel zeichen um
			int w = plainText.charAt(n);

			// Verschl�sseln der Gro�Buchstaben
			if ((w >= 65) && (w <= 90)) {
				w = w + schluessel;

				if (w > 90) {
					w = w - 26;
				}
				statuslang++;
			}
			// Verschl�sseln der KleinBuchstaben
			if ((w >= 97) && (w <= 122)) {
				w = w + schluessel;
				if (w > 122) {
					w = w - 26;
				}
				statuslang++;
			}
			// hange zeichen am Stringbuffer an
			ergebnis.append((char) w);

		}

		// Wandel in String um
		secretText = ergebnis.toString();
		
		setChanged();
		notifyObservers();
	}

	public void encode() throws Exception {
		// schl�sselwort in Gro�Buchstaben

		if (key.length() == 0) {
			throw new Exception("Leerer Schl�ssel!");
		}

		// Buffer f�r das Ergebnis erstellen
		StringBuffer ergebnis = new StringBuffer();
		// l�nge des Sch�sselwortes
		int lang = key.length();
		// Stelle der Verschl�sselung
		int statuslang = 0;
		// f�r die L�nge des Textes text verschl�sseln
		for (int n = 0; n < secretText.length(); n++) {

			// wenn stelle der Verschl�sselung gr��er als l�nge des
			// Schl�sselwortes
			if (statuslang == lang) {
				statuslang = statuslang - lang;
			}

			// errechne schl�ssel dieses Zeichens
			int schluessel = key.charAt(statuslang) - 65;

			// wandel zeichen um
			int w = secretText.charAt(n);

			// entschl�sseln der Gro�Buchstaben
			if ((w >= 65) && (w <= 90)) {
				w = w - schluessel;

				if (w < 65) {
					w = w + 26;
				}
				statuslang++;
			}
			// entschl�sseln der KleinBuchstaben
			if ((w >= 97) && (w <= 122)) {
				w = w - schluessel;
				if (w < 97) {
					w = w + 26;
				}
				statuslang++;
			}
			// hange zeichen am Stringbuffer an
			ergebnis.append((char) w);

		}

		// Wandel in String um
		plainText = ergebnis.toString();
		setChanged();
		notifyObservers();
	}

}
