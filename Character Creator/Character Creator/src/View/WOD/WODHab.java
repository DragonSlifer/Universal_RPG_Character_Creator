/*
 *  Role Game Character Creator
 *  Con este programa podrás crear
 *  fichas de rol para varios sistemas de
 *  juego, como el Mundo de Tinieblas o
 *  el NSD20
 */
package View.WOD;

import java.awt.GridLayout;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jorge
 */
public abstract class WODHab extends JPanel {

    private Vector<JTextField> Habilidades; ///< Array de JTextFields que se guardarán cada habilidad.
    private Vector<String> HabilidadesText; ///< Array de String que se guarda el nombre de cada habilidad.
    private JButton Comprobar;
    private Vector<String> identifiers;

    /**
     * Metodo abstracto. Este metodo nos permitirá poner la ruta del fichero de
     * habilidades.
     *
     * @param path
     */
    @Override
    public abstract String toString();              ///< Devuelve el nombre de la clase
    /**
     * Carga de datos
     */
    private final static String binPath = "./src/bin/WOD";  ///< Ruta a la carpeta de World Of Darkness
    private static String path = binPath;                   ///< Ruta al fichero de habilidades
    private static String mode;                             ///< Pone el tipo de juego
    private static String pathModeIdentifiers;              ///< Ruta a los identificadores

    public WODHab() {
        Habilidades = new Vector<>();
        HabilidadesText = new Vector<>();
        identifiers  = new Vector<>();
    }

    public void Update() {
        
        switch (this.mode) {
            case "VTM":
                pathModeIdentifiers = "/"+ mode + "/VTM_ClanIdentifiers.rpg";
                break;
        }
        
        this.readIdentifiers();
        this.readHabilities();
        this.HabilidadesText = this.filtro();

        this.setLayout(new GridLayout(0, 2));

        for (int i = 0; i < HabilidadesText.size(); i++) {
            this.add(new JLabel(HabilidadesText.elementAt(i)));
            Habilidades.add(new JTextField());
            this.add(Habilidades.elementAt(Habilidades.size() - 1));
        }
    }

    private void readIdentifiers() {
        try {
            String identifier;
            File fread;
            BufferedReader bread;
            fread = new File(binPath + pathModeIdentifiers);
            bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));

            while ((identifier = bread.readLine()) != null) {
                identifiers.add(identifier);
            }
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
            Logger.getLogger(WODHab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WODHab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este metodo actuará de filtro de las habilidades que no son de vampiro.
     *
     * @return
     */
    private Vector filtro() {
        for (int i = 0; i < HabilidadesText.size(); i++) {
            if ((!matchesSomeIdentifier(HabilidadesText.elementAt(i)))) {
                HabilidadesText.remove(i);
                i--;
            }
        }
        return HabilidadesText;
    }

    /**
     * Comprueba si una cadena contiene un identificador valido
     *
     * @param elementAt
     * @return
     */
    private boolean matchesSomeIdentifier(String elementAt) {
        boolean matches = false;
        String identifier;
        for (int i = 0; i < identifiers.size(); i++) {
            identifier = identifiers.elementAt(i);
            if (elementAt.contains(identifier)) {
                matches = true;
            }
        }
        return matches;
    }

    private void readHabilities() {
        try {
            String hability;
            File fread;
            BufferedReader bread;
            fread = new File(path);
            bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));

            while ((hability = bread.readLine()) != null) {
                HabilidadesText.add(hability);
            }
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
            Logger.getLogger(WODHab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WODHab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Vector<JTextField> getHabilidades() {
        return Habilidades;
    }

    public void setHabilidades(Vector<JTextField> Habilidades) {
        this.Habilidades = Habilidades;
    }

    public Vector<String> getHabilidadesText() {
        return HabilidadesText;
    }

    public void setHabilidadesText(Vector<String> HabilidadesText) {
        this.HabilidadesText = HabilidadesText;
    }

    public JButton getComprobar() {
        return Comprobar;
    }

    public void setComprobar(JButton Comprobar) {
        this.Comprobar = Comprobar;
    }

    public Vector<String> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Vector<String> identifiers) {
        this.identifiers = identifiers;
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        WODHab.path = path;
    }

    public void setRoute(String path) {
        WODHab.setPath(WODHab.getPath() + path);
    }

    public static String getMode() {
        return mode;
    }

    public static void setMode(String mode) {
        WODHab.mode = mode;
    }

    public static String getPathModeIdentifiers() {
        return pathModeIdentifiers;
    }

    public static void setPathModeIdentifiers(String pathModeIdentifiers) {
        WODHab.pathModeIdentifiers = pathModeIdentifiers;
    }

    
}
