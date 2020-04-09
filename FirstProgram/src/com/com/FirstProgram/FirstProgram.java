package com.com.FirstProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class FirstProgram  {

	private static final String DELIMITING_REGEXP = " ";
	private static final char WORDS_SEPARATOR = ' ';

	public static void main(String[] args) throws IOException {
		
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		
		BufferedReader sanner = new BufferedReader(inputStreamReader);

		System.out.print("Enter you text: ");
		String text = sanner.readLine();

		String anagram = getAnagram(text);

		System.out.println(anagram);
	}

	private static String getAnagram(String text) {
		String[] words = text.split(DELIMITING_REGEXP);

		StringBuilder anagramBuilder = new StringBuilder();

		for (String word : words) {
			String anagram = getAnagramFromWord(word);
			anagramBuilder.append(anagram);
			anagramBuilder.append(WORDS_SEPARATOR);
		}

		anagramBuilder.deleteCharAt(anagramBuilder.length() - 1);

		return anagramBuilder.toString();
	}

	private static String getAnagramFromWord(String word) {
		char[] chars = word.toCharArray();
		StringBuilder anagramBuilder = new StringBuilder();

		for (char ch : chars) {
			if (Character.isLetter(ch)) {
				anagramBuilder.append(ch);
			}
		}

		anagramBuilder.reverse();

		for (int charIndex = 0; charIndex < word.length(); charIndex++) {
			char ch = chars[charIndex];
			if (!Character.isLetter(ch)) {
				anagramBuilder.insert(charIndex, ch);
			}
		}

		return anagramBuilder.toString();
	}

}	

    