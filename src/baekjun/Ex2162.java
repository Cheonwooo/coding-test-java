package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2162 {
	
	private static class Line {
		long x1;
		long y1;
		long x2;
		long y2;

		public Line(long x1, long y1, long x2, long y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	private static int[] parents, parentCount;
	private static Line[] lines;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		parents = new int[n];
		parentCount = new int[n];
		lines = new Line[n];
		
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long x1 = Long.parseLong(st.nextToken());
			long y1 = Long.parseLong(st.nextToken());
			long x2 = Long.parseLong(st.nextToken());
			long y2 = Long.parseLong(st.nextToken());
			
			lines[i] = new Line(x1, y1, x2 ,y2);
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				if (isCross(lines[i], lines[j])) {//교차한다면 부모그룹 묶기
					if (parents[i] != parents[j]) {
						unionParent(i, j);
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			parentCount[findParent(i)]++;
		}
		
		int maxCount = 0;
		int group = 0;
		for (int i = 0; i < n; i++) {
			if (parentCount[i] != 0) {
				maxCount = Math.max(maxCount, parentCount[i]);
				group++;
			}
		}
		System.out.println(group);
		System.out.println(maxCount);
	}
	
	private static boolean isCross(Line line1, Line line2) {
		long[] a = new long[] {line1.x1, line1.y1};
		long[] b = new long[] {line1.x2, line1.y2};
		long[] c = new long[] {line2.x1, line2.y1};
		long[] d = new long[] {line2.x2, line2.y2};
		
		int ccw1 = ccw(a, b, c) * ccw(a, b, d);
		int ccw2 = ccw(c, d, a) * ccw(c, d, b);
		
		if (ccw1 == 0 && ccw2 == 0) {
			long minabx = Math.min(a[0], b[0]);
			long maxabx = Math.max(a[0], b[0]);
			long minaby = Math.min(a[1], b[1]);
			long maxaby = Math.max(a[1], b[1]);
			long mincdx = Math.min(c[0], d[0]);
			long maxcdx = Math.max(c[0], d[0]);
			long mincdy = Math.min(c[1], c[1]);
			long maxcdy = Math.max(c[1], d[1]);
			
			if (minabx <= maxcdx && mincdx <= maxabx && minaby <= maxcdy && mincdy <= maxaby) {
				return true;
			} else {
				return false;
			}
		} else if (ccw1 <= 0 && ccw2 <= 0) {
			return true;
		} else {
			return false;
		}
	}

	private static int ccw(long[] a, long[] b, long[] c) {
		long k = (a[0]*b[1] + b[0]*c[1] + c[0]*a[1]) - (a[0]*c[1] + c[0]*b[1] + b[0]*a[1]);
		
		if (k > 0) return 1;
		else if (k < 0) return -1;
		else return 0;
		
	}
	
	private static int findParent(int a) {
		if (parents[a] == a) return a;
		else return parents[a] = findParent(parents[a]);
	}
	
	private static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if (a < b) {
			parents[b] = a;
		} else {
			parents[a] = b;
		}
	}
}
