package com.lw.tech;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

@ApplicationScoped
public class ExpensesService {

    Set<Expenses> expenses = Collections.newSetFromMap(Collections.synchronizedMap(new HashMap<>()));

    @PostConstruct
    void initData(){

        expenses.add( new Expenses("food",10.5,Expenses.PaymentMethod.CASH));
        expenses.add( new Expenses("movie",50.6,Expenses.PaymentMethod.CREDIT_CARD));

    }



    //READ
    public Set<Expenses> list(){
        return expenses;
    }


    //create
    public Expenses create( Expenses expense ){
        expenses.add( expense );
        return expense;
    }


    public boolean delete(UUID uuid){
        return expenses.removeIf( expense -> expense.getUuid().equals(uuid));
    }
    public void update(Expenses expense){
        delete( expense.getUuid());
        create(expense);
    }
}
