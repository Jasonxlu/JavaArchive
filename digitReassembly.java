import java.util.*;
public class digitReassembly 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<5; i++)
		{
		String digits = Long.toString(sc.nextLong());
		long num = sc.nextLong();
		long sub = digits.length() - num;
		long total = 0;
		for(int x = 0; x<sub+1; x++)
		{
			total += Long.parseLong(digits.substring(x,(int)(x+num)));
		}
		System.out.println(total);
		}
	}

}
