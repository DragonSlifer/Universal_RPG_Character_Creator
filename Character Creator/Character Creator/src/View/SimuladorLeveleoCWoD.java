/*
 *  Role Game Character Creator
 *  Con este programa podr�s crear
 *  fichas de rol para varios sistemas de
 *  juego, como el Mundo de Tinieblas o
 *  el NSD20
 */
package View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author Jorge
 */
public class SimuladorLeveleoCWoD extends JPanel {

    int[] valores;                              ///< Valores del leveleo.
    String[] juegos = {"Vampiro", "Hombre Lobo", "Demonio", "Mago", "Changeling", "Cazador"};
    JComboBox tipo, nivelbase, nivelasubir, juego;

    public SimuladorLeveleoCWoD() {
        juego = new JComboBox(juegos);
    }

    public void readValores(String s) {
        String linea;
        int i = 0;
        try {
            BufferedReader bread;
            bread = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\Jorge\\Dropbox\\Character Creator\\Bin\\" + s + "\\valores.rpg")), "ISO-8859-1"));
            while ((linea = bread.readLine()) != null){
                valores[i] = Integer.parseInt(linea);
                i++;
            }
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(SimuladorLeveleoCWoD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimuladorLeveleoCWoD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
