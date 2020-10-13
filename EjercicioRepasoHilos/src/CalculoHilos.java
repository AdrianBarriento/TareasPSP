import java.math.BigInteger;

public class CalculoHilos extends Thread{
	private int principio;
	private int fin;
	
	public CalculoHilos(int principio, int fin) {
		this.principio = principio;
		this.fin = fin;
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		for(int num = principio; num<=fin; num++) {
			BigInteger big = new BigInteger(String.valueOf(num));
			if(big.isProbablePrime(1)) {
				System.out.println(big);	
			}
		}
		
	}
	
	
	

}
