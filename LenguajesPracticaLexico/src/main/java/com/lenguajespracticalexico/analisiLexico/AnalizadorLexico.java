/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lenguajespracticalexico.analisiLexico;

import com.lenguajespracticalexico.analisiLexico.enums.ErrorToken;
import com.lenguajespracticalexico.analisiLexico.enums.TipoToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * @author luis
 */
public @Data
class AnalizadorLexico {

    private Afd afd;
    private List<Token> tokens;
    private List<Token> tokenErrores;
    private int fila;
    private int columna;
    private int tempColumn;
    private int index;
    private String stringToken;
    private int estadoActual;
    private CaracterPosicion caracterPosicion;

    public AnalizadorLexico() {
        this.afd = new Afd();
        this.caracterPosicion = new CaracterPosicion();

    }

    private void inicialiar() {
        this.tokens = new ArrayList<>();
        this.tokenErrores = new ArrayList<>();
        this.fila = 1;
        this.columna = 0;
        this.index = 0;
        this.stringToken = "";
        this.tempColumn = 0;
    }

    /**
     * Es el método principal que llama a otro método quien se encarga de
     * generar los tokens
     *
     * @param texto
     */
    public void analizarTokens(String texto) {
        inicialiar();
        texto += "\n";
        try {
            for (int i = index; index < texto.length(); i++) {
                getToken(texto);
                System.out.println("");
            }

        } catch (Exception e) {

        }
        /*System.out.println("tokens");
        tokens.forEach((list) -> System.out.println(list.toString()));
        System.out.println("errores");
        tokenErrores.forEach((list) -> System.out.println(list.toString()));*/
    }

    /**
     * Se encarga de generar los tokens
     *
     * @param texto
     */
    private void getToken(String texto) {
        this.estadoActual = 0;
        this.stringToken = "";
        char temp;
        int estadoTemp = 0;
        int estadoSiguiente = 0;
        while (index < texto.length()) {
            columna++;
            temp = texto.charAt(index);
            if (temp == '\n') {
                columna = 0;
                fila++;
            }
            System.out.println("caracter " + temp + " estado actual: " + estadoActual + " next " + estadoTemp);

            estadoTemp = siguienteEstado(temp);
            if (estadoTemp > -1) {
                stringToken += temp;
                estadoActual = estadoTemp;
                estadoSiguiente = siguienteEstado(texto.charAt(index + 1));
                if (estadoSiguiente == -1) {
                    System.out.println("token " + stringToken);
                    //creamos el token
                    crearToken(stringToken, fila, columna, estadoActual);
                    stringToken = "";
                    estadoActual = 0;
                }
            } else {
                //validamos si existe algún símbolo que no esté en el alfabeto o símbolos permitidos
                if (temp != '\n' && (int)temp!=13) {
                    stringToken += temp;
                    crearToken(stringToken, fila, columna, estadoActual);
                    stringToken = "";
                }
            }
            index++;
        }
    }

    /**
     * Crea un token, clasifica y agrega el mismo a una lista de tokens o tokens
     * erróneos
     *
     * @param stringToken
     * @param fila
     * @param columna
     * @param estadoActual
     */
    private void crearToken(String stringToken, int fila, int columna, int estadoActual) {
        Token tokenNew = new Token(stringToken, "", fila, columna + 1, "", "");
        if (isEstadoAceptado(estadoActual)) {
            clasificarToken(tokenNew, estadoActual);
            tokens.add(tokenNew);
        } else {
            tokenNew.setCategoria(ErrorToken.TOKEN_ERRONÉO.toString());
            tokenErrores.add(tokenNew);
        }
    }

    /**
     * Obtiene la posición del estado siguiente en la matriz de transición de
     * acuerdo al caracter dado
     *
     * @param caracter
     * @return
     */
    private int siguienteEstado(char caracter) {
        int estadoSiguiente = -1;
        if (caracterPosicion.getPosicionCaracter(caracter) >= 0
                && (caracterPosicion.getPosicionCaracter(caracter) < afd.getTransiciones()[0].length)) {
            estadoSiguiente = afd.getTransiciones()[estadoActual][this.caracterPosicion.getPosicionCaracter(caracter)];
        }
        return estadoSiguiente;
    }

