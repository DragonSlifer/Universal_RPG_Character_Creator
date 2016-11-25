/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jorge
 */
public final class PanelPrincipal extends JPanel {

    private int JMax = 25;                        ///< Sirve para modificar la cantidad de juegos disponibles
    private int CMax = 10;                        ///< Sirve para modificar la cantidad de categorias maximas
    public JComboBox juegos;
    public JComboBox categorias;
    public JTextField jugador, personaje, cronica;
    public JButton aceptar;
    private Vector<String> sc;
    private String[][] sj;

    public PanelPrincipal() {
        String linea;
        int i = -1;
        int j = 0;
        File fread;
        BufferedReader bread;
        String path = System.getProperty("user.dir");

        try {

            fread = new File(processPath(path) + "/games.rpg");
            bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));

            sj = new String[CMax][JMax];
            sc = new Vector<>();

            while (((linea = bread.readLine()) != null) && ((j < JMax) || (i < CMax))) {        ///< Si se excete j o i, da error de lectura
                if (linea.charAt(0) == '[') {
                    linea = linea.replace("[", "").replace("]","");
                    sc.add(linea);
                    i++;
                    j = 0;
                    System.out.println("Vista -- PanelPrincipal -- Agregada la categoria: " + linea);
                } else {

                    sj[i][j] = linea;
                    j++;
                    System.out.println("Vista -- PanelPrincipal -- Agregado el juego: " + linea);
                }

            }
            if ((j > JMax) || (i > CMax)) {
                System.out.println("Vista -- PanelPrincipal: Se ha excedido el numero de categorias maximas o de juegos a cargar");
            }
            categorias = new JComboBox(sc);
            categorias.setActionCommand("PPCAT");
            categorias.setSelectedIndex(0);
            categorias = cleanBlankSpaces(categorias);

            juegos = new JComboBox();
            juegos.setActionCommand("PPJUE");
            ChangeComboBox();

            this.add(new JLabel("Categoria: "));
            this.add(categorias);
            this.add(new JLabel("Juego: "));
            this.add(juegos);

            jugador = new JTextField(10);

            personaje = new JTextField(10);

            cronica = new JTextField(10);

            aceptar = new JButton("Siguiente");

            aceptar.setActionCommand("PPAceptar");
            this.setLayout(new GridLayout(0,4));
            this.add(new JLabel("Jugador"));
            this.add(jugador);
            this.add(new JLabel("Personaje"));
            this.add(personaje);
            this.add(new JLabel("Cronica"));
            this.add(cronica);
            this.add(aceptar);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PanelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String processPath(String path) {
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

    public void ChangeComboBox() {
        juegos.removeAllItems();
        int i;

        i = categorias.getSelectedIndex();
        if (i > -1) {
            for (int x = 0; x < JMax; x++) {
                if (sj[i][x] != null)
                    juegos.addItem(sj[i][x]);
            }
        } else {
            System.out.println("Vista -- PanelPrincipal -- ChangeComboBox: No es posible cambiar a una categoria inexistente");
        }
        juegos = cleanBlankSpaces(juegos);
    }

    public void setActionListener(ActionListener al) {
        categorias.addActionListener(al);
        juegos.addActionListener(al);
        aceptar.addActionListener(al);
    }

    public void setJMax(int x) {
        if (x > JMax) {
            this.JMax = x;
        }
    }

    public void setCMax(int x) {
        if (x > CMax) {
            this.CMax = x;
        }
    }

    public String getCat() {
        return (String) categorias.getSelectedItem();
    }

    public String getJue() {
        return (String) juegos.getSelectedItem();
    }

    public String getJug() {
        return jugador.getText();
    }

    public String getPer() {
        return personaje.getText();
    }

    public String getCron() {
        return cronica.getText();
    }

    private JComboBox cleanBlankSpaces(JComboBox c) {
        for (int i = 0; i < c.getItemCount();i++){
            c.setSelectedIndex(i);
            if(((String)c.getSelectedItem() == " ") || ((String)c.getSelectedItem() == "")|| (c.getSelectedItem() == null))
                c.removeItemAt(i);
        }
        c.setSelectedIndex(0);
        return c;
    }

}
