package threads;

import java.util.Random;

import seccioncritica.Bandeja;

public class Cliente extends Thread{
	
	//ESTADO
	private Bandeja miBandeja;
	private int idCliente;
	
	/**
	 * Constructor 
	 * @param miIdCliente
	 * @param miBandeja
	 */
	public Cliente(int miIdCliente,Bandeja miBandeja) {
		
		this.miBandeja = miBandeja;
		idCliente = miIdCliente;
		
	}
	
	public void run() {
		while (true) {
			
			miBandeja.comerCangre(idCliente);
			
			Random r = new Random();
			int low = 1000;
			int high = 3000;
			int result = r.nextInt(high-low) + low;
			try {	
				Thread.sleep(result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Bandeja getMiBandeja() {
		return miBandeja;
	}

	public void setMiBandeja(Bandeja miBandeja) {
		this.miBandeja = miBandeja;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	

}
