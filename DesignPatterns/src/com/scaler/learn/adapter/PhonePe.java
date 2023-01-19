package com.scaler.learn.adapter;

/**
 * Code to an interface
 * Dependency Inversion:
 *  High level module should not be directly dependent upon low level module
 *  here phone pe if uses any bank api directly it will require to do changes in the main codebase or it should be able to switch to any other bank without any chagnes
 * */
public class PhonePe {
    BankApi bankApi;

    public PhonePe(BankApi bankApi){
        this.bankApi = bankApi;
    }

    public void deposit(){
        bankApi.deposit();
    }

    public void withdraw(){
        bankApi.withdraw();
    }

    public void checkBalance(){
        bankApi.checkBalance();
    }

}

