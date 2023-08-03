package salesTax;

public class Item implements Taxable{
	  private String name;
	    private double price;
	    private boolean isExempt;
	    private boolean isImported;

	    public Item(String name, double price, boolean isExempt, boolean isImported) {
	        this.name = name;
	        this.price = price;
	        this.isExempt = isExempt;
	        this.isImported = isImported;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public boolean isExempt() {
	        return isExempt;
	    }

	    public boolean isImported() {
	        return isImported;
	    }

		@Override
		public double calculateSalesTax() {
			double salesTaxRate = 0.0;

	        if (!isExempt) {
	            salesTaxRate += 0.1;
	        }

	        if (isImported) {
	            salesTaxRate += 0.05;
	        }

	        return roundUpToNearest0_05(price * salesTaxRate);
		}
		
		 private double roundUpToNearest0_05(double value) {
		        return Math.ceil(value * 20) / 20.0;
		    }
}
