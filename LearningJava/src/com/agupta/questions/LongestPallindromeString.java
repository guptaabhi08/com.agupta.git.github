package com.agupta.questions;

public class LongestPallindromeString {

	public static void main(String[] args) {
		String s = "forgeeksskeegfor";

		// By dynamic programming - Time & Space O(n^2)
		String result = getLongestPallindromeString(s);
		System.out.println("Longet pallindrome string is : " + result);

		// By using 2 center approach - Time - O(n^2)
		result = getPallindromeString(s);
		System.out.println("Longest pallindrome string is : " + result);
	}

	private static String getPSByCenter(String s, int c1, int c2) {
		int i = c1, j = c2;
		for (; i >= 0 && j < s.length(); i--, j++) {
			if (s.charAt(i) != s.charAt(j)) {
				break;
			}
		}
		return s.substring(i + 1, j);
	}

	private static String getPallindromeString(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		String result = s.substring(0, 1);
		for (int i = 1; i < s.length(); i++) {
			String res1 = "", res2 = "";
			if (i % 2 != 0) {
				res1 = getPSByCenter(s, i, i + 1);
			}
			res2 = getPSByCenter(s, i, i);
			if (result.length() < res1.length()) {
				result = res1;
			}
			if (result.length() < res2.length()) {
				result = res2;
			}
		}

		return result;
	}

	private static String getLongestPallindromeString(final String s) {
		if (s == null || s.length() == 0) {
			return null;
		}

		// initial Setup
		int n = s.length();
		boolean[][] table = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			table[i][i] = true;
		}

		int longestBegin = 0;
		int maxLength = 1;

		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				longestBegin = i;
				maxLength = 2;
			}
		}

		// main processing
		for (int j = 2; j < n; j++) {
			for (int i = 0; i < n - j; i++) {
				if (table[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
					table[i][j] = true;
					longestBegin = i;
					maxLength = j + 1;
				}
			}
		}

		return s.substring(longestBegin, maxLength);
	}

}