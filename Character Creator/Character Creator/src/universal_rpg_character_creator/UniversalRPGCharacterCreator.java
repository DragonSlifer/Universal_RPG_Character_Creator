/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universal_rpg_character_creator;

import Controller.Controller;
import Model.Model;
import View.View;
import java.io.IOException;

/**
 *
 * @author Jorge
 */
public class UniversalRPGCharacterCreator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Model modelo;
        modelo = new Model();

        View vista;
        vista = new View("Rol v0.1");

        Controller controlador = new Controller(vista, modelo);

        vista.setVisible(true);
        
    }

}
