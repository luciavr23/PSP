package ejercicio7_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



/*Implementar dos aplicaciones tal que una envíe el contenido de un fichero de
texto (el cliente) y la otra (el servidor) lea ese fichero de texto y lo muestre por
pantalla. Utiliza para ello sockets TCP. El servidor recibe cada línea del fichero e
indica n.º de línea y n.º de caracteres de cada línea.
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
		int lineas;
		int caracteres;
		String contenido;
		boolean salir;
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println(ANSI_RED+"Servidor iniciado");
			socket=servidor.accept();
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			while(true && in.available()>0) {
				lineas=in.readInt();
				contenido=in.readUTF();
				caracteres=in.readInt();
				System.out.println(ANSI_RED+"Linea "+lineas+":"+contenido+" "+caracteres);
			}
			System.out.println(ANSI_RED+"Servidor finalizado");
			socket.close();
		} catch (IOException e1) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
		}
	}
}
