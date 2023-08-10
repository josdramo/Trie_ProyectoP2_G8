/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.trie_proyectop2_g8;

/**
 *
 * @author Dell
 * @param <E>
 */
public class BinaryTreeNode<E> {
    private E content;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    public BinaryTreeNode(E content) {
        this.content = content;
        this.left = null;
        this.right = null;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<E> left) {
        this.left = left;
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" + "content=" + content + ", left=" + left + ", right=" + right + '}';
    }
}
