package org.mvpigs;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.mvpigs.pigcoin.BlockChain;
import org.mvpigs.pigcoin.GenSig;
import org.mvpigs.pigcoin.Transaction;
import org.mvpigs.pigcoin.Wallet;


import java.security.KeyPair;
import java.util.ArrayList;

public class testWallet {

    public Wallet wallet_1 = new Wallet();
    public Wallet wallet_2 = new Wallet();
    public Wallet origin = new Wallet();
    public BlockChain bChain = new BlockChain();
    public ArrayList<Transaction> blockchain = new ArrayList<Transaction>();
    public Transaction trx;

    @Before
    public void testCreacionWallets(){
        wallet_1 = new Wallet();
        wallet_1.generateKeyPair();
        wallet_2 = new Wallet();
        wallet_2.generateKeyPair();
        origin = new Wallet();
        origin.generateKeyPair();
    }


    @Test
    public void testCrearWallet1(){
        Wallet wallet_1 = new Wallet();
        KeyPair pair = GenSig.generateKeyPair();
        wallet_1.setSK(pair.getPrivate());
        wallet_1.setAddress(pair.getPublic());
        assertEquals(wallet_1.getAddress().hashCode(), pair.getPublic().hashCode());
    }

    @Test
    public void testCrearWallet2(){
        Wallet wallet_2 = new Wallet();
        wallet_2.generateKeyPair();

    }

    @Test
    public void visualizarWallets(){

        //Wallet 1
        assertEquals(wallet_1.toString(), "\nWallet = "+ wallet_1.getAddress().hashCode()+
                "\nTotal input = "+wallet_1.getTotal_input()+
                "\nTotal output = "+wallet_1.getTotal_output()+
                "\nBalance = "+wallet_1.getBalance()+"\n");

        //Wallet 2
        assertEquals(wallet_2.toString(), "\nWallet = "+ wallet_2.getAddress().hashCode()+
                "\nTotal input = "+wallet_2.getTotal_input()+
                "\nTotal output = "+wallet_2.getTotal_output()+
                "\nBalance = "+wallet_2.getBalance()+"\n");
    }

//    @Test
//    public void testVerPigcoinsWallets(){
//
//        wallet_1.loadCoins(bChain);
//        wallet_1.loadInputTransactions(bChain);
//        wallet_1.loadOutputTransactions(bChain);
//        wallet_2.loadCoins(bChain);
//        wallet_2.loadInputTransactions(bChain);
//        wallet_2.loadOutputTransactions(bChain);
//
//        assertEquals(wallet_1.toString(), "\n" +
//                "Wallet = 1990341\n" +
//                "Total input = 0.0\n" +
//                "Total output = 0.0\n" +
//                "Balance = 0.0");
//
//        assertEquals(wallet_2.toString(),"Wallet = 1982423\n" +
//                "Total input = 0.0\n" +
//                "Total output = 0.0\n" +
//                "Balance = 0.0" );
//    }

}
