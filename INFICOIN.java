public class INFICOIN {
    public static void main(String[] args) {
        
        Block genesisBlock = new Block("This is the first Block , so we will display 0 " , "0") ; 
        System.out.println("Hash for block 1 :" + genesisBlock.hash) ; 

        Block secondBlock = new Block("This is the Second Block" , genesisBlock.hash) ; 
        System.out.println("Hash for block 2 :" + secondBlock.hash) ; 
        
        Block thirdBlock = new Block("This is the Third Block" , secondBlock.hash) ; 
        System.out.println("Hash for block 1 :" + thirdBlock.hash) ; 
        
    }
}
