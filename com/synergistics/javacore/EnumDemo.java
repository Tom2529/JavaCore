package com.synergistics.javacore;

import java.math.BigDecimal;
import java.util.Arrays;

enum AccountType{
    CHECKING("Checking account"), //using the String constructor
    SAVINGS("Savings account"), //using the String constructor
    FIXEDDEPOSIT; //using the no-args constructor

    private String description = "default";

    AccountType(){ } //implicitly private

    AccountType(String desc){ //implicitly private
        this.description =  desc;
    }
    public void setDescription(String s){
        this.description = s;
    }
    public String getDescription(){
        return this.description;
    }

    AccountType getAccountType(int id){
        return values()[id];
    }
}

public class EnumDemo {

    public static void main(String[] args) {
        //AccountType.FIXEDDEPOSIT.setDescription("Fixed deposit account");
        //System.out.println(AccountType.FIXEDDEPOSIT.getDescription());

        //System.out.println(AccountType.CHECKING.getDescription());

        //Getting all values to Array
        AccountType[] accTypes = AccountType.values();
        System.out.println(Arrays.toString(accTypes));

        //Getting single value
        AccountType checkingAcctType = AccountType.valueOf("FIXEDDEPOSIT");
        System.out.println(checkingAcctType);
        System.out.println(checkingAcctType.toString());

        System.out.println(checkingAcctType.getAccountType(0));

//        BigDecimal price = new BigDecimal("19.99");
//        BigDecimal tax = new BigDecimal("0.07");
//        BigDecimal totalPrice = price.add(price.multiply(tax));
//
//        System.out.println("Total Price: " + totalPrice);

        double price = 19.99;
        double tax = 0.07;
        double totalPrice = price + (price * tax);

        System.out.println("Total Price: " + totalPrice);

    }
}
