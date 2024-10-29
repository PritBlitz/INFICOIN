import java.util.ArrayList;
import com.google.gson.GsonBuilder; 

public class INFICOIN {

    public static int difficulty = 5 ; 
    // difficilty 5 : 3 sec each block 
    // difficilty 6 : 10 sec each block
    // difficilty 7 : 2 minute each block

    public static ArrayList<Block> blockchain = new ArrayList<Block>() ;
    public static void main(String[] args) {
        
        // Now we will be adding the Blocks to the ArrayList 
        blockchain.add(new Block("Hi , This is the First Block" , "0"));
        System.out.println("Trying to Mine Block 1 ...");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("Hey There , This is the Second Block" , blockchain.get(blockchain.size() - 1).hash)) ; 
        System.out.println("Trying to Mine Block 2 ...");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("Hello , This is the Third Block" , blockchain.get(blockchain.size() - 1).hash)) ;
        System.out.println("Trying to Mine Block 3 ...");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid : " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain) ;    // This will convert the blockchain to a JSON format
        System.out.println("\nThe Block Chain : ");
        System.out.println(blockchainJson) ;
    }

    public static Boolean isChainValid() { 
        Block currentBlock ; 
        Block previousBlock ; 
        String hashTarget = new String(new char[difficulty]).replace('\0' , '0') ;

        // loop through blockchain to check hashes
        for(int i = 1  ; i < blockchain.size() ; i++) { 
            currentBlock = blockchain.get(i) ; 
            previousBlock = blockchain.get(i - 1) ; 
            if(!currentBlock.hash.equals(currentBlock.calculateHash())) { 
                System.out.println("Current Hashes not equal");
                return false  ; 
            }
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hash not Equal");
                return false ; 
                
            }

            if(!currentBlock.hash.substring(0 , difficulty).equals(hashTarget)) { 
                System.out.println("This Block Hasn't been Mined");
                return false ; 
            }
        }
        return true ; 
    }
}

