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
	private final String NUM = "0123456789";
	

	public String generateStringId(int length) 
	{
		StringBuilder returnValue = new StringBuilder(length);

		for (int i = 0; i < length; i++) 
		{
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}

		return new String(returnValue);
	}
	
	public String generateAccountNumber(int length)
	{
	StringBuilder returnValue = new StringBuilder(length);

			for (int i = 0; i < length; i++) 
			{
				returnValue.append(NUM.charAt(RANDOM.nextInt(NUM.length())));
			}

			return new String(returnValue);
	}
	
	
	public UUID generateIdByUUID()
	{
		UUID uniqueId = UUID.randomUUID();
		return uniqueId;
	}

}