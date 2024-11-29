package Ejercicio1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloTemp t=new HiloTemp();
		t.setName("temperatura");
		t.start();

		HiloHumedad h=new HiloHumedad();
		h.setName("humedad");
		h.start();

	}

}
