cd build_src
javac -cp "../lib:/bcprov-jdk15on-1.70.jar"  rahasya_ecdh_encryption/*.java
jar cfm ../lib/rahasya_ecc25519_x25519.jar manifest.MF rahasya_ecdh_encryption/*.class
cd ..
javac -cp ".;lib/rahasya_ecc25519_x25519.jar"  TestEncryption.java
java -cp ".;lib/rahasya_ecc25519_x25519.jar;lib/bcprov-jdk15on-1.70.jar"  TestEncryption
javac -cp ".;lib/rahasya_ecc25519_x25519.jar"  TestCode.java
java -cp ".;lib/rahasya_ecc25519_x25519.jar;lib/bcprov-jdk15on-1.70.jar"  TestCode

:: Commented or can be removed
::java -cp ".;lib/rahasya_ecc25519_x25519.jar;lib/bcprov-jdk15on-1.70.jar"  rahasya_ecdh_encryption/Crypto
::javac -cp ".;lib/rahasya_ecc25519_x25519.jar"  ../TestECC25519.java
::javac -cp ".;lib/rahasya_ecc25519_x25519.jar"  ../TestX25519.java

::java -cp ".;lib/rahasya_ecc25519_x25519.jar;lib/bcprov-jdk15on-1.70.jar"  ECC25519Main
::java -cp ".;lib/rahasya_ecc25519_x25519.jar;lib/bcprov-jdk15on-1.70.jar"  X25519Main
