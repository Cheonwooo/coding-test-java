package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1812 {
	
	private static int n;
	private static int[] student, sum;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		student = new int[n];
		sum = new int[n];
		
		for (int i = 0; i < n; i++) {
			sum[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < 100_001; i++) {
			if (check(i)) {
				for (int j = 0; j < n; j++) {
					System.out.println(student[j]);
				}
				return;
			}
		}
	}
	
	private static boolean check(int count) {
		student[0] = count;
		for (int i = 0; i < n-1; i++) {
			student[i+1] = sum[i] - student[i];
		}
		
		if (student[n-1] + student[0] != sum[n-1]) {
			return false;
		}
		return true;
	}

}
