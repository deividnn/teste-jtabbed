/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static util.Util.decrypt;
import org.ini4j.Wini;

/**
 *
 * @author deividnn
 */
public class Banco {

    public static Wini ini;
    public static String servidor, porta, user, senha, banco;

    static {
        try {
            ini = new Wini(new File(System.getProperty("user.dir") + File.separator + "conf.ini"));
            servidor = ini.get("conexao", "servidor");
            porta = ini.get("conexao", "porta");
            user = ini.get("conexao", "user");
            String s = ini.get("conexao", "senha");
            banco = ini.get("conexao", "banco");
            senha = decrypt(s);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "problemas ler arquivo de configuracao:ERRO - "+ex.toString());
        } catch (GeneralSecurityException ex) {
          JOptionPane.showMessageDialog(null, "problemas ler arquivo de configuracao:ERRO - "+ex.toString());
        }
    }

    public static Connection conectar() {
        try {
            if (senha.equals("")) {
                ini = new Wini(new File(System.getProperty("user.dir") + File.separator + "conf.ini"));
                servidor = ini.get("conexao", "servidor");
                porta = ini.get("conexao", "porta");
                user = ini.get("conexao", "user");
                String s = ini.get("conexao", "senha");
                banco = ini.get("conexao", "banco");
                senha = decrypt(s);
            }

            String url = "jdbc:postgresql://" + servidor + ":" + porta + "/" + banco + "?user=" + user + ""
                    + "&password=" + senha + "&charSet=utf-8";
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "problemas ao acessar banco de dados:ERRO - "+e.toString());
            Configuracao c = new Configuracao();
            c.setLocationRelativeTo(null);
            c.setVisible(true);
            return null;
        }

    }

}
