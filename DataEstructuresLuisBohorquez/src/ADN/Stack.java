/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADN;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 *
 * @author FAMILA BOHORQUEZ
 */
public class Stack {
    Sequence head = null;
    
    public boolean isEmpy()
    {
        return head == null ? true : false;
    }
    
    public void push(Sequence newNode)
    {
        isEmpy();
        newNode.next = head;
        head = newNode;
    }
    
    public String pop()
    {
        Sequence temp = head;
        head = head.next;
        
        String info = temp.toString();
        temp = null;
        System.gc();
        return info;
    }
    
    public String peek(int index)
    {
        Sequence temp = new Sequence();
        temp = head;
        String info;
        for(int i = 0 ; i<index-1;i++)
            temp = temp.next;
        info = temp.toString();
        return info;
    }
    
    public void inversa()
    {
        Sequence temp = new Sequence();
        temp = head;
        head = null;
        while(!isEmpy())
            temp = temp.next;
    }
    
    public void printStack()
    {   
        BufferedWriter bw = 
                new BufferedWriter(new OutputStreamWriter(System.out));
        
        try
        {
            bw.write("Grades:\n");
            while(!isEmpy())
            {
                bw.write(pop());
            
            }
            bw.flush();
        }
        catch(Exception ex){ex.printStackTrace();}
    }
}
