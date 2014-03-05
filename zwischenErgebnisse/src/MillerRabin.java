package prime;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Miller-Rabin-Test
 * @author Michael Koppen
 *
 */

public class JPrimeModel{
	/*
	 * int maximum					2.147.483.647
	 * long maximum		9.223.372.036.854.775.807
	 * 
	 * Wenn n < 1.373.653, ist es ausreichend a = 2 und 3 zu testen,
     * wenn n < 9.080.191, ist es ausreichend a = 31 und 73 zu testen,
     * wenn n < 4.759.123.141, ist es ausreichend a = 2, 7, und 61 zu testen,
     * wenn n < 2.152.302.898.747, ist es ausreichend a = 2, 3, 5, 7, und 11 zu testen,
     * wenn n < 3.474.749.660.383, ist es ausreichend a = 2, 3, 5, 7, 11, und 13 zu testen,
     * wenn n < 341.550.071.728.321, ist es ausreichend a = 2, 3, 5, 7, 11, 13, und 17 zu testen.
	 */
	private long[] zeuge = { 2, 3, 5, 7, 11, 13, 17};
	
	private final BigInteger ZERO=new BigInteger("0");
	private final BigInteger ONE=new BigInteger("1");
	private final BigInteger TWO=new BigInteger("2");
	private final BigInteger THREE=new BigInteger("3");
	//-----------------------------------BigInteger---------------------------------------------------------
	public BigInteger isPrimeBigInt(){
		Random prng = new SecureRandom();
		return BigInteger.probablePrime(150, prng);
	}
	//-----------------------------------Miller-Rabin-Test--------------------------------------------------

	/**
	 * Einstiegsmethode zum ueberprüfen ob zahl=primzahl
	 * Ueberpruefung auf Grundlegende vorraussetzungen
	 */
	public boolean isPrimeBig(BigInteger n) {
		if ((n.signum()==-1 || n.signum()==0)) {
			return false;
		} else if (n.equals(ONE)) {
			return false;
		} else if (n.compareTo(THREE) < 0) {
			return true;
		} else if (n.mod(TWO).equals(ZERO)) {
			return false;
		} else {
			return millerRabinBig(n);
		}
	}
	/**
	 * Einstiegsmethode zum generieren einer n-stelligen Primzahl
	 * Ueberpruefung auf Grundlegende vorraussetzungen
	 */
	public BigInteger isPrimeBigRandom(int lenght) throws JPrimeException {
		boolean accept=false;
		BigInteger n= new BigInteger("0");
		BigDecimal rand=new BigDecimal("0");
		BigDecimal pow=new BigDecimal("0");
		while(!accept){
			rand=new BigDecimal(Math.random());
			rand=rand.divide(new BigDecimal(""+0.3),100, BigDecimal.ROUND_UP);
			pow=new BigDecimal("10");
			pow=pow.pow(lenght);
			System.out.println("lenght: "+lenght);
			System.out.println("rand: "+rand);
			System.out.println("pow: "+pow);
			n=new BigInteger(""+(pow.multiply(rand)).toBigInteger());
			System.out.println(n);
			
			if (n.toString().length()!=lenght) {
				continue;
			}
			if ((n.signum()==-1 || n.signum()==0)) {
				accept=false;
//				throw new PrimeException("numberTooSmall");
				
			} else if (n.equals(ONE)) {
				accept=false;
			} else if (n.compareTo(THREE) < 0) {
				accept=true;
			} else if (n.mod(TWO).equals(ZERO)) {
				accept=false;
			} else {
				accept=millerRabinBig(n);
			}
		}
		return n;
	}
	/**
	 * Methode zum ueberprüfen ob zahl=primzahl nach Miller-Rabin-Test
	 * @param isPrime
	 * @return
	 */
	private boolean millerRabinBig(BigInteger isPrime) {
		BigInteger nsub1=isPrime.subtract(ONE);
		/*
		 * teste alle ob deterministisch
		 * a= "zufällige" basis
		 */
		for (int i = 0; i < zeuge.length; i++) {
			BigInteger a=new BigInteger("0");
			BigInteger modpow = null;
			BigInteger d=new BigInteger("0");
			a=new BigInteger(zeuge[i]+"");
			
			
			if (a.compareTo(isPrime) < 0) {
				long s = 0;
				d=isPrime;
				d=d.subtract(ONE);
				/*
				 * bestimme s
				 */
				while ((d.mod(TWO)).equals(ONE) ) {
					s++;
					d=d.divide(TWO);
				}
				/*
				 * teste aktuellen ob deterministisch
				 */
				
				modpow=a.modPow(d, isPrime);
				if (!(modpow.equals(ONE)) && !(modpow.equals(nsub1))) {
					for (long r = 1; r < s; r++) {
						modpow = (modpow.multiply(modpow)).mod(isPrime);
						if (modpow.equals(ONE)) {
							return false;
						}
						if (modpow.equals(nsub1)) {
							i++;
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	//-----------------------------------Miller-Rabin-Test fuer Long-Zahlen--------------------------------------------------

//	/*
//	 * Modulare Potenz
//	 */
//	private long modpow(long basis, long exponent, long modulo) {
//		long result = 1;
//		long gradebasis = basis;
//		while (exponent > 0) {
//			/*
//			 * exponent ungerade!
//			 */
//			if (exponent % 2 == 1) {
//				result = (result * gradebasis) % modulo;
//			}
//			/*
//			 * exponent gerade!
//			 */
//			gradebasis = (gradebasis * gradebasis) % modulo;
//			exponent /= 2;
//		}
//		return result;
//	}
//
//	private boolean millerRabin(long isPrime) {
//		
//		/*
//		 * teste alle ob deterministisch
//		 * a= "zufällige" basis
//		 */
//		outer:for (int i = 0; i < zeuge.length; i++) {
//			long a=zeuge[i];
//			if (a < isPrime) {
//				long s = 0;
//				long d = isPrime - 1;
//				/*
//				 * bestimme s
//				 */
//				while (d % 2 == 0) {
//					s++;
//					d /= 2;
////					System.out.println(d);
//				}
//				/*
//				 * teste aktuellen ob deterministisch
//				 */
//				long modpow = modpow(a, d, isPrime);
//				if (modpow != 1 && modpow != isPrime - 1) {
//					for (long r = 1; r < s; r++) {
//						modpow = (modpow * modpow) % isPrime;
//						if (modpow == 1) {
//							return false;
//						}
//						if (modpow == isPrime - 1) {
//							continue outer;
//						}
//					}
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//	public boolean isPrime(int n) {
//		if (n <= 1) {
//			return false;
//		} else if (n >=341550071728321l) {
//			//kann aktuell nicht erreicht werden (übersteigt bereich int)
//			//exception maxwert erreicht
//			// keine deterministische rechnung mehr möglich
//			return false;
//		} else if (n <= 3) {
//			return true;
//		} else if (n % 2 == 0) {
//			return false;
//		} else {
//			return millerRabin(n);
//		}
//	}
}
