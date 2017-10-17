package com.ah.paymentstrategy.version2;

public class PayPal implements PaymentInterface {

	String email;
	String password;
	int amount;
	
	public PayPal(String email,String password,int amount){
		this.email = email;
		this.password = password;
		this.amount = amount;
	}
	
	PaymentDAO pdao = new PaymentDAO();
	public boolean processpayment() {
		
		int availableamount = pdao.checkpaypalamount(email,password,amount);
		if(availableamount>amount)
		{
			System.out.println("payment processed successfully with paypal");
			return true;
		}
			else
		return false;
	}


}
