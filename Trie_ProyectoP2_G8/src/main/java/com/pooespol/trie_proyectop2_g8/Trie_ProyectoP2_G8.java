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
        abb.insertarPalabra("hola");
        abb.insertarPalabra("h0la");
        abb.insertarPalabra("cono");
        
        //System.out.println("Deberia salir true: "+abb.buscarPalabra("Hola"));
        //System.out.println("Deberia salir true: "+abb.buscarPalabra("hola"));
        //System.out.println("Deberia salir true: "+abb.buscarPalabra("h0la"));
        
        System.out.println("Deberia salir true: "+abb.eliminarPalabra("Hola"));
        System.out.println("");
        System.out.println("Deberia salir false: "+abb.eliminarPalabra("Hola"));
        System.out.println("");
        System.out.println("Deberia salir true: "+abb.eliminarPalabra("cono"));
        
        //System.out.println("Deberia salir false: "+abb.buscarPalabra("Hola"));
        
        System.out.println("Deberia salir true: "+abb.eliminarPalabra("hola"));
        //System.out.println("Deberia salir false: "+abb.buscarPalabra("hola"));
        
        //System.out.println("Deberia salir true: "+abb.buscarPalabra("h0la"));
    }
}
