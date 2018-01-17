package ie.km.blockchain.application.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encoder {

    private static Base64.Encoder encoder = Base64.getEncoder();

    private static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
          //
          // SHA-256 is an allowed algorithm
        }
    }

    public static String encode(byte[] data) {
        return encoder.encodeToString(data);
    }

    public static byte[] digest(byte[] data) {
        return md.digest(data);
    }

}