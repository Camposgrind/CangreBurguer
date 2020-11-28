package seccioncritica;


public class Bandeja {
	//ESTADO
	private int n;
	
	public Bandeja() {
		n= 0;
	}
	/**
	 * Método con el que aumentaremos el número de cangreBurguer que hay en la bandeja 
	 * @param idCocinero
	 */
	public synchronized void agregarCangre(int idCocinero) {
		
		n++;
		System.out.println("El cocinero "+idCocinero+" ha preparado una cangre, en la bandeja hay "+n+"\n" );
		notify();
	}
	/**
	 * Método con el que restaremos el número de cangreBurguer que hay en la bandeja
	 * @param idCliente
	 */
	public synchronized void comerCangre(int idCliente) {
		while(n==0) {
			try {
				System.out.println("El cliente "+idCliente+" TIENE HAMBRE!!!! y en la bandeja hay "+n +"\n");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		n--;
		notify();
		System.out.println("El cliente "+idCliente+" ha comido una cangre, en la bandeja hay "+n+"\n" );

	}
}
