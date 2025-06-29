package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex27967 {
	
	private static int n, count;
	private static String answer = "";
	private static char[] input, temp;
	private static List<Integer> index;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		input = br.readLine().toCharArray();
		
		index = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 'G') {
				index.add(i);
			}
		}
		
		count = index.size();
		temp = new char[count];
		comb(0);
		System.out.println(answer);
	}
	
	private static void comb(int depth) {
		if (depth == count) {
			char[] newInput = input.clone();
			
			for (int i = 0; i < index.size(); i++) {
				newInput[index.get(i)] = temp[i];
			}
			
			if (makeString(newInput)) {
				answer = new String(newInput);
			}
			return;
		}
		
		temp[depth] = '(';
		comb(depth+1);
		temp[depth] = ')';
		comb(depth+1);
	}
	
	private static boolean makeString(char[] newInput) {
		int balance = 0;
		for (char ch : newInput) {
			if (ch == '(') balance++;
			else {
				if (balance == 0) return false;
				balance--;
			}
		}
		return balance == 0;
	}
}
