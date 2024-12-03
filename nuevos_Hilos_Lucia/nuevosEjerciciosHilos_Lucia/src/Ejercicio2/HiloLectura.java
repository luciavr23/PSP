package Ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class HiloLectura extends Thread {
	private String fichero;
	private static final Object LOCK = new Object();

	public HiloLectura(String fichero) {
		this.fichero = fichero;
	}

	@Override
	public void run() {
		// la prioridad la establece la CPU puede ser q se establezca una prioridad y no
		// la coja
		System.out.println(
				"Dentro del Hilo:" + this.getName() + ", Prioridad: " + this.getPriority() + ", ID: " + this.getId());

		try {
			hiloEjecutandose();
			sleep(1000);
		} catch (InterruptedException e) {
		}
		if (interrupted()) {
			System.out.println("El hilo fue interrumpido");
		}
		System.out.println("Se sale del Hilo:" + this.getName());
	}

	public void hiloEjecutandose() {
		try {
			FileReader fr = new FileReader(this.fichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			// Solo un hilo puede entrar en esta sección crítica a la vez
			while (br.ready()) {
				synchronized (LOCK) {
					linea = br.readLine();
					if (this.getName().equals("minusculas")) {
						System.out.println(linea.toLowerCase());
					} else if (this.getName().equals("mayusculas")) {
						System.out.println(linea.toUpperCase());
					}
				}
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getFichero() {
		return fichero;
	}

	public void setFichero(String fichero) {
		this.fichero = fichero;
	}

}
