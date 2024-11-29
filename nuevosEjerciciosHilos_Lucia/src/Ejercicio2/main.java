package Ejercicio2;

public class main {

	public static void main(String[] args) {
		String fichero = "./Ejercicio2.txt";
		HiloLectura hiloMinus = new HiloLectura(fichero);
		hiloMinus.setName("minusculas");
		hiloMinus.start();

		HiloLectura hiloMayus = new HiloLectura(fichero);
		hiloMayus.setName("mayusculas");
		hiloMayus.start();

	}

}
