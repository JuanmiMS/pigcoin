package org.mvpigs.pigcoin;

import java.security.PublicKey;
import java.util.ArrayList;

public class BlockChain {

    ArrayList<Transaction> blockchain = new ArrayList<Transaction>();

    //Constructor
    public BlockChain(){
    }

    public ArrayList<Transaction> getBlockchain(){
        return this.blockchain;
    }

    //Métodos públicos
    public void addOrigin(Transaction transaction){
        blockchain.add(transaction);
    }
    public void summarize(){
        for (Transaction trx: blockchain) {
            System.out.println(trx.toString());
        }
    }

    public void summarize(int posicion){
        System.out.println(blockchain.get(posicion));
    }
}
