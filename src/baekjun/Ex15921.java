package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex15921 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		if (n == 0) {
			System.out.println("divide by zero");
			return;
		}
		
		int sum = 0;
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			count++;
		}
		
		double avg = (double)sum / count;
		double expt = 0;
		
		for (int i = 0; i < n ; i++) {
			expt += (double)arr[i] * (double)1/count;
		}
		System.out.printf("%.2f", avg / expt);
	}

}
