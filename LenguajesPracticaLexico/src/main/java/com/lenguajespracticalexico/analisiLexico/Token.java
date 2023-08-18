/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lenguajespracticalexico.analisiLexico;

import lombok.*;

/**
 *
 * @author luis
 */
@Data
@lombok.NoArgsConstructor
public class Token {

    private String lexema;
    private String categoria;
    private int fila;
    private int columna;
    private String patron;
}
