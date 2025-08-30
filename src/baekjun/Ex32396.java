package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex32396 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long[] arr = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		int count = 0;
		for (int i = 0; i < n-1; i++) {
			if (Math.abs(arr[i] - arr[i+1]) < m) {//뒤의 값과 먼저 비교
				arr[i+1] = arr[i] + m;
				
				if (i < n-2 && Math.abs(arr[i+2] - arr[i+1]) < m) {
					arr[i+1] = arr[i+2] + m;
				}
				
				count++;
			}
		}
		System.out.println(count);
	}

}
