package com.OnlineShopping.www;

public interface OnlineShopping {
	abstract void Shopping();
	
	public static void main(String[] args) {
		Flipkart flip = new Flipkart();
		Zudio zudio = new Zudio();
		Myntra myntra = new Myntra();
		
		zudio.Shopping();
		zudio.OnlinePayment();
		zudio.Swiping();
	}
	
	 
}
