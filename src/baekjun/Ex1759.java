package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * ���̵��
 * �Է� ���� ���ڵ��� ������ �������� ����
 * 	-for������ ���鼭 contains
 * �������� �ּ� �Ѱ� �������� �ּ� �ΰ�
 * L-3���� ����� �� ���ϱ�
 * ���� ����� ���� ����, �������� ���ĺ� �̾� ���ο� �迭�� ���� �� ����
 * 	-i=0���� i=L-3���� �ݺ���
 * 	-������ ������ ������ŭ �̾Ƴ��� -> ����,��������,�ߺ�x
 * �̾Ƴ� ���ĺ����� �������� ���ո���� -----> x
 * 
 * �־��� ���ڷ� ��� ����� ���� ���� �����
 * ����� ������ ������ 0���� ���, ������ 0��, 1���� ��� ����
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

