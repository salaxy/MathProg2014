import java.util.Observable;


public class CaesarModel extends  Observable
{
    private String plaintext;
    private String secrettext;
    private int key;


    public CaesarModel()
    {
      plaintext = new String("");
      secrettext = new String("");
      key = 0;
    }


    public void setPlainText(String txt)
    {
       plaintext = txt;
    }
    
    public void setSecretText(String txt)
    {
        secrettext = txt;
    }
    
    public void setKey(char c)throws Exception{

        if(!(((c>=65)&&(c<=90))||((c>=97)&&(c<=122)))){
        	throw new Exception("Nicht erlaubter Schlüssel");
        }else{
	        if((c>=65)&&(c<=90)){
	        	key = c-65; 
	        }
	        
	        if((c>=97)&&(c<=122)){
	        	key = c-97; 
	        }    	
        }
        
    }
    
    private void setKey(int s){
        	key = s;
    }
    
    public String getSecretText()
    {
      return secrettext;
    }
    
    public String getPlaintext()
    {
        return plaintext;
    }
    
    /**
     * verschluesseln 
     */
    public void decode()
    {
        //erzeugen eines Stringbuffers zum Anhängen der einzelnen Zeichen
        StringBuffer ergebnis =new StringBuffer();
        
        //löschen des Geheimtextes
        this.clearSecretText();
        
           //solange noch zeichen des klartextes zu verarbeiten sind
           for (int n=0;n< plaintext.length();n++)
           {
                   //wandel zeichen in Ascii-code um
                   int w=plaintext.charAt(n);
                   
                   //überprüfen ob zeichen ein Großbuchstabe ist
                   if((w>=65)&&(w<=90))
                   {
                     //verändern des Zeichens um schlüsselzahl
                     w= w + key;
                     if(w>90)
                     {
                       w=w-26;
                     }
                   }
                   
                   //überprüfen ob zeichen ein Kleinbuchstabe ist
                   if((w>=97)&&(w<=122))
                   {
                     //verändern des Zeichens um schlüsselzahl
                     w= w + key;
                     if(w>122)
                     {
                       w=w-26;
                     }
                   }
                   
                   //hänge zeichen am StringBuffer ergebnis an
                   ergebnis.append((char)w);
           }
           //Umwandeln des stringbuffers in einen String für das Attribut des geheimtextes
           secrettext=ergebnis.toString();
           
           //Observer benachrichtigen
    		setChanged();
    		notifyObservers();
    }
    
    /**
     * entschluesseln
     */
    public void encode()
    {  
        //erzeugen eines Stringbuffers zum Anhängen der einzelnen Zeichen
        StringBuffer ergebnis =new StringBuffer();
        
        //löschen des klartextes
        this.clearPlaintext();
        
           //solange noch zeichen des geheimtextes zu verarbeiten sind
           for (int n=0;n< secrettext.length();n++)
           {
                   //wandel zeichen in Ascii-code um
                   int w=secrettext.charAt(n);
                   
                   //überprüfen ob zeichen ein Großbuchstabe ist
                   if((w>=65)&&(w<=90))
                   {
                     //verändern des Zeichens um schlüsselzahl
                     w= w - key;
                     if(w<65)
                     {
                       w=w+26;
                     }
                   }
                   
                   //überprüfen ob zeichen ein Kleinbuchstabe ist
                   if((w>=97)&&(w<=122))
                   {
                     //verändern des Zeichens um schlüsselzahl
                     w= w - key;
                     if(w<97)
                     {
                       w=w+26;
                     }
                   }
                   
                   //hänge zeichen am StringBuffer ergebnis an
                   ergebnis.append((char)w);
           }
           //Umwandeln des stringbuffers in einen String für das Attribut des klartextes
           plaintext=ergebnis.toString();
           
           //Observer benachrichtigen
    		setChanged();
    		notifyObservers();

    }
    
    /**
     * löschen des Klartextes
     */
    public void clearPlaintext()
    {
        plaintext = "";
    }
    
    /**
     * löschen des Geheimtextes
     */
    public void clearSecretText()
    {
        secrettext = "";
    }
    
    /**
     * automatisches entschluesseln 
     * vom vorher festgelgten Geheimtext
     * mit caesar durch häufigkeitenanalyse
     */
    public void autoDecode(){
    	
    	clearPlaintext();
    	//Textanalyse der Häufigkeiten
        //erstelle neue Objekte zu Buchstabenhäufigkeitsanalyse
        CharPrevalence[] alphabet = new CharPrevalence[26]; 
         
        //haeufigkeiten vergleichen
         
        int amBesten=0;
        double besteDiff=0.0;
        double aktDiff=0.0;
         
        //durchläuft alle 25 brauchbaren schlüssel
        //vergleicht die Haufigkeit des Ergebnisses
        //mit der deutschen Häufigkeit
        //die geringste Differenz gewinnt das rennen 
        for(int i=1;i<=25;i++){
        	alphabet[i-1] =new CharPrevalence();
            this.setKey(i);
            this.encode();
        	alphabet[i-1].analyse(plaintext);
        	
        	if(amBesten!=0){
        		//schleife
        		aktDiff=alphabet[i-1].differences();
        		if(aktDiff<besteDiff){
            		amBesten=i;
            		besteDiff=aktDiff;
        		}
        	}else{
        		//erste schleife
        		amBesten=1;
        		besteDiff=alphabet[i-1].differences();
        	}
        	
        }
         
         //gefundenen schlüssel setzen
         key=amBesten;

         //Entschlüsselung mit dem besten Schluessel
         this.encode();
	
         //Observer benachrichtigen
         setChanged();
         notifyObservers();
    }
    
}
