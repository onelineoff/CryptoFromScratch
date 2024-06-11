package org.moyoman.crypto.cipher;

public interface CipherText {
	public String encrypt(CipherInput input);
	public DecipherResult decrypt(String encryptedText, CipherAlgorithm algorithm);
}
