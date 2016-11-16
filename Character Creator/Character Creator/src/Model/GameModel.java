/*
 *  Role Game Character Creator
 *  Con este programa podrás crear
 *  fichas de rol para varios sistemas de
 *  juego, como el Mundo de Tinieblas o
 *  el NSD20
 */
package Model;

import java.util.Date;

/**
 *
 * @author darkange
 */
public abstract class GameModel {

    /**
     * Atributos del Personaje
     */
    private String name, player, ClassName;
    private Date fecha_de_creacion, fecha_de_modificacion;

    public GameModel(String cn) {
        if (!cn.equals(null))
            ClassName = cn;
    }
    /**
     * Metodos abstractos
     */
    public abstract void aleatoriol();
    /**
     * Getters y setters
     */
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Date getFecha_de_creacion() {
        return fecha_de_creacion;
    }

    public void setFecha_de_creacion(Date fecha_de_creacion) {
        this.fecha_de_creacion = fecha_de_creacion;
    }

    public Date getFecha_de_modificacion() {
        return fecha_de_modificacion;
    }

    public void setFecha_de_modificacion(Date fecha_de_modificacion) {
        this.fecha_de_modificacion = fecha_de_modificacion;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }
    
    /**
     * Otros metodos
     */

    /**
     * Procesa el camino y devuelve la ruta de este
     * @param path
     * @return
     */
    public String processPath(String path) {
        boolean finished = false;
        int i = 0;
        String aux = "", aux2 = "";
        while (finished == false) {
            i++;
            do {
                aux2 += path.charAt(i);
                i++;
            } while (path.charAt(i) != '/');
            aux = aux + "/" + aux2;
            aux2 = "";
            if (aux.contains("Character Creator")) {
                finished = true;
            }
        }
        aux = aux + "/Bin";
        path = aux;
        return path;
    }
}
