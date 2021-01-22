package net.javaguides.springboot.utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Utils 
{

	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public String generateStringId(int length) 
	{
		StringBuilder returnValue = new StringBuilder(length);

		for (int i = 0; i < length; i++) 
		{
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}

		return new String(returnValue);
	}
	
	
	public UUID generateIdByUUID()
	{
		UUID uniqueId = UUID.randomUUID();
		return uniqueId;
	}

}