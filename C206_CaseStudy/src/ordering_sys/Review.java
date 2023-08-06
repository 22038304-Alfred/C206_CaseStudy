package ordering_sys;

public class Review {
	private int RateFood;
	private int RateExperience;
	private String Improvements;
	
	public Review(int RateExperience, int RateFood, String Improvements) {
		this.RateExperience = RateExperience;
		this.RateFood = RateFood;
		this.Improvements = Improvements;
	}

	public int getRateFood() {
		return RateFood;
	}
	public void publishRateFood(int rateFood) {
		RateFood = rateFood;
	}

	public int getRateExperience() {
		return RateExperience;
	}

	public void publishRateExperience(int rateExperience) {
		RateExperience = rateExperience;
	}

	public String getImprovements() {
		return Improvements;
	}

	public void publishImprovements(String improvements) {
		Improvements = improvements;
	}
}