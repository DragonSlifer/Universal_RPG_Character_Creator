/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jorge
 */
public class View extends JFrame {

    public PanelPrincipal pp;
    public Menu menu;
    public CardLayout cardLayout;
    public String juego;
    public JPanel p;
    public SimuladorLeveleoCthulhu s;
    public SimuladorLeveleoCWoD scwod;
    private VTM vtm;
    private Plenilunio mtp;

    public View(String c) throws IOException {
        super(c);
        p = new JPanel();
        pp = new PanelPrincipal();
        s = new SimuladorLeveleoCthulhu();
        //scwod = new SimuladorLeveleoCWoD();
        menu = new Menu();
        this.setJMenuBar(menu);
        cardLayout = new CardLayout();
        p.setLayout(cardLayout);
        p.add(pp, "PP");
        p.add(s, "SC");
        /**
         * Paneles de Fichas de Juego | | V
         */
        mtp = new Plenilunio();
        vtm = new VTM();
        /**
         * ^
         * |
         * |
         * Paneles de Fichas de Juego
         */
        p.add(mtp, "Malefic Time: Plenilunio");
        p.add(vtm, "Vampiro: La Mascarada");

        this.add(p);
    }

    public void setActionListener(ActionListener al) {
        pp.setActionListener(al);
        menu.setActionListener(al);
        s.setActionListener(al);
        vtm.setActionListeners(al);
    }

    public int getBase() {
        return s.getBase();
    }

    public int getCrit() {
        return s.getCrit();
    }

    public void Actual(String x) {
        s.Actual(x);
    }

    public void setResize(boolean b) {
        this.setResizable(b);
    }

    public void ChangeSize(int x, int y) {
        this.setSize(x, y);
    }

    public int getXsize() {
        int x;
        switch (juego) {
            case "Malefic Time: Plenilunio":
                x = 755;
                break;
            case "Vampiro: La Mascarada":
                x = vtm.getWcoord();
                break;
            default:
                x = 755;
                break;
        }
        return x;
    }

    public int getYsize() {
        int y;
        switch (juego) {
            case "Malefic Time: Plenilunio":
                y = 755;
                break;
            case "Vampiro: La Mascarada":
                y = vtm.getHcoord();
                break;
            default:
                y = 963;
                break;
        }
        return y;
    }

    public void ChangeComboBox() {
        pp.ChangeComboBox();
    }

    public String getCat() {
        return pp.getCat();
    }

    public String getJue() {
        return pp.getJue();
    }

    public String getJug() {
        return pp.getJug();
    }

    public String getPer() {
        return pp.getPer();
    }

    public String getCron() {
        return pp.getCron();
    }

    public void changePanel(String s) {
        this.juego = s;
        cardLayout.show(this.p, juego);
    }

    public void changeOtherPanel(String s) {
        cardLayout.show(this.p, s);
    }

    public boolean Comprobar(String command) {
        boolean retval = false;
        switch (command){
            case "VTMCompVTMAT":
                retval = vtm.Comprobar(command);
                break;
        }
        return retval;
    }

    
}
