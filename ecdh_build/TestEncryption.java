import rahasya_ecdh_encryption.ECDHCryptoUtils;
import java.util.Map;

public class TestEncryption {

    public static void main(String args[]) {

        String expiryDate = ECDHCryptoUtils.GetDate (48);

        String data = "Hello World";

        String curveType  = "ecc";

        Map<String,String>  serverecc = ECDHCryptoUtils.GenerateKeyMaterial (curveType, expiryDate);
        Map<String,String>  clientecc = ECDHCryptoUtils.GenerateKeyMaterial (curveType,expiryDate);

        String encryptedDataECC = ECDHCryptoUtils.EncryptDataECDH 
            (curveType, clientecc.get("publicKey"), clientecc.get("nonce"), 
            clientecc.get("expiry"), serverecc, data);

        System.out.println(encryptedDataECC);

    }

}