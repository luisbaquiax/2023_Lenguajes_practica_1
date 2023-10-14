/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lenguajespractica.parser;

import lombok.Data;

/**
 *
 * @author Luis
 */
@Data
public class ErrorSintactico {

    private int fila;
    private int columna;

    public ErrorSintactico(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
}
