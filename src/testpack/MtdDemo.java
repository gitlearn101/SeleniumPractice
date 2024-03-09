package testpack;

public class MtdDemo {

	public static void main(String[] args) {
		
		MtdDemo md = new MtdDemo();
		
		
		
		String takeData = md.getData();
		System.out.println(takeData+" is received from getData()");
		
		getDataStatic();         // no need to use any object to access this static method
		

	}
	
	
	public String getData()
	{
		System.out.println("Coming from getData()");
		
		return "Lelo data";
	}

	
	public static void getDataStatic()  				// once you mark the method as static then we don't have to use object to access this method. This method simply move to class level
	{
		System.out.println("COming from static method called getDataStatic()");
	}
	
}
