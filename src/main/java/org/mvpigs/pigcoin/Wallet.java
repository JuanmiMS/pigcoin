package org.mvpigs.pigcoin;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {

    private PublicKey address;
    private PrivateKey sKey;
    private double total_input;
    private double total_output;
    private double balance;

    //Constructor
    public Wallet(){
    }

    //Métodos públicos
    public void setSK(PrivateKey sKey){
        this.sKey = sKey;
    }

    public void generateKeyPair(){
        KeyPair pair = GenSig.generateKeyPair();
        setSK(pair.getPrivate());
        setAddress(pair.getPublic());
    }

    @Override
    public String toString(){
        return "\nWallet = "+ address.hashCode()+
                "\nTotal input = "+total_input+
                "\nTotal output = "+total_output+
                "\nBalance = "+balance+"\n";
    }

    /*Getters y setters*/
    public PublicKey getAddress() {
        return address;
    }

    public void setAddress(PublicKey address) {
        this.address = address;
    }

    public PrivateKey getsKey() {
        return sKey;
    }

    public void setsKey(PrivateKey sKey) {
        this.sKey = sKey;
    }

    public double getTotal_input(){
        return this.total_input;
    }

    public void setTotal_input(double total_input) {
        this.total_input = total_input;
    }
    public double getTotal_output(){
        return this.total_output;
    }
    public void setTotal_output(double total_output) {
        this.total_output = total_output;
    }


    public double getBalance() {
        return this.balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
