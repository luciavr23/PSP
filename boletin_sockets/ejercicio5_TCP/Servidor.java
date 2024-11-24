package ejercicio5_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
	/*Implementar un servidor utilizando tecnología Sockets JAVA TCP que permita
realizar las operaciones aritméticas básicas. Igualmente implementar un cliente
que haga uso del servicio. Crear un cliente para consola y otro cliente gráfico.*/	
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
			float resultado=0.0f;
			String operacion=in.readUTF();
			float num1=in.readFloat();
			float num2=in.readFloat();
			
			switch(operacion) {
				case "sumar": resultado=num1+num2;break;
				case "restar": resultado=num1-num2;break;
				case "multiplicar": resultado=num1*num2;break;
				case "dividir": resultado=num1/num2;break;
				default:
			}
			out.writeFloat(resultado);
		
			
		} catch (IOException e1) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
		}
	}
}