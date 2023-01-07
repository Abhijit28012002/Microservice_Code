package com.lw.tech;


import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Expenses{


    enum PaymentMethod{
        CASH,CREDIT_CARD,DEBIT_CARD;
    }


    @JsonbProperty("expenses_name")
    private String name;
    private double amount;

    @JsonbTransient
    private LocalDateTime creationDate;

    @JsonbProperty("Payment")
    private PaymentMethod paymentMethod;
    private UUID uuid;


    public Expenses(String name,double amount,LocalDateTime creationDate, PaymentMethod paymentMethod,UUID uuid){
        this.name=name;
        this.amount=amount;
        this.creationDate=creationDate;
        this.paymentMethod=paymentMethod;
        this.uuid=uuid;
    }

    public Expenses(String name,double amount,PaymentMethod paymentMethod){
        this.name=name;
        this.amount=amount;
        this.creationDate=LocalDateTime.now();
        this.paymentMethod=paymentMethod;
        this.uuid=UUID.randomUUID();
    }

    @JsonbCreator
    public Expenses of(String name,double amount,PaymentMethod paymentMethod){
        return new Expenses(name,amount,paymentMethod);
    }

    public UUID getUuid(){
        return uuid;
    }
    public void setUuid(UUID uuid){
        this.uuid=uuid;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public LocalDateTime getCreationDate(){
        return creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate){
        this.creationDate=creationDate;
    }

    public PaymentMethod getPaymentMethod(){
        return paymentMethod;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod=paymentMethod;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }



}