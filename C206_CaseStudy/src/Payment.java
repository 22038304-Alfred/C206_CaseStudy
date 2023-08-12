//queenie 22044804
public class Payment {
	private String buyerAcc;
	private int amount;
	private String method;
	private String  sellerAcc;
	private boolean hasRecord;
	
	public Payment(String buyerAcc, int amount, String method, String sellerAcc) {
		this.buyerAcc = buyerAcc;
		this.amount = amount;
		this.hasRecord = true; 
		this.method = method;
		this.sellerAcc = sellerAcc;
		
	}
	public String toString() {
		// Write your codes here
		String output = String.format("%-10s %-30d %-10s %-10s %-10s \n", buyerAcc,
		amount, showRecord(hasRecord), method, sellerAcc);
		return output;
	}
	public static String showRecord(boolean getRecord) {
		String hasRecord; 

		if (getRecord == true) {
			hasRecord = "Yes";
		} else {
			hasRecord = "No";
		}
		return hasRecord;
	}
	
	public String getBuyerAcc() {
		return buyerAcc;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getSellerAcc() {
		return sellerAcc;
	}
	public boolean getRecord() {
		return hasRecord;
	    }

	public void setRecord(boolean hasRecord) {
		this.hasRecord = hasRecord;
	}//end of main method
}//end of class
