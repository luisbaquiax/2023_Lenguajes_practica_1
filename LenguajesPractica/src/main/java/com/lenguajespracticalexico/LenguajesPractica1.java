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
import com.lenguajespracticalexico.analisiLexico.enums.TipoToken;
import com.lenguajespracticalexico.frontend.VentanaParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luis
 */
public class LenguajesPractica1 {

    public static void main(String[] args) {
        new VentanaParser().setVisible(true);
//        AnalizadorLexico analizadorLexico = new AnalizadorLexico();
//        analizadorLexico.analizarTokens("print((suma + 10 * resta / multiplicacion ** division % exponente)) # 81");
////        for (Token token : analizadorLexico.getTokens()) {
////            System.out.println(token.toString());
////        }
//        List<Token> tokens = new ArrayList<>();
//        for (int i = 0; i < analizadorLexico.getTokens().size(); i++) {
//            if (!analizadorLexico.getTokens().get(i).getCategoria().equals(TipoToken.ESPACIO.toString())
//                    && !analizadorLexico.getTokens().get(i).getSubCategoria().equals(TipoToken.SALTO_LINEA.toString())
//                    && !analizadorLexico.getTokens().get(i).getSubCategoria().equals(TipoToken.COMENTARIO.toString())) {
//                tokens.add(analizadorLexico.getTokens().get(i));
//            }
//        }
//        for (int i = 0; i < tokens.size(); i++) {
//            System.out.println(tokens.get(i).toString());
//        }
//        Parser p = new Parser();
//        p.runParser(tokens);
    }
}
