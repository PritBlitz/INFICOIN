import java.util.Date; 

public class Block { 
    // Hash = Digital fingerprint
    public String hash ;     // This will hold digital signature 
    public String previousHash ;  // This will hold the previous blocks' hash
    private String data ;        // This will hokd our block data 
    private long timeStamp ; 
    private int nonce  ; 


    public Block(String data , String previousHash) { 
        this.data = data ; 
        this.previousHash = previousHash ; 
        this.timeStamp = new Date().getTime() ; 
        this.hash = calculateHash() ; 
    }


    // applySha256 will help us calculate the hash 
    public String calculateHash() { 
        String calculatedHash = cryp_util.applySHA256(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data) ; 
        return calculatedHash ; 
    }

    public void mineBlock(int difficulty) { 
        String target = new String(new char[difficulty]).replace('\0', '0') ; 
        while(!hash.substring(0 , difficulty).equals(target)) { 
            nonce++ ; 
            hash = calculateHash() ; 
        }
        System.out.println("Block Mined!!! : " + hash); 
    }
}