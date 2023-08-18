/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lenguajespracticalexico.frontend;

import com.lenguajespracticalexico.analisiLexico.Afd;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author luis
 */
public class ColorJtextPane {

    private JTextPane textPane;
    private Afd afd;

    private final StyleContext cont = StyleContext.getDefaultStyleContext();

    //Colores 
    private final AttributeSet OPERADORES_ARITMETICOS_CELESTE = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(0, 205, 255));
    private final AttributeSet PALABRAS_CLAVE_MORADO = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(141, 51, 255));
    private final AttributeSet CONSTANTES_ROJO = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.RED);
    private final AttributeSet OTROS_GREEN = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(40, 180, 99));
    private final AttributeSet COMENTARIOS_GRAY = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.GRAY);
    private final AttributeSet IDENTIFICADORES = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);

    public ColorJtextPane(JTextPane textPane) {
        this.textPane = textPane;
        this.afd = new Afd();
    }

    /**
     * Para encontrar la últimas cadenas
     *
     * @param text
     * @param index
     * @return
     */
    private int indiceUltimoCaracterDifLetraNumero(String text, int index) {
        while (--index >= 0) {
            //  \\W = [A-Za-Z0-9]
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }

    //Pra encontrar las primeras cadenas
    private int indicePrimerCaracterDifLetraNumero(String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }

    /**
     * Para pintar las palabras
     */
    public void colors() {

        //Estilos-colores 
        DefaultStyledDocument doc = new DefaultStyledDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);

                String text = getText(0, getLength());
                int antes = indiceUltimoCaracterDifLetraNumero(text, offset);
                if (antes < 0) {
                    antes = 0;
                }
                int despues = indicePrimerCaracterDifLetraNumero(text, offset + str.length());
                int indexInicial = antes;
                int indexFinal = antes;

                while (indexFinal <= despues) {
                    if (indexFinal == despues || String.valueOf(text.charAt(indexFinal)).matches("\\W")) {
                        if (text.substring(indexInicial, indexFinal).matches("(\\W)*" + afd.booleanas())) {
                            setCharacterAttributes(indexInicial, indexFinal - indexInicial, CONSTANTES_ROJO, false);
                        } else if (text.substring(indexInicial, indexFinal).matches("(\\W)*" + afd.wordsKey())) {
                            setCharacterAttributes(indexInicial, indexFinal - indexInicial, PALABRAS_CLAVE_MORADO, false);
                        } else if (text.substring(indexInicial, indexFinal).
                                matches("(\\W)*(\\+|\\-|\\*|\\*\\*|\\%|\\/|\\/\\/|and|or|not|\\=|\\+\\=|-=|\\*=|/=|//=|\\*\\*=|>|<|>=|<=|==|\\!=)")) {
                            setCharacterAttributes(indexInicial, indexFinal - indexInicial, OPERADORES_ARITMETICOS_CELESTE, false);
                        } else if (text.substring(indexInicial, indexFinal).matches("(\\W)*(#)(\\w*)(\\ *)(\\W*)")) {
                            setCharacterAttributes(indexInicial, indexFinal - indexInicial, COMENTARIOS_GRAY, false);
                        } else if (text.substring(indexInicial, indexFinal).matches("(\\W)*(\\(|\\)|\\[|\\]|\\{|\\}|,|;|:)")) {
                            setCharacterAttributes(indexInicial, indexFinal - indexInicial, OTROS_GREEN, false);
                        } else {
                            setCharacterAttributes(indexInicial, indexFinal - indexInicial, IDENTIFICADORES, false);
                        }
                        indexInicial = indexFinal;

                    }
                    indexFinal++;
                }
            }

            public void romeve(int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String text = getText(0, getLength());
                int before = indiceUltimoCaracterDifLetraNumero(text, offs);
                if (before < 0) {
                    before = 0;
                }
                int after = indicePrimerCaracterDifLetraNumero(text, offs);
                String word = text.substring(before, after);
            }
        };

        JTextPane txtPane = new JTextPane(doc);
        String texto = textPane.getText();
        textPane.setStyledDocument(txtPane.getStyledDocument());
        textPane.setText(texto);

    }
}
