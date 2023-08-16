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

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            TrieNode node = current.getChildren().get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            TrieNode node = current.getChildren().get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return true;
    }
}
    

