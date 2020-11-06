package uk.ac.ucl.comp0110.java.investigation.gumtree;

public class Main {

    public static void main(String[] args) {
        runWorkerChain(1);
    }


    public static void runSimpleChain(int chainNum){
        for(int i=0; i<chainNum; i++){
            var trans = new Transaction("第" + (i+1) + "个事务");
            var block = new SimpleBlock(trans);
            block.mining();
        }
    }

    public static void runWorkerChain(int chainNum){
        for(int i=0; i<chainNum; i++){
            var trans = new Transaction("第" + (i+1) + "个事务");
            var block = new WorkerBlock(trans);
            block.mining();
        }
    }

}
