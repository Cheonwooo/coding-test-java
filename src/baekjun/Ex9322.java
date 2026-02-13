package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex9322 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			String[] order = br.readLine().split(" ");
			
			int[] orderMap = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				String next = st.nextToken();
				for (int j = 0; j < n; j++) {
					if (next.equals(order[j])) {
						orderMap[i] = j;
						break;
					}
				}
			}
			
			String[] incoded = br.readLine().split(" ");
			String[] answer = new String[n];
			for (int i = 0; i < n; i++) {
				answer[orderMap[i]] = incoded[i];
			}
			
			for (String word : answer) {
				sb.append(word + " " );
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
