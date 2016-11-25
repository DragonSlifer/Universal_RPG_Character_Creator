/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class Model {

    
    private Vector<User> Masters;
    private GameModel gameModel;
    private static String binPath = "./src/bin";

    public Model() throws UnsupportedEncodingException, IOException {
        
        Masters = new Vector<>();
        ReadMasterInfo();
    }

    
    public void ReadMasterInfo() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        User aux = new User();
        File fread;
        BufferedReader bread;
        String linea;
        int i = 0;
        
        fread = new File(binPath + "/Masters.rpg");
        bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));
        while ((linea = bread.readLine()) != null) {
            if ((i % 2) == 0) {               ///< Significa Usuario
                aux.setNombre(linea);
            } else if ((i % 2) != 0) {        ///< Significa Contraseña
                aux.setPass(linea);
            } else {
                Masters.add(aux);
            }
            i++;
        }
    }

    public void AddMasterInfo(String user, String pass) throws IOException {
        FileWriter fw;
        
        fw = new FileWriter(binPath + "/Masters.rpg", true);
        fw.write(user);
        fw.write("\n");
        fw.write(pass);
        fw.write("\n");
    }

    public int Leveleo(int base, int numcriticos) {
        int actual;
        Random rnd = new Random();
        actual = base;
        int x;
        for (int i = 0; i < numcriticos; i++) {
            x = (int) (rnd.nextDouble() * 100 + 1);
            if (x > actual) {
                x = 0;
                if (actual <= 20) {
                    x = (int) (rnd.nextDouble() * 10 + 1);
                } else if ((20 < actual) && (actual <= 35)) {
                    x = (int) (rnd.nextDouble() * 8 + 1);
                } else if ((35 < actual) && (actual <= 50)) {
                    x = (int) (rnd.nextDouble() * 6 + 1);
                } else if ((50 < actual) && (actual <= 70)) {
                    x = (int) (rnd.nextDouble() * 4 + 1);
                } else if ((70 < actual) && (actual <= 80)) {
                    x = (int) (rnd.nextDouble() * 3 + 1);
                } else if ((80 < actual) && (actual <= 90)) {
                    x = (int) (rnd.nextDouble() * 2 + 1);
                }

                actual += x;
            }
        }
        return actual;
    }

    /*private String processPath(String path) {
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
    }*/

    public void setOtherModel(String juego) {
        juego = processJuego(juego);
        if(juego.equals(gameModel.getClassName()))
        switch(juego){
            case "VTM":
                gameModel = new VTM("VTM");
                System.out.println("Model -- setOtherModel -- Nuevo Modelo de Juego: " + juego);
                break;
            default:
               System.out.println("Model -- setOtherModel -- Error: Juego no Registrado");
        }
    }

    private String processJuego(String juego) {
        String retval = null;
        
        String path = binPath + "/Files/Game_Equivalence.rpg";
        
        try {
            File fread = new File(path);
            BufferedReader bread = new BufferedReader(new InputStreamReader(new FileInputStream(fread), "ISO-8859-1"));
            String linea;
            int i = 0;
            Boolean STOP = false;
            String aux = null;
            while (((linea = bread.readLine()) != null) && (STOP == false)) {
                if ((i % 2) == 0) {               ///< Significa Juego
                    aux = linea;
                } else if ((i % 2) != 0) {        ///< Significa Abreviatura
                    if (aux == null ? juego == null : aux.equals(juego)){
                        retval = linea;
                        System.out.println("Model -- processJuego -- Abreviatura Encontrada: " + linea);
                        STOP = true;
                    }
                }
                i++;
            }
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retval;
    }

    private static class User {

        String nombre, password;

        public User() {
            nombre = "nombre";
            password = "contraseña";
        }

        public boolean compareUsers(User aux) {
            boolean ok = false;
            if ((this.nombre == aux.getNombre()) && (this.password == aux.getPass())) {
                ok = true;
            }
            return ok;
        }

        public String getNombre() {
            return nombre;
        }

        public String getPass() {
            return password;
        }

        public void setNombre(String s) {
            this.nombre = s;
        }

        public void setPass(String s) {
            this.nombre = s;
        }
    }
}
