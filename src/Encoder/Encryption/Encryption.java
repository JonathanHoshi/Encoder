package Encoder.Encryption;

public interface Encryption {
    public String encode(String plainText);
    public String decode(String encodedText);
}
