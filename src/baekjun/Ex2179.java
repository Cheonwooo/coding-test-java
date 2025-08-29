package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2179 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}
		
		String[] answer = new String[2];
		int max = -1;
		for (int i = 0; i < n; i++) {
			String wordA = words[i];
			if (wordA.length() < max) continue;
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				String wordB = words[j];
				
				if (wordB.length() < max) continue;
				int size = Math.min(wordA.length(), wordB.length());
				int count = 0;
				for (int k = 0; k < size; k++) {
					if (wordA.charAt(k) == wordB.charAt(k)) count++;
                    else break;
				}
				
				if (count > max) {
					max = count;
					answer[0] = words[i];
					answer[1] = words[j];
				}
			}
		}
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}

}
