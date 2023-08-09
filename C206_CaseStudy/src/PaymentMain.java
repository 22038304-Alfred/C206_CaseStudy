import java.util.ArrayList;
//queenie 22044804
public class PaymentMain {

    public static void main(String[] args) {
        
    	ArrayList<Payment> paymentList = new ArrayList<Payment>();

        paymentList.add(new Payment("12345", 40, "Visa", "54321"));
        paymentList.add(new Payment("56789", 20, "Credit Card","98765"));
        paymentList.add(new Payment("34567", 60, "PayNow", "76543"));
        
    }
    
    
    //input
	public static Payment inputPayment() {	
		
		String buyer = Helper.readString("Enter buyer account > ");
		int price = Helper.readInt("Enter price > ");
		String method = Helper.readString("Enter payment method > ");
		String seller = Helper.readString("Enter seller account > ");

		Payment trans = new Payment(buyer, price, method, seller);
		return trans;
		
	}
	
	
	//add
    public static void addPayment(ArrayList<Payment> paymentList, Payment trans) {
    	makePayment(paymentList, trans);
    }


	public static void makePayment(ArrayList<Payment> paymentList, Payment trans) {
		Payment newPay;
        String transBuyerAcc = trans.getBuyerAcc();
		for (Payment p : paymentList) {
        	newPay = p ;  
        if (newPay.getBuyerAcc().equalsIgnoreCase(transBuyerAcc) )
			return;
        }
        String transSellerAcc = trans.getSellerAcc();
		if (transBuyerAcc.isEmpty() || transSellerAcc.isEmpty()) {
            return;
        }
        paymentList.add(trans);
	}
    
    
    //retrieve
    public static String retrieveAllPayment(ArrayList<Payment> paymentList) {
		String output = "";

		for (Payment p : paymentList) {
			if (p.getRecord()) {
				output += p.toString();
			}
		}
		return output; 
	}
    
	public static void viewAllPayment(ArrayList<Payment> paymentList) {
		output(paymentList); 
	}


	public static void output(ArrayList<Payment> paymentList) {
		String output = String.format("%-10s %-30d %-10s %-10s %-10s \n", "BUYER ACC", "AMOUNT",
					"RECORD", "METHOD","SELLER ACC");
			 output += retrieveAllPayment(paymentList);	
			System.out.println(output);
	}
    
    
	//delete
	public static void deletePayment(ArrayList<Payment> paymentList, Payment trans) {
	    Payment delPay;
	    for (Payment p : paymentList) {
	        delPay = p;
	        String transBuyerAcc = trans.getBuyerAcc();
			String existBuyerAcc = delPay.getBuyerAcc();
			if (existBuyerAcc.equals(transBuyerAcc)) {
	            paymentList.remove(trans);
	            return; 
	        }
	    }
	}//end of main method
}//end of class




