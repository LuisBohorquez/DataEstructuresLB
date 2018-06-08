package ADN;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moroc
 */
public class Queue {
    
    Sequence head = null;
    
    public boolean isEmpy()
    {
        return head == null ? true : false;
    }
    
    public void enqueue(Sequence newNode)
    {
        if(isEmpy())
            head = newNode;
        else
        {
            Sequence temp = head;
            while(temp.next != null)
                temp=temp.next;
            temp.next = newNode;
        }
    }
    public String dequeue()
    {
        Sequence temp = head;
        head = head.next;
        String info = temp.toString();
        temp = null;
        System.gc();
        return info;
    }
    
    
}
