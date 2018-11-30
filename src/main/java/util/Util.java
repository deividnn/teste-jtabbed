/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextField;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author deividnn
 */
public class Util {

    public static SimpleDateFormat datahorasql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat datahoralegivel = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static SimpleDateFormat datasql = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat datalegivel = new SimpleDateFormat("dd/MM/yyyy");
    public static NumberFormat numero = new DecimalFormat("0.00");

    public static boolean camposVazio(boolean ok, List<JTextField> txt) {
        String aviso = "";
        JTextField l = null;

        for (JTextField t : txt) {
            if (t.getText() == null) {
                t.setText("");
            }
            if (t.getText().isEmpty()) {
                aviso += "Digite o campo " + t.getName() + "\n";
                t.setBackground(Color.red);
                if (l == null) {
                    l = t;
                }

            } else {
                t.setBackground(Color.white);
            }
        }
        if (!aviso.isEmpty()) {
            if (l != null) {
                l.requestFocus();
            }
            ok = false;
            JOptionPane.showMessageDialog(null, aviso, "Aviso", ERROR_MESSAGE);
        }

        return ok;
    }

    public static boolean emailValido(JTextField t) {
        String padrao = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if (!t.getText().matches(padrao)) {
            t.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Email invalido", "Aviso", ERROR_MESSAGE);
            t.requestFocus();
            return false;
        } else {
            t.setBackground(Color.white);
            return true;
        }
    }

    public static String md5(String txt) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5sum = md.digest(txt.getBytes());
            String o = String.format("%032X", new BigInteger(1, md5sum));
            return o;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static final char[] PASSWORD = "enfldsgbnlsngdlksdsgm".toCharArray();
    private static final byte[] SALT = {(byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12, (byte) 0xde, (byte) 0x33,
        (byte) 0x10, (byte) 0x12,};

   public static String encrypt(String property) throws GeneralSecurityException, UnsupportedEncodingException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
    }

    private static String base64Encode(byte[] bytes) {
        // NB: This class is internal, and you probably should use another impl
        return new BASE64Encoder().encode(bytes);
    }

    public static String decrypt(String property) throws GeneralSecurityException, IOException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
    }

    private static byte[] base64Decode(String property) throws IOException {
        // NB: This class is internal, and you probably should use another impl
        return new BASE64Decoder().decodeBuffer(property);
    }

   /* public static void main(String[] args) throws Exception {
        String originalPassword = "deivid";
        System.out.println("Original password: " + originalPassword);
        String encryptedPassword = encrypt(originalPassword);
        System.out.println("Encrypted password: " + encryptedPassword);
        String decryptedPassword = decrypt(encryptedPassword);
        System.out.println("Decrypted password: " + decryptedPassword);
    }*/

}
