
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22013393, 1 Aug 2023 5:52:56 pm
 */
public class Review {
	private String parentName;
	private int RateFood;
	private int RateExperience;
	private String Improvements;
	
	public Review(int RateExperience, int RateFood, String Improvements, String parentName) {
		this.RateExperience = RateExperience;
		this.RateFood = RateFood;
		this.Improvements = Improvements;
		this.parentName = parentName;
	}

	public String getParentName() {
		return parentName;
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
