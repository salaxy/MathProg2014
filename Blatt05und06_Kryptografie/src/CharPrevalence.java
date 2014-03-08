
public class CharPrevalence
{
	/**
	 * summen
	 */
     private int[] absolut=new int[26];
     /**
      * Attribut für alle mitgezählten Buchstaben
      */
     private int anzahl=0;

     public CharPrevalence(){
           //Feld mit 0 werten belegen
           for (int n = 0; n < 26; n++) {
               absolut[n] = 0;
           }
     }


     /**
      * zaehlt wie oft ein buchstabe vorkommt
      * @param String - irgent ein Text
      */
     public void analyse(String inhalt){
           //umwandeln in Großbuchstaben
           inhalt=inhalt.toUpperCase();
           //durchläuft den String
           for(int n=0;n<inhalt.length();n++){

                   int zeichen=inhalt.charAt(n)-65;
                   if((zeichen>=0)&&(zeichen<=25)){
                       absolut[zeichen]++;
                       anzahl++;
                   }
            }
    }
         
    /**
     * gibt als double wieder 
     * wie oft ein Buchstabe prozentual vorkommt
     * @param int - zahl desBuchstaben im alphabet, begin bei 0
     * @return double - prozentuales vorkommen
     */
    private double relativ(int c){
        return absolut[c]*100/(double)anzahl;
    }
    
    /**
     * Ermittelt die Alphabet-Verteilungsdifferenz
     */
    public double differences(){
    	//http://de.wikipedia.org/wiki/Buchstabenh%C3%A4ufigkeit
    	double[] german=new double[26];
    	german[0]=6.51;
    	german[1]=1.89;
    	german[2]=3.06;
    	german[3]=5.06;
    	german[4]=17.40;
    	german[5]=1.66;
    	german[6]=3.01;
    	german[7]=4.76;
    	german[8]=7.55;
    	german[9]=0.27;
    	german[10]=1.21;
    	german[11]=3.44;
    	german[12]=2.53;
    	german[13]=9.78;
    	german[14]=2.51;
    	german[15]=0.79;
    	german[16]=0.02;
    	german[17]=7.00;
    	german[18]=7.27;
    	german[19]=6.15;
    	german[20]=4.35;
    	german[21]=0.67;
    	german[22]=1.89;
    	german[23]=0.03;
    	german[24]=0.04;
    	german[25]=1.13;
    	
    	
    	double diff=0.0;
    	double sumDiff=0.0;
    	
    	//differrenzen der einzelenen Buchstaben ausrrechnen
    	//und summieren
    	for(int i=0;i<26;i++){
    		
    		diff=relativ(i)-german[i];
    		diff=diff*diff;
    		sumDiff+=diff;	
    	}
    	
    	return sumDiff;
    }
    
}
