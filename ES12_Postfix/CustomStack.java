package Postfix;

import java.util.Arrays;


public class CustomStack <E> 
{
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];
 
    public CustomStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }
 
    public void push(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }
 
    @SuppressWarnings("unchecked")
    public E pop() {
    	if (size == 0) {
    		System.out.println("Nothing to undo!");
            E e = (E) elements[++size];
             e = (E) elements[--size];

            return e;	
    	} else {
            E e = (E) elements[--size];
            elements[size] = null;
            return e;	

    	}
    }
 
    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
     
    @Override
    public String toString()
    {
         StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < size ;i++) {
             sb.append(elements[i].toString());
             if(i < size-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         if (size==0) {
        	 return "[]";
         }
         return sb.toString();
    }
    

    public void top()
    {
        if (size<=1) {
       	 System.out.printf("0\n");
        } else {
        	System.out.printf(elements[size-2].toString());
        }
        
   }
}