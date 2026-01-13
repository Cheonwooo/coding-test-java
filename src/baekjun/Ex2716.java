package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2716 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			char[] tree = br.readLine().toCharArray();
			
			int max = 0;
			int depth = 0;
			for (int j = 0; j < tree.length; j++) {
				if (tree[j] == '[') {
					depth++;
				} else {
					depth--;
				}
				max = Math.max(depth, max);
			}
			
			System.out.println((int)Math.pow(2, max));
		}
	}

}
