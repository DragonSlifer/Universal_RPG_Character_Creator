/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

/**
 *
 * @author Jorge
 */
public class Controller {

    static private View vista;
    static private Model modelo;
    
    

    /**
     *
     * @param vista
     * @param modelo
     */
    public Controller(View vista, Model modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setActionListener(new ActionListeners());
        vista.addWindowListener(new WindowListeners());
        vista.ChangeSize(900, 120);
        vista.setResize(false);
    }


    private static class ActionListeners implements ActionListener {

        /**
         *
         * @param ae
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            System.out.println("Controlller -- " + command + " command");
            switch (command) {
                case "PPCAT":
                    vista.ChangeComboBox();
                    break;
                case "PPJUE":
                    break;
                case "MSalir":
                    System.exit(0);
                case "MIni":
                    vista.changePanel("PP");
                    break;
                case "PPAceptar":
                    vista.changePanel(vista.getJue());
                    vista.ChangeSize(vista.getXsize(), vista.getYsize());
                                /**
                                 * ESTO ES MERAMENTE PARA DEBUG
                                 */
                                vista.setResize(true);
                                /**
                                 * ELIMINAR EN LA VERSIÓN FINAL
                                 */
                    String juego = vista.getJue();
                    vista.changePanel(juego);
                    modelo.setOtherModel(juego);
                    break;
                case "MSimuladorC":
                    vista.changeOtherPanel("SC");
                    vista.setResize(true);
                    vista.ChangeSize(755, 200);
                    break;
                case "LevelearC":
                    int x = modelo.Leveleo(vista.getBase(), vista.getCrit());
                    vista.Actual(Integer.toString(x));
                    break;
                case "VTMCompVTMAT":
                    Boolean retval = vista.Comprobar(command);
                    if (retval == false){
                        System.out.println("Controlller -- " + command + " have failed! There's some mistakes!");
                    }
                    break;
                case "VTM_CLAN_UPDATE":
                    Vector<String> param = vista.proccessViewCommand("VTM_CLAN_UPDATE",null);
                    modelo.processOtherModelCommand("VTM_CLAN_UPDATE",param);
                    break;
                default:
                    System.out.println(" not recognized");
                    break;
            }
        }
    }

    private static class WindowListeners extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }

    }
}
