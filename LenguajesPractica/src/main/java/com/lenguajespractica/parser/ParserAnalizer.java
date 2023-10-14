package com.lenguajespractica.parser;

import com.lenguajespracticalexico.analisiLexico.Token;
import java.util.ArrayList;

import java.util.List;
import lombok.Data;

@Data
public class ParserAnalizer {

    private ManejoBloque manejoBloque;
    private Parser parser;
    private  List<ErrorSintactico> errores;

    public ParserAnalizer(List<Token> tokens) {
        this.manejoBloque = new ManejoBloque(tokens);
        this.errores = new ArrayList<>();
        this.parser = new Parser(this.errores);
    }

    public void analizarBloques() {
        for (int index = 0; index < this.manejoBloque.getBloquesCodigo().size(); index++) {
            for (int cont = 0; cont < this.manejoBloque.getBloquesCodigo().get(index).getLineas().size(); cont++) {
                this.parser.runParser(this.manejoBloque.getBloquesCodigo().get(index).getLineas().get(cont));
            }
        }
    }
}
