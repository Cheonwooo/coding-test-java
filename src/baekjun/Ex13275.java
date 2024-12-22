package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 메모리 28572kb, 시간 164ms

public class Ex13275 {
	private static int[] mana;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		sb.append("#");
		for (int i = 0; i <str.length(); i++) {
			sb.append(str.charAt(i) + "#");
		}
		
		String newStr = sb.toString();
		mana = new int[newStr.length()];
		manacher(newStr, newStr.length());
		
		int answer = 0;
		for (int i = 0; i < newStr.length(); i++) {
			answer = Math.max(mana[i], answer);
		}
		System.out.println(answer);
	}
	
	public static void manacher(String str, int n) {
		int r = 0;
		int p = 0;
		
		for (int i = 0; i < n; i++) {
			if (i <= r) {
				mana[i] = Math.min(mana[2*p - i], r - i);
			} else {
				mana[i] = 0;
			}
			
			while (i - mana[i] -1 >= 0 && i + mana[i] + 1 < n &&
					str.charAt(i-mana[i]-1) == str.charAt(i+mana[i]+1)) {
				mana[i]++;
			}
			
			if (r < i + mana[i]) {
				r = i + mana[i];
				p = i;
			}
		}
	}

}
