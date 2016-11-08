package Cipher;

/**
 * Created by DucLe on 11/7/16.
 */
public class CipherProgram {
    public static void main(String args[]) {
        SimpleCipher cipher = new SimpleCipher(3);
        System.out.println("The message is: "+cipher.encode("Le Mai Thanh Duc"));
    }
}
