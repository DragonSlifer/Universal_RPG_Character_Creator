/*
 *  Role Game Character Creator
 *  Con este programa podrás crear
 *  fichas de rol para varios sistemas de
 *  juego, como el Mundo de Tinieblas o
 *  el NSD20
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase se encarga de gestionar la información de Vampiro: La Mascarada
 *
 * @author darkange
 */
public class VTM extends GameModel {

    /**
     * Atributos particulares. Estos atributos son exclusivos de la clase
     */
    ///< Informacion
    private String clan;
    ///< Atributos
    private int[] atr_fis, atr_soc, atr_ment;
    private Vector<String> atr_class;
    ///< Habilidades
    private int[] hab_tal, hab_tec, hab_con;
    private Vector<String> hab_class;
    ///< Ventajas
    ///< Disciplinas

    private Vector<String> disicipline_desc;
    private Vector<String> discipline_name;

    /**
     * Constructor del modelo VTM
     *
     * @param cn
     */
    public VTM(String cn) {
        super(cn);
        /**
         * Atributos. Se asigna un espacio de vector de 4 para dar la
         * posibilidad de generar un personaje de forma aleatoria.
         */
        atr_fis = new int[4];
        atr_soc = new int[4];
        atr_ment = new int[4];
        atr_class = new Vector<>();
        for (int i = 0; i < 3; i++) {    ///< Puntos Base
            atr_fis[i + 1] = 1;
            atr_soc[i + 1] = 1;
            atr_ment[i + 1] = 1;
        }
    }

    @Override
    public void aleatoriol() {
        try {
            Random r = new Random();    ///< Genero un numero aleatorio
            int a, b, c;                ///< Guarda el orden de las clases de numeros aleatorios
            boolean end = false;
            String path = System.getProperty("user.dir");
            path = processPath(path);
            selectRandomClan(r.nextInt(58) + 1, path + "/VTM/VTM_Clans.rpg");
            while (atr_class.size() != 3) {
                int aux = r.nextInt(3) + 1;
                switch (aux) {
                    case 1:
                        if (!atr_class.contains("Primarios")) {
                            atr_class.add("Primarios");
                        }
                        a = atr_class.indexOf("Primarios");
                        break;
                    case 2:
                        if (!atr_class.contains("Secundarios")) {
                            atr_class.add("Secundarios");
                        }
                        b = atr_class.indexOf("Secundarios");
                        break;
                    case 3:
                        if (!atr_class.contains("Terciarios")) {
                            atr_class.add("Terciarios");
                        }
                        c = atr_class.indexOf("Terciarios");
                        break;
                }
            }   while (!end) {
                
            }   end = false;
        } catch (IOException ex) {
            Logger.getLogger(VTM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lee todos los clanes del fichero de clanes y selecciona el que se
     * encuentra en i.
     *
     * @param i
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void selectRandomClan(int i, String path) throws FileNotFoundException, IOException {
        Vector<String> Clanes = new Vector<>();
        File fread;
        BufferedReader bread;
        String linea;
        int x = 0;
        fread = new File(path);
        bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));

        while (((linea = bread.readLine()) != null) && (x <= i)) {
            if (x == i) {
                this.clan = linea;
                System.out.println("Model -- GameModel(VTM) -- Clan Asignado: " + linea);
            } else {
                System.out.println("Model -- GameModel(VTM) -- Clan No Asignado: " + linea);
            }
            x++;
        }
        bread.close();
    }

    
}
