package org.mvpigs.pigcoin;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wallet {

    private PublicKey address;
    private PrivateKey sKey;
    private double total_input = 0;
    private double total_output = 0;
    private double balance;
    private ArrayList<Transaction> inputTransactions = new ArrayList<Transaction>();
    private ArrayList<Transaction> outputTransactions = new ArrayList<Transaction>();


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

    public void loadCoins(BlockChain blockChain){
        //Recorremos TODOS los movimientos que ha habido en el blockchain
        //Y calculamos los PGC (Pigcoins) de las wallets
        for (Transaction trx: blockChain.getBlockchain()) {
            movesPGC(trx.getpKey_sender().hashCode(), trx.getpKey_recipient().hashCode(), trx.getPigcoins());
        }

    }

    //Destino
    public void loadInputTransactions(BlockChain blockChain){
        //Nueva transacción, reiniciamos el total_input
        setTotal_input(0);

        for (Transaction trx: blockChain.getBlockchain()) {
            if (getAddress() == trx.getpKey_recipient()) {
                inputTransactions.add(trx);
                total_input+=trx.getPigcoins();

            }
        }
        setBalance(getTotal_input()-getTotal_output()); //Calculamos el balance
    }

    //Origen
    public void loadOutputTransactions(BlockChain blockChain){

        //Nueva transacción, reiniciamos totalOutput
        setTotal_output(0);
        for (Transaction trx: blockChain.getBlockchain()) {
            if (getAddress() == trx.getpKey_sender()) {
                outputTransactions.add(trx);
                setTotal_output(trx.getPigcoins());
            }
        }
        setBalance(getTotal_input()-getTotal_output()); //Calculamos el balance
    }

    public ArrayList<Transaction> getInputTransactions(){
        return inputTransactions;
    }
    public ArrayList<Transaction> getOutputTransactions(){
        return outputTransactions;
    }


    public Map collectCoins(double pigcoins){

        Map<String, Double> consumedCoins = new HashMap<>();
        for (Transaction trx: inputTransactions) {
            consumedCoins.put(trx.getHash(), trx.getPigcoins());
        }
        return consumedCoins;
    }

    public void signTransaction(String message){

    }

    public void sendCoins(PublicKey address,double pigcoins,String message, BlockChain bChain){
 //      bChain.processTransactions(wallet_1.getAddress(), wallet_2.getAddress(), consumedCoins, message, signedTransaction);

    }

    /*Métodos privados*/

    private void movesPGC(int origen, int destino, double cantidad){
//        System.out.println(origen + " MANDA "+cantidad+" a "+destino);
//        System.out.println(this.address.hashCode());

        //Si la dirección de la wallet coincide con destino, suma los PGC
        //Si a dirección de la wallet coincide con origen, resta los PGC
        //En caso de no aparecer, no ejecuta nada.
        if (origen == this.address.hashCode()){
            this.setBalance(this.balance - cantidad);
        }
        else if(destino == this.address.hashCode()){
            this.setBalance(this.balance + cantidad);
        }
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
