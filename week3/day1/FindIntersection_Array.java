package week3.day1;

public class FindIntersection_Array {

	public static void main(String[] args) {

		int num[]= {1,2,3,4,5,6};
		int num2[]= {11,12,3,4,33,55};
		for(int i=0;i<=num.length-1;i++)
		{
			for(int j=0;j<=num2.length-1;j++)
			{
				if(num[i]==num2[j])
				{
					System.out.println(num[i]);
				}
					}
			}
		}
	}

}
