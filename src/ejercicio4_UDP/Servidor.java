package ejercicio4_UDP;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Servidor {
	
	    public static void main(String[] args) {
	        final int PUERTO = 5000; // Puerto del servidor
	        byte[] buffer = new byte[1024];

	        try {
	            System.out.println("Servidor UDP iniciado...");
	            DatagramSocket socketUDP = new DatagramSocket(PUERTO);

	            while (true) {
	                // Recibir solicitud del cliente
	                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
	                socketUDP.receive(peticion);

	                // Convertir el mensaje recibido a número entero
	                String mensaje = new String(peticion.getData());
	                int numero = Integer.parseInt(mensaje.trim());
	                System.out.println("Número recibido: " + numero);

	                // Dirección y puerto del cliente
	                InetAddress direccionCliente = peticion.getAddress();
	                int puertoCliente = peticion.getPort();

	                // Enviar los 10 números consecutivos
	                System.out.println("Siguientes 10 números al enviado:");
	                for (int i = 1; i <= 10; i++) {
	                    String respuesta = Integer.toString(numero + i);
	                    byte[] datosRespuesta = respuesta.getBytes();

	                    // Crear el paquete con el mensaje exacto
	                    DatagramPacket paqueteRespuesta = new DatagramPacket(
	                            datosRespuesta, 
	                            datosRespuesta.length, 
	                            direccionCliente, 
	                            puertoCliente
	                    );

	                    // Enviar el paquete al cliente
	                    socketUDP.send(paqueteRespuesta);
	                    System.out.println(respuesta);
	                }
	            }
	        } catch (IOException e) {
	            System.err.println("Error en el servidor: " + e.getMessage());
	        }
	    }
	

}
