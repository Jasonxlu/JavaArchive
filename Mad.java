import java.util.*;
public class Mad {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		String line1 = sc.next();
		String line2 = sc.next();
		
		//Initialized Arrays
		ArrayList<String> A = new ArrayList<String>();
		ArrayList<String> B = new ArrayList<String>();
		ArrayList<String> change = new ArrayList<String>();
		ArrayList<Integer> index = new ArrayList<Integer>();
	
		//Added letters to arrays
		for(int x = 0; x<length; x++)
		{
			A.add(line1.substring(x,x+1));
		}
		for(int x = 0; x<length; x++)
		{
			B.add(line2.substring(x,x+1));
		}
		
		//Found different indexes
		int count = 0;
		boolean same = true;
		for(int x = 0; x<length; x++)
		{
			if(!(A.get(x).equals(B.get(x))))
			{
				index.add(x);
				same = false;
			}
		}

		
		String altered = line2;
		String alt = line1;
	
	
		while(same==false)
		{
			if(index.size()==1)
			{
				count++;
				break;
				
			}
			else
			{
				for(int x = 0; x<A.size(); x++)
				{
					A.remove(x);
					x--;
				}
				for(int x = index.get(0); x<index.get(index.size()-1)+1; x++)
				{
					A.add(alt.substring(x,x+1));
				}
				String sub = altered.substring(index.get(0),index.get(index.size()-1)+1);
				for(int x = 0; x<sub.length(); x++)
				{
					change.add(sub.substring(x,x+1));
				}
				for(int x = 0; x<change.size(); x++)
				{
					if(change.get(x).equals("H"))
					{
						change.set(x, "G");
					}
					else
					{
						change.set(x, "H");
					}
				}
				count++;
				altered = "";
				for(int x = 0; x<change.size(); x++)
				{
					altered+=change.get(x);
				}
				alt = alt.substring(index.get(0),index.get(index.size()-1)+1);
				
			}
			same = true;
			
			
			for(int x = 0; x<index.size(); x++)
			{
				index.remove(x);
				x--;
			}
			
			for(int x = 0; x<change.size(); x++)
			{
				if(!(A.get(x).equals(change.get(x))))
				{
					same = false;
					index.add(x);
				}
			}
			
			
			
			for(int x = 0; x<change.size(); x++)
			{
				change.remove(x);
				x--;
			}
			
		}
		
		System.out.println(count);
		
	}

}
