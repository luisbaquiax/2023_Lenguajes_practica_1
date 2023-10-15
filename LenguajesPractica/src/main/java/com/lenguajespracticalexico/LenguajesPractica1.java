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
import com.lenguajespractica.parser.ParserBloque;
import com.lenguajespracticalexico.analisiLexico.enums.TipoToken;
import com.lenguajespracticalexico.frontend.VentanaParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luis
 */
public class LenguajesPractica1 {

    public static void main(String[] args) {
        new VentanaParser().setVisible(true);
//        AnalizadorLexico analizadorLexico = new AnalizadorLexico();
//        analizadorLexico.analizarTokens("hola={\"id\":1, \"nombre\":\"Sin nombre\"}, {\"id\":2, \"nombre\":\"Xalarga\"}");
//        ParserBloque parserBloque = new ParserBloque(analizadorLexico.getTokens());
//        parserBloque.analizarBloques();

    }
}
