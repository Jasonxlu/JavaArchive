import java.util.*;
/*
 * Name: Jason Lu
 * School: Neuqua Valley HS
 * Division: Intermediate
 * Grade:11
 * Problem: ACSL Sameness Factor 2019-2020
 */
public class ASF3 
{

	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);
		for(int z = 0; z<5; z++)
		{
			String line1 = sc.next();
			String line2 = sc.next();
			ArrayList<String> text1 = new ArrayList<String>();
			ArrayList<String> text2 = new ArrayList<String>();


			//Add strings to array
			for(int x = 0; x<line1.length(); x++)
			{
				text1.add(line1.substring(x,x+1));
			}
			for(int x = 0; x<line2.length(); x++)
			{
				text2.add(line2.substring(x,x+1));
			}


			//Establish minimum length
			int minl=0;

			if(line1.length()<line2.length())
			{
				minl=line1.length();
			}
			else
			{
				minl=line2.length();
			}




			//While loop to shift
			boolean cont = true;
			boolean change = false;
			while(cont)
			{
				cont = false;


				//checks for empty strings
				if(text1.size()==0||text2.size()==0)
				{
					break;
				}


				//checks for direct line-up
				for(int x = 0; x<minl; x++)
				{
					if(text1.get(x).equals(text2.get(x)))
					{
						text1.remove(x);
						text2.remove(x);
						x--;
						minl--;
					}
				}


				
				for(int x = 0; x<minl-1; x++)
				{
					change = false;
					//checks text2 shift left
					if(text1.get(x).equals(text2.get(x+1)))
					{
						text1.remove(x);
						text2.remove(x);
						text2.remove(x);
						change = true;
						if(text1.size()>text2.size())
						{
							minl=text2.size();
						}
						else
						{
							minl=text1.size();
						}
						break;

					}

					if(x==minl-1)
					{
						break;
					}

					//checks text1 shift left
					if(text2.get(x).equals(text1.get(x+1)))
					{
						text2.remove(x);
						text1.remove(x);
						text1.remove(x);
						change = true;
						if(text1.size()>text2.size())
						{
							minl=text2.size();
						}
						else
						{
							minl=text1.size();
						}
						break;

					}

					if(x==minl-1)
					{
						break;
					}

					//same distance
					if(text1.get(x).equals(text2.get(x+1)))
					{
						if(text2.get(x).equals(text1.get(x+1)))
						{
							text1.remove(x);
							text2.remove(x);
							text2.remove(x);
							change = true;
							if(text1.size()>text2.size())
							{
								minl=text2.size();
							}
							else
							{
								minl=text1.size();
							}
							break;
						}
					}

					if(x==minl-1)
					{
						break;
					}

					if(change)
					{
						x--;
					}


				}

				//cont conditions
				
				for(int x = 0; x<minl; x++)
				{
					if(text1.get(x).equals(text2.get(x)))
					{
						cont = true;
					}
				}
				
				
				for(int x = 0; x<minl-1; x++)
				{
					if(text1.get(x).equals(text2.get(x+1)))
					{
						cont=true;

					}
					if(text2.get(x).equals(text1.get(x+1)))
					{
						cont = true;

					}
					
					if(text1.get(x+1).equals(text2.get(x+1))) 
					{
						cont = true;

					}
					if(text1.get(x).equals(text2.get(x+1)))
					{
						if(text2.get(x).equals(text1.get(x+1)))
						{
							cont = true;
						}
					}
				}
			

				if(minl==text1.size()&&minl<text2.size())
				{
					if(text1.get(minl-1).equals(text2.get(minl)))
					{
						text1.remove(minl-1);
						text2.remove(minl-1);
						text2.remove(minl-1);
						cont = true;
					}
				}
				if(minl==text2.size()&&minl<text1.size())
				{
					if(text2.get(minl-1).equals(text1.get(minl)))
					{
						text2.remove(minl-1);
						text1.remove(minl-1);
						text1.remove(minl-1);
						cont = true;
					}
				}

				if(text1.size()>text2.size())
				{
					minl=text2.size();
				}
				else
				{
					minl=text1.size();
				}


			}

			int val = 0;
			for(int x = 0; x<minl; x++)
			{
				val+=(text1.get(x).charAt(0)-text2.get(x).charAt(0));
			}

			val+=Math.abs(text1.size()-text2.size());
			System.out.println(val);
			
		}
		sc.close();


	}

}
