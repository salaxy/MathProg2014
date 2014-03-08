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

		// Normalisieren des Schlüssels nur Buchstaben a bis z
		StringBuffer buffer = new StringBuffer();
		int c = 0;

		for (int i = 0; i < s.length(); i++) {

			c = s.charAt(i);

			if ((c >= 65) && (c <= 90)) {
				buffer.append((char) c);
			} else {
				// konvertiert zu Großbuchstaben
				if ((c >= 97) && (c <= 122)) {
					buffer.append((char) (c - 32));
				} else {
					throw new Exception("Nicht erlaubter Schlüssel!");
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
		// schlüsselwort in GroßBuchstaben

		if (key.length() == 0) {
			throw new Exception("Leerer Schlüssel!");
		}

		// Buffer für das Ergebnis erstellen
		StringBuffer ergebnis = new StringBuffer();
		// länge des Schüsselwortes
		int lang = key.length();
		// Stelle der Verschlüsselung
		int statuslang = 0;
		// für die Länge des Textes text verschlüsseln
		for (int n = 0; n < plainText.length(); n++) {

			// wenn stelle der Verschlüsselung größer als länge des
			// Schlüsselwortes
			if (statuslang == lang) {
				statuslang = statuslang - lang;
			}

			// errechne schlüssel dieses Zeichens
			int schluessel = key.charAt(statuslang) - 65;

			// wandel zeichen um
			int w = plainText.charAt(n);

			// Verschlüsseln der GroßBuchstaben
			if ((w >= 65) && (w <= 90)) {
				w = w + schluessel;

				if (w > 90) {
					w = w - 26;
				}
				statuslang++;
			}
			// Verschlüsseln der KleinBuchstaben
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
		// schlüsselwort in GroßBuchstaben

		if (key.length() == 0) {
			throw new Exception("Leerer Schlüssel!");
		}

		// Buffer für das Ergebnis erstellen
		StringBuffer ergebnis = new StringBuffer();
		// länge des Schüsselwortes
		int lang = key.length();
		// Stelle der Verschlüsselung
		int statuslang = 0;
		// für die Länge des Textes text verschlüsseln
		for (int n = 0; n < secretText.length(); n++) {

			// wenn stelle der Verschlüsselung größer als länge des
			// Schlüsselwortes
			if (statuslang == lang) {
				statuslang = statuslang - lang;
			}

			// errechne schlüssel dieses Zeichens
			int schluessel = key.charAt(statuslang) - 65;

			// wandel zeichen um
			int w = secretText.charAt(n);

			// entschlüsseln der GroßBuchstaben
			if ((w >= 65) && (w <= 90)) {
				w = w - schluessel;

				if (w < 65) {
					w = w + 26;
				}
				statuslang++;
			}
			// entschlüsseln der KleinBuchstaben
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
