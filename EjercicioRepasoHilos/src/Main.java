import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el numero de hilos que quiera utilizar: ");
		int numHilos = teclado.nextInt();
		int primosDefinidos = 100000/numHilos;
		
		int principio=0, fin;
		for(int x = 0 ; x<numHilos; x++) {
			fin= principio + primosDefinidos;
			CalculoHilos hilo = new CalculoHilos(principio, fin);
			hilo.start();
			principio = fin;
		}
	}
}
