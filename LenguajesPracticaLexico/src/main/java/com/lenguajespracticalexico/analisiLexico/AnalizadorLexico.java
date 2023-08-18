/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lenguajespracticalexico.analisiLexico;

import com.lenguajespracticalexico.analisiLexico.enums.TipoToken;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
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

    public void analizarTokens(String texto) {
        inicialiar();
        texto += "\n";
        for (int i = index; index < texto.length(); i++) {
            getToken(texto);
            System.out.println("");
        }
        System.out.println("tokens");
        tokens.forEach((list) -> System.out.println(list.toString()));
        System.out.println("errores");
        tokenErrores.forEach((list) -> System.out.println(list.toString()));
    }

    private void getToken(String texto) {
        this.estadoActual = 0;
        this.stringToken = "";
        boolean continuar = true;
        char temp;
        int estadoTemp = 0;
        Token tokenNew = new Token();
        while ((continuar) && index < texto.length()) {
            temp = texto.charAt(index);
            if (temp == '\n') {
                this.fila++;
                columna = 0;
            } else {
                this.columna++;
                tempColumn = this.columna;
            }
            if ((Character.isSpaceChar(temp)) || temp == '\n' || estadoActual == -1) {
//                if ((estadoActual == Afd.S13) || (estadoActual == Afd.S19)
//                        || (estadoActual == Afd.S14) || (estadoActual == Afd.S20)
//                        || (estadoActual == Afd.S15) || (estadoActual == Afd.S21)) {
//                    stringToken += temp;
//                    continuar = true;
//                } else {
//                    continuar = false;
//                }
                continuar = false;
            } else {
                if (estadoActual >= 0) {
                    if (estadoActual == 10) {
                        break;
                    } else {
                        if ((estadoActual == Afd.S13) || (estadoActual == Afd.S19)) {
                            estadoTemp = Afd.S19;
                        } else if ((estadoActual == Afd.S14) || (estadoActual == Afd.S20)) {
                            estadoTemp = Afd.S20;
                        } else if ((estadoActual == Afd.S15) || (estadoActual == Afd.S21)) {
                            estadoTemp = Afd.S21;
                        } else {
                            estadoTemp = siguienteEstado(estadoActual, temp);
                        }
                        if (estadoTemp > -1) {
                            System.out.println("caracter " + temp + " estado actual: " + estadoActual + " siguiente: " + estadoTemp);
                            stringToken += temp;
                        } else {
                            tokenNew.setColumna(columna);
                            tokenNew.setFila(fila);
                            tokenNew.setLexema(stringToken);
                            if (isEstadoAceptado(estadoActual)) {
                                clasificarToken(tokenNew, estadoActual);
                                this.tokens.add(tokenNew);
                            } else {
                                index--;
                                boolean si = false;
                                for (Token token : tokens) {
                                    if (tokenNew.equals(token)) {
                                        si = true;
                                        break;
                                    }
                                }
                                if (!si) {
                                    this.tokenErrores.add(tokenNew);
                                }
                            }
                        }
                        estadoActual = estadoTemp;
                    }
                } else {
                    estadoActual = 0;
                }
            }
            this.index++;
        }
        System.out.println("token " + stringToken);
        if (estadoActual == -1) {
            index--;
        }
        tokenNew.setColumna(columna);
        tokenNew.setFila(fila);
        tokenNew.setLexema(stringToken);
        if (isEstadoAceptado(estadoActual)) {
            clasificarToken(tokenNew, estadoActual);
            this.tokens.add(tokenNew);
        } else {
            index--;
            boolean si = false;
            for (Token token : tokens) {
                if (tokenNew.equals(token)) {
                    si = true;
                    break;
                }
            }
            if (!si) {
                this.tokenErrores.add(tokenNew);
            }
        }

    }

    private int siguienteEstado(int estadoActual, char caracter) {
        int estadoSiguiente = -1;
        if (caracterPosicion.getPosicionCaracter(caracter) >= 0
                && (caracterPosicion.getPosicionCaracter(caracter) < afd.getTransiciones()[0].length)) {
            estadoSiguiente = afd.getTransiciones()[estadoActual][this.caracterPosicion.getPosicionCaracter(caracter)];
        }
        return estadoSiguiente;
    }

    private boolean isEstadoAceptado(int estadoActual) {
        for (int i : afd.getEstadosAceptacion()) {
            if (i == estadoActual) {
                return true;
            }
        }
        return false;
    }

    private void clasificarToken(Token token, int estadoActual) {
        switch (estadoActual) {
            case 1, 2 -> {
                if (isWordKey(token)) {
                    token.setCategoria(TipoToken.PALABRA_CLAVE.toString());
                    token.setPatron(ExpresionesRegulares.PALABRAS_CLAVE);
                } else if (isBoolean(token)) {
                    token.setCategoria(TipoToken.BOOLEANAS.toString());
                    token.setPatron(ExpresionesRegulares.PALABRAS_CLAVE);
                } else if (isLogico(token)) {
                    token.setCategoria(TipoToken.OPERADOR_LOGICO.toString());
                    token.setPatron(ExpresionesRegulares.PALABRAS_CLAVE);
                } else {
                    token.setCategoria(TipoToken.IDENTIFICADOR.toString());
                    token.setPatron(ExpresionesRegulares.ID);
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
            }
            case 16, 17 -> {
                token.setCategoria(TipoToken.OPERADOR_ARITMÉTICO.toString());
                token.setPatron(ExpresionesRegulares.OPERADORES);
            }
            case 21 -> {
                token.setCategoria(TipoToken.COMENTARIO.toString());
                token.setPatron(ExpresionesRegulares.COMENTARIO);
            }
            case 22 -> {
                token.setCategoria(TipoToken.DECIMAL.toString());
                token.setPatron(ExpresionesRegulares.DECIMAL);
            }
        }
    }

    /**
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

    public boolean isComparador(Token token) {
        for (String wordKey : afd.getComparadores()) {
            if (token.getLexema().equals(wordKey)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAsignacion(Token token) {
        for (String wordKey : afd.getSimboloAsignacion()) {
            if (token.getLexema().equals(wordKey)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSImbolo(Token token) {
        for (char wordKey : Afd.OTROS_SIMBOLOS.toCharArray()) {
            if (token.getLexema().equals(String.valueOf(wordKey))) {
                return true;
            }
        }
        return false;
    }
}
