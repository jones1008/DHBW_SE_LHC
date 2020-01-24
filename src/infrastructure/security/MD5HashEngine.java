package infrastructure.security;

import java.security.MessageDigest;
import java.util.Base64;

public class MD5HashEngine extends HashEngine {
    public String hash(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes());
            byte[] digest = md.digest();
            return Base64.getEncoder().encodeToString(digest);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
