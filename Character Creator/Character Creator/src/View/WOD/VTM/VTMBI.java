/*
 *  Role Game Character Creator
 *  Con este programa podr�s crear
 *  fichas de rol para varios sistemas de
 *  juego, como el Mundo de Tinieblas o
 *  el NSD20
 */
package View.WOD.VTM;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author darkange
 */
public class VTMBI extends JPanel {

    private JComboBox Clan;                     ///< Incluye antitribus, lineas de sangre y variaciones (VTM_Clans.rpg)
    private JComboBox Afiliacion;               ///< Camarilla, Sabbat, Anarquistas, Independientes, Nodistas,... (VTM_Afiliation.rpg)
    private JComboBox Concepto;                 ///< Conceptos. Se pueden agregar nuevos a traves del fichero (VTM_Concepts.rpg)
    private JComboBox Naturaleza;               ///< Naturaleza. Se pueden agregar nuevos a traves del fichero (VTM_Nature.rpg)
    private JComboBox Conducta;                 ///< Conducta. Se pueden agregar nuevos a traves del fichero (VTM_Demeanor.rpg)
    private JComboBox Generacion;               ///< Generación del personaje
    private JTextField Nombre;                  ///< Nombre del personaje
    private JTextField Jugador;                 ///< Nombre del jugador
    private JTextField Cronica;                 ///< Nombre de la crónica

    /**
     *
     * @param Clans
     * @param Afiliations
     * @param Concepts
     * @param Nature
     * @param Demeanor
     */
    public VTMBI(Vector<String> Clans, Vector<String> Afiliations, Vector<String> Concepts, Vector<String> Nature, Vector<String> Demeanor) {
        /**
         * LLENADO DE LOS JCOMBOBOX
         */
        Clan = new JComboBox(Clans);
        Afiliacion = new JComboBox(Afiliations);
        Concepto = new JComboBox(Concepts);
        Naturaleza = new JComboBox(Nature);
        Conducta = new JComboBox(Demeanor);
        Generacion = new JComboBox();
        for (int i = 15; i >= 2; i--) {
            Generacion.addItem((Integer.toString(i)) + "º");    ///< Dejará los numeros en formato iº
        }

        Nombre = new JTextField();
        Jugador = new JTextField();
        Cronica = new JTextField();

        this.setLayout(new GridLayout(3, 6));
        this.add(new JLabel("Nombre:"));
        this.add(Nombre);
        this.add(new JLabel("Naturaleza:"));
        this.add(Naturaleza);
        this.add(new JLabel("Clan:"));
        this.add(Clan);
        this.add(new JLabel("Jugador:"));
        this.add(Jugador);
        this.add(new JLabel("Conducta:"));
        this.add(Conducta);
        this.add(new JLabel("Generación:"));
        this.add(Generacion);
        this.add(new JLabel("Crónica:"));
        this.add(Cronica);
        this.add(new JLabel("Concepto:"));
        this.add(Concepto);
        this.add(new JLabel("Afiliación:"));
        this.add(Afiliacion);
    }

    public JComboBox getClan() {
        return Clan;
    }

    public JComboBox getAfiliacion() {
        return Afiliacion;
    }

    public JComboBox getConcepto() {
        return Concepto;
    }

    public JComboBox getNaturaleza() {
        return Naturaleza;
    }

    public JComboBox getConducta() {
        return Conducta;
    }

    public JComboBox getGeneracion() {
        return Generacion;
    }

    public JTextField getNombre() {
        return Nombre;
    }

    public JTextField getJugador() {
        return Jugador;
    }

    public JTextField getCronica() {
        return Cronica;
    }

    void setMainFont(Font Morpheus) {
        Clan.setFont(Morpheus);
        Afiliacion.setFont(Morpheus);
        Concepto.setFont(Morpheus);
        Naturaleza.setFont(Morpheus);
        Conducta.setFont(Morpheus);
        Generacion.setFont(Morpheus);
        Nombre.setFont(Morpheus);
        Jugador.setFont(Morpheus);
        Cronica.setFont(Morpheus);
    }

    public void setActionListeners(ActionListener al){
        Clan.setActionCommand("VTM_CLAN_UPDATE");
        Clan.addActionListener(al);
        
    }
    
    
}
