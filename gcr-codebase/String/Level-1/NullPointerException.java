public class NullPointerException{
	// method to generate null pointer exception
	public static void generateNullException(String s) throws NullPointerException{
		s.length();
	}
	
	public static void main(String[] args){
		String txt = null;
		try{
			generateNullException(txt);
		}
		catch(NullPointerException e){
			System.out.println("Exception Handeled");
			e.printStackTrace();
		}
	}
}