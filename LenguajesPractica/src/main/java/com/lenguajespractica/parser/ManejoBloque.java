package com.lenguajespractica.parser;

import com.lenguajespracticalexico.analisiLexico.Token;
import com.lenguajespracticalexico.analisiLexico.enums.TipoToken;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ManejoBloque {
    private List<Token> tokens;
    private List<Bloque> bloquesCodigo;

    public ManejoBloque(List<Token> tokens) {
        dividirPorBloque(tokens);
    }

    private void dividirPorBloque(List<Token> tokens) {
        this.tokens = tokens;
        this.bloquesCodigo = new ArrayList<>();
        int index = 0;
        Bloque bloque = null;
        for (int i = 0; i < tokens.size(); i++) {
            System.out.print((tokens.get(i).getColumna() - tokens.get(i).getLexema().length()) + " ");

            if ((tokens.get(i).getColumna() - tokens.get(i).getLexema().length() == 1)
                    && !tokens.get(i).getLexema().equalsIgnoreCase(TipoToken.ESPACIO.value)) {
                bloque = new Bloque();
                bloque.getTokens().add(tokens.get(i));
                this.bloquesCodigo.add(bloque);
            } else {
                bloque.getTokens().add(tokens.get(i));
            }
        }
    }
}
