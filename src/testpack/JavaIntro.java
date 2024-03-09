package testpack;

public class JavaIntro {

	public static void main(String[] args) {
		
		String[] name = {"Arya","Brami","Cynit","Doug"};
		int[] nos = {1,2,3,4,5,6,7,8,9,10};
		
		
		// normal for loop
		for (int i=0;i<name.length;i++) {
			System.out.println("The name from array are: "+name[i]);
		}
		
		
		// enhanced for loop
		for(String enc:name) {
			System.out.println("Enchanced FOR LOOP>>>The name from array are: "+enc);
		}
		

		// print the each value of int array element as multiple of 2
		for (int j=0;j<nos.length;j++) {
			System.out.println(nos[j]*2);
		}
		
		
		// print only multiple of 2 from array nos
		for (int k=0;k<nos.length;k++) {
			if(nos[k]%2 == 0)
			{
				System.out.println("The multiple of 2 from array called nos are : "+nos[k]);
			}
			else
			{
				System.out.println(nos[k]+ " is the odd value");
			}
		}
		
	}

}
