package ie.km.ripple.bc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class Encoder {

    private static BASE64Encoder encoder = new BASE64Encoder();

    private static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            
        }
    }

    public static String encode(byte[] data) {
        return encoder.encode(data);
    }

    public static byte[] digest(byte[] data) {
        return md.digest(data);
    }

}