package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex2545 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			long[] arr = new long[3];
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 3; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			long d = Long.parseLong(st.nextToken());
			long n = arr[0] + arr[1] + arr[2] - d;
			long min = 0;
			long k = 0;
			
			Arrays.sort(arr);
			
			min = Math.min(n / 3, arr[0]);
			n -= min;
			k = Math.min(n / 2, arr[1]);
			
			System.out.println(min * k * (n - k));
			
			
		}
	}

}
// 3 8 14
// 3 8 8
// 3 3 8
// 3 5 4