package org.mvpigs;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.mvpigs.pigcoin.GenSig;
import org.mvpigs.pigcoin.Wallet;


import java.security.KeyPair;

public class testAppJuanmi {

    @Test
    public void crearWallet1(){
        Wallet wallet_1 = new Wallet();
        KeyPair pair = GenSig.generateKeyPair();
        wallet_1.setSK(pair.getPrivate());
        wallet_1.setAddress(pair.getPublic());
        assertEquals(wallet_1.getAddress().hashCode(), pair.getPublic().hashCode());
    }

    @Test
    public void crearWallet2(){
        Wallet wallet_2 = new Wallet();
        wallet_2.generateKeyPair();

    }


}
