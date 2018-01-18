package stuff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class New {
	public static void main(String args[])
    {
        try 
        {
            System.out.print("Hello world ");
        }
        finally 
        {
            System.out.println("Finally executing ");
        }
        
        int i1 = 5; 
        int i2 = 6; 
        String s1 = "7"; 
        System.out.println(i1 + i2 + s1); /* Line 8 */
        
        Object i = new ArrayList().iterator(); 
        System.out.print((i instanceof List)+","); 
        System.out.print((i instanceof Iterator)+","); 
        System.out.print(i instanceof ListIterator); 
        
        boolean x = true;
		int a;
			if(x) a = x ? 1: 2;
			else a = x ? 3: 4;
			System.out.println(a);
			
		 int w=0, j=2;
		  do {
		     w=++w;
		     j--;
		  } while(j>0);
		  System.out.println(w);
		  
		  
		  
		  
		  

    }
}


