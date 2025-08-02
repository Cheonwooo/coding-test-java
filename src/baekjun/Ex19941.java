package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex19941 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char[] table = br.readLine().toCharArray();
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int start = i - k;
			int end = i + k;
			if (table[i] == 'P') {
				if (i - k < 0) {
					start = 0;
				}
				if (i + k >= n) {
					end = n-1;
				}
				
				for (int j = start; j <= end; j++) {
					if (table[j] == 'H') {
						table[j] = '*';
						answer++;
						break;
					}
				}
			}
		}
		System.out.println(answer);
	}

}
