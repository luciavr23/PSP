package ejercicio3_TCP;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	/*Implementar un servidor utilizando tecnología Sockets JAVA TCP que permita
leer un número y devuelva al cliente el cuadrado del número. Implementar
también el cliente.	*/
	
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_BLACK = "\u001B[30m";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		DataInputStream in;
		DataOutputStream out;
		float numMensaje;
		Boolean escribir=true;
		
		try {
			Socket socket = new Socket(HOST,PUERTO);
			
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			System.out.println(ANSI_BLACK+"Escriba el número:");
			numMensaje=sc.nextFloat();
				
			out.writeFloat(numMensaje);
				
			float resultado=in.readFloat();
			System.out.println("Cuadrado del número:"+resultado);
		
			System.out.println(ANSI_BLUE+"Cliente finalizado");
			sc.close();
			socket.close();
			
		}catch (IOException e1) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
		}
	}
}