import java.util.*;
public class Veitch {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<5; i++)
		{
			String exp = sc.nextLine()+"+";
			String[][] kmap = new String[4][4];
			ArrayList<String> parts = new ArrayList<String>();


			int index = 0;
			for(int x = 0; x<exp.length(); x++)
			{
				if(exp.substring(x,x+1).equals("+"))
				{
					parts.add(exp.substring(index,x));
					index = x+1;
				}
			}


			String a = "";
			String b = "";
			String c = "";
			String d = "";


			for(int row = 0; row<kmap.length; row++)
			{
				for(int col = 0; col<kmap[0].length; col++)
				{
					if(row == 0)
					{
						b = "B";
						d = "~D";
					}
					if(row == 1)
					{
						b = "B";
						d = "D";
					}
					if(row == 2)
					{
						b = "~B";
						d = "D";
					}
					if(row == 3)
					{
						b = "~B";
						d = "~D";					
					}

					if(col == 0)
					{
						a = "A";
						c = "~C";
					}
					if(col == 1)
					{
						a = "A";
						c = "C";
					}
					if(col == 2)
					{
						a = "~A";
						c = "C";
					}
					if(col == 3)
					{
						a = "~A";
						c = "~C";
					}

					kmap[row][col] = a+b+c+d;

				}
			}


			ArrayList<String> sep = new ArrayList<String>();

			for(int x = 0; x<parts.size(); x++)
			{
				for(int l = sep.size()-1; l>=0; l--)
				{
					sep.remove(l);
				}
				
				for(int y = 0; y<parts.get(x).length(); y++)
				{
					if(parts.get(x).substring(y,y+1).equals("~"))
					{
						sep.add(parts.get(x).substring(y,y+2));
						y+=2;
					}
					else
					{
						sep.add(parts.get(x).substring(y,y+1));
					}
				}
				
				boolean contains = true;

				for(int row = 0; row<kmap.length; row++)
				{
					for(int col = 0; col<kmap[0].length; col++)
					{
						for(int j = 0; j<sep.size(); j++)
						{
							if(kmap[row][col].indexOf(sep.get(j))==-1)
							{
								break;
							}
							else
							{
								kmap[row][col] = "X";
							}
						}
					}
				}

			}






		


			//Works below






			String row1 = "";
			String row2 = "";
			String row3 = "";
			String row4 = "";

			for(int row = 0; row<kmap.length; row++)
			{
				for(int col = 0; col<kmap[0].length; col++)
				{
					if(kmap[row][col].equals("X"))
					{
						if(row == 0)
						{
							row1 += "1";
						}
						if(row == 1)
						{
							row2 += "1";
						}
						if(row == 2)
						{
							row3 += "1";
						}
						if(row == 3)
						{
							row4 += "1";
						}
					}
					else 
					{
						if(row == 0)
						{
							row1 += "0";
						}
						if(row == 1)
						{
							row2 += "0";
						}
						if(row == 2)
						{
							row3 += "0";
						}
						if(row == 3)
						{
							row4 += "0";
						}
					}
				}
			}


			System.out.println(row1);
			System.out.println(row2);
			System.out.println(row3);
			System.out.println(row4);


			int bin1 = Integer.parseInt(row1);
			int bin2 = Integer.parseInt(row2);
			int bin3 = Integer.parseInt(row3);
			int bin4 = Integer.parseInt(row4);





		}

	}

}
