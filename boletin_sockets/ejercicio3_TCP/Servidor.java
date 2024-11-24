package ejercicio3_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
	/*Implementar un servidor utilizando tecnología Sockets JAVA TCP que permita
	leer un número y devuelva al cliente el cuadrado del número. Implementar
	también el cliente.*/	
	public static final String ANSI_RED = "\u001B[31m";

	public static void main(String[] args) {
		ServerSocket servidor = null;
		Integer cont=0;

		// Se abre un puente de comunicacion entre el servidor y el cliente
		Socket socket = null;
		
		final int PUERTO = 5000;
		

		DataInputStream in;
		DataOutputStream out;
		try {
			servidor = new ServerSocket(PUERTO);
			
			System.out.println(ANSI_RED+"Servidor iniciado");

			socket=servidor.accept();
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			float numCliente=in.readFloat();
			out.writeFloat(numCliente*numCliente);
		
			
		} catch (IOException e1) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
		}
	}
}