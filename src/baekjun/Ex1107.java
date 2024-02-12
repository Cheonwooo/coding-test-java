package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 아이디어
 * n이 주어지면 n부터 -/+하면서
 * 고장난 버튼이 없는 수가 나올 때까지 카운트세기
 * 현재 채녈은 100
 * 100에서 +/-비교
 * n부터 +/-비교
 * 
 * 시간복잡도
 * n
 * 
 * 자료구조
 * 고장난 버튼을 저장할 List
 */

public class Ex1107 {
	private static int m;
	private static List<String> breakButtons;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		breakButtons = new ArrayList<>();
		
		if (m == 0) {
			System.out.println((int)Math.log10(n)+1);
		} else {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int breakButton = Integer.parseInt(st.nextToken()); 
				breakButtons.add(String.valueOf(breakButton));
			}
			int answer = Math.min(plusButton(n), minusButton(n));
			answer = Math.min(answer, checkPlusHundred(n));
			answer = Math.min(answer, checkMinusHundred(n));
			System.out.println(answer);
		}
		
	}

	private static int plusButton(int n) {
		int len = (int)Math.log10(n)+1;
		int count = 0;
		while (true) {
			String buttonNumber = String.valueOf(n);
			boolean check = false;
			
			for (int i = 0; i < m; i++) {
				if (buttonNumber.contains(breakButtons.get(i))) {
					count++;
					check = true;
					n++;
					break;
				}
			}
			if (!check || n == 500_000) break;
		}
		return (count + len);
	}
	
	private static int minusButton(int n) {
		int len = (int)Math.log10(n)+1;
		int count = 0;
		while (n >= 0) {
			String buttonNumber = String.valueOf(n);
			boolean check = false;
			
			for (int i = 0; i < m; i++) {
				if (buttonNumber.contains(breakButtons.get(i))) {
					count++;
					check = true;
					n--;
					break;
				}
			}
			if (check && n == -1) {
				return Integer.MAX_VALUE;
			}
			if (!check) break;
		}
		return (count + len);
	}
	
	private static int checkPlusHundred(int n) {
		int count = 0;
		int start = 100;
		while (true) {
			if (start == n) break;
			if (start == 500001) {
				return Integer.MAX_VALUE;
			}
			
			start++;
			count++;
			String buttonNumber = String.valueOf(start);
			for (int i = 0; i < m; i++) {
				if (buttonNumber.contains(breakButtons.get(i))) {
					break;
				}
			}
		}
		return count;
	}
	
	private static int checkMinusHundred(int n) {
		int count = 0;
		int start = 100;
		while (true) {
			if (start == n) break;
			if (start == -1) {
				return Integer.MAX_VALUE;
			}
			
			start--;
			count++;
			String buttonNumber = String.valueOf(start);
			for (int i = 0; i < m; i++) {
				if (buttonNumber.contains(breakButtons.get(i))) {
					break;
				}
			}
		}
		return count;
	}
}
