package com.lenguajespractica.parser;

import com.lenguajespracticalexico.analisiLexico.Token;
import com.lenguajespracticalexico.analisiLexico.enums.TipoToken;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ManejoBloque {

    private List<Token> tokens;
    private List<Token> auxiTokens;
    private List<Bloque> bloquesCodigo;

    public ManejoBloque(List<Token> tokens) {
        this.auxiTokens = tokens;
        this.tokens = new ArrayList<>();
        this.bloquesCodigo = new ArrayList<>();
        omitirComentarios();
        dividirPorBloque();
        establecerLineas();
    }

    private void establecerLineas() {
        for (int i = 0; i < bloquesCodigo.size(); i++) {
            bloquesCodigo.get(i).dividirPorLiena();
        }
    }

    private void dividirPorBloque() {
        Bloque bloque = new Bloque();
        System.out.println("dividir por bloques");
        List<Token> tks = new ArrayList<>();
        int index = 0;
        for (int i = index; i < tokens.size(); i++) {
            System.out.print((tokens.get(i).getColumna() - tokens.get(i).getLexema().length()) + " ");
            if ((tokens.get(i).getColumna() - tokens.get(i).getLexema().length() == 1)) {
                bloque = new Bloque();
                bloque.getTokens().add(tokens.get(i));
                this.bloquesCodigo.add(bloque);
            } else {
                bloque.getTokens().add(tokens.get(i));
            }
        }
    }

    private Token getNext(List<Token> tokens, int index) {
        return tokens.get(index++);
    }

    private void omitirComentarios() {
        for (int i = 0; i < auxiTokens.size(); i++) {
            if (!auxiTokens.get(i).getCategoria().equals(TipoToken.COMENTARIO.toString())) {
                this.tokens.add(auxiTokens.get(i));
            }
        }
    }
}
