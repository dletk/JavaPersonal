package Cipher;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by DucLe on 11/7/16.
 */
public class testSimpleCipher {
    @Test
    public void testConstructor() {
        SimpleCipher aCipher;
        aCipher = new SimpleCipher(0);
        assertNotNull(aCipher);
    }

    @Test
    public void testDecode() {
        SimpleCipher aCipher;
        aCipher = new SimpleCipher(3);
        assertEquals("Test with 3 fails","defghi",aCipher.encode("abcdef"));
    }
}
