/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.trie_proyectop2_g8;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Dell
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insertarPalabra(String palabra) {
        TrieNode actual = root;
        for (char c : palabra.toCharArray()) {
            if (!actual.getChildren().containsKey(c)) {
                actual.getChildren().put(c, new TrieNode());
            }
            actual = actual.getChildren().get(c);
        }
        actual.setEndOfWord(true);
    }

    public boolean buscarPalabra(String palabra) {
        TrieNode actual = root;
        for (char c : palabra.toCharArray()) {
            TrieNode nodo = actual.getChildren().get(c);
            if (nodo == null) {
                return false;
            }
            actual = nodo;
        }
        return actual.isEndOfWord();
    }

    public boolean eliminarPalabra(String palabra) {
        return eliminarPalabraRecursivo(root, palabra, 0);
    }
    
//    private boolean eliminarPalabraRecursivo(TrieNode nodo, String palabra, int indice){
//        if(indice == palabra.length()){
//            if(!nodo.isEndOfWord()){
//                return false;
//            }
//            nodo.setEndOfWord(false);
//            return nodo.getChildren().isEmpty() && !nodo.isEndOfWord();
//        }
//        
//        char caracter = palabra.charAt(indice);
//        TrieNode nodoHijo = nodo.getChildren().get(caracter);
//        if(nodoHijo == null){
//            return false;
//        }
//        
//        boolean borrarHijo = eliminarPalabraRecursivo(nodoHijo, palabra, indice+1);
//        
//        if(borrarHijo){
//            nodo.getChildren().remove(caracter);
//            return nodo.getChildren().isEmpty() && !nodo.isEndOfWord();
//        }
//        return false;
//    }
    
    private boolean eliminarPalabraRecursivo(TrieNode current, String palabra, int index) {
    System.out.println("Eliminando en índice: " + index);
    
    if (index == palabra.length()) {
        if (!current.isEndOfWord()) {
            System.out.println("La palabra no existe en el Trie");
            return false; // La palabra no existe en el Trie
        }
        System.out.println("Marcando fin de palabra como falso");
        current.setEndOfWord(false);
        boolean shouldDelete = current.getChildren().isEmpty() && !current.isEndOfWord();
        System.out.println("Should delete: " + shouldDelete);
        return shouldDelete;
    }

    char c = palabra.charAt(index);
    TrieNode child = current.getChildren().get(c);
    if (child == null) {
        System.out.println("La palabra no existe en el Trie");
        return false; // La palabra no existe en el Trie
    }

    boolean shouldDeleteChild = eliminarPalabraRecursivo(child, palabra, index + 1);

    if (shouldDeleteChild) {
        System.out.println("Eliminando nodo hijo: " + c);
    current.getChildren().remove(c);
    boolean shouldDelete = current.getChildren().isEmpty();
    System.out.println("Should delete: " + shouldDelete);
    return shouldDelete;
    }

    return false;
}

    public boolean busquedaPrefijo(String prefijo) {
        TrieNode actual = root;
        for (char c : prefijo.toCharArray()) {
            TrieNode nodo = actual.getChildren().get(c);
            if (nodo == null) {
                return false;
            }
            actual = nodo;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trie{" + "root=" + root + '}';
    }

}
