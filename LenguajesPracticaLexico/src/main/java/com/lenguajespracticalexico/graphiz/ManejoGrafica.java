/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lenguajespracticalexico.graphiz;

import com.lenguajespracticalexico.analisiLexico.Token;
import com.lenguajespracticalexico.manejoArchivos.ManejoArchivo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class ManejoGrafica {

    private ManejoArchivo manejoArchivo;

    public ManejoGrafica(ManejoArchivo manejoArchivo) {
        this.manejoArchivo = manejoArchivo;
    }

    public void dibujar(Token token) {
        try {
            this.manejoArchivo.escribirArchivodeTexto("src/example.dot", getGraphiz(token));

            ProcessBuilder processBuilder = new ProcessBuilder(
                    "dot",
                    "-Tpng",
                    "-o",
                    "src/holaGraphiz.png",
                    "src/example.dot");
            processBuilder.start();
        } catch (IOException ex) {
            Logger.getLogger(ManejoGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getGraphiz(Token token) {
        String auxi = "";
        String caracteres = token.getLexema();
        String c = caracteres.charAt(caracteres.length() - 1) + "";

        for (int i = 0; i < caracteres.length() - 1; i++) {
            //auxi += caracteres.charAt(i) + "-> ";
            auxi += "\"" + caracteres.charAt(i) + "\" -> ";
        }
        //auxi += caracteres.charAt(caracteres.length() - 1) + "\"";
        auxi += "\"" + caracteres.charAt(caracteres.length() - 1) + "\"";
        String g = "digraph G {\n"
                + "\n"
                + "  \"" + c + "\" [shape=doublecircle]"
                + "  subgraph cluster_0 {\n"
                + "\n"
                + auxi + ";\n"
                + "    label = \"" + token.getCategoria() + "\";\n"
                + "  }\n"
                + "}";
        return g;
    }

}
