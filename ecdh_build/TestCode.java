import rahasya_ecdh_encryption.ECDHCryptoUtils;
import java.util.Map;

public class TestCode {

    public static void main(String args[]) {


        String expiryDate = ECDHCryptoUtils.GetDate (48);

        String data = "Hello World";

        Map<String,String>  clientX25519 = ECDHCryptoUtils.GenerateKeyMaterial ("x25519",expiryDate);
        Map<String,String>  serverX25519 = ECDHCryptoUtils.GenerateKeyMaterial ("x25519",expiryDate);

        String encryptedDataX25519 = ECDHCryptoUtils.EncryptDataECDH 
        ("x25519", clientX25519.get("publicKey"),clientX25519.get("nonce"),
        clientX25519.get("expiry"),serverX25519,data);


        String decryptedDataX25519 = ECDHCryptoUtils.DecryptDataECDH 
        ("x25519", serverX25519.get("publicKey"),serverX25519.get("nonce"),
        serverX25519.get("expiry"),clientX25519,encryptedDataX25519);

        System.out.println(encryptedDataX25519);
        System.out.println(decryptedDataX25519);


        Map<String,String>  clientecc = ECDHCryptoUtils.GenerateKeyMaterial ("ecc",expiryDate);
        Map<String,String>  serverecc = ECDHCryptoUtils.GenerateKeyMaterial ("ecc",expiryDate);

        String encryptedDataECC = ECDHCryptoUtils.EncryptDataECDH 
        ("ecc", clientecc.get("publicKey"),clientecc.get("nonce"),
        clientecc.get("expiry"),serverecc,data);


        String decryptedDataECC = ECDHCryptoUtils.DecryptDataECDH 
        ("ecc", serverecc.get("publicKey"),serverecc.get("nonce"),
        serverecc.get("expiry"),clientecc,encryptedDataECC);

        System.out.println(encryptedDataECC);
        System.out.println(decryptedDataECC);

    }

}