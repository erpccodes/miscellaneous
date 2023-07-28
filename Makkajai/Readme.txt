Sales Tax Calculator:

Description:

The Sales Tax Calculator is a Java application that calculates the total cost and sales taxes for a shopping basket of items. The application considers basic sales tax (10%) for all goods except for books,
food, and medical products, which are exempt. Additionally, it applies an additional 5% import duty for all imported goods, regardless of the exemption status.

The application takes input in the form of item details (name, price, exemption status, and import status) and produces a receipt 
listing all items, their prices (including tax), the total sales taxes paid, and the overall total amount.

Classes:

Item: Represents a single item with properties like name, price, exemption status, and import status.
ShoppingBasket: Represents a collection of items purchased.
Receipt: Generates the receipt details for a given shopping basket.
Usage:

To use the Sales Tax Calculator, create a ShoppingBasket, add items to it using the Item class, and then create a Receipt object 
to print the receipt details. The application provides a console-based interface for simplicity.

Test File:

ReceiptTest.java contains JUnit test cases to ensure the correctness of the Receipt class. It verifies the accuracy of the output for 
the provided input examples. The tests ensure that the application handles different input scenarios and produces the expected output.