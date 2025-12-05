package week1.day2;

import java.util.Scanner;

public class IsPriimeNumber {

	public static void main(String[] args) {
   int input;// user input
    int check=0;
   Scanner value= new Scanner(System.in);
   input=value.nextInt();
   for(int i=1;i<=input;i++)
   {
	   if(input%i==0)
	   {
		check++;
		 }
   }
	  if (check==2)
	  {
		System.out.print("It is prime number");
	  }
	  else
	  {
		  System.out.println("It is not a prime number");
	  }
	  
	   
   }
   
		   
	}


