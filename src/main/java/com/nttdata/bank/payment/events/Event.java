package com.nttdata.bank.payment.events;

import java.util.Date;
import lombok.Data;

@Data
public abstract class Event <T> {
    private String id;
    private Date date;
    private T data;
}
