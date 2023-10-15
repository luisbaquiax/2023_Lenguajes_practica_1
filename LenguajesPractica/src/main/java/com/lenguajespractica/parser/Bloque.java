package com.lenguajespractica.parser;

import com.kitfox.svg.A;
import com.lenguajespracticalexico.analisiLexico.Token;
import com.lenguajespracticalexico.analisiLexico.enums.TipoToken;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bloque {

    private List<Token> tokens;
    private List<List<Token>> lineas;

    public Bloque() {
        this.tokens = new ArrayList<>();
        this.lineas = new ArrayList<>();
    }

    public void dividirPorLiena() {
        List<Token> auxi = new ArrayList<>();
        for (int i = 0; i < this.tokens.size(); i++) {
            if (tokens.get(i).getCategoria().equals(TipoToken.SALTO_LINEA.toString())) {
                this.lineas.add(auxi);
                auxi = new ArrayList<>();
            } else {
                auxi.add(tokens.get(i));
            }
        }
    }
}
