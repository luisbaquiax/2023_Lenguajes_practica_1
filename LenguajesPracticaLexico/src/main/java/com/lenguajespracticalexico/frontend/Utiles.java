/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lenguajespracticalexico.frontend;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

/**
 *
 * @author luis
 */
public class Utiles {

    private static final int TAM = 20;

    /**
     * Set image to JMenuItem
     *
     * @param menuItem
     * @param ruta
     */
    public void setIconMenuItem(JMenuItem menuItem, String ruta) {
        ImageIcon icono1 = new ImageIcon(getClass().getResource(ruta));
        menuItem.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(TAM,
                TAM, Image.SCALE_SMOOTH)));
    }

    /**
     * Set image to JButton
     *
     * @param button
     * @param ruta
     * @param tam
     */
    public void setIconMenuItem(JButton button, String ruta, int tam) {
        ImageIcon icono1 = new ImageIcon(getClass().getResource(ruta));
        button.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(tam,
                tam, Image.SCALE_SMOOTH)));
    }

}
