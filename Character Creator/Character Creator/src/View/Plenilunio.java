/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;

/**
 *
 * @author Jorge
 */
public class Plenilunio extends JPanel{
    JTextField concepto;
    JSpinner fortaleza, combate, voluntad, astucia, sutileza, presencia, cultura, aguante, destino; 
    
    int puntosrest;
    int maxnorm;        ///< Maximo dones,armas y/o equipo
    /** Contendran un maximo delimitado (este maximo se podra "exceder" con la masterpass) **/
    JTextField[] dones;
    JTextField[] armas;
    JTextField[] equipo;
    JButton override;
    
    public Plenilunio(){
        JPanel ficha = new JPanel();
        //ImageIcon master = new ImageIcon ("override.bmp");
        ficha.setLayout(new GridLayout(9,3));
        dones = new JTextField[5];      ///< Contando que se haga el override
        armas = new JTextField[5];      ///< Con el override, se puede cambiar el tamaño
        equipo = new JTextField[5];     ///< Idem
        override = new JButton("master");
        
        String[] s = new String[10];
        for (int i = 0; i < 10; i++){
            s[i] = Integer.toString(i+1);
        }
        
        fortaleza = new JSpinner(new SpinnerListModel (s));
        combate = new JSpinner(new SpinnerListModel (s));
        voluntad = new JSpinner(new SpinnerListModel (s));
        astucia = new JSpinner(new SpinnerListModel (s));
        sutileza = new JSpinner(new SpinnerListModel (s));
        presencia = new JSpinner(new SpinnerListModel (s));
        cultura = new JSpinner(new SpinnerListModel (s));
        aguante = new JSpinner(new SpinnerListModel (s));
        destino = new JSpinner(new SpinnerListModel (s));
        
        ficha.add(fortaleza);
        ficha.add(new JLabel ("Fortaleza"));
         ficha.add(new JTextField(10));
        ficha.add(combate);
        ficha.add(new JLabel ("Combate"));
         ficha.add(new JTextField(10));
        ficha.add(voluntad);
        ficha.add(new JLabel ("Voluntad"));
         ficha.add(new JTextField(10));
        ficha.add(astucia);
        ficha.add(new JLabel ("Astucia"));
         ficha.add(new JTextField(10));
        ficha.add(sutileza);
        ficha.add(new JLabel ("Sutileza"));
         ficha.add(new JTextField(10));
        ficha.add(presencia);
        ficha.add(new JLabel ("Presencia"));
         ficha.add(new JTextField(10));
        ficha.add(cultura);
        ficha.add(new JLabel ("Cultura"));
         ficha.add(new JTextField(10));
        ficha.add(aguante);
        ficha.add(new JLabel ("Aguante"));
        JTextField stupid1 = new JTextField(10);
        JTextField stupid2 = new JTextField(10);
        stupid1.setEditable(false);
        stupid2.setEditable(false);
        ficha.add(stupid1);
        ficha.add(destino);
        ficha.add(new JLabel ("Destino"));
        ficha.add(stupid2);
        this.add(ficha);
        this.add(override);
    }
    /**
     * El metodo sirve de herramienta para el master, de tal forma que pueda
     * editar el contenido de varias opciones ocultas al jugador.
     * La contraseña se guardara en un fichero, codificada para evitar
     * ser descifrada.
     * 
     * @return 
     */
    public String[] override (){
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        String[] info = new String[2];
        
        JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
        label.add(new JLabel("E-Mail", SwingConstants.RIGHT));
        label.add(new JLabel("Password", SwingConstants.RIGHT));
        panel.add(label, BorderLayout.WEST);
        
        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField username = new JTextField();
        controls.add(username);
        JPasswordField password = new JPasswordField();
        controls.add(password);
        JOptionPane.showMessageDialog(this, panel, "login", JOptionPane.QUESTION_MESSAGE);
        
        panel.add(controls, BorderLayout.CENTER);
        
        info[0] = username.getText();
        info[1] = String.valueOf(password.getPassword());
        
        return info;
    }
}
