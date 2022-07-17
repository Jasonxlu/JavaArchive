import java.util.*;
import java.io.*;
public class numeralTriangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumOfLastRow("ABC","F",4));
		
	}
	
	 public static String sumOfLastRow(String s, String d, int r) 
	    {
	        //Convert Hex to decimal
	        int ds = Integer.parseInt(s,16);
	        int dd = Integer.parseInt(d,16);
	        
	        //Calculate total squares
	        int tot = 0;
	        for(int x = r; x>0; x--)
	        {
	            tot+=x;
	        }
	        
	        //Calculate final value in decimal
	        int fin = ((tot-1)*dd)+ds;
	        
	        //ArrayList to store last row of values as decimal 
	        ArrayList<Integer> dvals = new ArrayList<Integer>();
	        for(int x = 0; x<r; x++)
	        {
	            dvals.add(fin-(dd*x));
	        }
	        
	        //ArrayList to store last row of values as Hex
	        ArrayList<String> hvals = new ArrayList<String>();
	        for(int x = 0; x<r; x++)
	        {
	            hvals.add(Integer.toHexString(dvals.get(x)));
	        }
	        
	        dvals.clear();
	        
	        //ArrayList to store hex broken up
	        ArrayList<String> bvals = new ArrayList<String>();
	        for(int x = 0; x<r; x++)
	        {
	            for(int y = 0; y<hvals.get(x).length(); y++)
	            {
	                bvals.add(hvals.get(x).substring(y,y+1));
	            }
	            
	        }
	        
	        //Convert all broken up hex into decimal for addition
	        for(int x = 0; x<bvals.size(); x++)
	        {
	            dvals.add(Integer.parseInt(bvals.get(x),16));
	        }
	        
	        
	        //Add up all values of lastrow as decimal
	        int lasttotd = 0;
	        for(int x = 0; x<dvals.size(); x++)
	        {
	            lasttotd += dvals.get(x);
	        }
	        
	        String lasttoth = Integer.toHexString(lasttotd);
	        
	        while(lasttoth.length()>1)
	        {
	        	lasttotd=0;
	            for(int x = 0; x<lasttoth.length(); x++)
	            {
	                lasttotd += Integer.parseInt(lasttoth.substring(x,x+1),16);
	            }
	            
	            lasttoth = Integer.toHexString(lasttotd);
	            
	        }
	        
	        return lasttoth;
	        
	        
	    }

}
