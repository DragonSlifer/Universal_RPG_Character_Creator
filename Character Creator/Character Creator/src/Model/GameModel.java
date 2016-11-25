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
    private final static String binPath = "./src/bin";
    
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

    public static String getBinPath() {
        return binPath;
    }
    
    /**
     * Otros metodos
     */
}
