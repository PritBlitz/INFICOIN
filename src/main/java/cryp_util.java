import java.security.MessageDigest;

// We will be choosing SHA256 from the many cryptographic(algorithms) hash functions available
// This is how we will be generating a digital fingerprint 
// java.security.MessageDigest : imported to get access to the SHA256 algorithm.

public class cryp_util {
    // This helper class will help us in applying the SHA256 to a string and result the result  in hexadecimal format
    public static String applySHA256(String input) { 
        try { 
            MessageDigest digest = MessageDigest.getInstance("SHA-256") ; 
            // Applies sha256 to our input
            byte[] hash = digest.digest(input.getBytes("UTF-8")) ;   // This will contain the hash 
            StringBuffer hexStr = new StringBuffer() ;  // This will contain hash as a hexadecimal
            for(int i = 0 ; i < hash.length ; i++) { 
                String hex = Integer.toHexString(0xff & hash[i]) ;   // This will convert the byte to a hexadecimal // oxff ? - 0xff is a hexadecimal constant which is 255 in decimal // 0xff & hash[i] - This will convert the byte to an integer  
                if(hex.length() == 1) {
                    hexStr.append('0') ;           
                }
                hexStr.append(hex) ;    // This will append the hexadecimal to the string buffer
            }
            return hexStr.toString() ;   // This will return the hash as a hexadecimal
        }
        catch(Exception e) { 
            throw new RuntimeException(e) ; 
        }
    }
}
