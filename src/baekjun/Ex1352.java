package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1352 {
	
	private static int n;
	private static boolean found = false;
	private static String result = null;
	private static int[] firstAlphaPos = new int[27];
	private static int[] ans = new int[27];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= 26; i++) {
			backtracking(i, 1, 0);
		}
		System.out.println((result == null) ? -1 : result);
	}
	
	private static void backtracking(int usingAlphaCount, int curAlphaSeq, int sum) {
		if (curAlphaSeq == usingAlphaCount + 1) {
			if (sum == n) {//n이 됐다면 이제 만들어주자
				System.arraycopy(firstAlphaPos, 1, ans, 1, usingAlphaCount);
				updateResult(usingAlphaCount);
			}
			return;
		}
		
		int start = (curAlphaSeq == 1) ? 1 : firstAlphaPos[curAlphaSeq - 1] + 1;
		int end = sum + 1;
		
		for (int i = start; i <= end; i++) {
			if (sum + i > n) break;
			
			firstAlphaPos[curAlphaSeq] = i;
			backtracking(usingAlphaCount, curAlphaSeq + 1, sum + i);
		}
	}
	
	private static void updateResult(int usingAlphaCount) {
		char[] ch = new char[n + 1	];
		int[] remainCount = new int[usingAlphaCount + 1];
		
		for (int i = 1; i <= usingAlphaCount; i++) {
			ch[ans[i]] = (char)(i + 'A' -1);
			remainCount[i] = ans[i] - 1;
		}
		
		for (int i = 1; i <= n; i++) {
			if (ch[i] != 0) continue;
			
			for (int j = 1; j <= usingAlphaCount; j++) {
				if (remainCount[j] > 0) {
					ch[i] = (char)(j + 'A' - 1);
					remainCount[j]--;
					break;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < ch.length; i++) {
			sb.append(ch[i]);
		}
		String curStr = sb.toString();
		
		if (result == null || curStr.compareTo(result) < 0) {
			result = curStr;
		}
	}
}
