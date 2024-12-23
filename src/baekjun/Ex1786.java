package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 메모리 115200kb, 시간 4080ms

public class Ex1786 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		String pattern = br.readLine();
		
		kmp(word, pattern);
		
	}

	public static void kmp(String word, String pattern) {
		int[] table = createKmpTable(pattern);
		List<Integer> results = new ArrayList<>();
		int pIdx = 0;
		
		for (int idx = 0; idx < word.length(); idx++) {
			while (pIdx > 0 && word.charAt(idx) != pattern.charAt(pIdx)) {
				pIdx = table[pIdx-1];
			}
			
			if (word.charAt(idx) == pattern.charAt(pIdx)) {
				if (pIdx == pattern.length() - 1) {
					results.add(idx - pIdx + 1);
					pIdx = table[pIdx];
				} else {
					pIdx++;
				}
			}
		}
		System.out.println(results.size());
		for (int val : results) {
			System.out.println(val);
		}
	}
	
	public static int[] createKmpTable(String pattern) {
		int length = pattern.length();
		int[] table = new int[length];
		int pIdx = 0;
		
		for (int idx = 1; idx < length; idx++) {
			while (pIdx > 0 && pattern.charAt(idx) != pattern.charAt(pIdx)) {
				pIdx = table[pIdx-1];
			}
			
			if (pattern.charAt(idx) == pattern.charAt(pIdx)) {
				pIdx++;
				table[idx] = pIdx;
			}
		}
		
		return table;
	}
}
