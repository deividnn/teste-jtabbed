/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author deividnn
 */
public class Maximo extends PlainDocument {

    private int iMaxLength;

    public Maximo(int maxlen) {
        super();
        iMaxLength = maxlen;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        //super.insertString(offset, str.toUpperCase(), attr);
        if (str == null) {
            return;
        }
        if (iMaxLength <= 0) // aceitara qualquer no. de caracteres
        {
            super.insertString(offset, str, attr);
            return;
        }
        int ilen = (getLength() + str.length());
        if (ilen <= iMaxLength) // se o comprimento final for menor...
        {
            super.insertString(offset, str, attr);   // ...aceita str e passa ela para UpperCase
        }
    }

}
