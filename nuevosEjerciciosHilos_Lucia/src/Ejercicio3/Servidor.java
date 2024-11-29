package Ejercicio3;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/*Un cliente envía números enteros positivos al servidor hasta que el cliente envíe un número
negativo. El servidor lee número a número y responde OK cuando recibe cada número. El servidor
crea un fichero de texto (ejercicio3.txt) donde guarda cada número en líneas de 6 números. Si
existe el fichero, no se sobreescribe sino que la información se añade al final. Hay que usar Sockets
TCP.*/
public class Servidor {
	public static final String ANSI_RED = "\u001B[31m";
	
	public static void main(String[] args) {
		ServerSocket servidor = null;

		// Se abre un puente de comunicacion entre el servidor y el cliente
		Socket socket = null;
		final int PUERTO = 5000;
		DataInputStream in;
		DataOutputStream out;
		int mensaje;
		int cont=0;
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println(ANSI_RED+"Servidor iniciado");
			socket=servidor.accept();
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			File archivo=new File("./ejercicio3.txt");
			FileWriter fw=new FileWriter(archivo,true);
			BufferedWriter bw=new BufferedWriter(fw);
			if(archivo.exists() && archivo.length() > 0) {
				bw.write("\n");
			}
			mensaje=in.read();
			while(mensaje>=0) {
				cont++;
				if(cont!=6) {
					bw.write(mensaje+" ");
				}else {
					bw.write(mensaje+"\n");
					cont=0;
				}
				out.writeUTF("OK");
				mensaje=in.read();
			}
			System.out.println(ANSI_RED+"Servidor finalizado");
			bw.close();
			fw.close();
			socket.close();
			servidor.close();
		} catch (IOException e1) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
		}
	}

}
