package LinearDataStructures;

import java.io.*;

/*
# Stack Functions.
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
 * This class represents the behavior of Stacks
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class Stack {
	
	public Node top = null; //top
	
	public Stack() {}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		return top == null ? true : false;
	}
	
	
	/**
	 * 
	 * @param newNode
	 */
	public void push(Node newNode)
	{
		isEmpty();
        newNode.next = top;
        top = newNode;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Node pop()
	{
		Node temp = top;
		top = top.next;
        temp = null;
        System.gc();
        return temp;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String peek(int index)
	{
		Node temp = new Node();
        temp = top;
        String info;
        for(int i = 0 ; i<index-1;i++)
            temp = temp.next;
        info = temp.toString();
        return info;
	}
	
	
	/**
	 * 
	 */
	public void printStack()
	{
		BufferedWriter bw = new BufferedWriter(	new OutputStreamWriter( System.out ));
		
		try
		{
			while(!isEmpty())
				bw.write(pop().toString());
			
			bw.flush();
		}
		catch(Exception ex) { ex.printStackTrace(); }
	}
}