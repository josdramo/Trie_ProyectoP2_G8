/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Triee implements Serializable {
    private final TrieNode root;

    public Triee() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            currentNode.children.putIfAbsent(ch, new TrieNode());
            currentNode = currentNode.children.get(ch);
        }
        currentNode.isEndOfWord = true;
    }

    public List<String> search(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode currentNode = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!currentNode.children.containsKey(ch)) {
                return result;
            }
            currentNode = currentNode.children.get(ch);
        }

        collectWordsFromNode(currentNode, prefix, result);

        return result;
    }

    private void collectWordsFromNode(TrieNode node, String currentPrefix, List<String> result) {
        if (node.isEndOfWord) {
            result.add(currentPrefix);
        }

        for (char ch : node.children.keySet()) {
            TrieNode childNode = node.children.get(ch);
            collectWordsFromNode(childNode, currentPrefix + ch, result);
        }
    }
    

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!currentNode.children.containsKey(ch)) {
                return false;
            }
            currentNode = currentNode.children.get(ch);
        }
        return true;
    }
}

class TrieNode implements Serializable {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
