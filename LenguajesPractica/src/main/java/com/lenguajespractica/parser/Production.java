package com.lenguajespractica.parser;

import com.lenguajespracticalexico.analisiLexico.Token;
import com.lenguajespracticalexico.analisiLexico.enums.TipoToken;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Production {

    private List<String[]> producciones;


    public Production() {
        inicializr();
    }

    private void inicializr() {
        this.producciones = new ArrayList<>();
        this.producciones.add(new String[]{"B"}); // 0
        this.producciones.add(new String[]{"FUNTION"}); // 1
        this.producciones.add(new String[]{"INSTRUCCION"}); // 2
        this.producciones.add(new String[]{"SENTENCIA"}); // 3
        this.producciones.add(new String[]{"VALOR"}); // 4
        this.producciones.add(new String[]{"ARREGLO"}); // 5
        this.producciones.add(new String[]{"DICCIONARIO"}); // 6
        this.producciones.add(new String[]{"VALUE_ARRAY"}); // 7
        this.producciones.add(new String[]{"CONTENT_ARRAY"}); // 8
        this.producciones.add(new String[]{"DICC_CONTENT"}); // 9

        this.producciones.add(new String[]{"ELEMENT_DICC"}); // 10
        this.producciones.add(new String[]{"OPERACION"}); // 11
        this.producciones.add(new String[]{"X"}); // 12
        this.producciones.add(new String[]{"X'"}); // 13
        this.producciones.add(new String[]{"T"}); // 14
        this.producciones.add(new String[]{"T'"}); // 15
        this.producciones.add(new String[]{"P"}); // 16
        this.producciones.add(new String[]{"P'"}); // 17
        this.producciones.add(new String[]{"U"}); // 18
        this.producciones.add(new String[]{"E"}); // 19

        this.producciones.add(new String[]{"RETURN"}); // 20
        this.producciones.add(new String[]{"SEPARADOR"}); // 21
        this.producciones.add(new String[]{"PARAMS"}); // 22
        this.producciones.add(new String[]{"BREAK"}); // 23
        this.producciones.add(new String[]{"END_IF"}); // 24
        this.producciones.add(new String[]{"FOR_OPCION"}); // 25
        this.producciones.add(new String[]{"RANGE_PARAM"}); // 26
        this.producciones.add(new String[]{"RANGE_VALUE"}); // 27
        this.producciones.add(new String[]{"OTHER"}); // 28
        this.producciones.add(new String[]{"SIMBOLO"}); // 29

        this.producciones.add(new String[]{"SIGNO_ASIGNACION"}); // 30
        this.producciones.add(new String[]{"EXP"}); // 31
        this.producciones.add(new String[]{"OPT_COMP"}); // 32
        this.producciones.add(new String[]{"IS"}); // 33
        this.producciones.add(new String[]{"OPT_COMP"}); // 34
        this.producciones.add(new String[]{"IS"}); // 35
        this.producciones.add(new String[]{"NEXT_IS"}); // 36
        this.producciones.add(new String[]{"COMP"}); // 37
        this.producciones.add(new String[]{"CONDICION"}); // 38
        this.producciones.add(new String[]{"CONDICION_END"}); // 39

        this.producciones.add(new String[]{TipoToken.ID.getValue()}); // 40
        this.producciones.add(new String[]{TipoToken.CADENA.getValue()}); // 41
        this.producciones.add(new String[]{TipoToken.TRUE.getValue()}); // 42
        this.producciones.add(new String[]{TipoToken.FALSE.getValue()}); // 43
        this.producciones.add(new String[]{"[", "CONTENT_ARRAY", "]"}); // 44
        this.producciones.add(new String[]{"VALUE_ARRAY", "SEPARADOR", "CONTENT_ARRAY"}); // 45
        this.producciones.add(new String[]{"{ DICC_CONTENT }"}); // 46
        this.producciones.add(new String[]{TipoToken.CADENA.getValue(), ":", "VALUE_ARRAY", "SEPARADOR", "DICC_CONTENT"}); // 47
        this.producciones.add(new String[]{"(", "X", ")"}); // 48
        this.producciones.add(new String[]{"T", "X'"}); // 49

        this.producciones.add(new String[]{"+", "T"}); // 50
        this.producciones.add(new String[]{"-", "T"}); // 51
        this.producciones.add(new String[]{"P", "T'"}); // 52
        this.producciones.add(new String[]{"*", "P"}); // 53
        this.producciones.add(new String[]{"/", "P"}); // 54
        this.producciones.add(new String[]{"//", "P"}); // 55
        this.producciones.add(new String[]{"%", "P"}); // 56
        this.producciones.add(new String[]{"U", "P'"}); // 57
        this.producciones.add(new String[]{"**", "P"}); // 58
        this.producciones.add(new String[]{"-", "E"}); // 59

        this.producciones.add(new String[]{"E"}); // 60
        this.producciones.add(new String[]{"return", "VALOR"}); // 61
        this.producciones.add(new String[]{"yield", "VALOR"}); // 62
        this.producciones.add(new String[]{","}); // 63
        this.producciones.add(new String[]{"def", TipoToken.ID.getValue(), "(", "PARAMS", ")", ":"});//64
        this.producciones.add(new String[]{"VALOR", "SEPARADOR", "PARAMS"});//65
        this.producciones.add(new String[]{"if", "CONDICION", ":"});//66
        this.producciones.add(new String[]{"while", "CONDICION", ":"});//67
        this.producciones.add(new String[]{"if", "CONDICION", ":"});//68
        this.producciones.add(new String[]{"for", TipoToken.ID.getValue(), "in", "FOR_OPCION", ":"});//69

        this.producciones.add(new String[]{"break"}); // 70
        this.producciones.add(new String[]{"else", ":"}); // 71
        this.producciones.add(new String[]{"elif", "CONDICION", ":"}); // 72
        this.producciones.add(new String[]{"range", "(", "RANGE_PARAM", ")"}); // 73
        this.producciones.add(new String[]{"RANGE_VALUE", "OTHER"}); // 74
        this.producciones.add(new String[]{",", "RANGE_VALUE"}); // 75
        this.producciones.add(new String[]{"print", "(", "PARAMS", ")"}); // 76
        this.producciones.add(new String[]{TipoToken.ID.getValue(), "SIMBOLO"}); // 77
        this.producciones.add(new String[]{TipoToken.OPERADOR_ASIGNACION_MODULO_IGUAL.getValue(), "EXP"}); // 78
        this.producciones.add(new String[]{TipoToken.OPERADOR_ASIGNACION_MAS_IGUAL.getValue(), "EXP"}); // 79

        this.producciones.add(new String[]{TipoToken.OPERADOR_ASIGNACION_MENOS_IGUAL.getValue(), "EXP"}); // 80
        this.producciones.add(new String[]{TipoToken.OPERADOR_ASIGNACION_POR_IGUAL.getValue(), "EXP"}); // 81
        this.producciones.add(new String[]{TipoToken.OPERADOR_ASIGNACION_EXPONENTE_IGUAL.getValue(), "EXP"}); // 82
        this.producciones.add(new String[]{TipoToken.OPERADOR_ASIGNACION_DIV_IGUAL.getValue(), "EXP"}); // 83
        this.producciones.add(new String[]{TipoToken.OPERADOR_ASIGNACION_DIV_2_IGUAL.getValue(), "EXP"}); // 84
        this.producciones.add(new String[]{TipoToken.OPERADOR_ASIGNACION_MODULO_IGUAL.getValue(), "EXP"}); // 85
        this.producciones.add(new String[]{"(", "PARAMS", ")"}); // 86
        this.producciones.add(new String[]{"=", "EXP"}); // 87
        this.producciones.add(new String[]{"VALOR", "OPT_COMP"}); // 88
        this.producciones.add(new String[]{"OPERACION", "OPT_COMP"}); // 89

        this.producciones.add(new String[]{"not", "COMP"}); // 90
        this.producciones.add(new String[]{"signo_comparacion", "VALOR", "OPT_LOGICO"}); // 91
        this.producciones.add(new String[]{"in", "VALOR"}); // 92
        this.producciones.add(new String[]{"not", "in", "VALOR"}); // 93
        this.producciones.add(new String[]{"if", "CONDICION", "else", "VALOR"}); // 94
        this.producciones.add(new String[]{"IS"}); // 95
        this.producciones.add(new String[]{"and", "COMP"}); // 96
        this.producciones.add(new String[]{"or", "COMP"}); // 97
        this.producciones.add(new String[]{"is", "NEXT_IS"}); // 98
        this.producciones.add(new String[]{"not", "VALOR"}); // 99
        this.producciones.add(new String[]{"VALOR", "signo_comparacion", "VALOR"}); // 100
        this.producciones.add(new String[]{"VALOR", "CONDICION_END"}); // 101
        this.producciones.add(new String[]{"not", "VALOR", "CONDICION_END"}); // 102
        this.producciones.add(new String[]{"=="}); // 103
        this.producciones.add(new String[]{">="}); // 104
        this.producciones.add(new String[]{"<="}); // 105
        this.producciones.add(new String[]{">"}); // 106
        this.producciones.add(new String[]{"<"}); // 107
        this.producciones.add(new String[]{"!="}); // 108
        this.producciones.add(new String[]{Parser.EPSILON});//109
        this.producciones.add(new String[]{"num"}); // 110

    }

    public String[] getProducction(Token token, String producion) {
        String[] p = new String[]{Parser.SINTAXIS_ERROR};
        //con B
        if (token.getSubCategoria().equals(TipoToken.ID.getValue()) && producion.equals("B")) {
            p = this.producciones.get(3);
        } else if (token.getLexema().equals("print") && producion.equals("B")) {
            p = this.producciones.get(3);
        } else if (token.getLexema().equals("if") && producion.equals("B")) {
            p = this.producciones.get(2);
        } else if (token.getLexema().equals("while") && producion.equals("B")) {
            p = this.producciones.get(2);
        } else if (token.getLexema().equals("for") && producion.equals("B")) {
            p = this.producciones.get(2);
        } else if (token.getLexema().equals("def") && producion.equals("B")) {
            p = this.producciones.get(1);
        } else if (token.getLexema().equals("return") && producion.equals("B")) {
            p = this.producciones.get(20);
        } else if (token.getLexema().equals("yield") && producion.equals("B")) {
            p = this.producciones.get(20);
        } else if (token.getLexema().equals("break") && producion.equals("B")) {
            p = this.producciones.get(23);
        }
        //FUNTION
        else if (token.getLexema().equals("def") && producion.equals("FUNTION")) {
            p = this.producciones.get(1);
        }
        //INSTRUCCION
        else if (token.getLexema().equals("if") && producion.equals("INSTRUCCION")) {
            p = this.producciones.get(68);
        } else if (token.getLexema().equals("while") && producion.equals("INSTRUCCION")) {
            p = this.producciones.get(68);
        } else if (token.getLexema().equals("for") && producion.equals("INSTRUCCION")) {
            p = this.producciones.get(68);
        }
        //SENTENCIA
        else if (token.getSubCategoria().equals(TipoToken.ID.getValue()) && producion.equals("SENTENCIA")) {
            p = this.producciones.get(77);
        } else if (token.getSubCategoria().equals("print") && producion.equals("SENTENCIA")) {
            p = this.producciones.get(76);
        }
        //valor
        else if (token.getSubCategoria().equals(TipoToken.ID.getValue()) && producion.equals("VALOR")) {
            p = this.producciones.get(40);
        } else if ((token.getSubCategoria().equals(TipoToken.DECIMAL.getValue()) || token.getSubCategoria().equals(TipoToken.ENTERO.getValue()))
                && producion.equals("VALOR")) {
            p = this.producciones.get(110);
        } else if ((token.getSubCategoria().equals(TipoToken.CADENA.getValue()) && producion.equals("VALOR"))) {
            p = this.producciones.get(41);
        } else if ((token.getSubCategoria().equals(TipoToken.TRUE.getValue()) && producion.equals("VALOR"))) {
            p = this.producciones.get(42);
        } else if ((token.getSubCategoria().equals(TipoToken.FALSE.getValue()) && producion.equals("VALOR"))) {
            p = this.producciones.get(43);
        } else if ((token.getSubCategoria().equals(TipoToken.SIGNOS_PAREN_OPEN.getValue()) && producion.equals("VALOR"))) {
            p = this.producciones.get(11);
        } else if ((token.getSubCategoria().equals(TipoToken.SIGNOS_CORCHETE_OPEN.getValue()) && producion.equals("VALOR"))) {
            p = this.producciones.get(5);
        } else if ((token.getSubCategoria().equals(TipoToken.SIGNOS_LLAVE_OPEN.getValue()) && producion.equals("VALOR"))) {
            p = this.producciones.get(6);
        }
        //ARREGLO
        else if ((token.getSubCategoria().equals(TipoToken.SIGNOS_CORCHETE_OPEN.getValue()) && producion.equals("ARREGLO"))) {
            p = this.producciones.get(44);
        }
        //DICCIONARIO
        else if ((token.getSubCategoria().equals(TipoToken.SIGNOS_LLAVE_OPEN.getValue()) && producion.equals("DICCIONARIO"))) {
            p = this.producciones.get(46);
        }
        //VALUE_ARRAY
        else if ((token.getSubCategoria().equals(TipoToken.CADENA.getValue()) && producion.equals("VALUE_ARRAY"))) {
            p = this.producciones.get(41);
        } else if ((token.getSubCategoria().equals(TipoToken.DECIMAL.getValue()) || token.getSubCategoria().equals(TipoToken.ENTERO.getValue()))
                && producion.equals("VALUE_ARRAY")) {
            p = this.producciones.get(110);
        } else if ((token.getSubCategoria().equals(TipoToken.TRUE.getValue()) && producion.equals("VALUE_ARRAY"))) {
            p = this.producciones.get(42);
        } else if ((token.getSubCategoria().equals(TipoToken.FALSE.getValue()) && producion.equals("VALUE_ARRAY"))) {
            p = this.producciones.get(43);
        }
        return p;
    }
}