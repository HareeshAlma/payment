package com.ah.paymentstrategy.version2;

import java.util.Scanner;

public class TestPaymentStrategy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int type = scan.nextInt();
		if(type==1)
		{
			PaymentEngine pe = new PaymentEngine(new CreditCard(1234,"jan 2018",123,15));
			pe.dopayment();
		}
		else if(type==2)
		{
			PaymentEngine pe = new PaymentEngine(new PayPal("user1@gmail.com","password",50));
			pe.dopayment();
		}
		else if(type ==3)
		{
			PaymentEngine pe = new PaymentEngine(new Rewards(4578,"jan 2018",111,20));
			pe.dopayment();
			
		}
		
	}

}
