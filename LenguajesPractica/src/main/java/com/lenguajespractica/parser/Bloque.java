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
    private List<List<Token>> auxilineasTokens;
    private List<List<Token>> lineas;

    public Bloque() {
        this.tokens = new ArrayList<>();
        this.auxilineasTokens = new ArrayList<>();
        this.lineas = new ArrayList<>();
        dividirPorLiena();
        omitirEspaciosSaltos();
    }

    private void dividirPorLiena() {
        List<Token> auxi = new ArrayList<>();
        for (int i = 0; i < this.tokens.size(); i++) {
            auxi.add(tokens.get(i));
            if (tokens.get(i).getSubCategoria().equals(TipoToken.SALTO_LINEA.toString())) {
                auxi = new ArrayList<>();
                this.auxilineasTokens.add(auxi);
            }

        }
    }

    private void omitirEspaciosSaltos() {
        for (int i = 0; i < this.auxilineasTokens.size(); i++) {
            List<Token> auxi = new ArrayList<>();
            for (int j = 0; j < this.auxilineasTokens.get(i).size(); j++) {
                if (!this.auxilineasTokens.get(i).get(j).getCategoria().equals(TipoToken.ESPACIO.toString())
                        && !this.auxilineasTokens.get(i).get(j).getSubCategoria().equals(TipoToken.SALTO_LINEA.toString())
                        && !this.auxilineasTokens.get(i).get(j).getSubCategoria().equals(TipoToken.COMENTARIO.toString())) {
                    auxi.add(this.auxilineasTokens.get(i).get(j));
                }
            }
            this.lineas.add(auxi);
        }
    }

}
