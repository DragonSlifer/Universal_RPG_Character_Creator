/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Font;
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
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Jorge
 */
public class VTM extends JPanel {

    /**
     * Tamaño
     */
    private static final int WCOORD = 1209;
    private static final int HCOORD = 250;
    /**
     * Información básica
     */
    private JComboBox Rango;                    ///< Neonato, Ancilla, Antiguo, Matusanal, Antediluviano,... (VTM_Ranks.rpg)
    private JComboBox Senda;                    ///< Sendas de la iluminación. (VTM_Ilumination_Paths.rpg)
    private JComboBox Disciplinas;              ///< Disciplinas. Incluye todas las disciplinas (VTM_Disciplines.rpg)
    private JTextField Puntos_de_Experiencia;
    private JTextField Puntos_Gratuitos;
    /**
     * Paneles
     */
    private JTabbedPane tabedPane;              ///< Panel principal
    private JPanel expPanel;                    ///< Panel de experiencia y puntos gratuitos
    private VTMBI vtmbi;                        ///< Panel de información básica    
    private VTMAT vtmat;                        ///> Panel de atributos
    /**
     * Carga de datos
     */
    private final static String binPath = "./src/bin";
    /**
     * Datos cargados
     */
    private Vector<String> Clans;
    private Vector<String> Disciplines;
    private Vector<String> Paths;
    private Vector<String> OtherPaths;          ///< Sendas de taumaturgia, nigromancia...
    private Vector<String> Rituals;             ///< Guarda los rituales de una categoria
    private Vector<String> Afiliations;
    private Vector<String> Concepts;
    private Vector<String> Nature;
    private Vector<String> Demeanor;
    private Vector<String> Ranks;
    private Vector<String> Backgrounds;

    /**
     * Misc.
     */
    private Font Morpheus;

    public VTM() {
        /**
         * Informacion Basica
         */
        Puntos_de_Experiencia = new JTextField();
        Puntos_Gratuitos = new JTextField();

        Puntos_Gratuitos.setText("15");
        Puntos_Gratuitos.setEditable(false);

        try {
            System.out.println("Vista -- VTM -- Iniciada la lectura del fichero");

            /**
             * Inicializacion de los vectores
             */
            Clans = new Vector<>();
            Afiliations = new Vector<>();
            Disciplines = new Vector<>();
            Paths = new Vector<>();
            Nature = new Vector<>();
            Demeanor = new Vector<>();
            Ranks = new Vector<>();
            Backgrounds = new Vector<>();
            Concepts = new Vector<>();
            OtherPaths = new Vector<>();

            /**
             * Carga de los ComboBox
             */
            String path = System.getProperty("user.dir");
            path = binPath;
            Clans = readClans(path + "/VTM/VTM_Clans.rpg");
            Afiliations = readAfiliations(path + "/VTM/VTM_Afiliations.rpg");
            Disciplines = readDisciplines(path + "/VTM/VTM_Disciplines.rpg");
            Paths = readPaths(path + "/VTM/VTM_Ilumination_Paths.rpg");
            Nature = readNatures(path + "/VTM/VTM_Nature.rpg");
            Demeanor = Nature;
            Ranks = readRanks(path + "/VTM/VTM_Ranks.rpg");
            Backgrounds = readBackgrounds(path + "/VTM/VTM_Backgrounds.rpg");
            Concepts = readConcepts(path + "/VTM/VTM_Concepts.rpg");

            System.out.println("Vista -- VTM -- Finalizada la lectura del fichero");
        } catch (FileNotFoundException ex1) {
            System.out.println("Vista -- VTM -- ERROR DE LECTURA DE FICHERO: ALGUN FICHERO NO EXISTE");
            Logger.getLogger(VTM.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (IOException ex) {
            Logger.getLogger(VTM.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * Fin de lectura del fichero VTM_INFO.rpg
         */
        Disciplinas = new JComboBox(Disciplines);
        Rango = new JComboBox(Ranks);
        Senda = new JComboBox(Paths);
        /**
         * Interfaz gráfica
         */
        Morpheus = new Font("Morpheus", Font.PLAIN, 16);
        this.setLayout(new BorderLayout());
        this.tabedPane = new JTabbedPane();
        vtmbi = new VTMBI(Clans, Afiliations, Concepts, Nature, Demeanor);
        vtmbi.setMainFont(Morpheus);
        vtmat = new VTMAT();
        tabedPane.addTab("Info Básica", vtmbi);
        tabedPane.addTab("Atributos", vtmat);

        this.add(tabedPane, "Center");
    }

    /**
     * Lee todos los clanes del fichero de clanes
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private Vector<String> readClans(String path) throws FileNotFoundException, IOException {
        Vector<String> Clanes = new Vector<>();
        File fread;
        BufferedReader bread;
        String linea;

        fread = new File(path);
        bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));

        while ((linea = bread.readLine()) != null) {
            Clanes.add(linea);
            System.out.println("Vista -- VTM -- Clan leido: " + linea);
        }
        bread.close();
        return Clanes;
    }

    /**
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private Vector<String> readAfiliations(String path) throws FileNotFoundException, IOException {
        Vector<String> Afiliaciones = new Vector<>();
        File fread;
        BufferedReader bread;
        String linea;

        fread = new File(path);
        bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));

        while ((linea = bread.readLine()) != null) {
            Afiliaciones.add(linea);
            System.out.println("Vista -- VTM -- Afiliacion leida: " + linea);
        }
        bread.close();
        return Afiliaciones;
    }

    /**
     *
     * @param path
     * @return
     * @throws IOException
     */
    private Vector<String> readDisciplines(String path) throws IOException {
        Vector<String> Disciplinas = new Vector<>();
        File fread;
        BufferedReader bread;
        String linea;

        fread = new File(path);
        bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));

        while ((linea = bread.readLine()) != null) {
            Disciplinas.add(linea);
            System.out.println("Vista -- VTM -- Disciplina leida: " + linea);
        }
        bread.close();
        return Disciplinas;
    }

    /**
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private Vector<String> readPaths(String path) throws FileNotFoundException, IOException {
        Vector<String> SendasIluminacion = new Vector<>();
        File fread;
        BufferedReader bread;
        String linea;

        fread = new File(path);
        bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));

        while ((linea = bread.readLine()) != null) {
            SendasIluminacion.add(linea);
            System.out.println("Vista -- VTM -- Senda de la Iluminación leida: " + linea);
        }
        bread.close();
        return SendasIluminacion;
    }

    /**
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private Vector<String> readNatures(String path) throws FileNotFoundException, IOException {
        Vector<String> Nat = new Vector<>();
        File fread;
        BufferedReader bread;
        String linea;

        fread = new File(path);
        bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));

        while ((linea = bread.readLine()) != null) {
            Nat.add(linea);
            System.out.println("Vista -- VTM -- Naturaleza leida: " + linea);
        }
        bread.close();
        return Nat;
    }

    /**
     *
     * @param path
     * @return
     * @throws IOException
     */
    private Vector<String> readRanks(String path) throws IOException {
        Vector<String> Rangos = new Vector<>();
        File fread;
        BufferedReader bread;
        String linea;

        fread = new File(path);
        bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));

        while ((linea = bread.readLine()) != null) {
            Rangos.add(linea);
            System.out.println("Vista -- VTM -- Rango leida: " + linea);
        }
        bread.close();
        return Rangos;
    }

