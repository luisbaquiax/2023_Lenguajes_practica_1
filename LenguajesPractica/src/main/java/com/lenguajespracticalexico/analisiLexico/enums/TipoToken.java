/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.lenguajespracticalexico.analisiLexico.enums;

/**
 * @author luis
 */
public enum TipoToken {
    OPERADOR_ARITMÉTICO("OPERADOR_ARITMÉTICO"),
    OPERADOR_ARITMETICO_MAS("+"),
    OPERADOR_ARITMETICO_MENOS("-"),
    OPERADOR_ARITMÉTICO_MULTI("*"),
    OPERADOR_ARITMÉTICO_DIV("/"),
    OPERADOR_ARITMÉTICO_DIV_2("//"),
    OPERADOR_ARITMÉTICO_EXPONENTE("**"),
    OPERADOR_ARITMÉTICO_MODULO("%"),
    OPERADOR_COMPARACION("OPERADOR_COMPARACION"),
    OPERADOR_COMPARACION_IGUAL("=="),
    OPERADOR_COMPARACION_DIFERENTE("!="),
    OPERADOR_COMPARACION_MAYOR_QUE(">"),
    OPERADOR_COMPARACION_MENOR_QUE("<"),
    OPERADOR_COMPARACION_MAYOR_IGUAL(">="),
    OPERADOR_COMPARACION_MENOR_IGUAL("<="),
    OPERADOR_LOGICO("OPERADOR_LOGICO"),
    OPERADOR_LOGICO_AND("and"),
    OPERADOR_LOGICO_OR("or"),
    OPERADOR_LOGICO_NOT("not"),
    OPERADOR_ASIGNACION("OPERADOR_ASIGNACION"),
    SIGNO_IGUAL("="),
    OPERADOR_ASIGNACION_POR_IGUAL("*="),
    OPERADOR_ASIGNACION_DIV_IGUAL("/="),
    OPERADOR_ASIGNACION_EXPONENTE_IGUAL("**="),
    OPERADOR_ASIGNACION_DIV_2_IGUAL("//="),
    OPERADOR_ASIGNACION_MODULO_IGUAL("%="),
    OPERADOR_ASIGNACION_MAS_IGUAL("+="),
    OPERADOR_ASIGNACION_MENOS_IGUAL("-="),
    PALABRA_CLAVE("PALABRA_CLAVE"),
    CADENA("CADENA"),
    ID("ID"),
    ENTERO("ENTERO"),
    DECIMAL("DECIMAL"),
    BOOLEANAS("BOOLEANAS"),
    FALSE("False"),
    TRUE("True"),
    COMENTARIO("COMENTARIO"),
    SIGNOS("SIGNOS"),
    PARENTESIS_OPEN("("),
    PARENTESIS_CLOSE(")"),
    CORCHETE_OPEN("["),
    SIGNOS_CORCHETE_CLOSE("]"),
    LLAVE_OPEN("{"),
    SIGNOS_LLAVE_CLOSE("}"),
    SIGNOS_COMA(","),
    SIGNOS_PUNTO_COMA(";"),
    SIGNOS_DOS_PUNTOS(":"),
    ESPACIO(" "),
    OPERADOR_TERNARIO("?"),
    TOKEN_PUNTO("."),
    IN("in"),
    NOT("not"),
    AND("and"),
    OR("or"),
    SALTO_LINEA("\n"),
    NUMERO("NUMERO");

    public String value;

    private TipoToken(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
