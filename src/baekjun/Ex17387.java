package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17387 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());
		long[] a = new long[] {x1, y1};
		long[] b = new long[] {x2, y2};
		
		st = new StringTokenizer(br.readLine());
		long x3 = Long.parseLong(st.nextToken());
		long y3 = Long.parseLong(st.nextToken());
		long x4 = Long.parseLong(st.nextToken());
		long y4 = Long.parseLong(st.nextToken());
		long[] c = new long[] {x3, y3};
		long[] d = new long[] {x4, y4};
		
		int ccw1 = ccw(a, b, c) * ccw(a, b, d);
		int ccw2 = ccw(c, d, a) * ccw(c, d, b);
		
		if (ccw1 == 0 && ccw2 == 0) {
			long minabx = Math.min(a[0], b[0]);
			long maxabx = Math.max(a[0], b[0]);
			long mincdx = Math.min(c[0], d[0]);
			long maxcdx = Math.max(c[0], d[0]);
			long minaby = Math.min(a[1], b[1]);
			long maxaby = Math.max(a[1], b[1]);
			long mincdy = Math.min(c[1], d[1]);
			long maxcdy = Math.max(c[1], d[1]);
			
			if (minabx <= maxcdx && mincdx <= maxabx && minaby <= maxcdy && mincdy <= maxaby) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		} else if (ccw1 <= 0 && ccw2 <= 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	private static int ccw(long[] a, long[] b, long[] c) {
		long k = (a[0]*b[1] + b[0]*c[1] + c[0]*a[1]) - (a[0]*c[1] + c[0]*b[1] + b[0]*a[1]);
		if (k > 0) return 1;
		else if (k < 0) return -1;
		else return 0;
	}

}
