public class PenDisstribution{
	public static void main(String[] args){
		// Numbers of Pen
		int Pens = 14;
		// No of Students
		int Stu = 3;
		// Finding the pens per Students
		int PenPH = Pens/Stu;
		// Now Lets find the Pens Remaining
		int PensR = Pens%Stu;
		
		
		
		System.out.println("The Pen Per Student is : " +PenPH+ " and the remaining pen not distributed is : " + PensR);
		
		
		
	}
}