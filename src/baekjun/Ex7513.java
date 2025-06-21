package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex7513 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			sb.append("Scenario #" + i + ":\n");
			
			int m = Integer.parseInt(br.readLine());
			String[] words = new String[m];
			
			for (int j = 0; j < m; j++) {
				words[j] = br.readLine();
			}
			
			int n = Integer.parseInt(br.readLine());
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				
				String password = "";
				for (int p = 0; p < k; p++) {
					int index = Integer.parseInt(st.nextToken());
					password += words[index];
				}
				
				sb.append(password + "\n");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
