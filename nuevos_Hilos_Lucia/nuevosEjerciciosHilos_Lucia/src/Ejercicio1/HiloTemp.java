package Ejercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class HiloTemp extends Thread{
	
	@Override
	public void run() {
		//la prioridad la establece la CPU puede ser q se establezca una prioridad y no la coja
		System.out.println("Dentro del Hilo:" + this.getName() + ", Prioridad: " + this.getPriority() + ", ID: " + this.getId() );
		
		try {
			hiloEjecutandose();
			sleep(1000);
		} catch(InterruptedException e) { }
		if (interrupted()) {
			System.out.println("El hilo fue interrumpido");
		}
		System.out.println("Se sale del Hilo:" + this.getName());
	}
	
	public void hiloEjecutandose() {
		
		Scanner sc = new Scanner(System.in);
		String temp;
		
		try {
			FileWriter fw=new FileWriter("./temperatura.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			
			Date ahora=new Date();
			int mSeg=(int)ahora.getTime()/60000;
			int fin=mSeg+1;
			while (mSeg<fin) {
				System.out.println("Introduzca temperatura (en ºC) a medir:");
				temp=sc.nextLine();
				bw.write(temp+"ºC\n");
				// Esperamos 1 segundo para permitir que el tiempo cambie
			    try {
			        Thread.sleep(1000); // 1000 milisegundos = 1 segundo
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
			    ahora=new Date();
				mSeg=(int)ahora.getTime()/60000;
			}
			bw.close();
			fw.close();
		}catch(IOException e) {
			e.getMessage();
		}
	}
	
}
