Basic cryptography demonstration code
===============================

This is a project for demonstrating basic historical cryptographic techniques, such as substitution or rotation ciphers.

This is primarily meant as a gentle introduction to cryptography, especially as a way of teaching cryptographic techniques to kids or teens.  This is **NOT** meant as usable code for any real applications.

# Requirements
1. Java 17 or later.
2. Apache Maven, version 3.6.0 or later.
3. git client.

# Steps to build and run Spring Boot application
1. cd to the directory with this README file.
2. Type: mvn clean compile test.
3. Type: mvn spring-boot:run
4. REST calls are at localhost:8888, or whatever port is set in application.properties.
5. Type: mvn package to create the executable jar file.
6. For the openapi3 (swagger) interface, in the browser, go to: http://localhost:8888/swagger-ui/index.html

# Installation
**TODO**

# Algorithms
Some of the basic techniques are:
* Encryption
* Encoding
* Stegnography

## Cipher
* Rotation Cipher
* Substitution Cipher
* Transposition Cipher
* One Time Pad

## Encoding
* QR encoding

## Stegnography
* Images
* Music
* Text

### Rotation Cipher
One of the simplest methods of encypting data.  It involves rotating the letters of the alphabet.  For example, the Caesar Cipher rotates by 3, so there is a one to one substitution for each letter, like this:
`Plain Text      ABCDEFGHIJKLMNOPQRSTUVWXYZ`
`Encrypted Text  DEFGHIJKLMNOPQRSTUVWXYXABC`

This was useful in ancient times, but a simple program can crack this almost instantaneously.

The secret key is the number of positions to rotate by.  There are only 25 possibilities.  Rotating by 26 is the same as not encrypting at all.

### Substitution Cipher
This is only slightly more complex than the rotation cipher.

For each letter in the plain text, a different letter is substituted.
It's possible for a given letter to map to itself.

This is the simplest possible substitution cipher.

For example, a one to one substitution might be done like this:
`Plain Text      ABCDEFGHIJKLMNOPQRSTUVWXYZ`
`Encrypted Text  CLMQBAZVINODHGFEJKPRSTYXWU`

There are many more combinations than with the rotation cipher, but this too can be easily cracked by a modern computer. There are too many combinations to solve this by brute force, but some techniques are:
* Letters appear with different frequency.  The most common are: e,a,r,i,o,t,n,s.
* The most common 80 words are likely to appear with high frequency in any text.
* Certain bigrams (two letters in sequence) appear with the greatest frequency.  The most frequent are: th, he, in, er, an.

Knowing the above facts, the decrypter program can first narrow down the possibilities by analyzing the encrypted text, and looking at the frequency of the encrypted letters, as well as the most common encrypted words, and most common encrypted bigrams.

Using the above information, the number of possibilities becomes much smaller, and those can be examined in a brute force manner.

This can be further refined by breaking up the brute force search into two steps, taking advantage of the fact that the brute force search is proportional to n factorial, where n is the number of unknown letters, and if a + b = c, then a! + b! is much, much less than c!.

### Transposition Cipher
There are many variations of this.  One example is to pick a code word, such as algorithms, which consists of unique letters.  The code word is written at the top of a rectangular group of letters.  The second line is the position of the letter above in the alphabet.  Finally, the plaintext is written in rows of the same length as the code word.  

For example, if the message is one if by land, two if by sea, it would be written like this:

`a   l   g   o   r   i   t   h   m   s`

`1   12  7   15  18  9   20  8   13  19`

`o   n   e   i   f   b   y   l   a   n`

`d   ,   t   w   o   i   f   b   y   s `  

`e   a   x   x   x   x   x   x   x   x`

If there are blank spaces, just fill them in with an x, or some other character.

The encrypted message is written by sorting by the numbers in the second line, and writing out each column in order, so the above would be:
`oiebtxlenfwxiybsox,a`

### One Time Pad
This is the only provably secure encryption algorithm. You exclusive or (xor) a random key of the same size as the plaintext with the plaintext, and this results in the encrypted file of the same size.

## Stegnography

Stegnography is the science of hiding information where it is not plainly visible.  There are many examples of this, going back to ancient Greece, when a man had his hair shaved, a messaged tattooed on his scalp,  and waited for the hair to grow back enough to hide the message.

Some physical techniques include hidden ink, and embedding messages in knitting patterns.

More modern examples include embedding hidden messages in audio or video files.



## Encoding

Encoding is different from encryption, in that the information is not easily human readable, but there is no secret key; the message can be encoded or decoded according to well known rules.  QR codes are an example of this.  A QR code can encode several thousand characters worth of data. Information can be hidden from the average person, but can be easily viewed by anyone who decodes the image, often with an app on a phone or tablet.

Messages can also be encoded before being encrypted, to defeat some of the simplistic decryption techniques used in this code sample.

# Links
(https://en.wikipedia.org/wiki/Cryptography#Classic_cryptography)

(https://en.wikipedia.org/wiki/Caesar_cipher)

(https://en.wikipedia.org/wiki/Substitution_cipher)

(https://en.wikipedia.org/wiki/Transposition_cipher)

(https://en.wikipedia.org/wiki/Polyalphabetic_cipher)

(https://en.wikipedia.org/wiki/Steganography)


(https://en.wikipedia.org/wiki/QR_code)

(https://sites.math.washington.edu/~koblitz/crlogia.html)

(https://www.qr-code-generator.com) - [QR image generator.]

(https://zxing.org/w/decode.jspx) -  [QR image decoder.]

