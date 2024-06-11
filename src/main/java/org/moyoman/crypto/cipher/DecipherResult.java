package org.moyoman.crypto.cipher;

public record DecipherResult(String key, String encyptedText, 
		String decryptedText, CipherAlgorithm algorithm) {

}
