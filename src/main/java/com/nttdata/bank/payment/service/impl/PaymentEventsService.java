package com.nttdata.bank.payment.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.nttdata.bank.payment.events.Event;
import com.nttdata.bank.payment.events.PaymentCreatedEvent;
import com.nttdata.bank.payment.model.Payment;

@Component
public class PaymentEventsService {
	
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	@Value("${topic.payment.name:payments}")
	private String topicPayment;
	
	public void publish(Payment payment) {

		PaymentCreatedEvent created = new PaymentCreatedEvent();
		created.setData(payment);
		created.setId(UUID.randomUUID().toString());
//		created.setType(EventType.CREATED);
		created.setDate(new Date());

		this.producer.send(topicPayment, created);
	}

}
