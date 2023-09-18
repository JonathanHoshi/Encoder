package Encoder.Encryption;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class TableEncryption implements Encryption {

    protected HashMap<Integer, Character> indexToRef;
    protected HashMap<Character, Integer> refToIndex;

    public TableEncryption(ArrayList<Character> charArr) {
        this.indexToRef = new HashMap<>();
        this.refToIndex = new HashMap<>();

        for (int i = 0; i < charArr.size(); i++) {
            this.indexToRef.put(i, charArr.get(i));
            this.refToIndex.put(charArr.get(i), i);
        }
    }

    public void printTable() {
        for (Integer name: indexToRef.keySet()) {
            String key = name.toString();
            String value = indexToRef.get(name).toString();
            System.out.println(key + " " + value);
        }
    }
}
