package salesTax;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Input 1
        ShoppingBasket basket1 = new ShoppingBasket();
        basket1.addItem(new Item("book", 12.49, true, false));
        basket1.addItem(new Item("music CD", 14.99, false, false));
        basket1.addItem(new Item("chocolate bar", 0.85, true, false));

        System.out.println("Output 1:");
        Receipt receipt1 = new Receipt(basket1.getItems());
        receipt1.printReceipt();

        // Input 2
        ShoppingBasket basket2 = new ShoppingBasket();
        basket2.addItem(new Item("imported box of chocolates", 10.00, true, true));
        basket2.addItem(new Item("imported bottle of perfume", 47.50, false, true));

        System.out.println("\nOutput 2:");
        Receipt receipt2 = new Receipt(basket2.getItems());
        receipt2.printReceipt();

        // Input 3
        ShoppingBasket basket3 = new ShoppingBasket();
        basket3.addItem(new Item("imported bottle of perfume", 27.99, false, true));
        basket3.addItem(new Item("bottle of perfume", 18.99, false, false));
        basket3.addItem(new Item("packet of headache pills", 9.75, true, false));
        basket3.addItem(new Item("box of imported chocolates", 11.25, true, true));

        System.out.println("\nOutput 3:");
        Receipt receipt3 = new Receipt(basket3.getItems());
        receipt3.printReceipt();
    }
	}