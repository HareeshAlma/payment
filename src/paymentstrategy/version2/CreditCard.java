package com.ah.paymentstrategy.version2;

public class CreditCard implements PaymentInterface{

	int cardnumber;
	String expiry;
	int ccv;
	int amount;
	
	public CreditCard(int cardnumber,String expiry,int ccv, int amount){
		this.cardnumber = cardnumber;
		this.expiry = expiry;
		this.ccv = ccv;
		this.amount = amount;
	}
	
	PaymentDAO pdao = new PaymentDAO();
	public boolean processpayment() {
		
		int availableamount = pdao.checkamount(cardnumber,expiry,ccv,amount);
		if(availableamount>amount)
		{
			System.out.println("payment processed successfully with CreditCard");
			return true;
		}
			else
		return false;
	}

}
