public class ProfitAndLoss{
	public static void main(String[] args){
		// Cost Price
		int cost = 129;
		// Selling Price 
		int selling  = 191;
		// We have finded the Profit 
		double profit = selling-cost;
		// And here we have find the Profit Persentage 
		double profitp = (profit/cost)*100;
		
		System.out.println("The Cost Price is INR "+ cost+ " and Selling Price is INR " +selling+
"The Profit is INR "+ profit+ "and the Profit Percentage is "+ profitp);
		
		
		
	}
}