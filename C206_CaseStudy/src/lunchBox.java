
public class lunchBox {
		private String name;
		private String description;
		private String prices;
		private boolean isAvailable;
		
		public lunchBox(String name, String description) {
			this.name = name;
			this.description = description;
			this.isAvailable = true;
		}
		public String toString() {
			String itemInfo = String.format("%-10s %-30s %-10s %-10s", name,
			description, showAvailability(isAvailable), prices);
			return itemInfo;
		}
		
		public static String showAvailability(boolean isAvailable) {
			String avail;

			if (isAvailable == true) {
				avail = "Yes";
			} else {
				avail = "No";
			}
			return avail;
		}

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}

		public String getPrices() {
			return prices;
		}

		public boolean getIsAvailable() {
			return isAvailable;
		}

		public void setIsAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}//end of main method
	}//end of class
