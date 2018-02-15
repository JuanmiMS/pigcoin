package org.mvpigs;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.mvpigs.pigcoin.GenSig;
import org.mvpigs.pigcoin.Transaction;
import org.mvpigs.pigcoin.Wallet;

public class testTransaction {
    private Transaction trx;
    private Wallet wallet_1;
    private Wallet wallet_2;


    @Before
    public void testCreacionTransaction(){
        wallet_1 = new Wallet();
        wallet_1.generateKeyPair();
        wallet_2 = new Wallet();
        wallet_2.generateKeyPair();
        trx = new Transaction("hash_1", "0", wallet_1.getAddress(), wallet_2.getAddress(), 20, "a flying pig!");

    }

    @Test
    public void testVerTransaccion(){
        assertEquals(trx.toString(), "\nhash = "+trx.getHash()+
                "\nprev_hash = "+trx.getPrev_hash()+
                "\npKey_sender = "+trx.getpKey_sender().hashCode()+
                "\npKey_recipient = "+trx.getpKey_recipient().hashCode()+
                "\npigcoins = "+trx.getPigcoins()+
                "\nmessage = "+trx.getMessage());
    }

}
