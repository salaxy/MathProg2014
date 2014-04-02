

import gauss.Model;
import gauss.View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Die Klasse beinhaltet die Methode zum<br>
 * hinzufügen der Panels sowie die update Methode<br>
 * und die actionPerformed Methode.
 */
public class MainView extends JPanel implements ActionListener, Observer {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Methode zum hinzufügen der Panels
	 * @param zahlModel
	 * @param modModel
	 */
	public MainView(){
		
		//model erzeugen
//		ZahlModel zahlModel = new ZahlModel();
//		ModModel modModel=new ModModel();
//		EuModel euModel = new EuModel();
//		KaModel kaModel = new KaModel();
//		GausModel gaModel = new GausModel();
		//@ Alex für alle ähnlich, aber bennene die Klassen besser
		Model gaussModel =  new Model();
//		CaesarModel caesar = new CaesarModel();
//		VigenereModel vigenere=new VigenereModel();
//		JPrimeModel prime=new JPrimeModel();
//		RSAModel rsa=new RSAModel();
//		HamModel ham=new HamModel();
					
		
		// Panels hinzufügen
		JTabbedPane tp = new JTabbedPane(JTabbedPane.NORTH);
//		tp.setPreferredSize(new Dimension(760,460));
		tp.setPreferredSize(new Dimension(810,460));
		
		

//		tp.addTab("Zahlensysteme", new ZahlView(zahlModel));
//		tp.addTab("ModularePotenz", new ModView(modModel));
//		tp.addTab("Euklid", new EuView(euModel));
//		tp.addTab("Kalender", new KaView(kaModel));
//		tp.addTab("Matrizen", new GaView(gaModel));
		tp.addTab("Matrizen", new View(gaussModel));
//		tp.addTab("Kryptologie", new KrypView(caesar,vigenere));
//		tp.addTab("Hamming", new HamView(ham));
//		tp.addTab("Miller Rabin", new JPrimeView(prime));
//		tp.addTab("RSA-Algo", new RSAView(rsa));
//		tp.addTab("Ueber", new InfoView());
		
		
		//@ Alex ganz beliebig weitere hinzufügen
		
		add(tp);
	}
	
	/**
	 * update Methode
	 */
	@Override
	public void update(Observable arg0, Object arg1) {}

	/**
	 * actionPerformed Methode
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {}
}
