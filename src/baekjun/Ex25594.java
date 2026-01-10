package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex25594 {
	
	private static Map<String, String> words = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		makeWordDocs();
		
		for (String key : words.keySet()) {
			String value = words.get(key);
			value = value.toUpperCase();
			input = input.replaceAll(key, value);
		}
		
		for (int i = 0; i < input.length(); i++) {
			if (Character.isLowerCase(input.charAt(i))) {
				System.out.println("ERROR!");
				return;
			}
		}
		System.out.println("It's HG!");
		System.out.println(input.toLowerCase());
	}

	private static void makeWordDocs() {
		words.put("aespa", "a");
		words.put("baekjoon", "b");
		words.put("cau", "c");
		words.put("debug", "d");
		words.put("edge", "e");
		words.put("firefox", "f");
		words.put("golang", "g");
		words.put("haegang", "h");
		words.put("iu", "i");
		words.put("java", "j");
		words.put("kotlin", "k");
		words.put("lol", "l");
		words.put("mips", "m");
		words.put("null", "n");
		words.put("os", "o");
		words.put("python", "p");
		words.put("query", "q");
		words.put("roka", "r");
		words.put("solvedac", "s");
		words.put("tod", "t");
		words.put("unix", "u");
		words.put("virus","v");
		words.put("whale", "w");
		words.put("xcode", "x");
		words.put("yahoo", "y");
		words.put("zebra", "z");
	}
}
