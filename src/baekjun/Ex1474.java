package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex1474 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<String> words = new ArrayList<>();
		
		int totalSize = 0;
		for (int i = 0; i < n; i++) {
			String next = br.readLine();
			totalSize += next.length();
			words.add(next);
		}
		
		if ((m - totalSize) > 0) {
			int count = (m - totalSize) / (n-1);
			int mod = (m - totalSize) % (n-1);
			
			String line = "";
			while (count-- > 0) {
				line += "_";
			}
			
			for (int i = 0; i < n-1; i++) {
				if (mod > 0) {
					if (words.get(i+1).charAt(0) <= 'z' && words.get(i+1).charAt(0) >= 'a') {
						words.set(i, words.get(i) + "_");
						mod--;
					} else if (i >= n - 1 - mod) {
						words.set(i, words.get(i) + "_");
						mod--;
					}
				}
				words.set(i, words.get(i) + line);
			}
		}
		
		for (String str : words) {
			sb.append(str);
		}
		System.out.println(sb);
	}

}
