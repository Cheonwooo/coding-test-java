package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex9460 {
	private static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Point o) {
			return this.x - o.x;
		}
	}
	
	private static int n, k;
	private static List<Point> points;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			points = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				points.add(new Point(x, y));
			}
			
			Collections.sort(points);
			
			double left = 0.0;
			double right = 100000000.0;
			double answer = 100000001.0;

			while (right - left > 0.01) {
				double mid = (left + right) / 2;
				
				if (isPossible(mid)) {
					//해당 높이가 가능하다면
					//mid가 충분한 것이므로 right를 줄이기
					//불가능하다면 mid를 늘려야함
					right = mid;
					answer = Math.min(answer, mid);
				} else {
					left = mid;
				}
			}
			System.out.printf("%.1f\n", answer);
		}
	}

	private static boolean isPossible(double value) {
		int minH = points.get(0).y;
		int maxH = points.get(0).y;
		
		int count = 1;
		for (int i = 1; i < n; i++) {
			int y = points.get(i).y;
			
			int nextMinH = Math.min(minH, y);
			int nextMaxH = Math.max(maxH, y);
			double newValue = ((double)nextMaxH - (double)nextMinH) / 2.0;
			
			if (newValue > value) {
				count++;
				minH = y;
				maxH = y;
			} else {
				minH = nextMinH;
				maxH = nextMaxH;
			}
		}
		
		if (count > k) return false;
		return true;
	}
}
