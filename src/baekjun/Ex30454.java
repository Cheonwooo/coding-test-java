package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex30454 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int max = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split("0");
			
			int line = 0;
			for (int j = 0; j < temp.length; j++ ) {
				if (!temp[j].equals("")) {
					line++;
				}
			}
			if (line > max) {
				max = line;
				count = 1;
			} else if (line == max) {
				count++;
			}
		}
		System.out.println(max + " " + count);
	}

}
