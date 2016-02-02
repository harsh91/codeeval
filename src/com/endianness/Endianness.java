package com.endianness;

import java.nio.ByteOrder;

/**
 * Endianness
 * Displays the endianness of the system.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/15/2015 11:27PM
 */
public class Endianness {

	public static void main(String[] args) {
		if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
			System.out.println("BigEndian");
		} else {
			System.out.println("LittleEndian");
		}
	}

}
