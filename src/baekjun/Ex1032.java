package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex1032 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String str1 = br.readLine();
		boolean[] check = new boolean[str1.length()];
		
		Arrays.fill(check, true);
		
		for (int i = 0; i < n-1; i++) {
			String str2 = br.readLine();
			
			for (int j = 0; j < str1.length(); j++) {
				if (!check[j]) continue;//이미 한 번 다르다고 체크됐다면
				
				if (str1.charAt(j) != str2.charAt(j) ) {
					check[j] = false;
				}
			}
		}
		
		for (int i = 0; i < str1.length(); i++) {
			if (check[i]) {
				System.out.print(str1.charAt(i));
			} else {
				System.out.print("?");
			}
		}
	}
}
