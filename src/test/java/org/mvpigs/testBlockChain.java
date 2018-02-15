package org.mvpigs;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.mvpigs.pigcoin.BlockChain;
import org.mvpigs.pigcoin.Transaction;
import org.mvpigs.pigcoin.Wallet;


import java.security.KeyPair;
import java.util.ArrayList;

public class testBlockChain extends testTransaction {

    public BlockChain bChain;
    ArrayList<Transaction> blockchain = new ArrayList<Transaction>();


    @Before
    public void testCrearBlockChain(){
        bChain= new BlockChain();
        trx = new Transaction("hash_1", "0", origin.getAddress(), wallet_1.getAddress(), 20, "bacon eggs");
        bChain.addOrigin(trx);
        trx = new Transaction("hash_2", "1", origin.getAddress(), wallet_2.getAddress(), 10, "spam spam spam");
        bChain.addOrigin(trx);
        trx = new Transaction("hash_3", "hash_1", wallet_1.getAddress(), wallet_2.getAddress(), 20, "a flying pig!");
        bChain.addOrigin(trx);
    }

    @Test
    public void testSummarize(){
        int i = 0;
        for (Transaction trx: blockchain) {
            assertEquals("hash_"+i, trx.getHash());
            i++;
        }
    }
}
