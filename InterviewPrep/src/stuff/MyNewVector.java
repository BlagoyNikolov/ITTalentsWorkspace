package stuff;
import java.util.Vector; 

class MyVector extends Vector 
{
	private static final long serialVersionUID = 1L;
	int i = 1; /* Line 5 */
    public MyVector() 
    { 
        i = 2; 
    } 
} 

public class MyNewVector extends MyVector 
{
    public MyNewVector () 
    { 
        i = 4; /* Line 15 */
    } 
    public static void main (String args []) 
    { 
        MyVector v = new MyNewVector(); /* Line 19 */
    } 
}


