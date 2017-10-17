package com.ah.paymentstrategy.version2;

public class Rewards implements PaymentInterface {

	
	
	int cardnumber;
	String expiry;
	int pin;
	int amount;
	
	public Rewards(int cardnumber,String expiry,int pin, int amount){
		this.cardnumber = cardnumber;
		this.expiry = expiry;
		this.pin = pin;
		this.amount = amount;
	}
	
	PaymentDAO pdao = new PaymentDAO();
	public boolean processpayment() {
		
		int availableamount = pdao.checkrewardsamount(cardnumber,expiry,pin,amount);
		if(availableamount>amount)
		{
			System.out.println("payment processed successfully with paypal");
			return true;
		}
			else
		return false;
	}


}
