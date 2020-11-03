package uk.ac.ucl.comp0110.java.investigation.gumtree;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.security.MessageDigest;
import java.util.Date;

public class WorkerBlock extends SimpleBlock {

    private final String flag;

    public WorkerBlock(Transaction transaction) {
        this(0 , transaction);
    }

    public WorkerBlock(int preHash, Transaction transaction) {
        super(preHash, transaction);
        var flagInt = (int)(Math.random() * 100);
        flag = String.valueOf(flagInt);
    }

    @Override
    public void mining() {
        var timeFormatter = new SimpleDateFormat("hh:mm:ss");
        try {
            var sha256Encryptor =  MessageDigest.getInstance("SHA-256");
            System.out.println("Start Mining: at " + timeFormatter.format(new Date()));
            System.out.println(getTransaction().toString());
            String blockSHA256Str;
            do{
                var random = (int) (100 * Math.random());
                var data = this.getPreHash() + getTransaction().toString() + random;
                sha256Encryptor.update(data.getBytes());
                var blockSHA256 = Math.abs(new BigInteger(sha256Encryptor.digest()).longValue());
                blockSHA256Str = String.valueOf(blockSHA256);
            }while(!blockSHA256Str.startsWith(flag));
            System.out.println("SHA256: " + blockSHA256Str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("End Mining: at " + timeFormatter.format(new Date()));
    }
}
