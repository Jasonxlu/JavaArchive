import java.util.*;
public class MultipleArrays 
{

	public static String[][] twoDArray(String arr, int row, int col)
	{
		String[][] fin = new String[row][col];
		int count = 0;
		for(int r = 0; r<row; r++)
		{
			for(int c = 0; c<fin[r].length; c++)
			{
				fin[r][c] = arr.substring(count,count+1);
				count+=2;
			}
		}
		return fin;
	}

	public static ArrayList<String> spat(String[][] arr, int row, int col)
	{
		ArrayList<String> vals = new ArrayList<String>();
		try
		{
			vals.add(arr[row-1][col-1]);
		}
		catch(Exception e)
		{}
		try
		{
			vals.add(arr[row-1][col]);
		}
		catch(Exception e)
		{}
		try
		{
			vals.add(arr[row-1][col+1]);
		}
		catch(Exception e)
		{}
		try
		{
			vals.add(arr[row][col-1]);
		}
		catch(Exception e)
		{}
		try
		{
			vals.add(arr[row][col+1]);
		}
		catch(Exception e)
		{}
		try
		{
			vals.add(arr[row+1][col-1]);
		}
		catch(Exception e)
		{}
		try
		{
			vals.add(arr[row+1][col]);
		}
		catch(Exception e)
		{}
		try
		{
			vals.add(arr[row+1][col+1]);
		}
		catch(Exception e)
		{}

		return vals;

	}

	public static ArrayList<String> combine(ArrayList<ArrayList<String>> arr)
	{
		ArrayList<String> combo = new ArrayList<String>();
		for(int x = 0; x<arr.size(); x++)
		{
			for(int y = 0; y<arr.get(x).size(); y++)
			{
				combo.add(arr.get(x).get(y));
			}
		}
		return combo;
	}

	public static void main(String[] args) 
	{
		String rc = "3 4";
		String[] arrs = {"6 2 7 4 6 1 5 7 5 6 7 8", "4 8 6 4 4 5 7 2 7 6 5 4", "3 6 9 2 4 8 2 6 3 2 1 4", "4 3 5 7 6 8 9 1 2 4 3 5"};
		int space = rc.indexOf(" ");
		int r = Integer.parseInt(rc.substring(0,space));
		int c = Integer.parseInt(rc.substring(space+1,rc.length()));

		ArrayList<String[][]> twoD = new ArrayList<String[][]>();
		for(int x = 0; x<arrs.length; x++)
		{
			twoD.add(twoDArray(arrs[x],r,c));
		}

		ArrayList<Integer> finale = new ArrayList<Integer>();		
		ArrayList<Integer> locationr = new ArrayList<Integer>();
		ArrayList<Integer> locationc = new ArrayList<Integer>();
		int count = 0;
		int locar = 0;
		int locac = 0;
		locationr.add(0);
		locationc.add(0);

		Boolean cont = true;

		while(cont)
		{

			ArrayList<ArrayList<String>> adj = new ArrayList<ArrayList<String>>();

			for(int x = 0; x<twoD.size(); x++)
			{
				adj.add(spat(twoD.get(x),locar,locac));
			}


			ArrayList<String> combo = combine(adj);

			Collections.sort(combo);
			Collections.reverse(combo);

			LinkedHashSet<String> noDupe = new LinkedHashSet(combo);
			ArrayList<String> noDupeA = new ArrayList<String>(noDupe);

			String max = noDupeA.get(0);
			for(int x = 0; x<noDupeA.size(); x++)
			{
				if(Collections.frequency(combo,noDupeA.get(x))==1)
				{
					max = noDupeA.get(x);
					break;
				}
			}

			int sub = 0;
			for(int x = 0; x<adj.size(); x++)
			{
				for(int y = 0; y<adj.get(x).size(); y++)
				{
					if(adj.get(x).get(y).equals(max))
					{
						sub = x;
					}
				}
			}

			for(int row = 0; row<r; row++)
			{
				for(int col = 0; col<c; col++)
				{
					if((twoD.get(sub)[row][col]).equals(max) && (row-locationr.get(count))<2 && (col-locationc.get(count))<2)
					{
						if((locationr.indexOf(row)==locationc.indexOf(col)) && locationr.indexOf(row)!=-1)
						{
							cont = false;
						}
						else
						{
							locar = row;
							locac = col;
						}
					}
				}
			}


			count++;
			if(cont==false)
			{
				break;
			}
			locationr.add(locar);
			locationc.add(locac);
		}


		for(int row = 0; row<locationr.size(); row++)
		{
			int min = Integer.parseInt(twoD.get(0)[locationr.get(0)][locationc.get(0)]);
			for(int x = 0; x<twoD.size(); x++)
			{
				if(Integer.parseInt(twoD.get(x)[locationr.get(row)][locationc.get(row)])<min)
				{
					min = Integer.parseInt(twoD.get(x)[locationr.get(row)][locationc.get(row)]);
				}
			}

			finale.add(min);
		}
		
		int sum = 0;

		for(int x = 0; x<finale.size(); x++)
		{
			sum+=finale.get(x);
		}
		
		System.out.println(sum);
		
	}

}
