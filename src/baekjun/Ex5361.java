package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex5361 {
	
	private static double[] cost = new double[] {350.34, 230.90, 190.55, 125.30, 180.90};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			double sum = 0;
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				sum += cost[j] * num;
			}
			System.out.printf("$" + "%.2f" + "\n", sum);
		}
	}

}
