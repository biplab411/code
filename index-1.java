import java.util.Scanner;

public class ProductCatalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int priceA = 20;
        int priceB = 40;
        int priceC = 50;

        
        System.out.print("Enter the quantity of Product A: ");
        int quantityA = scanner.nextInt();
        System.out.print("Is Product A a gift? (yes/no): ");
        String giftA = scanner.next();

        System.out.print("Enter the quantity of Product B: ");
        int quantityB = scanner.nextInt();
        System.out.print("Is Product B a gift? (yes/no): ");
        String giftB = scanner.next();

        System.out.print("Enter the quantity of Product C: ");
        int quantityC = scanner.nextInt();
        System.out.print("Is Product C a gift? (yes/no): ");
        String giftC = scanner.next();

        
        int totalA = quantityA * priceA;
        int totalB = quantityB * priceB;
        int totalC = quantityC * priceC;

       
        int subtotal = totalA + totalB + totalC;

        int discountAmount = 0;
        int totalQuantity = quantityA + quantityB + quantityC;

        if (subtotal > 200) {
            discountAmount = 10;
        } else if (quantityA > 10 || quantityB > 10 || quantityC > 10) {
            int discountableTotal = 0;
            if (quantityA > 10) {
                discountableTotal += totalA;
            }
            if (quantityB > 10) {
                discountableTotal += totalB;
            }
            if (quantityC > 10) {
                discountableTotal += totalC;
            }
            discountAmount = (int) (discountableTotal * 0.05);
        } else if (totalQuantity > 20) {
            discountAmount = (int) (subtotal * 0.10);
        } else if (totalQuantity > 30 && (quantityA > 15 || quantityB > 15 || quantityC > 15)) {
            if (quantityA > 15) {
                discountAmount += ((quantityA - 15) * priceA) / 2;
            }
            if (quantityB > 15) {
                discountAmount += ((quantityB - 15) * priceB) / 2;
            }
            if (quantityC > 15) {
                discountAmount += ((quantityC - 15) * priceC) / 2;
            }
        }

        
        int giftWrapFee = (giftA.equalsIgnoreCase("yes") ? quantityA : 0) +
                (giftB.equalsIgnoreCase("yes") ? quantityB : 0) +
                (giftC.equalsIgnoreCase("yes") ? quantityC : 0);

        
        int shippingFee = ((totalQuantity - 1) / 10 + 1) * 5;

        int total = subtotal - discountAmount + shippingFee + giftWrapFee;

        
        System.out.println("Product A - Quantity: " + quantityA + ", Total: " + totalA);
        System.out.println("Product B - Quantity: " + quantityB + ", Total: " + totalB);
        System.out.println("Product C - Quantity: " + quantityC + ", Total: " + totalC);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount Applied: " + (discountAmount > 0 ? "Yes" : "No") + ", Amount: " + discountAmount);
        System.out.println("Shipping Fee: " + shippingFee);
        System.out.println("Gift Wrap Fee: " + giftWrapFee);
        System.out.println("Total: " + total);
    }
}
