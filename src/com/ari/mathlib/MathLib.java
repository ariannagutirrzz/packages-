package com.ari.mathlib;

import java.util.ArrayList;


import packages.Objects;
	public class MathLib {

		private static Double iva = 0.16;
		private static Double totalGrossValue = 0.0;
        private static Double totalNetValue = 0.0;
	
		//GROSS AND NET VALUES
		
	    public static Double grossValue(ArrayList<Objects> productsList) {
	        // Calcula el valor bruto: precio * cantidad
	    	for (Objects product : productsList) {
	            totalGrossValue += product.getPrice() * product.getAmount();
	        }
	    	
	    	return totalGrossValue;
	    }

	    public static Double netValue(ArrayList<Objects> productsList) {

	    	for(Objects product : productsList) {
	    		  totalNetValue += (product.getPrice() + product.getAmount() * iva);
	    	}
	    	return totalNetValue;
	    }
	    
	    // AMOUNT OF VALUES
	    
	    public static int amountOfEachProducts(Objects product) {
	    	return product.getAmount();

	    }
	    
	    // EXPENSIVE PRODUCT
	    
	    public static Objects expensiveProduct(ArrayList<Objects> productsList) {
			
	    	if (productsList.isEmpty()) {
	            return null; // The list is empty, there are no products to compare.
	        }
	    	
	        Objects expensiveProduct = productsList.get(0);
	        for (Objects product : productsList) {
	            if (product.getPrice() > expensiveProduct.getPrice()) {
	                expensiveProduct = product;
	            }
	        }
	    	
	    	return expensiveProduct;
	    };
	    
	    //CHEAPER PRODUCT
	    
	    public static Objects cheaperProduct(ArrayList<Objects> productsList) {
			
	    	if (productsList.isEmpty()) {
	            return null; // The list is empty, there are no products to compare.
	        }
	    	
	        Objects cheaperProduct = productsList.get(0);
	        for (Objects product : productsList) {
	            if (product.getPrice() < cheaperProduct.getPrice()) {
	                cheaperProduct = product;
	            }
	        }

	    	return cheaperProduct;
	    };
	    
	    // MOST AMOUNT OF THE PRODUCTS
	    
	    public static Objects mostAmount(ArrayList<Objects> productsList) {
			
	    	if (productsList.isEmpty()) {
	            return null; // The list is empty, there are no products to compare.
	        }
	    	
	        Objects mostAmountProduct = productsList.get(0);
	        for (Objects product : productsList) {
	            if (product.getAmount() > mostAmountProduct .getAmount()) {
	            	mostAmountProduct  = product;
	            }
	        }

	    	return mostAmountProduct;
	    };
	    
	    // LESS AMOUNT OF THE PRODUCTS
	    
	    public static Objects lessAmount(ArrayList<Objects> productsList) {
			
	    	if (productsList.isEmpty()) {
	            return null; // The list is empty, there are no products to compare.
	        }
	    	
	        Objects lessAmountProduct = productsList.get(0);
	        for (Objects product : productsList) {
	            if (product.getAmount() < lessAmountProduct .getAmount()) {
	            	lessAmountProduct = product;
	            }
	        }

	    	return lessAmountProduct;
	    };
	    
	    // BIGGEST DISCOUNT 
	    
	    public static Objects biggestDiscount(ArrayList<Objects> productsList) {
			
	    	if (productsList.isEmpty()) {
	            return null; // The list is empty, there are no products to compare.
	        }
	    	
	        Objects biggestDiscount = productsList.get(0);
	        for (Objects product : productsList) {
	            if (product.getAmount() > biggestDiscount .getDiscount()) {
	            	biggestDiscount  = product;
	            }
	        }

	    	return biggestDiscount;
	    };
	    
	    // SMALLEST DISCOUNT
	    
	    public static Objects smallestDiscount(ArrayList<Objects> productsList) {
			
	    	if (productsList.isEmpty()) {
	            return null; // The list is empty, there are no products to compare.
	        }
	    	
	        Objects smallestDiscount = productsList.get(0);
	        for (Objects product : productsList) {
	            if (product.getAmount() < smallestDiscount .getDiscount()) {
	            	smallestDiscount  = product;
	            }
	        }

	    	return smallestDiscount;
	    };
	    	    
	
	}
	