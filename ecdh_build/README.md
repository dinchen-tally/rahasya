# Introduction

This readme will guide about rahasya_ecc25519_x25519 JAR file.
This jar file is created using code available in this report.
It can be used for ECC25519 as well as X25519 operations.
It is meant to serve as infrastructure for any entity looking to implement 
encryption, which FIPs are required to do as per REBIT/Sahmati standards.
It can also be used as reference by FIUs, and AAs to check their respective encryption and decryption algorithms. The code used for this JAR is already available in the same repo.
The jar file in this folder is generated using BouncyCastle Library as well as java code in this repo.
However, BouncyCastle library is required for the execution of this code

# Dependencies

This code package has the following dependencies:

    Java 8 or higher
    Bouncy Castle cryptography library version 1.68 or higher

# Code Overview

The code package has the following classes:

    ECDHCryptoUtils : This class contains methods for generating ECDH key pairs, encrypting and decrypting data using ECDH encryption algorithm. It uses the X25519Controller and ECCController classes for generating the key pairs and performing encryption and decryption.

    X25519Controller: This class contains methods for generating X25519 key pairs and performing encryption and decryption using X25519 encryption algorithm.

    ECCController: This class contains methods for generating elliptic curve key pairs and performing encryption and decryption using elliptic curve cryptography.

# Methods

## ECDHCryptoUtils class

````bash
GenerateKeyMaterial(String CurveType, String ExpiryDate) ```bash -> Map<String, String>
````

This method generates a new ECDH key pair, consisting of a private key and a public key. The CurveType parameter specifies the type of curve to use for generating the key pair, and can be either "ECC" or "X25519". The ExpiryDate parameter specifies the date and time when the key pair will expire, in the format "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'". The method returns a map containing the private key, public key, nonce and expiry date.

```bash
GenerateRandomBase64Nonce() -> String
```

This method generates a random 32-byte nonce and returns it as a Base64-encoded string.

```bash
GetDate(int Hour) -> String
```

This method returns the current date and time, adjusted by the specified number of hours. The Hour parameter specifies the number of hours to adjust the date and time by. The method returns the adjusted date and time as a string in the format "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'".

```bash
EncryptDataECDH(String CurveType, String ClientPublicKey, String ClientNonce, String ClientExpiryDate, Map<String, String> ServerKEYMaterialMap, String DataToBeEncrypted) -> String
```

This method encrypts the specified data using the ECDH encryption algorithm. The CurveType parameter specifies the type of curve to use for encryption, and can be either "ECC" or "X25519". The ClientPublicKey parameter specifies the public key of the client, used for the encryption process. The ClientNonce parameter specifies a nonce provided by the client, used for the encryption process. The ClientExpiryDate parameter specifies the expiry date of the client key. The ServerKEYMaterialMap parameter is a map containing the private key, public key, nonce and expiry date of the server. The DataToBeEncrypted parameter is the data to be encrypted. The method returns the encrypted data as a Base64-encoded string.

```bash
DecryptDataECDH(String CurveType, String ServerPublicKey, String ServerNonce, String ServerExpiryDate, Map<String, String> ClientKEYMaterialMap, String DataToBeDecrypted) -> String
```

This method decrypts the specified data using the ECDH encryption algorithm. The CurveType parameter specifies the type of curve to use for decryption, and can be either "ECC" or "X25519". The ServerPublicKey parameter specifies the public key of the server, used for the for the decryption process. The ServerNonce parameter specifies a nonce provided by the server, used for the decryption process. The ServerExpiryDate parameter specifies the expiry date of the server key. The ClientKEYMaterialMap parameter is a map containing the private key, public key, nonce and expiry date of the client.. The DataToBeDecrypted parameter is the data to be decrypted. The method returns the decrypted data as a string.

## Adding BouncyCastle provider

[Steps to add BouncyCastle library](https://tomee.apache.org/bouncy-castle.html)

### Compiling test file

```bash
cd rahasya/ecdh_build
javac -cp ".;lib/rahasya_ecc25519_x25519.jar"  TestEncryption.java
```

### Running the test file

```bash
java -cp ".;lib/rahasya_ecc25519_x25519.jar;lib/bcprov-jdk15on-1.70.jar"  TestEncryption
```
