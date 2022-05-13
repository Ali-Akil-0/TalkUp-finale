package controller;

import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;
import static sun.security.krb5.Confounder.bytes;


public class RSA {
    private PrivateKey privatekey;
        private PublicKey publicKey;
        public RSA(){
    try {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        KeyPair pair = generator.generateKeyPair();
        privatekey = pair.getPrivate();
        publicKey = pair.getPublic();
    } catch (Exception ignored) {}
}
        private String encode(byte[] data){
    return Base64.getEncoder().encodeToString(data);
}
private byte[] decode(String data){
    return Base64.getDecoder().decode(data);
}
public String encrypt(String message,PublicKey publicKey) throws Exception{
    byte[] messageToBytes = message.getBytes();
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(Cipher.ENCRYPT_MODE,publicKey);
    byte[] encryptedBytes = cipher.doFinal(messageToBytes);
    return encode(encryptedBytes);
}
public String decrypt(String encryptedMessage,PrivateKey privatekey ) {
    try{
         byte[] encryptedBytes = Base64.getMimeDecoder().decode(encryptedMessage);
    Cipher cipher = Cipher.getInstance("RSA");
     cipher.init(Cipher.DECRYPT_MODE, privatekey);
        return new String(cipher.doFinal(encryptedBytes), UTF_8);
    }
    catch(Exception e){
        System.out.println(e.getMessage());
        return null ;
    }
   
        
}
public static void main(String[] args) {
    RSA rsa = new RSA();
    try{
        //String encryptedMessage = rsa.encrypt("Hello World");
       // String decryptedMessage = rsa.decrypt(encryptedMessage);

       // System.err.println("Encrypted:\n"+encryptedMessage);
       // System.err.println("Decrypted:\n"+decryptedMessage);

    }catch (Exception ingored){}
}
}

