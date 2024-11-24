package ejercicio5_TCP;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	/*Implementar un servidor utilizando tecnología Sockets JAVA TCP que permita
realizar las operaciones aritméticas básicas. Igualmente implementar un cliente
que haga uso del servicio. Crear un cliente para consola y otro cliente gráfico.	*/
	
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_BLACK = "\u001B[30m";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		DataInputStream in;
		DataOutputStream out;
		float num1;
		float num2;
		String operacion;
		
		try {
			Socket socket = new Socket(HOST,PUERTO);
			
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			System.out.println("-Sumar\n-Restar\n-Multiplicar\n-Dividir");
			System.out.println(ANSI_BLACK+"Escriba operacion a realizar:");
			operacion=sc.nextLine();
			
			System.out.println(ANSI_BLACK+"Escriba el primer número:");
			num1=sc.nextFloat();
			
			System.out.println(ANSI_BLACK+"Escriba el segundo número:");
			num2=sc.nextFloat();
			
			
			out.writeUTF(operacion.toLowerCase());
			out.writeFloat(num1);
			out.writeFloat(num2);
			
			
			float resultado=in.readFloat();
			
			System.out.println("Resultado de la operación:"+resultado);
		
			System.out.println(ANSI_BLUE+"Cliente finalizado");
			sc.close();
			socket.close();
			
		}catch (IOException e1) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
		}
	}
}