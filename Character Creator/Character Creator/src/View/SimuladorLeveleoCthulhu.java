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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jorge
 */
public class SimuladorLeveleoCthulhu extends JPanel {
    private JTextField base, numcriticos, nivelactual;
    private JButton subirnivel;
    
    public SimuladorLeveleoCthulhu(){
        base = new JTextField();
        numcriticos = new JTextField();
        nivelactual = new JTextField();
        subirnivel = new JButton("Simular");
        subirnivel.setActionCommand("LevelearC");
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1,6));
        this.setLayout(new BorderLayout());
        p.add(new JLabel ("Base"));
        p.add(base);
        p.add(new JLabel ("Nivel de Leveleo"));
        p.add(numcriticos);
        p.add(new JLabel("Nivel Actual"));
        nivelactual.setEditable(false);
        p.add(nivelactual);
        this.add(subirnivel,"South");
        this.add(p,"Center");
        this.setVisible(true);
    }
    
    public void setActionListener(ActionListener al){
        this.subirnivel.addActionListener(al);
    }
    
    public int getBase (){
        return Integer.parseInt(base.getText());
    }
    
    public int getCrit(){
        return Integer.parseInt(numcriticos.getText());
    }
    
    public void Actual(String x){
        nivelactual.setText(x);
    }
}
