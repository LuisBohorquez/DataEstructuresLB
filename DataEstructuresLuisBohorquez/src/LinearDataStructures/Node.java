package LinearDataStructures;


/*
# Interface of a Generic Node.
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
 * This class represents the behavior of an Interface of a Generic Node
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class Node {
	public int value;
	Node next = null; //Pointer
	
	 public Node(){}
	  public Node(int value)
	  {
	      
	      this.value = value;
	      
	  }
	  public String toString()
	  {
	      return "Value: " + this.value + "\n"; 
	  }
	  public Node clone()
	  {
	      Node temp = new Node(this.value);
	      return temp;
	  }
	/**
	 * 
	 * @return
	 */
	

	
	public boolean isEqual(Node node) {
		if(this.value==node.value) {
			return true;
		}else {
			return false;
		}
	}
	
	
}