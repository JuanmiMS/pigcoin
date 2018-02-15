package org.mvpigs.pigcoin;

import java.util.ArrayList;

public class BlockChain {

    ArrayList<Transaction> blockchain = new ArrayList<Transaction>();

    public BlockChain(){
    }

    public void addOrigin(Transaction transaction){
        blockchain.add(transaction);
    }
    public void summarize(){
        for (Transaction trx: blockchain) {
            System.out.println(trx.toString());
        }
    }
}
