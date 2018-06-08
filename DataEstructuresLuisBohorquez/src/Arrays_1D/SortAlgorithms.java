package Arrays_1D;
import java.util.Random;
import java.io.*;
import java.util.Random;

/*
# Examples of Sort Algorithms based on arrays.
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
 * This class represents the behavior of several Sort Algorithms based on arrays
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class SortAlgorithms {
	
	
	/**
	 * 
	 * @param unsortedArray
	 */
	public static void insertionSort(int[] unsorted)
	{
		int temp, indexHole;
        
        for(int i=1; i< unsorted.length; i++) {
            temp=unsorted[i];
            indexHole=i;
            
            while(indexHole>0 && unsorted[indexHole-1]>temp) {
                unsorted[indexHole]=unsorted[indexHole-1]; //Se corren todos los numeros una posición hacia adelante
                indexHole -=1; //equivalente a  indexHole--
            }
            unsorted[indexHole]=temp;
        }
	}
	
	
	/**
	 * 
	 * @param unsortedArray
	 */
	public static void selectionSort(int[] unsortedArray)
	{
		int indexSmallest, tempSwap;
		
		for(int i = 0; i < unsortedArray.length - 1; i++)
		{
			indexSmallest = i;
			
			for(int j = i + 1; j < unsortedArray.length; j++)
				if(unsortedArray[j] < unsortedArray[indexSmallest])
					indexSmallest = j;
			
			tempSwap = unsortedArray[i];
			unsortedArray[i] = unsortedArray[indexSmallest];
			unsortedArray[indexSmallest] = tempSwap;
		}
	}
	
	
	/**
	 * 
	 * @param unsorted
	 */
	public static void bubbleSort(int[] unsorted) {

        boolean swap;
        int temp;
        do {
            swap=false;
            for(int i=0;i<(unsorted.length-1);i++) {
                if(unsorted[i]>unsorted [i+1]){
                    temp=unsorted[i];
                    unsorted[i]=unsorted[i+1];
                    unsorted[i+1]=temp;
                    swap=true;
                }
            }
        }
        while(swap);
    }
	
	
	/**
	 * 
	 * @param unsortedArray
	 */
	public static void countingSort(int [] unsorted){
        int max = Integer.MIN_VALUE;
        int aux[];
        int index = 0;
        
        for (int i = 0; i < unsorted.length; i++) {
            if (unsorted[i]>max){
                max=unsorted[i];
            }
        }
        aux = new int [max + 1];
        
        for (int i = 0; i < unsorted.length; i++) {
            aux[unsorted[i]] +=1;           
        }
        
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[i]; j++) {
                unsorted[index]=i;
                index += 1;                         
            }
            
        }
    }
	
	/**
	 * 
	 * @param unsortedArray
	 * @return
	 */
	public static void mergeSort(int[] unsorted) {
        int size;
        
        if(unsorted.length>1) {
            
            size=unsorted.length/2;
            int[] left_array = new int[size];
            int[] right_array = new int[unsorted.length-size];//si es impar lo crea de tamaño size+1
            
            //LLenando el arreglo izquierdo
            for(int i=0;i<size;i++) 
                left_array[i]=unsorted[i];
            
            //LLenando el arreglo derecho            
            for(int i=size;i<unsorted.length;i++)
                right_array[i-size]=unsorted[i];
            
            
            
            mergeSort(left_array);
            mergeSort(right_array);
            
            
        }
    }
	
	
	/**
	 * 
	 * @param array_left
	 * @param array_right
	 * @return
	 */
	public int[] merge(int[] array_left, int[] array_right)
	{
		int[]temp = new int[array_left.length + array_right.length]; //Create array of complete size, i.e. size of left array plus size of right array
		int left = 0, right = 0, index = 0; //Index for: left array, right array, and temp array. All must start in zero.
		
		while(left < array_left.length && right < array_right.length) //While are still elements inside left array or right array, we can made comparisons
		{
			if(array_left[left] <= array_right[right]) //If element in left array is minor or equal to element in right array
			{
				temp[index] = array_left[left]; //Add element of left array
				left += 1; //Because we add an element of left array, index that control left array must increase
			}
			else
			{
				temp[index] = array_right[right]; //Add element of right array
				right += 1; //Because we add an element of right array, index that control right array must increase
			}
			
			index += 1; //Increase index of complete array
		}
		
		if(left < array_left.length) //If there are still element in left array
			for(int i = left; i < array_left.length; i++) //Add all elements of left array
			{
				temp[index] = array_left[left]; //Add element
				left += 1; //Increase index over left array
				index += 1; //Increase index over complete array
			}	
		else //If there are still element in left array
			for(int i = right; i < array_right.length; i++) //Add all elements of right array
			{
				temp[index] = array_right[right]; //Add element
				right += 1; //Increase index over right array
				index += 1;  //Increase index over complete array
			}	
		
		return temp; //Return complete array 
	}
	
	
	/**
	 * 
	 * @param unsortedArray
	 * @return
	 */
	public static void quickSort(int[] unsorted, int left, int right) {
	    int pivot = unsorted[left];
	    int i = left;
	    int j = right;
	    int aux;
	    while (i < j) {
	        while (unsorted[i] <= pivot && i < j) {
	            i++;
	        }
	        while (unsorted[j] > pivot) {
	            j--;
	        }
	        if (i < j) {
	            aux = unsorted[i];
	            unsorted[i] = unsorted[j];
	            unsorted[j] = aux;
	        }
	    }
	    unsorted[left] = unsorted[j];
	    unsorted[j] = pivot;
	    if (left < j - 1) {
	        quickSort(unsorted, left, j - 1);
	    }
	    if (j + 1 < right) {
	        quickSort(unsorted, j + 1, right);
	    }
	}

	
	/**
	 * 
	 * @param unsortedArray
	 * @return
	 */
	public static void randomQsuickSort(int[] unsorted, int left, int right) {
		Random rnd = new Random();
		int pivot = unsorted[left + rnd.nextInt(right - left)];
	    int i = left;
	    int j = right;
	    int aux;
	    while (i < j) {
	        while (unsorted[i] <= pivot && i < j) {
	            i++;
	        }
	        while (unsorted[j] > pivot) {
	            j--;
	        }
	        if (i < j) {
	            aux = unsorted[i];
	            unsorted[i] = unsorted[j];
	            unsorted[j] = aux;
	        }
	    }
	    unsorted[left] = unsorted[j];
	    unsorted[j] = pivot;
	    if (left < j - 1) {
	        quickSort(unsorted, left, j - 1);
	    }
	    if (j + 1 < right) {
	        quickSort(unsorted, j + 1, right);
	    }
	}
	
	
	/**
	 * 
	 * @param pathFile
	 * @return
	 */
	public int[] readArrayFromFile(String pathFile)
	{
		try
		{
			FileReader fr = new FileReader(pathFile);
			BufferedReader br = new BufferedReader( fr );
			
			String[] numbers = br.readLine().split(",");
			int[] arrayNumbers = new int[numbers.length];
			
			for(int i = 0; i < numbers.length; i++)
				arrayNumbers[i] = Integer.parseInt( numbers[i] );
			
			br.close();
			
			return arrayNumbers;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public int[] readArrayFronConsole()
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		try
		{
			String[] numbers = br.readLine().split(",");
			int[] arrayNumbers = new int[numbers.length];
			
			for(int i = 0; i < numbers.length; i++)
				arrayNumbers[i] = Integer.parseInt( numbers[i] );
			
			return arrayNumbers;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		SortAlgorithms sorts = new SortAlgorithms();
		BasicOperations bo = new BasicOperations();
		
		int[] a = sorts.readArrayFronConsole();
		mergeSort(a);
		bo.printArray(a);
	}
}