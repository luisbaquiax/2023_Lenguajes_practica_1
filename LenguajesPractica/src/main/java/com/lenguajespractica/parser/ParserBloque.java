package com.lenguajespractica.parser;

import com.lenguajespracticalexico.analisiLexico.Token;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import lombok.Data;

@Data
public class ParserBloque {

    private ManejoBloque manejoBloque;
    private Parser parser;
    private List<ErrorSintactico> errores;

    public ParserBloque(List<Token> tokens) {
        this.manejoBloque = new ManejoBloque(tokens);
        this.errores = new ArrayList<>();
        this.parser = new Parser(this.errores);
    }

    public void analizarBloques() {

        System.out.println("");
        for (int index = 0; index < this.manejoBloque.getBloquesCodigo().size(); index++) {
            for (int i = 0; i < this.manejoBloque.getBloquesCodigo().get(index).getLineas().size(); i++) {
                System.out.println("analizando por lineas de codigo");
                System.out.println("linea "+Arrays.toString(this.manejoBloque.getBloquesCodigo().get(index).getLineas().get(i).toArray()));
                try {
                    parser.runParser(this.manejoBloque.getBloquesCodigo().get(index).getLineas().get(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
