/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lenguajespracticalexico.reportes;

import com.lenguajespracticalexico.analisiLexico.Token;
import com.lenguajespracticalexico.analisiLexico.enums.TipoToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class ManejoReportes {

    public ManejoReportes() {
    }

    public List<Token> reportFilters(String textFilter, List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getLexema().contains(textFilter)) {
                list.add(token);
            }
        }
        return list;
    }

    public List<Token> getIdentificadores(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getCategoria().equals(TipoToken.IDENTIFICADOR.toString())) {
                list.add(token);
            }
        }
        return list;
    }

    public List<Token> getDecimales(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getCategoria().equals(TipoToken.DECIMAL.toString())) {
                list.add(token);
            }
        }
        return list;
    }

    public List<Token> getEnteros(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getCategoria().equals(TipoToken.ENTERO.toString())) {
                list.add(token);
            }
        }
        return list;
    }

    public List<Token> getWordKeys(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getCategoria().equals(TipoToken.PALABRA_CLAVE.toString())) {
                list.add(token);
            }
        }
        return list;
    }

    public List<Token> getBooleanas(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getCategoria().equals(TipoToken.BOOLEANAS.toString())) {
                list.add(token);
            }
        }
        return list;
    }

    public List<Token> getLogicos(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getCategoria().equals(TipoToken.OPERADOR_LOGICO.toString())) {
                list.add(token);
            }
        }
        return list;
    }

    public List<Token> getTokensAsignacion(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getCategoria().equals(TipoToken.OPERADOR_ASIGNACION.toString())) {
                list.add(token);
            }
        }
        return list;
    }

    public List<Token> getTokensAritmeticos(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getCategoria().equals(TipoToken.OPERADOR_ARITMÉTICO.toString())) {
                list.add(token);
            }
        }
        return list;
    }

    public List<Token> getTokensComparacion(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getCategoria().equals(TipoToken.OPERADOR_COMPARACION.toString())) {
                list.add(token);
            }
        }
        return list;
    }

    public List<Token> getTokensCadena(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getCategoria().equals(TipoToken.CADENA.toString())) {
                list.add(token);
            }
        }
        return list;
    }

    public List<Token> getTokensComentario(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getCategoria().equals(TipoToken.COMENTARIO.toString())) {
                list.add(token);
            }
        }
        return list;
    }

    public List<Token> getTokensSignos(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getCategoria().equals(TipoToken.SIGNOS.toString())) {
                list.add(token);
            }
        }
        return list;
    }
}
