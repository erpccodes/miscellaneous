public class HelloWorld {
    public static void main(String args[]) {
        for (int i = 1; i <= 100; i++) {
              if (i % 15 == 0) {
                  System.out.println("Hello World");
               } else if (i % 5 == 0) {
                   System.out.println("Hello");
               } else {
                    System.out.println(i);
                }
         }
     }   

}
