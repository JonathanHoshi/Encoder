package Encoder;

import Encoder.Encryption.Encryption;
import Encoder.Encryption.CharShiftTableEncryption;

import java.util.ArrayList;
import java.util.Arrays;

public class Encoder {

    private Encryption encryption;

    public Encoder() {
        Character[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '(', ')', '*', '+', ',', '-', '.', '/'};
        ArrayList<Character> refTable = new ArrayList<>(Arrays.asList(cArr));
        this.encryption = new CharShiftTableEncryption(refTable);
    }

    public Encoder(Encryption encryption) {
        this.encryption = encryption;
    }

    public String encode(String plainText) {
        return this.encryption.encode(plainText);
    }

    public String decode(String encodedText) {
        return this.encryption.decode(encodedText);
    }
}
