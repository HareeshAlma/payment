package com.ah.paymentstrategy;

public class PaymentEngine {

	private PaymentInterface pi;
	
	public PaymentEngine(PaymentInterface pi){
		this.pi = pi;
	}
	
	public boolean dopayment(){
		return pi.processpayment();
	}
}
