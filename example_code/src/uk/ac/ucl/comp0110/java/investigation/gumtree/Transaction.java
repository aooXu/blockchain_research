package uk.ac.ucl.comp0110.java.investigation.gumtree;

import java.util.Date;

public class Transaction {

    private final String core;
    private final Date timestamp;

    public Transaction(String msg){
        this(msg, new Date());
    }

    public Transaction(String msg, Date timestamp){
        this.core = msg;
        this.timestamp = timestamp;
    }

    public String toString(){
        return "Record Message: " + core + "\n" +
                "Date Time: " + timestamp.toString();
    }

}