    /**
     * Sirve para verificar si el estado actual está en la lista de estados
     * aceptados
     *
     * @param estadoActual
     * @return
     */
    private boolean isEstadoAceptado(int estadoActual) {
        for (int i : afd.getEstadosAceptacion()) {
            if (i == estadoActual) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que sirve para clasificar el tipo de token
     *
     * @param token
     * @param estadoActual
     */
    private void clasificarToken(Token token, int estadoActual) {
        for (Map.Entry<String, String> element : afd.getDiccionario().entrySet()) {
            if (element.getValue().equals(token.getLexema())) {
                token.setSubCategoria(element.getKey());
                break;
            }
        }
        switch (estadoActual) {
            case 1, 2 -> {
                if (isWordKey(token)) {
                    token.setCategoria(TipoToken.PALABRA_CLAVE.toString());
                    token.setPatron(token.getLexema());
                    token.setSubCategoria(TipoToken.PALABRA_CLAVE.toString());
                } else if (isBoolean(token)) {
                    token.setCategoria(TipoToken.BOOLEANAS.toString());
                    token.setPatron(token.getLexema());
                } else if (isLogico(token)) {
                    token.setCategoria(TipoToken.OPERADOR_LOGICO.toString());
                    token.setPatron(token.getLexema());
                } else {
                    token.setCategoria(TipoToken.IDENTIFICADOR.toString());
                    token.setPatron(ExpresionesRegulares.ID);
                    token.setSubCategoria(TipoToken.IDENTIFICADOR.toString());
                }
            }
            case 3, 4, 5, 6, 7 -> {
                token.setCategoria(TipoToken.OPERADOR_ARITMÉTICO.toString());
                token.setPatron(ExpresionesRegulares.OPERADORES);
            }
            case 8 -> {
                token.setCategoria(TipoToken.OPERADOR_ASIGNACION.toString());
                token.setPatron(ExpresionesRegulares.ASIGNACION);
            }
            case 10 -> {
                if (isAsignacion(token)) {
                    token.setCategoria(TipoToken.OPERADOR_ASIGNACION.toString());
                    token.setPatron(ExpresionesRegulares.ASIGNACION);
                } else if (isComparador(token)) {
                    token.setCategoria(TipoToken.OPERADOR_COMPARACION.toString());
                    token.setPatron(ExpresionesRegulares.COMPARACION);
                } else if (isSImbolo(token)) {
                    token.setCategoria(TipoToken.SIGNOS.toString());
                    token.setPatron(ExpresionesRegulares.OTROS);
                } else if (token.getLexema().equals(" ")) {
                    token.setCategoria(TipoToken.ESPACIO.toString());
                    token.setPatron(" ");
                } else if (token.getLexema().equals(TipoToken.OPERADOR_TERNARIO.value)) {
                    token.setCategoria(TipoToken.OPERADOR_TERNARIO.toString());
                    token.setPatron(TipoToken.OPERADOR_TERNARIO.value);
                } else if (token.getLexema().equals(TipoToken.TOKEN_PUNTO.value)) {
                    token.setCategoria(TipoToken.TOKEN_PUNTO.toString());
                    token.setPatron(TipoToken.TOKEN_PUNTO.value);
                } else {
                    token.setCategoria(TipoToken.CADENA.toString());
                    token.setPatron(ExpresionesRegulares.CADENA);
                }
            }
            case 11, 23 -> {
                token.setCategoria(TipoToken.OPERADOR_COMPARACION.toString());
                token.setPatron(ExpresionesRegulares.COMPARACION);
            }
            case 12 -> {
                token.setCategoria(TipoToken.ENTERO.toString());
                token.setPatron(ExpresionesRegulares.ENTERO);
                token.setSubCategoria(TipoToken.ENTERO.toString());
            }
            case 15 -> {
                token.setCategoria(TipoToken.COMENTARIO.toString());
                token.setPatron(ExpresionesRegulares.COMENTARIO);
                token.setSubCategoria(TipoToken.COMENTARIO.toString());
            }
            case 16, 17 -> {
                token.setCategoria(TipoToken.OPERADOR_ARITMÉTICO.toString());
                token.setPatron(ExpresionesRegulares.OPERADORES);
            }
            case 21 -> {
                token.setCategoria(TipoToken.COMENTARIO.toString());
                token.setPatron(ExpresionesRegulares.COMENTARIO);
                token.setSubCategoria(TipoToken.COMENTARIO.toString());
            }
            case 22 -> {
                token.setCategoria(TipoToken.DECIMAL.toString());
                token.setPatron(ExpresionesRegulares.DECIMAL);
                token.setSubCategoria(TipoToken.DECIMAL.toString());
            }
        }
    }

    /**
     * Verifica si el token es una palabra reservada
     *
     * @param token
     * @return
     */
    public boolean isWordKey(Token token) {
        for (String wordKey : afd.getPalabrasReservadas()) {
            if (token.getLexema().equals(wordKey)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return true if token is True or False
     *
     * @param token
     * @return
     */
    public boolean isBoolean(Token token) {
        for (String wordKey : afd.getBooleanas()) {
            if (token.getLexema().equals(wordKey)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrun true if token is an operator logico
     *
     * @param token
     * @return
     */
    public boolean isLogico(Token token) {
        for (String wordKey : afd.getOperadoresLogicos()) {
            if (token.getLexema().equals(wordKey)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return true if token is an Comparator
     *
     * @param token
     * @return
     */
    public boolean isComparador(Token token) {
        for (String wordKey : afd.getComparadores()) {
            if (token.getLexema().equals(wordKey)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrun true if token is an symbol asignacion
     *
     * @param token
     * @return
     */
    public boolean isAsignacion(Token token) {
        for (String wordKey : afd.getSimboloAsignacion()) {
            if (token.getLexema().equals(wordKey)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return true if token is a symbol of Grammar
     *
     * @param token
     * @return
     */
    public boolean isSImbolo(Token token) {
        for (char wordKey : Afd.OTROS_SIMBOLOS.toCharArray()) {
            if (token.getLexema().equals(String.valueOf(wordKey))) {
                return true;
            }
        }
        return false;
    }
}
