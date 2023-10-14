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
        this.producciones.add(new String[]{"{", "DICC_CONTENT", "}"}); // 46
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
        this.producciones.add(new String[]{TipoToken.NUMERO.getValue()}); // 110

    }

    public String[] getProducction(Token token, String producion) {
        String[] p = new String[]{Parser.SINTAXIS_ERROR};
        //con B
        if (token.getSubCategoria().equals(TipoToken.ID.getValue()) && producion.equals("B")) {
            p = this.producciones.get(3);
        }
        //prueba caso-epsilon
        else if (token.getSubCategoria().equals("$") && producion.equalsIgnoreCase("OPT_COMP")) {
            p = new String[]{Parser.EPSILON};
        } else if (token.getSubCategoria().equals("$") && producion.equalsIgnoreCase("OPT_LOGICO")) {
            p = this.producciones.get(109);
        }
        //
        else if (token.getLexema().equals("print") && producion.equals("B")) {
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
        } else if ((token.getLexema().equals("elif") || token.getSubCategoria().equals("else")) && producion.equals("B")) {
            p = this.producciones.get(24);
        }
        //FUNTION
        else if (token.getLexema().equals("def") && producion.equals("FUNTION")) {
            p = this.producciones.get(64);
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
        } else if ((token.getSubCategoria().equals(TipoToken.NUMERO.getValue()))
                && producion.equals("VALOR")) {
            p = this.producciones.get(110);
        } else if ((token.getSubCategoria().equals(TipoToken.CADENA.getValue()) && producion.equals("VALOR"))) {
            p = this.producciones.get(41);
        } else if ((token.getSubCategoria().equals(TipoToken.TRUE.getValue()) && producion.equals("VALOR"))) {
            p = this.producciones.get(42);
        } else if ((token.getSubCategoria().equals(TipoToken.FALSE.getValue()) && producion.equals("VALOR"))) {
            p = this.producciones.get(43);
        } else if ((token.getSubCategoria().equals(TipoToken.PARENTESIS_OPEN.getValue()) && producion.equals("VALOR"))) {
            p = this.producciones.get(11);
        } else if ((token.getSubCategoria().equals(TipoToken.CORCHETE_OPEN.getValue()) && producion.equals("VALOR"))) {
            p = this.producciones.get(5);
        } else if ((token.getSubCategoria().equals(TipoToken.LLAVE_OPEN.getValue()) && producion.equals("VALOR"))) {
            p = this.producciones.get(6);
        }
        //ARREGLO
        else if ((token.getSubCategoria().equals(TipoToken.CORCHETE_OPEN.getValue()) && producion.equals("ARREGLO"))) {
            p = this.producciones.get(44);
        }
        //DICCIONARIO
        else if ((token.getSubCategoria().equals(TipoToken.LLAVE_OPEN.getValue()) && producion.equals("DICCIONARIO"))) {
            p = this.producciones.get(46);
        }
        //VALUE_ARRAY
        else if ((token.getSubCategoria().equals(TipoToken.CADENA.getValue()) && producion.equals("VALUE_ARRAY"))) {
            p = this.producciones.get(41);
        } else if ((token.getSubCategoria().equals(TipoToken.NUMERO.getValue()))
                && producion.equals("VALUE_ARRAY")) {
            p = this.producciones.get(110);
        } else if ((token.getSubCategoria().equals(TipoToken.TRUE.getValue()) && producion.equals("VALUE_ARRAY"))) {
            p = this.producciones.get(42);
        } else if ((token.getSubCategoria().equals(TipoToken.FALSE.getValue()) && producion.equals("VALUE_ARRAY"))) {
            p = this.producciones.get(43);
        }
        //CONTENT_ARRAY
        else if (((token.getSubCategoria().equals(TipoToken.CADENA.getValue())
                || token.getSubCategoria().equals(TipoToken.NUMERO.getValue())
                || token.getSubCategoria().equals(TipoToken.TRUE.getValue())
                || token.getSubCategoria().equals(TipoToken.FALSE.getValue())
        )
                && producion.equals("CONTENT_ARRAY"))) {
            p = this.producciones.get(45);
        } else if ((token.getSubCategoria().equals("]") && producion.equals("CONTENT_ARRAY"))) {
            p = this.producciones.get(109);
        }
        //DICC_CONTENT
        else if ((token.getSubCategoria().equals(TipoToken.CADENA.getValue()) && producion.equals("DICC_CONTENT"))) {
            p = this.producciones.get(10);
        } else if ((token.getSubCategoria().equals(TipoToken.SIGNOS_LLAVE_CLOSE.getValue()) && producion.equals("DICC_CONTENT"))) {
            p = this.producciones.get(109);
        }
        //ELEMENT_DICC
        else if ((token.getSubCategoria().equals(TipoToken.CADENA.getValue()) && producion.equals("ELEMENT_DICC"))) {
            p = this.producciones.get(47);
        }
        //OPERACION
        else if ((token.getSubCategoria().equals(TipoToken.PARENTESIS_OPEN.getValue()) && producion.equals("OPERACION"))) {
            p = this.producciones.get(48);
        }
        //x
        else if (((token.getSubCategoria().equals(TipoToken.PARENTESIS_OPEN.getValue())
                || token.getSubCategoria().equals(TipoToken.NUMERO.getValue())
                || token.getSubCategoria().equals(TipoToken.TRUE.getValue())
                || token.getSubCategoria().equals(TipoToken.ID.getValue())
                || token.getLexema().equals("-"))
                && producion.equals("X"))) {
            p = this.producciones.get(49);
        }
        //x'
        else if (token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMETICO_MAS.getValue()) && producion.equals("X'")) {
            p = this.producciones.get(50);
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMETICO_MENOS.getValue()) && producion.equals("X'")) {
            p = this.producciones.get(51);
        } else if (token.getSubCategoria().equals(TipoToken.PARENTESIS_CLOSE.getValue()) && producion.equals("X'")) {
            p = this.producciones.get(109);
        }
        //T
        else if (((token.getSubCategoria().equals(TipoToken.PARENTESIS_OPEN.getValue())
                || token.getSubCategoria().equals(TipoToken.NUMERO.getValue())
                || token.getSubCategoria().equals(TipoToken.TRUE.getValue())
                || token.getSubCategoria().equals(TipoToken.ID.getValue())
                || token.getLexema().equals("-"))
                && producion.equals("T"))) {
            p = this.producciones.get(52);
        }
        //T'
        else if ((token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMÉTICO_DIV_2.getValue())
                && producion.equalsIgnoreCase("T'"))) {
            p = this.producciones.get(54);
        } else if ((token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMÉTICO_DIV.getValue())
                && producion.equalsIgnoreCase("T'"))) {
            p = this.producciones.get(55);
        } else if ((token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMÉTICO_MULTI.getValue()) && producion.equalsIgnoreCase("T'"))) {
            p = this.producciones.get(53);
        } else if ((token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMÉTICO_MODULO.getValue()) && producion.equalsIgnoreCase("T'"))) {
            p = this.producciones.get(56);
        } else if ((token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMETICO_MAS.getValue())
                || token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMETICO_MENOS.getValue())) && producion.equalsIgnoreCase("T'")) {
            p = this.producciones.get(109);
        }
        //p
        else if ((token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMETICO_MENOS.getValue())
                || token.getSubCategoria().equals(TipoToken.PARENTESIS_CLOSE.getValue())
                || token.getSubCategoria().equals(TipoToken.TRUE.getValue())
                || token.getSubCategoria().equals(TipoToken.NUMERO.getValue())
                || token.getSubCategoria().equals(TipoToken.ID.getValue()))
                && producion.equalsIgnoreCase("P")) {
            p = this.producciones.get(57);
        }
        //P'
        else if ((token.getSubCategoria().equals(TipoToken.PARENTESIS_CLOSE.getValue())
                || token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMETICO_MAS.getValue())
                || token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMETICO_MENOS.getValue())
                || token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMÉTICO_DIV_2.getValue())
                || token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMÉTICO_DIV.getValue())
                || token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMÉTICO_MULTI.getValue())
                || token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMÉTICO_MODULO.getValue()))
                && producion.equalsIgnoreCase("P'")) {
            p = this.producciones.get(109);
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMÉTICO_EXPONENTE.getValue()) && producion.equalsIgnoreCase("P'")) {
            p = this.producciones.get(58);
        }
        //U
        else if ((token.getSubCategoria().equals(TipoToken.ID.getValue())
                || token.getSubCategoria().equals(TipoToken.NUMERO.getValue())
                || token.getSubCategoria().equals(TipoToken.TRUE.getValue())
                || token.getSubCategoria().equals(TipoToken.PARENTESIS_OPEN.getValue())
        )
                && producion.equalsIgnoreCase("U")) {
            p = this.producciones.get(60);
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_ARITMETICO_MENOS.getValue()) && producion.equalsIgnoreCase("U")) {
            p = this.producciones.get(59);
        }
        //E
        else if (token.getSubCategoria().equals(TipoToken.ID.getValue()) && producion.equalsIgnoreCase("E")) {
            p = this.producciones.get(40);
        } else if ((token.getSubCategoria().equals(TipoToken.NUMERO.getValue()))
                && producion.equalsIgnoreCase("E")) {
            p = this.producciones.get(110);
        } else if (token.getSubCategoria().equals(TipoToken.TRUE.getValue()) && producion.equalsIgnoreCase("E")) {
            p = this.producciones.get(42);
        } else if (token.getSubCategoria().equals(TipoToken.PARENTESIS_OPEN.getValue()) && producion.equalsIgnoreCase("E")) {
            p = this.producciones.get(11);
        }
        //RETURN
        else if (token.getSubCategoria().equals("return") && producion.equalsIgnoreCase("RETURN")) {
            p = this.producciones.get(61);
        } else if (token.getSubCategoria().equals("yield") && producion.equalsIgnoreCase("RETURN")) {
            p = this.producciones.get(62);
        }
        //SEPARADOR
        else if ((token.getSubCategoria().equals(TipoToken.ID.getValue())
                || token.getSubCategoria().equals(TipoToken.NUMERO.getValue())
                || token.getSubCategoria().equals(TipoToken.CADENA.getValue())
                || token.getSubCategoria().equals(TipoToken.TRUE.getValue())
                || token.getSubCategoria().equals(TipoToken.FALSE.getValue())
                || token.getSubCategoria().equals(TipoToken.PARENTESIS_CLOSE.getValue())
                || token.getSubCategoria().equals(TipoToken.SIGNOS_CORCHETE_CLOSE.getValue())
                || token.getSubCategoria().equals(TipoToken.SIGNOS_LLAVE_CLOSE.getValue())
        )
                && producion.equalsIgnoreCase("SEPARADOR")) {
            p = this.producciones.get(109);
        } else if (token.getSubCategoria().equals(",") && producion.equalsIgnoreCase("SEPARADOR")) {
            p = new String[]{","};
        }
        //PARAMS
        else if ((token.getSubCategoria().equals(TipoToken.ID.getValue())
                || token.getSubCategoria().equals(TipoToken.CADENA.getValue())
                || token.getSubCategoria().equals(TipoToken.NUMERO.getValue())
                || token.getSubCategoria().equals(TipoToken.TRUE.getValue())
                || token.getSubCategoria().equals(TipoToken.FALSE.getValue())
                || token.getSubCategoria().equals(TipoToken.PARENTESIS_OPEN.getValue())
                || token.getSubCategoria().equals(TipoToken.CORCHETE_OPEN.getValue())
                || token.getSubCategoria().equals(TipoToken.LLAVE_OPEN.getValue())
        )
                && producion.equalsIgnoreCase("PARAMS")) {
            p = this.producciones.get(65);
        } else if (token.getSubCategoria().equals(TipoToken.PARENTESIS_CLOSE.getValue()) && producion.equalsIgnoreCase("PARAMS")) {
            p = this.producciones.get(109);
        }
        //break
        else if (token.getSubCategoria().equals("break") && producion.equalsIgnoreCase("BREAK")) {
            p = new String[]{"break"};
        }
        //END_IF
        else if (token.getSubCategoria().equals("else") && producion.equalsIgnoreCase("END_IF")) {
            p = this.producciones.get(71);
        } else if (token.getSubCategoria().equals("elif") && producion.equalsIgnoreCase("END_IF")) {
            p = this.producciones.get(72);
        }
        //FOR_OPCION
        else if (token.getSubCategoria().equals(TipoToken.ID.getValue()) && producion.equalsIgnoreCase("FOR_OPCION")) {
            p = new String[]{TipoToken.ID.getValue()};
        } else if (token.getSubCategoria().equals(TipoToken.CORCHETE_OPEN.getValue()) && producion.equalsIgnoreCase("FOR_OPCION")) {
            p = this.producciones.get(5);
        } else if (token.getSubCategoria().equals("range") && producion.equalsIgnoreCase("FOR_OPCION")) {
            p = this.producciones.get(73);
        }
        //RANGE_PARAM
        else if (token.getSubCategoria().equals(TipoToken.ID.getValue()) && producion.equalsIgnoreCase("RANGE_PARAM")) {
            p = this.producciones.get(74);
        } else if (token.getSubCategoria().equals(TipoToken.NUMERO.getValue()) && producion.equalsIgnoreCase("RANGE_PARAM")) {
            p = this.producciones.get(74);
        } else if (token.getSubCategoria().equals(TipoToken.PARENTESIS_CLOSE.getValue()) && producion.equalsIgnoreCase("FOR_OPCION")) {
            p = this.producciones.get(109);
        }
        //RANGE_VALUE
        else if (token.getSubCategoria().equals(TipoToken.ID.getValue()) && producion.equalsIgnoreCase("RANGE_VALUE")) {
            p = new String[]{TipoToken.ID.getValue()};
        } else if (token.getSubCategoria().equals(TipoToken.NUMERO.getValue()) && producion.equalsIgnoreCase("RANGE_VALUE")) {
            p = new String[]{TipoToken.NUMERO.getValue()};
        }
        //OTHER
        else if (token.getSubCategoria().equals(TipoToken.SIGNOS_COMA.getValue()) && producion.equalsIgnoreCase("OTHER")) {
            p = this.producciones.get(75);
        } else if (token.getSubCategoria().equals(TipoToken.PARENTESIS_CLOSE.getValue()) && producion.equalsIgnoreCase("OTHER")) {
            p = this.producciones.get(109);
        }
        //SIMBOLO
        else if (token.getSubCategoria().equals(TipoToken.OPERADOR_ASIGNACION_MODULO_IGUAL.getValue()) && producion.equalsIgnoreCase("SIMBOLO")) {
            p = this.producciones.get(78);
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_ASIGNACION_MAS_IGUAL.getValue()) && producion.equalsIgnoreCase("SIMBOLO")) {
            p = this.producciones.get(79);
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_ASIGNACION_MENOS_IGUAL.getValue()) && producion.equalsIgnoreCase("SIMBOLO")) {
            p = this.producciones.get(80);
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_ASIGNACION_POR_IGUAL.getValue()) && producion.equalsIgnoreCase("SIMBOLO")) {
            p = this.producciones.get(81);
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_ASIGNACION_EXPONENTE_IGUAL.getValue()) && producion.equalsIgnoreCase("SIMBOLO")) {
            p = this.producciones.get(82);
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_ASIGNACION_DIV_IGUAL.getValue()) && producion.equalsIgnoreCase("SIMBOLO")) {
            p = this.producciones.get(83);
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_ASIGNACION_DIV_2_IGUAL.getValue()) && producion.equalsIgnoreCase("SIMBOLO")) {
            p = this.producciones.get(84);
        } else if (token.getSubCategoria().equals(TipoToken.PARENTESIS_OPEN.getValue()) && producion.equalsIgnoreCase("SIMBOLO")) {
            p = this.producciones.get(86);
        } else if (token.getSubCategoria().equals(TipoToken.SIGNO_IGUAL.getValue()) && producion.equalsIgnoreCase("SIMBOLO")) {
            p = this.producciones.get(87);
        }
        //EXP
        else if ((token.getSubCategoria().equals(TipoToken.ID.getValue())
                || token.getSubCategoria().equals(TipoToken.CADENA.getValue())
                || token.getSubCategoria().equals(TipoToken.NUMERO.getValue())
                || token.getSubCategoria().equals(TipoToken.TRUE.getValue())
                || token.getSubCategoria().equals(TipoToken.FALSE.getValue())
                || token.getSubCategoria().equals(TipoToken.PARENTESIS_OPEN.getValue())
                || token.getSubCategoria().equals(TipoToken.CORCHETE_OPEN.getValue())
                || token.getSubCategoria().equals(TipoToken.LLAVE_OPEN.getValue())
        )
                && producion.equalsIgnoreCase("EXP")) {
            p = this.producciones.get(88);
        } else if (token.getSubCategoria().equals("not") && producion.equalsIgnoreCase("EXP")) {
            p = this.producciones.get(90);
        }
        //OPT_COMP
        else if (token.getSubCategoria().equals(TipoToken.NOT.getValue()) && producion.equalsIgnoreCase("EXP")) {
            p = this.producciones.get(93);
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_COMPARACION_IGUAL.getValue()) && producion.equalsIgnoreCase("OPT_COMP")) {
            p = new String[]{"==", "VALOR", "OPT_LOGICO"};
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_COMPARACION_DIFERENTE.getValue()) && producion.equalsIgnoreCase("OPT_COMP")) {
            p = new String[]{"!=", "VALOR", "OPT_LOGICO"};
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_COMPARACION_MAYOR_QUE.getValue()) && producion.equalsIgnoreCase("OPT_COMP")) {
            p = new String[]{">", "VALOR", "OPT_LOGICO"};
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_COMPARACION_MAYOR_IGUAL.getValue()) && producion.equalsIgnoreCase("OPT_COMP")) {
            p = new String[]{">=", "VALOR", "OPT_LOGICO"};
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_COMPARACION_MENOR_IGUAL.getValue()) && producion.equalsIgnoreCase("OPT_COMP")) {
            p = new String[]{"<=", "VALOR", "OPT_LOGICO"};
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_COMPARACION_MENOR_QUE.getValue()) && producion.equalsIgnoreCase("OPT_COMP")) {
            p = new String[]{"<", "VALOR", "OPT_LOGICO"};
        } else if (token.getSubCategoria().equals("if") && producion.equalsIgnoreCase("OPT_COMP")) {
            p = this.producciones.get(94);
        } else if (token.getSubCategoria().equals("in") && producion.equalsIgnoreCase("OPT_COMP")) {
            p = this.producciones.get(92);
        } else if (token.getSubCategoria().equals("is") && producion.equalsIgnoreCase("OPT_COMP")) {
            p = this.producciones.get(95);
        }
        //OPT_LOGICO
        else if (token.getSubCategoria().equals(TipoToken.AND.getValue()) && producion.equalsIgnoreCase("OPT_LOGICO")) {
            p = new String[]{TipoToken.AND.getValue(), "COMP"};
        } else if (token.getSubCategoria().equals(TipoToken.OR.getValue()) && producion.equalsIgnoreCase("OPT_LOGICO")) {
            p = new String[]{TipoToken.OR.getValue(), "COMP"};
        }

        //IS
        else if (token.getSubCategoria().equals("is") && producion.equalsIgnoreCase("IS")) {
            p = this.producciones.get(98);
        }
        //NEXT_IS
        else if ((token.getSubCategoria().equals(TipoToken.ID.getValue())
                || token.getSubCategoria().equals(TipoToken.CADENA.getValue())
                || token.getSubCategoria().equals(TipoToken.NUMERO.getValue())
                || token.getSubCategoria().equals(TipoToken.TRUE.getValue())
                || token.getSubCategoria().equals(TipoToken.FALSE.getValue())
                || token.getSubCategoria().equals(TipoToken.PARENTESIS_OPEN.getValue())
                || token.getSubCategoria().equals(TipoToken.CORCHETE_OPEN.getValue())
                || token.getSubCategoria().equals(TipoToken.LLAVE_OPEN.getValue())
        )
                && producion.equalsIgnoreCase("NEXT_IS")) {
            p = this.producciones.get(4);
        } else if (token.getSubCategoria().equals(TipoToken.NOT.getValue()) && producion.equalsIgnoreCase("NEXT_IS")) {
            p = this.producciones.get(99);
        }
        //COMP
        else if ((token.getSubCategoria().equals(TipoToken.ID.getValue())
                || token.getSubCategoria().equals(TipoToken.CADENA.getValue())
                || token.getSubCategoria().equals(TipoToken.NUMERO.getValue())
                || token.getSubCategoria().equals(TipoToken.TRUE.getValue())
                || token.getSubCategoria().equals(TipoToken.FALSE.getValue())
                || token.getSubCategoria().equals(TipoToken.PARENTESIS_OPEN.getValue())
                || token.getSubCategoria().equals(TipoToken.CORCHETE_OPEN.getValue())
                || token.getSubCategoria().equals(TipoToken.LLAVE_OPEN.getValue())
        )
                && producion.equalsIgnoreCase("COMP")) {
            p = this.producciones.get(100);
        }
        //CONDICION
        else if ((token.getSubCategoria().equals(TipoToken.ID.getValue())
                || token.getSubCategoria().equals(TipoToken.CADENA.getValue())
                || token.getSubCategoria().equals(TipoToken.NUMERO.getValue())
                || token.getSubCategoria().equals(TipoToken.TRUE.getValue())
                || token.getSubCategoria().equals(TipoToken.FALSE.getValue())
                || token.getSubCategoria().equals(TipoToken.PARENTESIS_OPEN.getValue())
                || token.getSubCategoria().equals(TipoToken.CORCHETE_OPEN.getValue())
                || token.getSubCategoria().equals(TipoToken.LLAVE_OPEN.getValue())
        )
                && producion.equalsIgnoreCase("CONDICION")) {
            p = this.producciones.get(101);
        } else if (token.getSubCategoria().equals(TipoToken.NOT.getValue()) && producion.equalsIgnoreCase("CONDICION")) {
            p = this.producciones.get(102);
        }
        //CONDICION_END
        else if ((token.getSubCategoria().equals("else")
                || token.getSubCategoria().equals(":")
        )
                && producion.equalsIgnoreCase("CONDICION_END")) {
            p = this.producciones.get(109);
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_COMPARACION_IGUAL.getValue()) && producion.equalsIgnoreCase("CONDICION_END")) {
            p = new String[]{"==", "VALOR"};
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_COMPARACION_DIFERENTE.getValue()) && producion.equalsIgnoreCase("CONDICION_END")) {
            p = new String[]{"!=", "VALOR"};
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_COMPARACION_MAYOR_QUE.getValue()) && producion.equalsIgnoreCase("CONDICION_END")) {
            p = new String[]{">", "VALOR"};
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_COMPARACION_MAYOR_IGUAL.getValue()) && producion.equalsIgnoreCase("CONDICION_END")) {
            p = new String[]{">=", "VALOR",};
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_COMPARACION_MENOR_IGUAL.getValue()) && producion.equalsIgnoreCase("CONDICION_END")) {
            p = new String[]{"<=", "VALOR"};
        } else if (token.getSubCategoria().equals(TipoToken.OPERADOR_COMPARACION_MENOR_QUE.getValue()) && producion.equalsIgnoreCase("CONDICION_END")) {
            p = new String[]{"<", "VALOR"};
        }
        return p;
    }
}
