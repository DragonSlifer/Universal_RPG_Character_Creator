/*
 *  Role Game Character Creator
 *  Con este programa podr�s crear
 *  fichas de rol para varios sistemas de
 *  juego, como el Mundo de Tinieblas o
 *  el NSD20
 */
package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author darkange
 */
class VTMAT extends JPanel {

    JPanel Fisicos, Sociales, Mentales;
    JTextField Fuerza, Resistencia, Destreza, Carisma, Manipulacion, Apariencia, Inteligencia, Percepcion, Astucia;
    JComboBox F,S,M;
    JButton Comprobar;

    public VTMAT() {
        Fisicos = new JPanel();
        Fisicos.setBorder(BorderFactory.createTitledBorder("Físicos"));
        Sociales = new JPanel();
        Sociales.setBorder(BorderFactory.createTitledBorder("Sociales"));
        Mentales = new JPanel();
        Mentales.setBorder(BorderFactory.createTitledBorder("Mentales"));

        Fisicos.setLayout(new GridLayout(3, 2));
        Fuerza = new JTextField();
        Resistencia = new JTextField();
        Destreza = new JTextField();
        Fisicos.add(new JLabel("Fuerza"));
        Fisicos.add(Fuerza);
        Fisicos.add(new JLabel("Destreza"));
        Fisicos.add(Destreza);
        Fisicos.add(new JLabel("Resistencia"));
        Fisicos.add(Resistencia);

        Sociales.setLayout(new GridLayout(3, 2));
        Carisma = new JTextField();
        Manipulacion = new JTextField();
        Apariencia = new JTextField();
        Sociales.add(new JLabel("Carisma"));
        Sociales.add(Carisma);
        Sociales.add(new JLabel("Manipulación"));
        Sociales.add(Manipulacion);
        Sociales.add(new JLabel("Apariencia"));
        Sociales.add(Apariencia);

        Mentales.setLayout(new GridLayout(3, 2));
        Inteligencia = new JTextField();
        Percepcion = new JTextField();
        Astucia = new JTextField();
        Mentales.add(new JLabel("Inteligencia"));
        Mentales.add(Inteligencia);
        Mentales.add(new JLabel("Percepción"));
        Mentales.add(Percepcion);
        Mentales.add(new JLabel("Astucia"));
        Mentales.add(Astucia);
        
        F = new JComboBox();
        F.addItem("Primarios");
        F.addItem("Secundarios");
        F.addItem("Terciarios");
        S = new JComboBox();
        S.addItem("Primarios");
        S.addItem("Secundarios");
        S.addItem("Terciarios");
        M = new JComboBox();
        M.addItem("Primarios");
        M.addItem("Secundarios");
        M.addItem("Terciarios");
        
        JPanel p = new JPanel();
        JPanel p_aux = new JPanel();
        p.setLayout(new GridLayout(0, 3));
        this.setLayout(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder("Atributos"));
        p_aux.setLayout(new GridLayout(0, 3));
        p.add(Fisicos);
        p.add(Sociales);
        p.add(Mentales);
        this.add(p,"Center");
        Comprobar = new JButton("Comprobar Datos");
        p_aux.add(F);
        p_aux.add(S);
        p_aux.add(M);
        p_aux.add(Comprobar);
        this.add(p_aux,"South");
    }

    /**
     *
     * @param al
     */
    public void setActionListeners(ActionListener al) {
        Comprobar.addActionListener(al);
        Comprobar.setActionCommand("VTMCompVTMAT");
    }    

    public boolean Comprobar() {
        boolean retval = false;
        int f = this.F.getSelectedIndex();
        int s = this.S.getSelectedIndex();
        int m = this.M.getSelectedIndex();
        
        if((f!=s) && (f!=m) && (s!=m)){
            retval = true;
        }
        return retval;
    }
}
