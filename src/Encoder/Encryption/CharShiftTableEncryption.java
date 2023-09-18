package Encoder.Encryption;

import Encoder.Operator.CharOperator;

import java.util.ArrayList;

public class CharShiftTableEncryption extends TableEncryption {

    private CharOperator charOperator;

    public CharShiftTableEncryption(ArrayList<Character> charArr, Character shiftChar) {
        this(charArr, () -> shiftChar);
    }

    public CharShiftTableEncryption(ArrayList<Character> charArr, CharOperator charOperator) {
        this(charArr);
        if (charArr.contains(charOperator.op())) {
            this.charOperator = charOperator;
            return;
        }

        System.out.println("Character not in referenced table. Switched to Random Encoding.");
    }

    public CharShiftTableEncryption(ArrayList<Character> charArr) {
        super(charArr);

        this.charOperator = () -> getRandomShiftChar();
    }

    private Character getRandomShiftChar() {
        int index = (int)(Math.random() * ((indexToRef.size()) + 1));
        return indexToRef.get(index);
    }

    @Override
    public String encode(String plainText) {
        Character shiftChar = charOperator.op();
        int shiftIndex = refToIndex.get(shiftChar);

        String encodedString = "";
        encodedString += shiftChar;

        for (int i = 0; i < plainText.length(); i++) {
            char curChar = plainText.charAt(i);

            if (refToIndex.containsKey(curChar)) {
                int shiftedIndex = (refToIndex.get(curChar) + indexToRef.size() - shiftIndex) % indexToRef.size();
                encodedString += indexToRef.get(shiftedIndex);
            } else {
                encodedString += curChar;
            }
        }

        return encodedString;
    }

    @Override
    public String decode(String encodedText) {
        char shiftChar = encodedText.charAt(0);

        if (!refToIndex.containsKey(shiftChar)) {
            return encodedText;
        }

        int shiftIndex = refToIndex.get(shiftChar);
        String decodedString = "";

        for (int i = 1; i < encodedText.length(); i++) {
            char curChar = encodedText.charAt(i);

            if (refToIndex.containsKey(curChar)) {
                int shiftedIndex = (refToIndex.get(curChar) + shiftIndex) % indexToRef.size();
                decodedString += indexToRef.get(shiftedIndex);
            } else {
                decodedString += curChar;
            }
        }

        return decodedString;
    }
}
