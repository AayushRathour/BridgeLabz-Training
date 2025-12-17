public class DiscountedPriceAndAmount{
	public static void main(String[] args){
		// This is the Course Fee 
		int fee = 125000;
		
		// Disscount Offered By the University
		int discountPercent = 10;
		
		// Here We have finded the Discount Amount
		int Discount = (fee*discountPercent)/100;
		
		// this is the Final Free After Discount 
		int finalFee = fee - Discount;
		
		System.out.println("The discount amount is INR : "+ Discount+ " and final discounted fee is INR : " +finalFee);
		
		
		
	}
}