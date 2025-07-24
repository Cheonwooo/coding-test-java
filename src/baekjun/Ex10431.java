package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10431 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[20];
			for (int i = 0; i < 20; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[j] > arr[i]) answer++;
				}
			}
			
			System.out.println(n + " " + answer);
		}
	}

}
