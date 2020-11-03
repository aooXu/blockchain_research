package uk.ac.ucl.comp0110.java.investigation.gumtree;

import java.util.Arrays;

public class SimpleBlock {

    private final int preHash;

    private final int blockHash;
    private final Transaction transaction;

    public SimpleBlock(Transaction transaction){
        this(0, transaction);
    }

    public SimpleBlock(int preHash, Transaction transaction) {
        this.preHash = preHash;
        this.transaction = transaction;
        Object[] contents = {preHash, transaction};
        this.blockHash = Arrays.hashCode(contents);
    }

    public int getPreHash() {
        return preHash;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public int getBlockHash() {
        return blockHash;
    }

    public void mining(){
        String miningRes = transaction.toString() + "\nBlock Hash:" + blockHash;
        System.out.println(miningRes);
    }
}