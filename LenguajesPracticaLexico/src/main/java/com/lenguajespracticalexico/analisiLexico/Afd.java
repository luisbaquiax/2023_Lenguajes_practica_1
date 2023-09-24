/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lenguajespracticalexico.analisiLexico;

import java.util.HashMap;
import lombok.Data;
import com.lenguajespracticalexico.analisiLexico.enums.TipoToken;

/**
 *
 * @author luis
 */
public @Data
class Afd {

    public static final String ALFABETO = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
    public static final String LETRAS = "abcdefghijklmnopqrstuvwxyz";
    public static final String DIGITOS = "0123456789";
    public static final String OTROS_SIMBOLOS = "(){}[],:;";
    private String[] palabrasReservadas;
    private String[] booleanas;
    private String[] operadoresLogicos;
    /**
     *
     */
    private String[] simboloAsignacion;
    private String[] comparadores;
    private String[] operadoresAritmeticos;

    private HashMap<String, String> diccionario;

    private int[] estados;
    private int[] estadosAceptacion;

    private int[][] transiciones;

    public Afd() {
        this.palabrasReservadas = new String[]{
            "as",
            "assert",
            "break",
            "class",
            "continue",
            "def",
            "del",
            "elif",
            "else",
            "except",
            "finally",
            "for",
            "from",
            "global",
            "if",
            "import",
            "in",
            "is",
            "lambda",
            "None",
            "nonlocal",
            "pass",
            "raise",
            "return",
            "try",
            "while",
            "with",
            "yield"
        };
        this.diccionario = new HashMap<>();
        //constantes
        this.booleanas = new String[]{"True", "False"};
        this.diccionario.put("True", "True");
        this.diccionario.put("False", "False");

        /**
         *
         */
        this.simboloAsignacion = new String[]{"=", "*=", "**=", "/=", "//=", "+=", "-=", "%="};
        this.diccionario.put(TipoToken.OPERADOR_ASIGNACION_IGUAL.toString(), "=");
        this.diccionario.put(TipoToken.OPERADOR_ASIGNACION_POR_IGUAL.toString(), "*=");
        this.diccionario.put(TipoToken.OPERADOR_ASIGNACION_EXPONENTE_IGUAL.toString(), "**=");
        this.diccionario.put(TipoToken.OPERADOR_ASIGNACION_DIV_IGUAL.toString(), "/=");
        this.diccionario.put(TipoToken.OPERADOR_ASIGNACION_DIV_2_IGUAL.toString(), "//=");
        this.diccionario.put(TipoToken.OPERADOR_ASIGNACION_MAS_IGUAL.toString(), "+=");
        this.diccionario.put(TipoToken.OPERADOR_ASIGNACION_MENOS_IGUAL.toString(), "-=");
        this.diccionario.put(TipoToken.OPERADOR_ASIGNACION_MODULO_IGUAL.toString(), "%=");

        this.operadoresLogicos = new String[]{"and", "or", "not"};
        this.diccionario.put(TipoToken.OPERADOR_LOGICO_AND.toString(), "and");
        this.diccionario.put(TipoToken.OPERADOR_LOGICO_OR.toString(), "or");
        this.diccionario.put(TipoToken.OPERADOR_LOGICO_NOT.toString(), "not");

        this.comparadores = new String[]{"==", "!=", ">", "<", ">=", "<="};
        this.diccionario.put(TipoToken.OPERADOR_COMPARACION_IGUAL.toString(), "==");
        this.diccionario.put(TipoToken.OPERADOR_COMPARACION_DIFERENTE.toString(), "!=");
        this.diccionario.put(TipoToken.OPERADOR_COMPARACION_MAYOR_QUE.toString(), ">");
        this.diccionario.put(TipoToken.OPERADOR_COMPARACION_MENOR_QUE.toString(), "<");
        this.diccionario.put(TipoToken.OPERADOR_COMPARACION_MAYOR_IGUAL.toString(), ">=");
        this.diccionario.put(TipoToken.OPERADOR_COMPARACION_MENOR_IGUAL.toString(), "<=");

        this.operadoresAritmeticos = new String[]{"+", "-", "**", "/", "//", "%", "*"};
        this.diccionario.put(TipoToken.OPERADOR_ARITMÉTICO_MAS.toString(), "+");
        this.diccionario.put(TipoToken.OPERADOR_ARITMÉTICO_MENOS.toString(), "-");
        this.diccionario.put(TipoToken.OPERADOR_ARITMÉTICO_EXPONENTE.toString(), "**");
        this.diccionario.put(TipoToken.OPERADOR_ARITMÉTICO_DIV.toString(), "/");
        this.diccionario.put(TipoToken.OPERADOR_ARITMÉTICO_DIV_2.toString(), "//");
        this.diccionario.put(TipoToken.OPERADOR_ARITMÉTICO_MODULO.toString(), "%");
        this.diccionario.put(TipoToken.OPERADOR_ARITMÉTICO_MULTI.toString(), "*");

        this.diccionario.put(TipoToken.SIGNOS_PAREN_OPEN.toString(), "(");
        this.diccionario.put(TipoToken.SIGNOS_PAREN_CLOSE.toString(), ")");
        this.diccionario.put(TipoToken.SIGNOS_CORCHETE_OPEN.toString(), "[");
        this.diccionario.put(TipoToken.SIGNOS_CORCHETE_CLOSE.toString(), "]");
        this.diccionario.put(TipoToken.SIGNOS_LLAVE_OPEN.toString(), "{");
        this.diccionario.put(TipoToken.SIGNOS_LLAVE_CLOSE.toString(), "}");
        this.diccionario.put(TipoToken.SIGNOS_COMA.toString(), ",");
        this.diccionario.put(TipoToken.SIGNOS_DOS_PUNTOS.toString(), ":");
        this.diccionario.put(TipoToken.SIGNOS_PUNTO_COMA.toString(), ";");

        this.diccionario.put(TipoToken.TOKEN_ESPECIAL_ESPACIO.toString(), " ");
        this.diccionario.put(TipoToken.TOKEN_PUNTO.toString(), TipoToken.TOKEN_PUNTO.value);
        this.diccionario.put(TipoToken.OPERADOR_TERNARIO.toString(), TipoToken.OPERADOR_TERNARIO.value);
        this.estados = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};

