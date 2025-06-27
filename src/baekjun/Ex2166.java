package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex2166 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {x, y});
		}
		list.add(list.get(0));
		
		double sum1 = 0;
		double sum2 = 0;
		for (int i = 0; i < list.size() - 1; i++) { 
			sum1 += (double)list.get(i)[0] * list.get(i+1)[1];
			sum2 += (double)list.get(i)[1] * list.get(i+1)[0];
		}
		
		double answer = sum1 - sum2;
		
		System.out.printf("%.1f", Math.abs(answer / 2));
	}

}
