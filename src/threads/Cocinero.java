package threads;

import java.util.Random;

import seccioncritica.Bandeja;

public class Cocinero extends Thread{
	
	//ESTADO	
	private Bandeja miBandeja;
	private int idCocinero;
	
	/**
	 * Constructor 
	 * @param miIdCocinero
	 * @param miBandeja
	 */
	public Cocinero(int miIdCocinero,Bandeja miBandeja) {
		
		this.miBandeja = miBandeja;
		idCocinero = miIdCocinero;
		
	}
	public void run() {
		while(true) {
			Random r = new Random();
			int low = 1000;
			int high = 3000;
			int result = r.nextInt(high-low) + low;
			
			try {
				
				Thread.sleep(result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			miBandeja.agregarCangre(idCocinero);
		}
	}

	public Bandeja getMiBandeja() {
		return miBandeja;
	}

	public void setMiBandeja(Bandeja miBandeja) {
		this.miBandeja = miBandeja;
	}

	public int getIdCocinero() {
		return idCocinero;
	}

	public void setIdCocinero(int idCocinero) {
		this.idCocinero = idCocinero;
	}

}
