/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Jorge
 */
public class Menu extends JMenuBar {

    JMenu Inicio, Ayuda, Herramientas;
    JMenuItem Cargar, Guardar, Salir, HowTo, Creditos, SimuladorLeveleo, Ini;

    public Menu() {
        Inicio = new JMenu("Inicio");

        Ayuda = new JMenu("Ayuda");
        
        Herramientas = new JMenu ("Herramientas");
        
        Ini = new JMenuItem("Inicio");
        Ini.setActionCommand("MIni");
        
        Cargar = new JMenuItem("Cargar Ficha...");
        Cargar.setActionCommand("MCargar");

        Guardar = new JMenuItem("Guardar Ficha...");
        Guardar.setActionCommand("MGuardar");

        Salir = new JMenuItem("Salir");
        Salir.setActionCommand("MSalir");

        HowTo = new JMenuItem("Uso de la aplicacion detallado...");
        HowTo.setActionCommand("MAyuda");

        Creditos = new JMenuItem("Creditos");
        Creditos.setActionCommand("MCreditos");
        
        SimuladorLeveleo = new JMenuItem("Simulador leveleo Cthulhu");
        SimuladorLeveleo.setActionCommand("MSimuladorC");

        Inicio.add(Ini);
        Inicio.add(Cargar);
        Inicio.add(Guardar);
        Inicio.add(Salir);

        Ayuda.add(HowTo);
        Ayuda.add(Creditos);
        
        Herramientas.add(SimuladorLeveleo);

        this.add(Inicio);
        this.add(Herramientas);
        this.add(Ayuda);
    }

    public void setActionListener(ActionListener al) {
        Ini.addActionListener(al);
        Cargar.addActionListener(al);
        Guardar.addActionListener(al);
        Salir.addActionListener(al);
        HowTo.addActionListener(al);
        Creditos.addActionListener(al);
        SimuladorLeveleo.addActionListener(al);
    }
}
