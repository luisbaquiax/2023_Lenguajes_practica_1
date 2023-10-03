package com.lenguajespracticalexico.parser;

import com.lenguajespracticalexico.analisiLexico.Token;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bloque {

    private List<Token> tokens;

    public  Bloque(){
        this.tokens = new ArrayList<>();
    }

}
