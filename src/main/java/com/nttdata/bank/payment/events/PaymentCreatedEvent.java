package com.nttdata.bank.payment.events;

import com.nttdata.bank.payment.model.Payment;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentCreatedEvent extends Event<Payment>{

}
