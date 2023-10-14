/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lenguajespracticalexico.analisiLexico;

/**
 * @author luis
 */
public class CaracterPosicion {

    public CaracterPosicion() {
    }

    /**
     * Retorna la posción del caracter en la matriz transición
     *
     * @param caracter
     * @return
     */
    public int getPosicionCaracter(char caracter) {
        int posicion = -1;

        if (esLetra(caracter)) {
            posicion = 0;
        } else if (esDigito(caracter)) {
            posicion = 1;
        } else if (caracter == '_') {
            posicion = 2;
        } else if (caracter == '+') {
            posicion = 3;
        } else if (caracter == '-') {
            posicion = 4;
        } else if (caracter == '*') {
            posicion = 5;
        } else if (caracter == '/') {
            posicion = 6;
        } else if (caracter == '%') {
            posicion = 7;
        } else if (caracter == '=') {
            posicion = 8;
        } else if (caracter == '!') {
            posicion = 9;
        } else if (caracter == '>') {
            posicion = 10;
        } else if (caracter == '<') {
            posicion = 11;
        } else if (caracter == '\'') {
            posicion = 12;
        } else if (caracter == '"') {
            posicion = 13;
        } else if (caracter == '#') {
            posicion = 14;
        } else if (caracter == '(') {
            posicion = 15;
        } else if (caracter == ')') {
            posicion = 16;
        } else if (caracter == '{') {
            posicion = 17;
        } else if (caracter == '}') {
            posicion = 18;
        } else if (caracter == '[') {
            posicion = 19;
        } else if (caracter == ']') {
            posicion = 20;
        } else if (caracter == ',') {
            posicion = 21;
        } else if (caracter == ';') {
            posicion = 22;
        } else if (caracter == ':') {
            posicion = 23;
        } else if (caracter == ' ' || caracter == '?' /*|| caracter == '\t'*/) {
            posicion = 24;
        } else if (caracter == '.') {
            posicion = 25;
        } else if (caracter == '\n') {
            posicion = -1;
        }  else {
            posicion = 26;
        }

        return posicion;
    }

    /**
     * Verifica se el caraceter es una letra
     *
     * @param caracter
     * @return
     */
    public boolean esLetra(char caracter) {
        for (char letra : Afd.LETRAS.toCharArray()) {
            if (String.valueOf(letra).equalsIgnoreCase(String.valueOf(caracter))) {
                return true;
            }
        }
        return false;
    }

    public boolean esDigito(char caracter) {
        return Character.isDigit(caracter);
    }

    /**
     * Verifica si el caraceter está definido en el alfabeto
     *
     * @param caracter
     * @param alfabeto
     * @return
     */
    public boolean caracterPermitido(char caracter, String alfabeto) {
        for (char c : alfabeto.toCharArray()) {
            if (String.valueOf(c).equalsIgnoreCase(String.valueOf(caracter))) {
                return true;
            }
        }
        return false;
    }
}
