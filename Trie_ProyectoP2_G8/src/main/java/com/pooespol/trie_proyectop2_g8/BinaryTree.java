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
 * @param <E>
 */
public class BinaryTree<E> {
    private BinaryTreeNode<E> root;
    private Comparator<E> cmp;

    public BinaryTree(Comparator<E> cmp) {
        this.cmp = cmp;
        this.root = null;
    }

    public BinaryTree(E content) {
        this.root = new BinaryTreeNode<>(content);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public E getRoot() {
        if (!this.isEmpty()) {
            return root.getContent();
        }
        return null;
    }

    public void setRoot(E content) {
        this.root.setContent(content);
    }

    public BinaryTree<E> getLeft() {
        if (!this.isEmpty()) {
            return root.getLeft();
        }
        return null;
    }

    public BinaryTree<E> getRight() {
        if (!this.isEmpty()) {
            return root.getRight();
        }
        return null;
    }
   

    boolean setRight(BinaryTree<E> t) {
        if (!this.isEmpty()) {
            this.root.setRight(t);
            return true;
        }
        return false;
    }

    boolean setLeft(BinaryTree<E> t) {
        if (!this.isEmpty()) {
            this.root.setLeft(t);
            return true;
        }
        return false;
    }
    
    private boolean isLeaf() {
        if (this.isEmpty()) {
            return false;
        }
        return this.root.getLeft() == null && this.root.getRight() == null;
    }
    
    public List<E> PreOrderTransversal() {
        List<E> results = new LinkedList<>();
        if (!this.isEmpty()) {
            results.add(this.root.getContent());
            if (this.getLeft() != null) {
                results.addAll(this.getLeft().PreOrderTransversal());
            }
            if (this.getRight() != null) {
                results.addAll(this.getRight().PreOrderTransversal());
            }
        }
        return results;
    }
    
    public void add(E content){
        Stack<BinaryTree<E>> stackTrees = new Stack<>();
        if(this.isEmpty()){
            root = new BinaryTreeNode(content);
        }
        else{
            stackTrees.push(this);
            while(!stackTrees.isEmpty()){
                BinaryTree<E> subTree = stackTrees.pop();
                if (cmp.compare(content, subTree.getRoot()) == 0) {
                    return;
                }
                else if(cmp.compare(content, subTree.getRoot()) > 0){
                    if(subTree.getRight() == null){
                        BinaryTree<E> newChildren = new BinaryTree<>(cmp);
                        newChildren.root = new BinaryTreeNode<>(content);
                        subTree.setRight(newChildren);
                        return;
                    }
                    stackTrees.push(subTree.getRight());
                }
                else if(cmp.compare(content, subTree.getRoot()) < 0){
                    if(subTree.getLeft() == null){
                        BinaryTree<E> newChildren = new BinaryTree<>(this.cmp);
                        newChildren.root = new BinaryTreeNode<>(content);
                        subTree.setLeft(newChildren);
                        return;
                    }
                    stackTrees.push(subTree.getLeft());
                }             
            }
        }
    }
    
}
