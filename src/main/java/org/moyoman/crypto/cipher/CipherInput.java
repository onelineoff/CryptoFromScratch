package org.moyoman.crypto.cipher;

public record CipherInput(String key, String plainText, CipherAlgorithm algorithm) {

}
