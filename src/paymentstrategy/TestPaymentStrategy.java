package com.ah.paymentstrategy;

import java.util.Scanner;

public class TestPaymentStrategy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int type = scan.nextInt();
		if(type==1)
		{
			PaymentEngine pe = new PaymentEngine(new CreditCard());
			System.out.println(pe.dopayment());
		}
		else if(type==2)
		{
			PaymentEngine pe = new PaymentEngine(new PayPal());
			System.out.println(pe.dopayment());
		}
		
	}

}
