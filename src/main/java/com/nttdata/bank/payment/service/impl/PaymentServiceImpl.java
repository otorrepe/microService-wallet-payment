package com.nttdata.bank.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bank.payment.model.Payment;
import com.nttdata.bank.payment.service.PaymentService;

import reactor.core.publisher.Mono;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentEventsService paymentEventsService;

	@Override
	public Mono<Payment> save(Payment payment) {
		int mobile = payment.getMobile();
		payment.setDescriptionPayment("Hicistes una transferencia");
		paymentEventsService.publish(payment);
		return Mono.just(payment)
				.flatMap(p -> {
					p.setDescriptionPayment("Te hicieron una transferencia");
					p.setMobile(p.getExternalMobile());
					p.setExternalMobile(mobile);
					paymentEventsService.publish(p);
					return Mono.just(p);
				});
	}

}
