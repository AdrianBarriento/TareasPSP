import java.math.BigInteger;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		int tiempoInicio = (int) System.currentTimeMillis();
		Scanner teclado = new Scanner(System.in);
		//pedimos el numero de hilos que queremos ejecutar y establecemos la porcion de numeros que va a abarcar cada hilo
		System.out.println("Introduce el numero de hilos que quiera utilizar: ");
		int numHilos = teclado.nextInt();
		int primosDefinidos = 100000/numHilos;
		
		//en un bucle se van ejecutando los hilos y se les pasa donde tienen que empezar y donde tienen que acabar
		int principio=0, fin;
		for(int x = 0 ; x<numHilos; x++) {
			fin= principio + primosDefinidos;
			CalculoHilos hilo = new CalculoHilos(principio, fin);
			hilo.start();
			//este sleep sirve para que espere un segundo cuando empiece un hilo, asi le da tiempo a acabar y no se van colapsando
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			}catch(InterruptedException ex) {}
			principio = fin;
		}
		int tiempoFin = (int) System.currentTimeMillis();
		int tiempoTotal = tiempoFin-tiempoInicio;
		System.out.println("Ha tardado "+ tiempoTotal+" milisegundos utilizando "+numHilos+" hilos.");
	}
}
