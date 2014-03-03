package zwischenErgebnisse;

/**
*
* @author Li La van RAW
*/
public class IsbnChecksum {
    /*
        s = (10 * x_1 + 9 * x_2 + ... + 2 * x_9) % 11
    */
    
    static final int CHECK_DIGIT_POSITION = 9;
    
    public static int generateCheckDigit(int[] isbnDigits) {
        int sum = 0;
        for (int i = 0, j = 10; i < CHECK_DIGIT_POSITION; i++, j--) {
            sum += j * isbnDigits[i];
        }
        return 11 - (sum % 11);
    }
    
    public static boolean validateIsbn(int[] isbnDigits) {        
        return generateCheckDigit(isbnDigits) == isbnDigits[CHECK_DIGIT_POSITION];
    }
    
    public static String checkISBN(String isbn) {
    	return "TODO";
    }
    
    public static void main(String[] args) {
        //Geheime Botschaften. Die Kunst der Verschlüsselung 
    	//von der Antike bis in die Zeiten des Internet.
    	//Autor: Simon Singh
    	int[] geheimeBotschaftenISBN = {3, 4, 2, 3, 3, 3, 0, 7, 1, 6};
    	int geheim = generateCheckDigit(geheimeBotschaftenISBN);
    	System.out.println("Geheime Botschaften: " + geheim);
    	
    	//Fermats letzter Satz: Die abenteuerliche 
    	//Geschichte eines mathematischen Rätsels
    	//Autor: Simon Singh
    	int[] fermatsLetzterSatz = {3, 4, 2, 3, 3, 3, 0, 5, 2, 0};
    	int fermats = generateCheckDigit(fermatsLetzterSatz);
    	System.out.println("Fermats letzter Satz: " + fermats);
    	
        int[] momoIsbn = {3, 5, 2, 2, 2, 0, 1, 8, 8};
        int momo = generateCheckDigit(momoIsbn);
        System.out.println("Momo Prüfziffer sollte 4 sein: " + momo);
        
        int[] unendlicheGeschichteIsbn = {3, 5, 2, 2, 1, 7, 6, 8, 4};
        int unendlicheGeschichte = generateCheckDigit(unendlicheGeschichteIsbn);
        System.out.println("Unendliche Geschichte Prüfziffer sollte 7 sein: " + unendlicheGeschichte);
    }
}