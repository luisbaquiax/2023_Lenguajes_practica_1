/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lenguajespracticalexico.frontend;

import java.awt.Color;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.Element;

/**
 *
 * @author luis
 */
public class LineNumberTextPane extends JTextPane {

    private JTextPane txtPane;

    public LineNumberTextPane(JTextPane textPane) {
        this.txtPane = textPane;
        setEditable(false);
        setFont(textPane.getFont());
        setBackground(Color.lightGray);
        setMargin(new Insets(0, 5, 0, 5));

        textPane.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLineNumbers();
            }
        });
        updateLineNumbers();
    }

    private void updateLineNumbers() {
        Document doc = txtPane.getDocument();
        Element root = doc.getDefaultRootElement();
        int lines = root.getElementCount();
        String sb = "";

        for (int i = 1; i <= lines; i++) {
            sb += i + "\n";
        }

        setText(sb);
    }
}
