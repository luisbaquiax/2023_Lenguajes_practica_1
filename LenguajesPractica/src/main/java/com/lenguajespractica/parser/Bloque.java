package com.lenguajespractica.parser;

import com.lenguajespracticalexico.analisiLexico.Token;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bloque {

    private List<Token> tokens;
    private List<Bloque> lineasTokens;

    public  Bloque(){
        this.tokens = new ArrayList<>();
        this.lineasTokens = new ArrayList<>();
        dividirPorLiena();
    }
    private void dividirPorLiena(){
        for (int i = 0; i < this.tokens.size(); i++) {

        }

    }

}
