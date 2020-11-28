package main;

import seccioncritica.Bandeja;
import threads.Cliente;
import threads.Cocinero;

public class Main {

	public static void main(String[] args) {
		final int N_COCINEROS = 20;	
		final int N_CLIENTES = 20;
		
		//Monitor concurrente
		Bandeja miBandeja = new Bandeja();
		
		//Hilos que pelean por incrementar en paralelo
		Cliente[] Clientes = new Cliente[N_CLIENTES];
		Cocinero[] Cocineros = new Cocinero[N_COCINEROS];
		
		//Creamos los cocineros
		for(int i = 0 ; i < N_COCINEROS ; i++){
			Cocineros[i] = new Cocinero( i,miBandeja);
			
		}
		
		//Creamos los clientes 
		for(int i = 0 ; i < N_CLIENTES ; i++){
			Clientes[i] = new Cliente(i,miBandeja);
			
		}
		
		//Lanzando hilos Cocineros 
		for(int i = 0; i < N_COCINEROS ; i++){
			Cocineros[i].start();
		}
		
		//Lanzando hilos de Clientes
		for (int i = 0; i < N_CLIENTES; i++) {
			
			Clientes[i].start();
		}
	}

}
