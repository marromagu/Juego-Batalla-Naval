/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author mario
 */
public class DatosJugador implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int idJugador;
    private final String usuario;
    private final int contraseña;
    private  HashMap<Integer, String> listaPartidaTermindas;
    private  HashMap<Integer, String> listaPartidasMiTurno;
    private  HashMap<Integer, String> listaPartidasSuTurno;

    public DatosJugador(int idJugador, String usuario, int contraseña, HashMap<Integer, String> listaPartidaTermindas, HashMap<Integer, String> listaPartidasMiTurno, HashMap<Integer, String> listaPartidasSuTurno) {
        this.idJugador = idJugador;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.listaPartidaTermindas = listaPartidaTermindas;
        this.listaPartidasMiTurno = listaPartidasMiTurno;
        this.listaPartidasSuTurno = listaPartidasSuTurno;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public HashMap<Integer, String> getListaPartidaTermindas() {
        return listaPartidaTermindas;
    }

    public HashMap<Integer, String> getListaPartidasMiTurno() {
        return listaPartidasMiTurno;
    }

    public HashMap<Integer, String> getListaPartidasSuTurno() {
        return listaPartidasSuTurno;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DatosJugador{");
        sb.append("idJugador=").append(idJugador);
        sb.append(", usuario=").append(usuario);
        sb.append(", contrase\u00f1a=").append(contraseña);
        sb.append(", listaPartidaTermindas=").append(listaPartidaTermindas);
        sb.append(", listaPartidasMiTurno=").append(listaPartidasMiTurno);
        sb.append(", listaPartidasSuTurno=").append(listaPartidasSuTurno);
        sb.append('}');
        return sb.toString();
    }

    public void setListaPartidaTermindas(HashMap<Integer, String> listaPartidaTermindas) {
        this.listaPartidaTermindas = listaPartidaTermindas;
    }

    public void setListaPartidasMiTurno(HashMap<Integer, String> listaPartidasMiTurno) {
        this.listaPartidasMiTurno = listaPartidasMiTurno;
    }

    public void setListaPartidasSuTurno(HashMap<Integer, String> listaPartidasSuTurno) {
        this.listaPartidasSuTurno = listaPartidasSuTurno;
    }

}
