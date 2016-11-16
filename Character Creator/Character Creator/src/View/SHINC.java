/*
 *  Role Game Character Creator
 *  Con este programa podr�s crear
 *  fichas de rol para varios sistemas de
 *  juego, como el Mundo de Tinieblas o
 *  el NSD20
 */
package View;

import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Jorge
 */
public class SHINC extends JPanel {

    private static int max_power = 4;
    private JTextField nick, age, group, job, base;             ///< Basic data
    private JComboBox powers_origin;                            ///< Origin of the character powers
    private JTextField[] stats, skills, skills_learn;           ///< Stats, Skills and Learned Skills 
    private JTextField combDamage, comb_def,
            assaultAtk, pvRegen, psicoguard,
            jump, v_jump;                                       ///< Combat Damage, Combat Defense, Number of attacks in an assault, PV regeneration, Psiquic Defense, Horitzontal Jump, Vertical Jump
    private JTextArea inventory;                                ///< Starting inventory
    private JComboBox[] powers;                                 ///< Powers the super have (limited to 4)
    private JTextArea info;                                     ///< Informative text
    private JComboBox secret_id, family, infancy, friendship,
            legal_situation, economical_situation;              ///< Human situation
    private JComboBox social_rank, public_rank;                 ///< MetaHuman situation
    private JTextArea char_story;                               ///< Character story

    public SHINC() {
        /**
         * Auxiliar variables
         */
        Vector<JLabel> stat_labels = new Vector<>();            ///< Stat Names
        Vector<JLabel> lstats_labels = new Vector<>();          ///< Learned Skill Names
        Vector<JLabel> skill_labels = new Vector<>();           ///< Skill Names
        Vector<JLabel> bdata_labels = new Vector<>();           ///< Basic Data Labels
        Vector<JLabel> _labels = new Vector<>();          ///< 
        /**
         * Reading shinc.rpg information
         */
        /**
         * Initializing vectors
         */
        stats = new JTextField[7];
        skills = new JTextField[16];
        skills_learn = new JTextField[8];
        powers = new JComboBox[max_power];
        /**
         * Initializing individual JTextFields
         */
        nick = new JTextField();
        age = new JTextField();
        group = new JTextField();
        job = new JTextField();
        base = new JTextField();
        combDamage = new JTextField();
        comb_def = new JTextField();
        assaultAtk = new JTextField();
        pvRegen = new JTextField();
        psicoguard = new JTextField();
        jump = new JTextField();
        v_jump = new JTextField();
        /**
         * Initializing JTextAreas
         */
        inventory = new JTextArea();
        info = new JTextArea();
        char_story = new JTextArea();
        /**
         * Intializing JComboBoxes
         */
        powers_origin = new JComboBox();
        secret_id = new JComboBox();
        family = new JComboBox();
        infancy = new JComboBox();
        friendship = new JComboBox();
        legal_situation = new JComboBox();
        economical_situation = new JComboBox();
        social_rank = new JComboBox();
        public_rank = new JComboBox();
    }
}
