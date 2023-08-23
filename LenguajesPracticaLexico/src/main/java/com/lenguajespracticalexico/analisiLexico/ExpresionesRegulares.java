/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lenguajespracticalexico.analisiLexico;

/**
 *
 * @author luis
 */
public class ExpresionesRegulares {

    public static final String ID = "([a-zA-z]+|\\_)([a-zA-z]|\\_|[0-9])*$";
    public static final String DECIMAL = "[0-9]+[.][0-9]+$";
    public static final String ENTERO = "[0-9]+$";
    public static final String CADENA = "(['])(.*)([']) | ([\"])(.*)([\"])$";
    public static final String PALABRAS_CLAVE = "[a-zA-Z]+";
    public static final String COMENTARIO = "[#](.)*$";
    public static final String COMPARACION = "(==|!=|>|<|>=|<=)$";
    public static final String OTROS = "(\\(|\\)|\\{|\\}|\\[|\\]|\\,|\\;|\\:)$";
    public static final String OPERADORES = "((+|-|**|/|//|%|*)$";
    public static final String ASIGNACION = "(=|+=|-=|**=|/=|//=|%=|*=)$";
}
