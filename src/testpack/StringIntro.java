package testpack;

public class StringIntro {

	public static void main(String[] args) {
		
		// In Java, String is an object that represent sequence of characters
		
		String s = "Hello biu"; 						// option 1 (String literal) >> also we have concept of pointer here
		String so = new String("Hello joik"); 			// option 2 (new keyword) >> no concept of pointer
		
		
		//split
		String str = "This is new world";
		String[] spltied = str.split("new");
		
		for (int i=0;i<spltied.length;i++)
		{
			System.out.println("The splited ::"+spltied[i]);
		}
		

		// Display as sequence of characters
		for (int j=0;j<str.length();j++)
		{
			System.out.println(str.charAt(j));
		}
		
		
		// Display sequence of charater of str array in reverse order
		for(int m=str.length()-1;m>=0;m--)
		{
			System.out.println("The reverse order :: "+str.charAt(m));
		}
		
	}

}
