package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex14658 {

	private static List<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {x, y});
		}
		
		int count = 0;
		for (int[] a : list) {
			for (int[] b : list) {
				count = Math.max(count, countStars(a[0], b[1], l));
			}
		}
		System.out.println(k - count);
	}
	
	private static int countStars(int a, int b, int l) {
		int count = 0;
		for (int[] stars : list) {
			if (stars[0] >= a && stars[0] <= a + l && stars[1] >= b && stars[1] <= b + l) {
				count++;
			}
		}
		return count;
	}

}
