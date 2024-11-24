package ejercicio6_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/*Implementar dos aplicaciones(cliente/servidor) tal que una envíe un mensaje
numerado al servidor mientras no se indique que no por teclado. El servidor
responderá al mensaje con la cadena “OK” y seguirá esperando mensajes
nuevos del cliente. Mostrar los mensajes por pantalla. Utiliza para ello sockets
TCP.
*/
public class Servidor {
	public static final String ANSI_RED = "\u001B[31m";
	public static void main(String[] args) {
		ServerSocket servidor = null;

		// Se abre un puente de comunicacion entre el servidor y el cliente
		Socket socket = null;
		final int PUERTO = 5000;
		DataInputStream in;
		DataOutputStream out;
		String mensaje;
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println(ANSI_RED+"Servidor iniciado");
			socket=servidor.accept();
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			while(true) {
				mensaje=in.readUTF();
				if(mensaje.equals("fin")) {
					break;
				}
				System.out.println(ANSI_RED+"Mensaje:"+mensaje);
				out.writeUTF("OK");	
			}
			System.out.println(ANSI_RED+"Servidor finalizado");
			socket.close();
		} catch (IOException e1) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
		}
	}
}
