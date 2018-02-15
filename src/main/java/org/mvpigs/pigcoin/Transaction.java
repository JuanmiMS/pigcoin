package org.mvpigs.pigcoin;

import java.security.PublicKey;

public class Transaction {

    private String hash;
    private String prev_hash;
    private PublicKey pKey_sender;
    private PublicKey pKey_recipient;
    private double pigcoins;
    private String message;
    private byte[] signature;


    //Constructores
    public Transaction(){}

    public Transaction(String hash, String prev_hash, PublicKey pKey_sender,
                       PublicKey pKey_recipient, double pigcoins, String message){
        this.hash = hash;
        this.prev_hash = prev_hash;
        this.pKey_sender = pKey_sender;
        this.pKey_recipient = pKey_recipient;
        this.pigcoins = pigcoins;
        this.message = message;
    }

    //Métodos públicos
    @Override
    public String toString(){
        return "\nhash = "+ hash+
                "\nprev_hash = "+prev_hash+
                "\npKey_sender = "+pKey_sender.hashCode()+
                "\npKey_recipient = "+pKey_recipient.hashCode()+
                "\npigcoins = "+pigcoins+
                "\nmessage = "+message;
    }

    //Getters y setters
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public PublicKey getpKey_sender() {
        return pKey_sender;
    }

    public void setpKey_sender(PublicKey pKey_sender) {
        this.pKey_sender = pKey_sender;
    }

    public String getPrev_hash() {
        return prev_hash;
    }

    public void setPrev_hash(String prev_hash) {
        this.prev_hash = prev_hash;
    }

    public PublicKey getpKey_recipient() {
        return pKey_recipient;
    }

    public void setpKey_recipient(PublicKey pKey_recipient) {
        this.pKey_recipient = pKey_recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getPigcoins() {
        return pigcoins;
    }

    public void setPigcoins(double pigcoins) {
        this.pigcoins = pigcoins;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }






}
