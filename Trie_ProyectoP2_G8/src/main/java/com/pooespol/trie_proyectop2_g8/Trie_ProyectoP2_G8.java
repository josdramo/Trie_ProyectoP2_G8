/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.pooespol.trie_proyectop2_g8;

/**
 *
 * @author Dell
 */
public class Trie_ProyectoP2_G8 {

    public static void main(String[] args) {
        Trie abb = new Trie();

        abb.insertarPalabra("Hola");
        
        System.out.println(abb.search("Hola"));
        

    }
}
