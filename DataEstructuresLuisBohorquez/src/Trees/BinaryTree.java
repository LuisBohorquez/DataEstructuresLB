package Trees;


/*
# Binary Tree Data Structure.
#
# Created by Msc. Carlos Andres Sierra on April 2018.
# Copyright (c) 2018  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of DataStructuresTemplates.
#
# DataStructuresTemplates is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 3.
*/

/**
 * This class represents the behavior of Binary Trees
 * @author MSc. Carlos Andres Sierra, PhD. student
 */

public class BinaryTree {
    Node root=null;
    
    public BinaryTree (){}

    public void intert(int value){
        Node node= new Node(value);
        if(root==null){
            root=node;
        }else{
            Node temp = root;
            Node parent=null;
            boolean left = false;
            
            while(temp!=null){
                parent=temp;
                if(value<temp.value){
                    temp=temp.left;
                    left=true;
                }else{
                    temp=temp.right;
                    left=false;
                }       
            }
            temp=node;
            
            if(left)
                parent.left=temp;
            else
                parent.right=temp;
        }
    }
    
    public void preorder_print(Node node){
        if(node!=null){
            System.out.println(node.toString());
            preorder_print(node.left);
            preorder_print(node.right);
        }
    }
    
    public void posorder_print(Node node){
        if(node!=null){
            posorder_print(node.left);
            posorder_print(node.right);
            System.out.println(node.toString());
        }
    }
      
    public void inorder_print(Node node){
        if(node!=null){
            inorder_print(node.left);
            System.out.println(node.toString());
            inorder_print(node.right);
        }
    }
    
    public int offsprings(Node node){ 
        return(node.left != null) ? (node.right != null ? 2: 1):(node.right != null ? 1:0); 
    }
    
    public Node search (int value){
        Node temp = root;
        
        while(temp != null)
            if(temp.value == value)
                return temp;
            else
                if(value<temp.value)
                    temp=temp.left;
                else
                    temp=temp.right;
        return null;
    }
    
    public void delete (int value){
        Node temp = root;
        Node parent = null;
        boolean left=false;
        
        while(temp != null){
            if(temp.value == value)
                break;
            else{
                parent = temp;
                if(value<temp.value){
                    temp=temp.left;
                    left=true;
                }else{
                    temp=temp.right;
                    left=false;
                }
            }
        }
        if(temp!=null){
            int counter=this.offsprings(temp);
            
            if(counter==0){
                if(left)
                    parent.left=null;
                else
                    parent.right=null;
            }else{
                if (counter==1){
                    if(temp.left!=null)
                        if(left)
                            parent.left=temp.left;
                        else
                            parent.right=temp.left;
                    else
                        if(left)
                            parent.left=temp.right;
                        else
                            parent.right=temp.right;
                }else{
                    Node less = temp.right;
                    Node less_parent = less;
                    
                    while(less.left != null){
                        less_parent = less;
                        less = less.left;
                    }
                    
                    if(less.right !=null)
                        less_parent.left = less.right;
                    
                    less.right = temp.right;
                    less.left = temp.left;
                    
                    if(left)
                        parent.left=less;
                    else
                        parent.right=less;
                }
            }
        }
    }
    
    public static void main(String[] args) {    
        BinaryTree prueba = new BinaryTree();
        prueba.intert(82);
        prueba.intert(85);
        prueba.intert(55);
        prueba.intert(38);
        prueba.intert(70);
        prueba.intert(2);
        prueba.intert(81);
        System.out.println("posorder");
        prueba.posorder_print(prueba.root);
        System.out.println("inorder");
        prueba.inorder_print(prueba.root);
        System.out.println("preorder");
        prueba.preorder_print(prueba.root);
    }
}