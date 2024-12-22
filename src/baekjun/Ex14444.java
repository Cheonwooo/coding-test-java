package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//메모리 28660kb, 시간 168ms

public class Ex14444 {
	
	private static int[] mana;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		sb.append("#");
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i) + "#");
		}
		
		str = sb.toString();
		mana = new int[str.length()];
		manacher(str, str.length());
		
		int answer = 0;
		for (int i = 0; i <str.length(); i++) {
			answer = Math.max(answer, mana[i]);
		}
		System.out.println(answer);
	}
	
	public static void manacher(String str, int n) {
		int r = 0;//i + mana[i]값
		int p = 0;//r이 최댓값일 때의 인덱스 값
		
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
			
			if (i + mana[i] > r) {
				r = i+mana[i];
				p = i;
			}
		}
	}

}
