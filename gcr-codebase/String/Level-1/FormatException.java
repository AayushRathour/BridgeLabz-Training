public class FormatException{
	// Created method to generate number format exception
	public static void generateException(String str) throws NumberFormatException{
		Integer.parseInt(str);
	}
	
	public static void main(String[] args){
		String str = "demo";
		try{
			generateException(str);
		}
		catch(NumberFormatException e){
			System.out.println("Exception Handeled");
			e.printStackTrace();
		}
	}
}