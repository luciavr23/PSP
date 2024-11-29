package Ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/*Un cliente envía números enteros positivos al servidor hasta que el cliente envíe un número
negativo. El servidor lee número a número y responde OK cuando recibe cada número. El servidor
crea un fichero de texto (ejercicio3.txt) donde guarda cada número en líneas de 6 números. Si
existe el fichero, no se sobreescribe sino que la información se añade al final. Hay que usar Sockets
TCP.*/
public class Cliente {
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_BLACK = "\u001B[30m";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		DataInputStream in;
		DataOutputStream out;
		int cont;
		int respuesta;
		String mensaje;
		String respServer;
		
		try {
			Socket socket = new Socket(HOST,PUERTO);
			
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
		
			System.out.println("Escriba un número positivo (negativo para salir) :");
			respuesta=sc.nextInt();
			
			while(respuesta>=0) {
				out.write(respuesta);
				respServer=in.readUTF();
				System.out.println(ANSI_BLUE+"Respuesta servidor:"+respServer);
				System.out.println("Escriba un número positivo (negativo para salir) :");
				respuesta=sc.nextInt();
			}
			System.out.println(ANSI_BLUE+"Cliente finalizado");
			sc.close();
			socket.close();
		}catch(IOException e1) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
		}
	}

}
