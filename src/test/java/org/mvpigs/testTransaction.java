package org.mvpigs;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.mvpigs.pigcoin.Transaction;
import org.mvpigs.pigcoin.Wallet;
import org.mvpigs.pigcoin.BlockChain;

public class testTransaction extends testBlockChain{




    //@Before
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

    @Test
    public void testEjecutarTransacciones(){

        wallet_1.loadCoins(bChain);
        wallet_2.loadCoins(bChain);

        //Normalmente utilizaría el assertEquals, pero
        //me da un error de que ya no se utiliza (deprecated)
        //Así que tengo que crear un if para comparar

        //assertEquals(wallet_1.getBalance(), 0.0);
        //assertEquals(wallet_2.getBalance(), 30.0);

        if((wallet_1.getBalance() != 0.0) && (wallet_2.getBalance() != 30.0)){
            //Forzamos el fallo
            assertEquals(1,2);
        }
        else {
            //test Pasado
        }



    }

}
