package LinearDataStructures;
import java.io.*;



/*
# Lists based on Pointers.
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
 * This class represents the behavior of Lists based on Pointers
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class List {

	public Node head = null;
	
	
	public List() {}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	
	/**
	 * 
	 */
	public void printList()
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out ));
		Node temp = head;
		
		try
		{
			while(temp != null)
			{
				bw.write(temp.toString());
				temp = temp.next;
			}
			bw.flush();
		}
		catch(Exception ex) { ex.printStackTrace(); }
	}
	
	
	/**
	 * 
	 * @param newNode
	 */
	public void insertAtBegin(Node newNode)
	{
		newNode.next = head;
		head = newNode;
	}
	
	
	/**
	 * 
	 * @param newNode
	 */
	public void insertAtEnd(Node newNode)
	{
		if(isEmpty())
            head = newNode;
        else
        {
            Node temp = head;
            while(temp.next != null)
                temp=temp.next;
            temp.next = newNode;
        }
	}
	
	
	/**
	 * 
	 * @param newNode
	 * @param index
	 */
	public void insertAtIndex(Node newNode, int index)
	{
		Node temp=head;

        for (int i = 0; i < index; i++)
            temp = temp.next;

        newNode.next=temp.next;
        temp.next=newNode;
	}
	
	
	/**
	 * 
	 */
	public void deleteAtBegin()
	{
		Node temp = head;
        head = temp.next;
        temp = null;
        System.gc();
	}
	
	
	/**
	 * 
	 */
	public void deleteAtEnd()
	{
		 Node temp = head.next;
	     Node pre = head;
	     while(temp.next != null)
	         pre=pre.next;
	     System.gc();
	     pre.next=null;
	}
	
	
	/**
	 * 
	 * @param index
	 */
	public void deleteAtIndex(int index)
	{
		 Node temp = this.get(index-1);
	        if(temp!=null) {
		        @SuppressWarnings("unused")
				Node toDelete=temp.next;
		        temp.next = temp.next.next;
		        toDelete = null;
	        }
	}
	
	
	/**
	 * 
	 * @param oldNode
	 * @param newNode
	 */
	public void updateFirst(Node oldNode, Node newNode)
	{
		Node temp = head;
		Node previous = head;
		
		while(temp != null)
		{
			if(temp.isEqual(oldNode))
			{
				newNode.next= temp.next ;
				previous.next= newNode;
				temp = null;
				break;
			}
			
			previous = temp;
			temp = temp.next;
		}
	}
	
	
	/**
	 * 
	 * @param oldNode
	 * @param newNode
	 */
	public void updateAll(Node oldNode, Node newNode)
	{
		Node temp = head;
		Node previous = head;
		
		while(temp != null)
		{
			if(temp.isEqual(oldNode))
			{
				newNode.next= temp.next;
				previous.next=newNode;
				temp = null;
				previous = newNode;
				temp = newNode.next;
			}
			else
			{
				previous = temp;
				temp = temp.next;
			}
		}
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public Node linealSearch(Node node)
	{
		Node temp = head;
		Node result = null;
		
		while(temp != null)
			if(temp.isEqual(node))
			{	
				result =  temp;
				break;
			}
			else
				temp = temp.next;
			
		return result;
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public List searchAll(Node node)
	{
		Node temp = head;
		List results = new List();
		
		while(temp != null)
		{
			if(temp.isEqual(node))
			{	
				results.insertAtEnd(temp.clone());
			}
			
			temp = temp.next;
		}
		
		return results;
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public Node binarySearch(Node node)
	{
		return null;
	}
	
	
	/**
	 * 
	 */
	public void reverse()
	{
		Stack tempStack = new Stack();
		Node temp = head;
		
		while(temp != null)
		{
			tempStack.push(temp.clone());
			temp = temp.next;
		}
		
		head = tempStack.top;
	}
	
	
	/**
	 * 
	 * @param unsorted
	 */
	public void quickSort(int lowerBound, int upperBound, List unsorted)
	{
		int i = lowerBound, j=upperBound;
    	double pivot = unsorted.get(lowerBound+(upperBound-lowerBound)/2).value;
    	
    	while(i<=j) {
    		while(unsorted.get(i).value<pivot) {
    			i+=1;
    		}
    		while(unsorted.get(j).value>pivot) {
    			j-=1;
    		}
    		
    		if(i<=j) {
    			swap(i,j);
    			i+=1;j+=1;
    		}
    	}
    	
    	if(lowerBound<j) 
    		quickSort(lowerBound,j,unsorted);
    	if(i<upperBound) 
    		quickSort(i,upperBound, unsorted);
	}
	
	
	public List sublist(int begin)
	{
		List subList = new List();
		
		if(begin < this.length())
		{
			Node temp = head;
			
			for(int i = 0; i < begin; i++)
				temp = temp.next;
			
			while(temp != null)
			{
				subList.insertAtEnd(temp.clone());
				temp = temp.next;
			}
		}
		
		return subList;
	}
	
	
	/**
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public List sublist(int begin, int end)
	{
		List subList = new List();
		if(end<this.length() && end>begin) {
			for(int i=0;i<=end;i++) {
				if(begin < this.length())
				{
					Node temp = head;
					
					for(int j = 0; j < begin; j++)
						temp = temp.next;
					
					while(temp != null)
					{
						subList.insertAtEnd(temp.clone());
						temp = temp.next;
					}
				}
			}
		}
		
		return subList;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public int length()
	{
		int counter=0;
        if(!this.isEmpty()) {
	        Node temp =head;
	        while(temp!=null) {
	            temp=temp.next;
	            counter++;
	        }
        }
        return counter;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public List cloneList()
	{
		List clone = new List();
		Node a=this.head;
		a = clone.head;
		
		for(int i=0; i<this.length();i++) {
			a.next=this.get(i+1);
			a=a.next;
		}
		return clone;		
	}
	
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public boolean isEqual(List list)
	{
		boolean isEqual = true;
		Node tempCurrent = head;
		Node tempList = list.head;
		
		while(tempCurrent != null && tempList != null)
			if(tempCurrent.isEqual(tempList))
			{
				tempCurrent = tempCurrent.next;
				tempList = tempList.next;
			}
			else
			{
				isEqual = false;
				break;
			}
			
		return isEqual;
	}
	
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Node get(int index)
	{
		if(index < this.length() && index>=0) {
            Node temp = head;
            for(int i =0;i<index;i++) {
                temp = temp.next;
            }
            return temp;
        }
        return null;
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public int indexOf(Node node)
	{
		int index = -1;
		Node temp = head;
		
		while(temp != null)
		{
			index += 1;
			if(temp.isEqual(node))
				return index;
			
			temp = temp.next;
		}
		 
		index = -1;
		return index;
	}
	
	public void swap(int i, int j) {
    	
		Node previ=this.get(i-1), prevj=this.get(j-1);
		Node Ni=previ.next, Nj=prevj.next;
		
		previ.next=Nj;
		prevj.next=Ni;
	}
}