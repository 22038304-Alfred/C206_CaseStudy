import java.util.ArrayList;

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
    	Payment newPay;
        for (Payment p : paymentList) {
        	newPay = p ;  
        if (newPay.getBuyerAcc().equalsIgnoreCase(trans.getBuyerAcc()) )
			return;
        }
        if (trans.getBuyerAcc().isEmpty() || trans.getSellerAcc().isEmpty()) {
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
	        if (delPay.getBuyerAcc().equals(trans.getBuyerAcc())) {
	            paymentList.remove(trans);
	            return; 
	        }
	    }
	}
}




