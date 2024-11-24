package ejercicio7_TCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/*Implementar dos aplicaciones tal que una envíe el contenido de un fichero de
texto (el cliente) y la otra (el servidor) lea ese fichero de texto y lo muestre por
pantalla. Utiliza para ello sockets TCP. El servidor recibe cada línea del fichero e
indica n.º de línea y n.º de caracteres de cada línea.
*/
public class Cliente {
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_BLACK = "\u001B[30m";

	public static void main(String[] args) {
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		DataInputStream in;
		DataOutputStream out;
		int cont;
		FileReader fr = null;
		BufferedReader br = null;
		String linea = "";
		int caracteres;
		
		try {
			Socket socket = new Socket(HOST,PUERTO);
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			fr = new FileReader("/ejercicio7_TCP/Ejercicio7.txt");
			br = new BufferedReader(fr);
			cont=0;
			caracteres=0;
	
			while (br.ready()) {// comprueba si hay + datos para leer
				linea = br.readLine(); // lee una linea hasta el \n
				cont++;
				out.writeInt(cont);
				out.writeUTF(linea);
				caracteres=linea.length();
				out.writeInt(caracteres);
				caracteres=0;
			}
			System.out.println(ANSI_BLUE+"Cliente finalizado");
			socket.close();	
		}catch (IOException e1) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
		}
	}

}
