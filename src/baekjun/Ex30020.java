package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex30020 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int hamburgerCount = n - m;
		
		if (hamburgerCount <= 0 || hamburgerCount > m) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			System.out.println(hamburgerCount);
			
			int cheese = m / hamburgerCount;
			int remainCheese = m % hamburgerCount;
			
			for (int i = 0; i < hamburgerCount; i++) {
				int cheeseCount = cheese;
				if (i < remainCheese) {
					cheeseCount++;
				}
				
				int patty = cheeseCount + 1;
				String burger = "";
				for (int j = 0; j < patty + cheeseCount; j++) {
					if (j % 2 == 0) {
						burger += "a";
					} else {
						burger += "b";
					}
				}
				System.out.println(burger);
			}
		}
	}

}
