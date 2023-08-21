/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import java.io.Serializable;
import util.Triee;

/**
 *
 * @author infrative
 */
public class AppState implements Serializable {
    private static AppState instance;
    
    final private Triee diccionario;
    
    private AppState() {
        diccionario = new Triee();
    }
    
    public static AppState getInstance() {
        if (instance == null) {
            instance = new AppState();
        }
        
        return instance;
    }
    
    public static void setInstanceIfNotDefined(AppState appState) {
        if (instance == null) {
            instance = appState;
        } else {
            throw new RuntimeException("Ya está definida una instancia de AppState.");
        }
    }
    
    public Triee getDiccionario() {
        return diccionario;
    }
}
