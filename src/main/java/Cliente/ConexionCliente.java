/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Cliente;

import Datos.DatosJugador;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mario
 */
public final class ConexionCliente {

    private static ConexionCliente miCliente = null;
    private DatosJugador misDatos;
    private Socket socketCliente;
    private DataInputStream flujo_entrada;
    private DataOutputStream flujo_salida;
    private ObjectInputStream objeto_entrada;
    private HashMap<Integer, String> listaUsuario;

    public static ConexionCliente getCliente() {
        if (miCliente == null) {
            miCliente = new ConexionCliente();
        }
        return miCliente;
    }

    public ConexionCliente() {
        establecerConexion();
    }

    public void establecerConexion() {
        final String HOST = "localhost";
        final int PUERTO = 2001;
        try {
            // Conectar al servidor
            socketCliente = new Socket(HOST, PUERTO);
            listaUsuario = new HashMap<>();
            // Inicializar flujos de entrada y salida para la comunicación con el servidor
            flujo_entrada = new DataInputStream(socketCliente.getInputStream());
            flujo_salida = new DataOutputStream(socketCliente.getOutputStream());
            objeto_entrada = new ObjectInputStream(socketCliente.getInputStream());

        } catch (IOException e) {
            System.out.println("--> Error en la conexión con el servidor: " + e.getMessage());
        }
    }

    //Método para mandar los datos del login
    public boolean login(String usuario, int contraseña) {
        try {
            //Mandamos al servidor el Usuario y la contraseña
            flujo_salida.writeUTF(usuario);
            flujo_salida.writeInt(contraseña);
            listaUsuario = (HashMap<Integer, String>) recibirObjeto();
            System.out.println(listaUsuario);
            misDatos = (DatosJugador) recibirObjeto();
            return true;
        } catch (IOException ex) {
            System.out.println("--> ERROR: mandarDatosLogin: " + ex.getMessage());
        }
        return false;

    }

    public ArrayList<String> repeticion(int id_partida) {
        ArrayList<String> listaRepeticion = null;
        try {
            flujo_salida.writeInt(1);
            flujo_salida.writeInt(id_partida);
            listaRepeticion = (ArrayList<String>) recibirObjeto();
            return listaRepeticion;
        } catch (IOException ex) {
            System.out.println("--> ERROR:HashMap<Integer, String> repeticion: " + ex.getMessage());
            return listaRepeticion;
        }

    }

    public boolean solicitarRendirse(int id_partida) {
        try {
            flujo_salida.writeInt(2);
            System.out.println(misDatos.getListaPartidasSuTurno().get(id_partida));
            misDatos.getListaPartidasSuTurno().remove(id_partida);
            flujo_salida.writeInt(getMisDatos().getIdJugador());
            flujo_salida.writeInt(id_partida);
            return flujo_entrada.readBoolean();

        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("--> Error al enviar id_partida: " + ex.getMessage());

        }
        return false;
    }

    public void hacerDisparo(int id_partida, int x, int y) {
        try {
            flujo_salida.writeInt(3);
            flujo_salida.writeInt(getMisDatos().getIdJugador());
            flujo_salida.writeInt(id_partida);
            flujo_salida.writeInt(x);
            flujo_salida.writeInt(y);
            misDatos.getListaPartidasMiTurno().remove(id_partida);
        } catch (IOException ex) {
            System.out.println("--> ERROR: Al Hacer Disparo: " + ex.getMessage());

        }
    }

    public void actualizarListaDePartidas() {
        try {
            flujo_salida.writeInt(4);
            misDatos.setListaPartidaTermindas((HashMap<Integer, String>) recibirObjeto());
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int crearNuevaPartida(int id_Jugador2) {
        int id_partida = 0;
        try {
            flujo_salida.writeInt(5);
            flujo_salida.writeInt(misDatos.getIdJugador());
            flujo_salida.writeInt(id_Jugador2);
            id_partida = flujo_entrada.readInt();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_partida;
    }

    // Método para recibir un objeto por socket
    public Object recibirObjeto() {
        try {
            return objeto_entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("--> Error al recibir el objeto por el socket: " + e.getMessage());
            return null;
        }
    }

    public DatosJugador getMisDatos() {
        return misDatos;
    }

    public void setMisDatos(DatosJugador misDatos) {
        this.misDatos = misDatos;
    }

    public void cerrarConexiones() {
        try {
            listaUsuario.remove(misDatos.getIdJugador());
            // Cierra la conexión del cliente y otros recursos
            if (socketCliente != null && !socketCliente.isClosed()) {
                socketCliente.close();
                System.out.println("--> Conexión del cliente cerrada.");
            }

            // Cierra flujos de entrada y salida
            if (flujo_entrada != null) {
                flujo_entrada.close();
            }
            if (flujo_salida != null) {
                flujo_salida.close();
            }
        } catch (IOException e) {
            System.out.println("--> Error al cerrar conexiones: " + e.getMessage());
        }
    }

    public HashMap<Integer, String> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(HashMap<Integer, String> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

}
