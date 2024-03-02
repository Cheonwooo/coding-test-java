package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 아이디어
 * 입력 받은 문자들을 모음과 자음으로 구분
 * 	-for문으로 돌면서 contains
 * 모음에서 최소 한개 자음에서 최소 두개
 * L-3으로 경우의 수 구하기
 * 구한 경우의 수로 모음, 자음에서 알파벳 뽑아 새로운 배열로 저장 후 정렬
 * 	-i=0부터 i=L-3까지 반복문
 * 	-모음과 자음을 갯수만큼 뽑아내기 -> 조합,오름차순,중복x
 * 뽑아낸 알파벳으로 오름차순 조합만들기 -----> x
 * 
 * 주어진 문자로 모든 경우의 수를 먼저 만들기
 * 경우의 수에서 모음이 0개인 경우, 자음이 0개, 1개인 경우 제외
 */

public class Ex1759 {
	private static int L, C;
	private static List<String> vowel = Arrays.asList("a", "e", "i", "o", "u");
	private static String[] arr, words;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[L];
		visited = new boolean[C];
		
		words = new String[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			words[i] = st.nextToken();
		}
		
		Arrays.sort(words);
		
		dfs(0, 0);
		System.out.println(sb);
	}
	
	private static void dfs(int start, int depth) {
		if (depth == L) {
			String password = "";
			
			for (String val : arr) {
				password += val;
			}
			
			if (!checkPassword(password)) return;
			
			sb.append(password).append("\n");
			return;
		}
		
		for (int i = start; i < C; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = words[i];
				dfs(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
	
	private static boolean checkPassword(String password) {
		
		int vowCount = 0;
		int consCount = L;
		for (int i = 0; i < vowel.size(); i++) {
			if (password.contains(vowel.get(i))) {
				vowCount++;
				consCount--;
			}
		}
		if (vowCount < 1 || consCount <2) return false;
		else return true;
	}
}

