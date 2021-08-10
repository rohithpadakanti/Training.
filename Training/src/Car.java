import java.util.Scanner;

public class Store {

	public static void main(String[] args) {
		String productTypes[] = { "Jeans", "shoes", "shirts" };
		String products[] = { "A", "B", "C" };
		float amount[] = { 100, 200, 300 };
		int quantity[] = { 1, 2, 3 };

		System.out.println("Hi There, Welcome to Clothing Store");
		System.out.println("please select clothing for M/W: ");
		Scanner sc = new Scanner(System.in);
		switch (sc.next().toLowerCase()) {
		case "m":
			System.out.println("******Displaying Men Clothing*******");
			break;
		case "w":
			System.out.println("******Displaying Women Clothing*****");
			break;
		default:
			System.err.println("Invalid input");
			System.exit(1);
			break;
		}
		for (int i = 0; i < productTypes.length; i++) {
			System.out.printf("%1$s %2$10s %3$s %4$" + (22 - productTypes[i].length()) + "s%n", "*", i + 1,
					productTypes[i], "*");
		}
		System.out.printf("%1$s %2$5s %3$4s%n", "*", "Please choose clothing type: ", "*");
		System.out.println("************************************");
		switch (sc.next()) {
		case "1":
		case "2":
		case "3":
			System.out.println("----------------------------");
			System.out.println("products  quantity  Amount ");
			System.out.println("----------------------------");
			for (int i = 0; i < products.length; i++) {
				System.out.printf("%1$4s %2$10s %3$10.2f%n", products[i], quantity[i], amount[i]);
			}
			System.out.println("----------------------------");
			System.out.println("select product:");
			String product = sc.next();
			System.out.println("select quantity:");
			int quant = sc.nextInt();
			int index = 0;
			switch (product.toLowerCase()) {
			case "a":
				index = 0;
				break;
			case "b":
				index = 1;
				break;
			case "c":
				index = 2;
				break;
			default:
				System.err.println("Invalid product");
				System.exit(3);
				break;
			}
			int originalQuant = quantity[index];
			if (quant > originalQuant) {
				System.err.println("qunatity is not valid");
				System.exit(3);
			} else {
				System.out.println("*****Invoice generated******");
				System.out.println("----------------------------");
				System.out.println("products  quantity  Bill ");
				System.out.println("----------------------------");
				Bill bill = new Bill();
				float originalBill = bill.calculateBill(quant, amount[index]);
				int gst = 0;
				if (originalBill > 100 && originalBill <= 200) {
					gst = 10;
				} else if (originalBill > 200 && originalBill <= 500) {
					gst = 20;
				} else if (originalBill > 500) {
					gst = 30;
				}
				float finalBill = bill.calculateBill(quant, amount[index], gst);
				System.out.printf("%1$4s %2$10s %3$10.2f%n", products[index], quant, originalBill);
				System.out.println("----------------------------");
				System.out.println("Total: " + finalBill + " (" + originalBill + "Rs + " + gst + "% GST i.e. "
						+ bill.calculateGst(originalBill, gst)+"Rs)");
			}
			break;
		default:
			System.exit(2);
			System.err.println("Invalid input");
			break;
		}
		sc.close();
	}

}
class Bill {
	
	
	float calculateBill(float quantity,float price) {
		return quantity*price;
	}
	
	float calculateBill(float quantity,float price,int gst) {
		float amount = calculateBill(quantity, price);
		return amount+=(amount*gst/100);
	}
	
	float calculateGst(float amount,int gst) {		
		return (amount*gst/100);
	}

}

