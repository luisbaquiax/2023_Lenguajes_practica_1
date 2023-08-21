/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.lenguajespracticalexico;

import com.lenguajespracticalexico.analisiLexico.Afd;
import com.lenguajespracticalexico.analisiLexico.AnalizadorLexico;
import com.lenguajespracticalexico.frontend.VentanaParser;

/**
 *
 * @author luis
 */
public class LenguajesPractica1 {

    public static void main(String[] args) {
//        new VentanaParser().show();
        Afd a = new Afd();
        AnalizadorLexico l = new AnalizadorLexico();
        String texto = "def if \"cadena \" : ( 4 + 5 )\n"
                + "mi_id_\n"
                + "#comentario \n"
                + "while\n"
                + "for\n"
                + ">=";
//        l.analizarTokens("=========");
        l.analizarTokens("_h____ola. 464+6. (hola         ) { } 5.6 try \nFalse \nclass + += = == -= /= *= **");
    }
}
 