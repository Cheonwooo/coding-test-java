package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex25643 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boolean check = true;
		String pre = br.readLine();
		for (int i = 0; i < n-1; i++) {
			String next = br.readLine();
			for (int j = 1; j <= m; j++) {
				if (pre.substring(0, j).equals(next.subSequence(m-j, m))) {
					check = true;
					break;
				} else if (pre.substring(m-j, m).equals(next.substring(0, j))) {
					check = true;
					break;
				} else {
					check = false;
				}
			}
			pre = next;
			if (!check) break;
		}
		System.out.println((check) ? 1 : 0);
	}

}
