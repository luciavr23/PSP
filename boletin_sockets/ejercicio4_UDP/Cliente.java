package ejercicio4_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int PUERTO_SERVIDOR = 5000;
        byte[] buffer;

        try {
            // Dirección del servidor
            InetAddress direccionServidor = InetAddress.getByName("localhost");

            // Crear socket UDP
            DatagramSocket socketUDP = new DatagramSocket();

            // Pedir número al usuario
            System.out.print("Introduce un número: ");
            String mensaje = sc.nextLine();

            // Enviar el número al servidor
            buffer = mensaje.getBytes("UTF-8");
            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
            socketUDP.send(pregunta);
            System.out.println("Número enviado al servidor.");

            // Leer los 10 números consecutivos enviados por el servidor
            System.out.println("10 números consecutivos al introducido:");
            for (int i = 0; i < 10; i++) {
                buffer = new byte[1024]; // Crear un nuevo buffer para cada respuesta
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
                socketUDP.receive(respuesta);

                // Leer y mostrar el número recibido
                String numeroRecibido = new String(respuesta.getData(), 0, respuesta.getLength()).trim();
                System.out.println(numeroRecibido);
            }

            // Cerrar el socket
            socketUDP.close();

        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
