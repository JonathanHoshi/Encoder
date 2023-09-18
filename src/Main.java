import Encoder.Encoder;
import Encoder.Encryption.CharShiftTableEncryption;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        randomEncoder();
        fixedBEncoder();
    }

    public static void randomEncoder() {
        System.out.println("--------- Random Encoder ---------");
        Encoder randomEncoder = new Encoder();

        // Encoding Decoding test case (random)
        String ed1PlainText = "HELLO WORLD";
        String ed1EncodedText = randomEncoder.encode(ed1PlainText);
        String ed1DecodedText = randomEncoder.decode(ed1EncodedText);

        System.out.println("ED1 Plain Text       : " + ed1PlainText);
        System.out.println("Encode > Encoded Text: " + ed1EncodedText);
        System.out.println("Decode > Decoded Text: " + ed1DecodedText);

        String ed2PlainText = "hello world";
        String ed2EncodedText = randomEncoder.encode(ed2PlainText);
        String ed2DecodedText = randomEncoder.decode(ed2EncodedText);

        System.out.println("ED2 Plain Text       : " + ed2PlainText);
        System.out.println("Encode > Encoded Text: " + ed2EncodedText);
        System.out.println("Decode > Decoded Text: " + ed2DecodedText);

        // Decoding test case (random)
        String d1EncodedText = "BGDKKN VNQKC";
        String d1PlainText = randomEncoder.decode(d1EncodedText);

        System.out.println("D1 Encoded Text      : " + d1EncodedText);
        System.out.println("Decode > Plain Text  : " + d1PlainText);

        String d2EncodedText = "FC/GGJ RJMG.";
        String d2PlainText = randomEncoder.decode(d2EncodedText);

        System.out.println("D2 Encoded Text      : " + d2EncodedText);
        System.out.println("Decode > Plain Text  : " + d2PlainText);
    }

    public static void fixedBEncoder() {
        System.out.println("--------- Fixed Encoder (B) ---------");

        Character[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9', '(', ')', '*', '+', ',', '-', '.', '/'};
        ArrayList<Character> refTable = new ArrayList<>(Arrays.asList(cArr));
        Encoder fixedBEncoder = new Encoder(new CharShiftTableEncryption(refTable, 'B'));

        // Encoding Decoding test case (B)
        String ed1PlainText = "HELLO WORLD";
        String ed1EncodedText = fixedBEncoder.encode(ed1PlainText);
        String ed1DecodedText = fixedBEncoder.decode(ed1EncodedText);

        System.out.println("ED1 (B) Plain Text   : " + ed1PlainText);
        System.out.println("Encode > Encoded Text: " + ed1EncodedText);
        System.out.println("Decode > Decoded Text: " + ed1DecodedText);

        // Decoding test case
        String d1EncodedText = "FC/GGJ RJMG.";
        String d1PlainText = fixedBEncoder.decode(d1EncodedText);

        System.out.println("D1 Encoded Text      : " + d1EncodedText);
        System.out.println("Decode > Plain Text  : " + d1PlainText);
    }
}