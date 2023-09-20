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
        System.out.println("< default test case 1 >");
        String ed1PlainText = "HELLO WORLD";
        String ed1EncodedText = randomEncoder.encode(ed1PlainText);
        String ed1DecodedText = randomEncoder.decode(ed1EncodedText);

        System.out.println("ED1 Plain Text       : " + ed1PlainText);
        System.out.println("Encode > Encoded Text: " + ed1EncodedText);
        System.out.println("Decode > Decoded Text: " + ed1DecodedText);
        System.out.println();

        System.out.println("< invalid test case 1 >");
        String ied1PlainText = "hello world";
        String ied1EncodedText = randomEncoder.encode(ied1PlainText);
        String ied1DecodedText = randomEncoder.decode(ied1EncodedText);

        System.out.println("IED1 Plain Text      : " + ied1PlainText);
        System.out.println("Encode > Encoded Text: " + ied1EncodedText);
        System.out.println("Decode > Decoded Text: " + ied1DecodedText);
        System.out.println();

        // Decoding test case (random)
        System.out.println("< decoding test case 1 >");
        String d1EncodedText = "BGDKKN VNQKC";
        String d1PlainText = randomEncoder.decode(d1EncodedText);

        System.out.println("D1 Encoded Text      : " + d1EncodedText);
        System.out.println("Decode > Plain Text  : " + d1PlainText);
        System.out.println();

        System.out.println("< decoding test case 2 >");
        String d2EncodedText = "FC/GGJ RJMG.";
        String d2PlainText = randomEncoder.decode(d2EncodedText);

        System.out.println("D2 Encoded Text      : " + d2EncodedText);
        System.out.println("Decode > Plain Text  : " + d2PlainText);
        System.out.println();
    }

    public static void fixedBEncoder() {
        System.out.println("--------- Fixed Encoder (B) ---------");

        // Generate a fixed CharShiftTableEncryption that specifically offset the shifting by character 'B' -> '1'
        Character[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9', '(', ')', '*', '+', ',', '-', '.', '/'};
        ArrayList<Character> refTable = new ArrayList<>(Arrays.asList(cArr));
        Encoder fixedBEncoder = new Encoder(new CharShiftTableEncryption(refTable, 'B'));

        // Encoding Decoding test case (B)
        System.out.println("< default test case 1 (B) >");
        String ed1PlainText = "HELLO WORLD";
        String ed1EncodedText = fixedBEncoder.encode(ed1PlainText);
        String ed1DecodedText = fixedBEncoder.decode(ed1EncodedText);

        System.out.println("ED1 (B) Plain Text   : " + ed1PlainText);
        System.out.println("Encode > Encoded Text: " + ed1EncodedText);
        System.out.println("Decode > Decoded Text: " + ed1DecodedText);
        System.out.println();

        // Decoding test case
        System.out.println("< decoding test case 1 (B) >");
        String d1EncodedText = "FC/GGJ RJMG.";
        String d1PlainText = fixedBEncoder.decode(d1EncodedText);

        System.out.println("D1 Encoded Text      : " + d1EncodedText);
        System.out.println("Decode > Plain Text  : " + d1PlainText);
        System.out.println();
    }
}