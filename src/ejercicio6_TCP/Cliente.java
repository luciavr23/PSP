package ejercicio6_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/*Implementar dos aplicaciones(cliente/servidor) tal que una envíe un mensaje
numerado al servidor mientras no se indique que no por teclado. El servidor
responderá al mensaje con la cadena “OK” y seguirá esperando mensajes
nuevos del cliente. Mostrar los mensajes por pantalla. Utiliza para ello sockets
TCP.
*/
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
		String respuesta;
		String mensaje;
		String respServer;
		
		try {
			Socket socket = new Socket(HOST,PUERTO);
			
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			cont=0;
			System.out.println("¿Quieres enviar un mensaje? (si/no)");
			respuesta=sc.nextLine().toLowerCase();
			
			while(!respuesta.equals("no")) {
				if(respuesta.equals("si")) {
					mensaje="mensaje nº"+cont;
					out.writeUTF(mensaje);
					cont++;
					respServer=in.readUTF();
					System.out.println(ANSI_BLUE+respServer);
				}
				System.out.println("¿Quieres enviar un mensaje? (si/no)");
				respuesta=sc.nextLine().toLowerCase();
			}
			out.writeUTF("fin");
			System.out.println(ANSI_BLUE+"Cliente finalizado");
			sc.close();
			socket.close();
			
		}catch (IOException e1) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
		}
	}

}
