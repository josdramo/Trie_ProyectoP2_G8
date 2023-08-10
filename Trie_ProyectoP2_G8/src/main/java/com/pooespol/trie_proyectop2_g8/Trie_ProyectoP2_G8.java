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
        BinaryTree<Integer> abb = new BinaryTree<>((a, b) -> a.compareTo(b));
        abb.add(8);
        abb.add(3);
        abb.add(1);
        abb.add(20);
        abb.add(10);
        abb.add(5);
        abb.add(4);
        System.out.println("--Arbol binario de busqueda---");
        System.out.println("(Imagen del arbol en la carpeta src)");
        System.out.println("Recorrido en pre orden");
        System.out.println(abb.PreOrderTransversal());
        
        

    }
}
