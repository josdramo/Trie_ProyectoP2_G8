/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dell
 */
class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean endOfWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.endOfWord = false;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    @Override
    public String toString() {
        return "TrieNode{" + "children=" + children + ", endOfWord=" + endOfWord + '}';
    }
    
    
}
