package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex33631 {
	
	private static int f, c, e, b, rf, rc, re, rb, cookie;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		f = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		rf = Integer.parseInt(st.nextToken());
		rc = Integer.parseInt(st.nextToken());
		re = Integer.parseInt(st.nextToken());
		rb = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			query(q, r);
		}
	}
	
	private static void query(int q, int r) {
		if (q == 1) {
			if (f / (rf * r) > 0 && 
					c / (rc * r) > 0 &&
					e / (re * r) > 0 &&
					b / (rb * r) > 0) {
				cookie += r;
				f -= (rf * r);
				c -= (rc * r);
				e -= (re * r);
				b -= (rb * r);
				System.out.println(cookie);
			} else {
				System.out.println("Hello, siumii");
			}
		} else if (q == 2) {
			f += r;
			System.out.println(f);
		} else if (q == 3) {
			c += r;
			System.out.println(c);
		} else if (q == 4) {
			e += r;
			System.out.println(e);
		} else {
			b += r;
			System.out.println(b);
		}
	}

}