        this.estadosAceptacion = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 21, 22, 23};

        matrizTransiciones();
    }

    public String otherSimbols() {
        String other = "";
        for (int i = 32; i < 127; i++) {
            other += (char) i;
        }
        return other;
    }

    public String wordsKey() {
        String w = "(";
        for (int i = 0; i < palabrasReservadas.length - 1; i++) {
            w += palabrasReservadas[i] + "|";
        }
        w += palabrasReservadas[palabrasReservadas.length - 1];
        w += ")";
        return w;
    }

    public String booleanas() {
        String w = "(";
        for (int i = 0; i < booleanas.length - 1; i++) {
            w += booleanas[i] + "|";
        }
        w += booleanas[booleanas.length - 1];
        w += ")";
        return w;
    }

    private void matrizTransiciones() {
        this.transiciones = new int[][]{
            {+1, 12, +2, +3, +4, +5, +6, +7, +8, +9, 23, 11, 13, 14, 15, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, -1},//0
            {+1, +2, +2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//1
            {+2, +2, +2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//2
            {-1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//3
            {-1, -1, -1, -1, -1, -1, -1, -1, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//4
            {-1, -1, -1, -1, -1, 16, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//5
            {-1, -1, -1, -1, -1, -1, 17, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//6
            {-1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//7
            {-1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//8
            {-1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//9
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//10
            {-1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//11
            {-1, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 18, -1},//12
            {13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 10, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13},//13
            {14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14},//14
            {15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},//15
            {-1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//16
            {-1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//17
            {-1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//18
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, -1, -1},//19
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1},//20
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1},//21
            {-1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//22
            {-1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}//23
        };
    }

}
