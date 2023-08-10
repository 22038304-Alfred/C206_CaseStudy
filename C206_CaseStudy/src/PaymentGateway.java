import java.time.LocalDate;

public class PaymentGateway {
	private String id;
	private String creditCard;
	private String CVC;
	private LocalDate ccDate;
	private String ccNameHolder;
	private double creditAmt;
	private static final String ccv = "^4[0-9]{12}(?:[0-9]{3})?$";
	private static final String ccm = "^5[1-5][0-9]{14}$";
	private static final String cvc = "^[0-9]{3,4}$";
	
	public PaymentGateway(String ccNameHolder, String creditCard, String CVC, LocalDate ccDate) {
		this.id = Helper.toHex((ccNameHolder+creditCard+CVC).toString());
		this.ccNameHolder = ccNameHolder;
		this.creditCard = creditCard;
		this.CVC = CVC;
		this.ccDate = ccDate;
		this.creditAmt = 0;
	}

	public double getCreditAmt() {
		return creditAmt;
	}

	public void setCreditAmt(double creditAmt) {
		this.creditAmt = creditAmt;
	}

	public String getccId() {
		return id;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getCVC() {
		return CVC;
	}

	public void setCVC(String cVC) {
		CVC = Helper.readStringRegEx(cVC, cVC);
	}

	public LocalDate getCcDate() {
		return ccDate;
	}

	public void setCcDate(LocalDate ccDate) {
		this.ccDate = ccDate;
	}

	public String getCcNameHolder() {
		return ccNameHolder;
	}

	public void setCcNameHolder(String ccNameHolder) {
		this.ccNameHolder = ccNameHolder;
	}
	
	public boolean authenticate(String ccNameHolder, String creditCard, String CVC, LocalDate ccDate) {
		boolean verifiedCC = false;
		boolean verifiedcvc = false;
		boolean verifiedDate= false;
		if(Helper.readBooleanRegEx(creditCard,ccv) == true) {
			System.out.println("Credit Card: Visa");
			verifiedCC = true;
		}else if(Helper.readBooleanRegEx(creditCard, ccm) ==  true) {
			System.out.println("Credit Card: MasterCard");
			verifiedCC = true;
		}
		
		if(!verifiedCC) {
			if(Helper.readBooleanRegEx(CVC, cvc)) {
				verifiedcvc = true;
			}
		}
		
		if(!verifiedcvc) {
			 if(Helper.readBoolLocalDateCC(ccDate.toString())) {
				 verifiedDate = true;
			 }
		}
		return verifiedDate && verifiedcvc && verifiedCC;
	}

}
