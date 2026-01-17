package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2090 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (arr.length == 1) {
			System.out.println(arr[0] + "/" + 1);
			return;
		}
		
		long gcd = getGCD(arr[0], arr[1]);
		long lcm = (arr[0] * arr[1]) / gcd;
		
		for (int i = 2; i < arr.length; i++) {
			gcd = getGCD(lcm, arr[i]);
			lcm = (lcm * arr[i]) / gcd;
		}
		
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (lcm/ arr[i]);
		}
		
		gcd = getGCD(sum, lcm);
		System.out.println((lcm/gcd) + "/" + (sum/gcd));
	}
	
	private static long getGCD(long a, long b) {
		if (a % b == 0) {
			return b;
		}
		return getGCD(b, a % b);
	}

}
