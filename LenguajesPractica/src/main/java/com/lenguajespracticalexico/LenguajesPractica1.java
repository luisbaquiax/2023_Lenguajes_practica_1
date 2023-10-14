/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.lenguajespracticalexico;

import com.lenguajespractica.parser.ManejoBloque;
import com.lenguajespractica.parser.Production;
import com.lenguajespracticalexico.analisiLexico.AnalizadorLexico;
import com.lenguajespracticalexico.analisiLexico.Token;
import com.lenguajespractica.parser.Bloque;
import com.lenguajespractica.parser.Parser;

/**
 * @author luis
 */
public class LenguajesPractica1 {

    public static void main(String[] args) {
        //new VentanaParser().setVisible(true);
        AnalizadorLexico analizadorLexico = new AnalizadorLexico();
        analizadorLexico.analizarTokens("def funcion1():\n" +
                "  hola\n" +
                "  hola\n" +
                "def funcion2():\n" +
                "  hola\n" +
                "variable = 446");
        Production p = new Production();
        for (int i = 0; i < p.getProducciones().size(); i++) {
            System.out.println(i);
        }
    }
}
