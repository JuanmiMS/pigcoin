package org.mvpigs.pigcoin;

import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {
    private PublicKey address;
    private PrivateKey sKey;

    public Wallet(){
    }

    public void setSK(PrivateKey sKey){
        this.sKey = sKey;
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
}
