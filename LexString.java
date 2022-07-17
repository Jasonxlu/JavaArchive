import java.util.*;
public class LexString 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();

		//Breaks up text into individual letters
		ArrayList<String> textb = new ArrayList<String>();
		for(int x = 0; x<text.length(); x++)
		{
			textb.add(text.substring(x,x+1));
		}


		//Array of Chars to turn into Ascii
		char[] chars = text.toCharArray();


		//Adds chars to an arraylist and removes nonalphanumeric letters
		ArrayList<Integer> textc = new ArrayList<Integer>();
		for(int x = 0; x<chars.length; x++)
		{
			textc.add((int)chars[x]);
		}

		for(int x = 0; x<textc.size(); x++)
		{
			if(!(textc.get(x)>47 && textc.get(x)<58) && !(textc.get(x)>64 && textc.get(x)<91) && !(textc.get(x)>96 && textc.get(x)<123))
			{
				textc.remove(x);
				textb.remove(x);
				x--;
			}
		}

		//Sorts remaining strings in textb arraylist
		Collections.sort(textb);



		//Finds total num of each letter/number
		ArrayList<Integer> textd = new ArrayList<Integer>();

		int start = 0;
		int len = 0;
		textd.add(start);
		for(int x = 0; x<textb.size(); x++)
		{

			if(!(textb.get(start).equals(textb.get(x))))
			{

				len = x-start;
				textd.add(len);
				start = x;
				textd.add(start);
			}
			if(x==(textb.size()-1))
			{
				len = textb.size()-start;
				textd.add(len);
			}


		}

		//combines length and value into a single string
		ArrayList<String> texte = new ArrayList<String>();
		for(int x = 0; x<textd.size(); x++)
		{
			if(x%2==0)
			{
				texte.add(textd.get(x+1)+textb.get(textd.get(x)));
			}
		}

		Collections.sort(texte);
		//Collections.reverse(texte);
		
		int count2 = 0;
		while(Integer.parseInt(texte.get(0).substring(0,texte.get(0).length()-1))>Integer.parseInt(texte.get(texte.size()-1).substring(0,texte.get(texte.size()-1).length()-1)))
		{
			texte.add(texte.remove(0));
			count2+=2;
		}

		System.out.println(texte);


		ArrayList<String> textf = new ArrayList<String>();
		String ini = texte.get(0).substring(0,texte.get(0).length()-1);
		start = 0;
		textf.add(ini);
		for(int x = 0; x<texte.size(); x++) 
		{
			if(texte.get(x).substring(0,texte.get(x).length()-1).equals(ini))
			{
				textf.set(start,textf.get(start)+texte.get(x).substring(texte.get(x).length()-1));
			}
			else
			{
				start+=1;
				ini = texte.get(x).substring(0,texte.get(x).length()-1);
				textf.add(ini);
				textf.set(start,textf.get(start)+texte.get(x).substring(texte.get(x).length()-1));
			}
		}	

		Collections.reverse(textf);

		System.out.println(textf);
		
		
		ArrayList<Integer> lengths = new ArrayList<Integer>();
		for(int x = 0; x<count2; x++)
		{
			int count = 0;
			for(int y = 0; y<textf.get(x).length(); y++)
			{
				String str = textf.get(x).substring(y,y+1);
				if(((int)(str.charAt(0))>47 && (int)(str.charAt(0))<58) )
				{
					count++;
					
				}
			}
			
			lengths.add(count);
		}
		for(int x = 0; x<textf.size()-count2; x++)
		{
			lengths.add(1);
		}
		
		
		
		int alt = 0;
		for(int x = 0; x<textf.size(); x++)
		{
			if(alt%2!=0)
			{
				StringBuffer sbf = new StringBuffer(textf.get(x).substring(lengths.get(x)));
				sbf.reverse();
				textf.set(x, textf.get(x).substring(0,lengths.get(x))+sbf);
			}
			alt++;
		}
		
		
		
		String out = textf.get(0);
		for(int x = 1; x<textf.size(); x++)
		{
			out+=","+ textf.get(x);
		}

		System.out.println(out);


	}

}
