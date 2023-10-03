/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.lenguajespracticalexico;

import com.lenguajespracticalexico.analisiLexico.AnalizadorLexico;
import com.lenguajespracticalexico.analisiLexico.Token;
import com.lenguajespracticalexico.frontend.VentanaParser;
import com.lenguajespracticalexico.parser.Bloque;
import com.lenguajespracticalexico.parser.Parser;

import java.util.Arrays;
import java.util.List;

/**
 * @author luis
 */
public class LenguajesPractica1 {

    public static void main(String[] args) {
        //new VentanaParser().show();
        AnalizadorLexico analizadorLexico = new AnalizadorLexico();
        analizadorLexico.analizarTokens("def funcion1():\n" +
                                        "  hola\n" +
                                        "  hola\n" +
                                        "def funcion2():\n" +
                                        "  hola\n" +
                                        "variable = 446");
        Parser parser = new Parser();
        parser.dividirPorBloque(analizadorLexico.getTokens());
        for (Bloque b : parser.getBloquesCodigo()) {
            System.out.println("bloque");
            for(Token token: b.getTokens()){
                System.out.println(token.toString());
            }
        }
    }
}