    /**
     *
     * @param path
     * @return
     * @throws IOException
     */
    private Vector<String> readBackgrounds(String path) throws IOException {
        Vector<String> Trasfondos = new Vector<>();
        File fread;
        BufferedReader bread;
        String linea;

        fread = new File(path);
        bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));

        while ((linea = bread.readLine()) != null) {
            Trasfondos.add(linea);
            System.out.println("Vista -- VTM -- Trasfondo leido: " + linea);
        }
        bread.close();
        return Trasfondos;
    }

    /**
     *
     * @param path
     * @return
     * @throws IOException
     */
    private Vector<String> readConcepts(String path) throws IOException {
        Vector<String> Conceptos = new Vector<>();
        File fread;
        BufferedReader bread;
        String linea;

        fread = new File(path);
        bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));

        while ((linea = bread.readLine()) != null) {
            Conceptos.add(linea);
            System.out.println("Vista -- VTM -- Concepto leido: " + linea);
        }
        bread.close();
        return Conceptos;
    }

    /**
     *
     * @param nameDiscipline
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Vector<String> readOtherPath(String nameDiscipline) throws FileNotFoundException, IOException {
        Vector<String> Path = new Vector<>();
        File file;
        BufferedReader bread;
        String linea;
        nameDiscipline = nameDiscipline.replace("*", "");
        switch (nameDiscipline) {
            case "Hechicería Assamita":
                nameDiscipline = "Hechiceria_Assamita";
                break;
            case "Hechicería Setita":
                nameDiscipline = "Hechiceria_Setita";
                break;
            case "Taumaturgia Sielánica":
                nameDiscipline = "Taumaturgia_Sielanica";
                break;
            case "Hechicería Koldun":
                nameDiscipline = "Hechiceria_Koldun";
                break;
            default:
                nameDiscipline = nameDiscipline.replace(' ', '_');
        }
        String path = binPath;
        file = new File(path + "/VTM/VTM_Sendas_" + nameDiscipline + ".rpg");
        bread = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
        while ((linea = bread.readLine()) != null) {
            Path.add(linea);
            System.out.println("Vista -- VTM -- Camino leido: " + linea);
        }

        return Path;
    }

    public int getWcoord() {
        return WCOORD;
    }

    public int getHcoord() {
        return HCOORD;
    }

    public void setActionListeners(ActionListener al) {
        vtmat.setActionListeners(al);
    }

    public boolean Comprobar(String command) {
        boolean retval = false;
        switch (command) {
            case "VTMCompVTMAT":
                retval = vtmat.Comprobar();
                break;
        }
        return retval;
    }

}
