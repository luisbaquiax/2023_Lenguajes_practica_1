package com.lenguajespractica.parser;

import com.lenguajespracticalexico.analisiLexico.Token;
import com.lenguajespracticalexico.analisiLexico.enums.TipoToken;
import lombok.Data;

import java.util.List;
import java.util.Stack;

@Data
public class Parser {
    public static final String SINTAXIS_ERROR = "sintaxis-error";
    public static final String EPSILON = "ε";

    private Production production;
    private int index;

    public Parser() {
        this.index = 0;
        this.production = new Production();
    }

    public void runParser(List<Token> tokens) {
        Stack<String> stack = new Stack<>();
        stack.push("$");
        stack.push("B");
        //simbolo de aceptacion
        Token dolar = new Token();
        dolar.setSubCategoria("$");
        tokens.add(dolar);

        Token next = nextToken(tokens);

        while (!stack.empty()) {
            for (int i = 0; i < stack.size(); i++) {
                System.out.print(stack.get(i) + " ");
            }
            System.out.println();
            System.out.println("cabeza " + stack.get(stack.size() - 1));
            System.out.println("token: " + next.getSubCategoria());
            System.out.println();
            if (stack.get(stack.size() - 1).equals(Parser.SINTAXIS_ERROR)) {
                System.out.println(Parser.SINTAXIS_ERROR);
                stack.pop();
                next = nextToken(tokens);
            }
            if (next.getSubCategoria().equals(stack.get(stack.size() - 1))) {
                stack.pop();
                try {
                    next = nextToken(tokens);
                } catch (Exception e) {
                }
            } else if (stack.get(stack.size() - 1).equals(Parser.EPSILON)) {
                stack.pop();
            } else {
                String[] productions = this.production.getProducction(next, stack.get(stack.size() - 1));
                stack.pop();
                for (int i = productions.length - 1; i > -1; i--) {
                    stack.push(productions[i]);
                }
                System.out.println("productions");
                for (int i = 0; i < productions.length; i++) {
                    System.out.print(productions[i] + " ");
                }
                System.out.println();
            }
        }
        if (stack.empty()) {
            System.out.println("Todo bien");
        } else {
            System.out.println("Sintáxis erro");
        }
    }

    private Token nextToken(List<Token> tokens) {
        return tokens.get(this.index++);
    }
}
