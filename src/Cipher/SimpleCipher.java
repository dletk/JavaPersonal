package Cipher;

/**
 * Created by DucLe on 11/7/16.
 */
public class SimpleCipher {
    int shiftNumber;

    public SimpleCipher(int shiftNumber) {
        this.shiftNumber = shiftNumber;
    }

    protected String encode(String message) {
        char[] raw_message = message.toCharArray();
        for (int i = 0; i < message.length(); i++) {
            if (raw_message[i] != ' ') {
                if (i + shiftNumber <= 26) {
                    raw_message[i] += shiftNumber;
                } else if (i + shiftNumber > 26) {
                    raw_message[i] -= (26 - shiftNumber);
                }
            }
        }
        return new String(raw_message);
    }
}
