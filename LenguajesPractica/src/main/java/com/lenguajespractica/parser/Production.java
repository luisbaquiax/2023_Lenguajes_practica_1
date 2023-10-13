package com.lenguajespractica.parser;

import com.lenguajespracticalexico.analisiLexico.Token;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Production {

    private List<String[]> producciones;


    public Production() {
    }

    private void inicializr() {
        this.producciones = new ArrayList<>();
        this.producciones.add(new String[]{"(", "OPT_ARIT", ")"});
        this.producciones.add(new String[]{"{", "DICC_CONTENT", "}"});
    }

    public String[] getProducction(Token token, String producion){
        String[] p = new String[]{Parser.SINTAXIS_ERROR};

        return p;
    }
}
