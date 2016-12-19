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
public class VTMHCon extends WODHab{
    public VTMHCon() {
        super();
        this.setRoute("/WOD_Knowledges.rpg");
        this.setMode("VTM");
        this.Update();
    }

    @Override
    public String toString() {
        return "VTMHCon";
    }
    
}
