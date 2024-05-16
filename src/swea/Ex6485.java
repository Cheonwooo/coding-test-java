package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex6485 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[5001];
			
			for (int i = 0 ; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				for (int j = a; j <= b; j++) {
					arr[j]++;
				}
			}
			
			int P = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < P; i++) {
				int c = Integer.parseInt(br.readLine());
				sb.append(arr[c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
