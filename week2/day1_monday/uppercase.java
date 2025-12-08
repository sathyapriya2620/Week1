package week2.day1;

public class uppercase {

	
	public static void main(String args[])
	{
		 String sample = "sathya"; 
		    
		    // get array of characters in string 
		    char[] ch = sample.toCharArray(); 
		    // iterate over characters 
		    for (int i = 0; i < ch.length; i++) { 
		      // get current character 
		      char c = ch[i]; 
		      
		     // System.out.print(ch[index]); / to check whether the loop is iterated full length
		      // check if position of this character is odd 
		    if (i % 2 != 0) { 
		        // convert it to upper case 
		    char result=Character.toUpperCase(ch[i]);
		      System.out.print(result);
		      } 
		    else
		    {
		    	//char result1=Character.toLowerCase(ch[i]);
			      System.out.print(ch[i]);
		    }
		    } 
}
}


		
	   
	   
	   
    
		
			
	



	
			
		
		
		
	
	

	

	
	

