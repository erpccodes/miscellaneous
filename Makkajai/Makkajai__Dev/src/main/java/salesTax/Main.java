package salesTax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of items in the shopping basket:");
        int numberOfItems = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()

        List<Taxable> items = new ArrayList<>();

        for (int i = 0; i < numberOfItems; i++) {
            System.out.println("Enter the details for item " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Price: ");
            double price = scanner.nextDouble();

            scanner.nextLine(); // Consume the newline character left by nextDouble()

            System.out.print("Is the item exempt from sales tax? (true/false): ");
            boolean isExempt = scanner.nextBoolean();

            System.out.print("Is the item imported? (true/false): ");
            boolean isImported = scanner.nextBoolean();

            scanner.nextLine(); // Consume the newline character left by nextBoolean()

            items.add(new Item(name, price, isExempt, isImported));
        }

        System.out.println("Receipt:");
        ReceiptGenerator receiptGenerator = new ReceiptGenerator(items);
        receiptGenerator.generateReceipt();

        scanner.close();
    }
}
