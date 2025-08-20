package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex20528 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String pre = st.nextToken();
		for (int i = 1; i < n; i++) {
			String next = st.nextToken();
			if (pre.charAt(pre.length()-1) != next.charAt(0)) {
				System.out.println(0);
				return;
			}
			pre = next;
		}
		System.out.println(1);
	}

}
