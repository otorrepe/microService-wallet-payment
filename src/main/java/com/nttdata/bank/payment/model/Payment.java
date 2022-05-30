package com.nttdata.bank.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	private String _id;
	
		/* CATEGORY */
	//1 - Transacción
	//2 - Transferencia
	//3 - movimiento de tarjeta
	//private Byte category;

		/* TYPE */
	//1 - Depósito
	//2 - Retiro
	//3 - Transferencia
	//private Byte type;
	
	private String descriptionPayment;
	
	private String description;
	
	private Double amount;
	
//	private String createAt;
	
	private int externalMobile;
	
	//@JsonProperty(access = Access.WRITE_ONLY)
	private int mobile;

}
