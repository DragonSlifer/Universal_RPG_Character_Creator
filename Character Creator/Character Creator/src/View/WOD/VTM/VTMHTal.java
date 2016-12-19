/*
 *  Role Game Character Creator
 *  Con este programa podr�s crear
 *  fichas de rol para varios sistemas de
 *  juego, como el Mundo de Tinieblas o
 *  el NSD20
 */
package View.WOD.VTM;

import View.WOD.WODHab;

/**
 *
 * @author Jorge
 */
public class VTMHTal extends WODHab{
    public VTMHTal() {
        super();
        this.setRoute("/WOD_Skills.rpg");
        this.setMode("VTM");
        this.Update();
    }

    @Override
    public String toString() {
        return "VTMHTec";
    }
    
}
