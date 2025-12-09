package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2003 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		long sum = arr[0];
		int s = 0;
		int e = 0;
		while (true) {
			if (e >= n) break;
			
			if (sum > m) {
				sum -= arr[s++];
			} else if (sum == m)  {
				answer++;
				sum += arr[++e];
			} else {
				sum += arr[++e];
			}
		}
		System.out.println(answer);
	}

}
