package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex15786 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[] origin = br.readLine().toCharArray();
		
		for (int i = 0; i < m; i++) {
			int index = 0;
			int count = 0;
			
			char[] postit = br.readLine().toCharArray();
			for (int j = 0; j < postit.length; j++) {
				if (index == origin.length) break; 
				if (origin[index] == postit[j]) {
					index++;
					count++;
				}
			}
			
			if (count != origin.length) {
				System.out.println("false");
			} else {
				System.out.println("true");
			}
		}
	}
}
