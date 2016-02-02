package com.decryption;

/**
 * Decryption
 * Decrypting messages based on a key.
 * 
 * There is no input for this program.
 * Given: A message that has to decoded based on a key.
 * 
 * @author Harsh <girdharharsh@gmail.com>
 * @since 11/26/2015 5:20PM
 */
public class Decryption {

	/**
	 * decryptMessage
	 * Returns the decoded message based on the unique key.
	 * Apply a decrytion scheme for decoding the message.
	 * 
	 * @param key Unique key to decode the message
	 * @param msg The message that is to be decoded
	 * @return String Final decoded string
	 */
	public String decryptMessage(String key, String msg) {
		// Ascii value of CAPS A -> as the output is in CAPS
		int asciiA = (int) new Character('A');
		// Whatever is decoded is concatenated in this string.
		String decoded = "";
		
		// First level of decoding.
		// Fetch 2 characters from message string at a time and search in english alphabets.
		for (int i = 0, len = msg.length(); i < len; i += 2) {
			char messageChar = msg.charAt(i);
			if (messageChar == ' ') {
				decoded += " ";
				i--;
				continue;
			}
			
			String index = "" + messageChar + msg.charAt(i + 1);
			
			// Searching alphabet in english characters.
			char alphabetPos[] = Character.toChars(asciiA + Integer.parseInt(index));
			
			// value associated with that alphabet in given key.
			int keyIndex = key.indexOf(alphabetPos[0]);
			
			// Search for alphabet situated at position 'keyIndex'.
			char decodedCharacter[] = Character.toChars(asciiA + keyIndex);
			decoded += decodedCharacter[0];
		}
		return decoded;
	}

	public static void main(String[] args) {
		Decryption decryption = new Decryption();
		String key = "BHISOECRTMGWYVALUZDNFJKPQX";
		String msg = "012222 1114142503 0313012513 03141418192102 0113 2419182119021713 06131715070119";
		System.out.println(decryption.decryptMessage(key, msg));
	}
}