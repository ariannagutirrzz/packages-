package packages;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.ari.mathlib.MathLib;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MathLib ml = new MathLib();
		DecimalFormat df = new DecimalFormat("#.00");

		double tasaDolar = 37.0;
		double iva = 0.16;
		ArrayList<Objects> productsList = new ArrayList<>();
		
		//VARIABLES FOR PRICES VALIDATIONS
		double price =0;
		String priceString;
		boolean validInput = false;
		String pricePattern = "^[+-]?\\d+(\\.\\d{1,2})?$";
		
		int choice;
		
		do {
			
			System.out.println("-------MENU-------");
			System.out.println("1. Add products");
			System.out.println("2. Edit product");
			System.out.println("3. Search product");
			System.out.println("4. Statistics");
			System.out.println("5. Configurations");
			System.out.println("6. Exit");

			choice =sc.nextInt();
			
			switch (choice) {
			case 1: 	
				System.out.println("How many products would you like to add? ");
				int products = sc.nextInt();
				for(int i =0; i<products;i++) {
					
					boolean verification;
					String code;
			    	do {
			    		
			    		System.out.println("Type the code of the product "+ (i+1)+ ": "); 
						code = sc.next();
						verification = false;
						
						for(Objects product : productsList) {
							if(code.equals(product.getCode()) ) {
								System.err.println("The code you entered is already in use.");
								verification = true;
								break;
							};
						}
						
			    	} while(verification == true);
			    	
					System.out.println("Type the name of the product "+(i+1) + ": ");
					String name = sc.next();

					do {
					    System.out.println("Type the new price: ");
					    priceString = sc.next();

					    if (priceString.matches(pricePattern)) {
					        price = Double.parseDouble(priceString);
					        validInput = price > 0;
					        if (!validInput) {
					            System.err.println("The price cannot be less than 0.");
					        }
					    } else {
					        System.err.println("Invalid price format. Please only enter two decimal places.");
					    }
					} while (!validInput);
					
					System.out.println("Type the discount "+(i+1)+ ": ");
					double discount = sc.nextDouble();
					
					System.out.println("Type the amount of the product "+(i+1)+ ": ");
					int amount = sc.nextInt();
					
					Objects product = new Objects(name, code, price, discount, amount);
                    productsList.add(product);
                    System.out.println("Product added.");
                   
				}

				break;
			case 2:
				int opt =0;
				
				if(productsList.size() == 0) {
					System.err.println("Add some product first");
					break;
				}

				do {
					int count = 1;
					for (Objects obj : productsList) {
						System.out.println("Product " + count + ": ");
		                    productInfo(obj,tasaDolar);
		                    count++;
		                }
					System.out.println("Select the product you want to edit: ");
					int productToEdit = sc.nextInt();
					
					 if (productToEdit < 1 || productToEdit > productsList.size()) {
				            System.err.println("Invalid product selection. Please select a valid product.");
				        }
					 
					System.out.println("What do you want to edit?");
					System.out.println("1. Code");
					System.out.println("2. Name");
					System.out.println("3. Price");
					System.out.println("4. Discount");
					System.out.println("5. Amount");
					System.out.println("6. Go back");
					opt = sc.nextInt();
					Objects productSelect = productsList.get(productToEdit - 1);
					
					switch (opt) {
						case 1: 
							
							boolean condition;
							String code;
							do {
								
								System.out.println("Type the new code: ");
								code = sc.next();
								condition = false;
								
								for(Objects product : productsList) {
									if(code.equals(product.getCode()) ) {
										System.err.println("The code you entered is already in use.");
										condition = true;
										break;
									}
								}	
								
							} while(condition == true);
									
							productSelect.setCode(code);
							break;
							
						case 2: 
							System.out.println("Type the new name: ");
							String name = sc.next();
							productSelect.setName(name);
							break;
						case 3: 

							do {
							    System.out.println("Type the new price: ");
							    priceString = sc.next();

							    if (priceString.matches(pricePattern)) {
							        price = Double.parseDouble(priceString);
							        validInput = price > 0;
							        if (!validInput) {
							            System.err.println("The price cannot be less than 0.");
							        }
							    } else {
							        System.err.println("Invalid price format. Please only enter two decimal places.");
							    }
							} while (!validInput);
							productSelect.setPrice(price);

							break;
						case 4: 
							System.out.println("Type the new discount: ");

							Double Discount = sc.nextDouble();
							productSelect.setDiscount(Discount);;
							break;
						case 5: 
							System.out.println("Type the new amount: ");
							int Amount = sc.nextInt();
							productSelect.setAmount(Amount);
							break;
						case 6: break;
						
						default: System.err.println("Wrong option");
					}
					
				} while(opt != 6);

				break;
			case 3:
				
				if(productsList.size() == 0) {
					System.err.println("Add some product first");
					break;
				}
				
				System.out.println("Type the product code");
				String productCode = sc.next();
				boolean validate = false;

				for (Objects product : productsList) {

					if(productCode.equals(product.getCode())) {
						productInfo(product,tasaDolar);
	                    validate = true;
					} 
                }
				
					if(validate == false ) {
						System.out.println("code doesn't exist ");
					}
					
				break;
			case 4: 
				
				if(productsList.size() == 0) {
					System.err.println("Add some product first");
					break;
				}
				
				System.out.println("---STATISTICS---");
				
//				neto y bruto
				
					Object grossValue = MathLib.grossValue(productsList);
					Object netValue = MathLib.netValue(productsList);
					System.out.println("Gross value: " + df.format(grossValue));
					System.out.println("Net value: " + df.format(netValue));

				
				System.out.println();
				
				// cantidad de productos
				for(Objects product : productsList) {
					
					double amountOf = MathLib.amountOfEachProducts(product);
					System.out.println("Amount of " + product.getName() + ": " + amountOf);
				}
				
				System.out.println();
				
				
				//producto mas y menos costoso
		        Objects expensiveProduct = MathLib.expensiveProduct(productsList);

		        if (expensiveProduct != null) {
		            System.out.println("The expensive product is:");
		            productInfo(expensiveProduct, tasaDolar);
		        } else {
		            System.out.println("No products were found in the list.");
		        }
		        
		        
		        Objects cheaperProduct = MathLib.cheaperProduct(productsList);

		        if (cheaperProduct != null) {
		            System.out.println("The cheaper product is:");
		            productInfo(cheaperProduct,tasaDolar);
		        } else {
		            System.out.println("No products were found in the list.");
		        }
				
			
				//producto en mayor y menor cantidad

		        Objects mostAmount = MathLib.mostAmount(productsList);

		        if (mostAmount != null) {
		            System.out.println("The product with more amount is:");
		            productInfo(mostAmount,tasaDolar);
		        } else {
		            System.out.println("No products were found in the list.");
		        }
				
		        Objects lessAmount = MathLib.lessAmount(productsList);

		        if (lessAmount != null) {
		            System.out.println("The product with less amount is:");
		            productInfo(lessAmount,tasaDolar);
		        } else {
		            System.out.println("No products were found in the list.");
		        }
				
		        
				//producto con mas y menos descuento
				
		        Objects biggestDiscount = MathLib.biggestDiscount(productsList);

		        if (biggestDiscount != null) {
		            System.out.println("The product with the biggest discount is:");
		            productInfo(biggestDiscount,tasaDolar);
		        } else {
		            System.out.println("No products were found in the list.");
		        }
		        
		        Objects smallestDiscount = MathLib.smallestDiscount(productsList);

		        if (smallestDiscount != null) {
		            System.out.println("The product with the smallest discount is:");
		            productInfo(smallestDiscount,tasaDolar);
		        } else {
		            System.out.println("No products were found in the list.");
		        }
				
				//total de producto
				
				System.out.println("Total of products: " + productsList.size());
				break;
			case 5:
				
					int option2;

					do {

						System.out.println("Select the option you want to modify");
						System.out.println("1. IVA");
						System.out.println("2. Dolar price");
						System.out.println("3. Go back");
						option2 = sc.nextInt();
						
						switch(option2) {
						case 1:
							System.out.println("Type the new value for the IVA");
							iva = sc.nextDouble();
							System.out.println("IVA changed succesfully to: " + iva);
							iva /= 100;
							break;
						case 2:
							System.out.println("Type the new value for the dolar");
							tasaDolar = sc.nextDouble();
							System.out.println("Dolar price changed succesfully to: " + tasaDolar);
							break;
						case 3: break;
							default: System.err.println("Type a valid option");
						}
					} while (option2 != 3);
			
				break;
			case 6: break;
				
				default: System.err.println("Select a valid option");;
			}


		} while (choice !=6);

	}
	
	public static void productInfo(Objects obj, double tasaDolar) {

		System.out.println("Name: " + obj.getName());
        System.out.println("Code: " + obj.getCode());
        
		DecimalFormat df = new DecimalFormat("#.00");

		String formattedPrice = df.format(obj.getPrice());
		String formattedDiscount = df.format(obj.getDiscount());
		
        System.out.println("Price: " + formattedPrice + "$ || " +  df.format((obj.getPrice() * tasaDolar)) +" Bs. ");
        System.out.println("Discount: " + formattedDiscount);
        System.out.println("Amount: " + obj.getAmount());
        System.out.println();
	}
	
}