package salesTax;

import java.text.DecimalFormat;
import java.util.List;

public class ReceiptGenerator {
    private List<Taxable> items;

    public ReceiptGenerator(List<Taxable> items) {
        this.items = items;
    }

    public void generateReceipt() {
        double totalSalesTax = 0;
        double totalPrice = 0;

        for (Taxable taxable : items) {
            Item item = (Item) taxable; // Cast the Taxable object to Item
            double itemPrice = item.getPrice();
            double salesTax = taxable.calculateSalesTax(); // Use the interface method
            totalSalesTax += salesTax;
            totalPrice += itemPrice + salesTax;

            String itemString = item.getName() + ": " + formatPrice(itemPrice + salesTax);
            System.out.println(itemString);
        }

        System.out.println("Sales Taxes: " + formatPrice(totalSalesTax));
        System.out.println("Total: " + formatPrice(totalPrice));
    }

    private String formatPrice(double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(price);
    }
}
