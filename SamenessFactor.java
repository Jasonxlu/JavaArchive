import java.util.*;

public class SamenessFactor {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int k = 0; k<5; k++)
		{
			String s1=sc.next();
			String s2=sc.next();
			ArrayList<String> s1char=new ArrayList<String>();
			ArrayList<String> s2char=new ArrayList<String>();
			int minL;
			for(int i=0;i<s1.length();i++)
			{
				s1char.add(s1.substring(i,i+1));
			}
			for(int i=0;i<s2.length();i++)
			{
				s2char.add(s2.substring(i,i+1));
			}
			if(s1char.size()>s2char.size())
			{
				minL=s2char.size();
			}
			else
			{
				minL=s1char.size();
			}
		
			boolean notComplete=true;
			while(notComplete)
			{
				if(s1char.size()==0||s2char.size()==0)
				{
					break;
				}
				for(int i=0;i<minL;i++)
				{
					if(s1char.get(i).equals(s2char.get(i)))
					{
						s1char.remove(i);
						s2char.remove(i);
						i--;
						minL--;
					}
				}
				for(int i=0;i<minL-1;i++)
				{
					boolean changed=false;
					if(s1char.get(i).equals(s2char.get(i+1)))
					{
						s1char.remove(i);
						s2char.remove(i);
						s2char.remove(i);
						changed=true;
						if(s1char.size()>s2char.size())
						{
							minL=s2char.size();
						}
						else
						{
							minL=s1char.size();
						}
						break;
					}
					if(i==minL-1)
					{
						break;
					}
					if(s2char.get(i).equals(s1char.get(i+1)))
					{
						s2char.remove(i);
						s1char.remove(i);
						s1char.remove(i);
						changed=true;
						if(s1char.size()>s2char.size())
						{
							minL=s2char.size();
						}
						else
						{
							minL=s1char.size();
						}
						break;
					}
					if(i==minL-1)
					{
						break;
					}
					if(s1char.get(i).equals(s2char.get(i+1))&&s2char.get(i).equals(s1char.get(i+1)))
						{
							s2char.remove(i);
							s1char.remove(i);
							s1char.remove(i);
							changed=true;
							if(s1char.size()>s2char.size())
							{
								minL=s2char.size();
							}
							else
							{
								minL=s1char.size();
							}
							break;
						}
					if(i==minL-1)
					{
						break;
					}
					if(changed)
					{
						i--;
					}
					
				}
				int count=0;
				for(int i=0;i<minL;i++)
				{
					if(s1char.get(i).equals(s2char.get(i)))
					{
						count=1;
					}
				}
				for(int i=0;i<minL-1;i++)
				{
					if(s1char.get(i).equals(s2char.get(i+1)))
					{
						count=1;
					}
					if(s2char.get(i).equals(s1char.get(i+1)))
					{
						count=1;
					}
				
					if(s1char.get(i).equals(s2char.get(i+1))&&s2char.get(i).equals(s1char.get(i+1)))
					{
						count=1;
					}
				}
				
				if(minL==s1char.size()&&minL<s2char.size())
				{
					if(s1char.get(minL-1).equals(s2char.get(minL)))
					{
						s1char.remove(minL-1);
						s2char.remove(minL-1);
						s2char.remove(minL-1);
						count=1;
					}
				}
				if(minL==s2char.size()&&minL<s1char.size())
				{
					if(s2char.get(minL-1).equals(s1char.get(minL)))
					{
						s2char.remove(minL-1);
						s1char.remove(minL-1);
						s1char.remove(minL-1);
						count=1;
					}
				}
				if(s1char.size()>s2char.size())
				{
					minL=s2char.size();
				}
				else
				{
					minL=s1char.size();
				}
				if(count==0)
				{
					notComplete=false;
				}
			}
			
			int z=0;
			for(int i=0;i<minL;i++)
			{
				int x=(s1char.get(i).charAt(0)-s2char.get(i).charAt(0));
				z+=x;
			}
			int maxL=0;
			if(s1char.size()>s2char.size())
			{
				maxL=s1char.size();
			}
			else
			{
				maxL=s2char.size();
			}
			z+=(maxL-minL);
			System.out.println(z);
		}
	}
}
		

