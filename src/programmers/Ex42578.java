package programmers;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 아이디어
 * 모든 조합의 경우의 수를 구하기
 * 구한 경우의 수에서 종류의 수가 2이상인 경우는 제외
 * 
 * 시간복잡도
 * 2^n = 2^30
 * 
 * 자료구조
 * 의상 이름을 저장할 String[]
 * 사용된 의상 종류를 저장할 map
 */

public class Ex42578 {
	private static int count;
	private static String[] arr, name;
	private static boolean[] visited;
	private static Map<String, Integer> clothType;
	private static Map<String, String> nameAndType;

	public static void main(String[] args) throws IOException{
		
		String[][] clothes= {{"crow_mask", "face"},
				{"blue_sunglasses", "face"},
				{"smoky_makeup", "face"}};
		
		System.out.println(solution(clothes));
	}

	private static int solution(String[][] clothes) {
		name = new String[clothes.length];
		clothType = new HashMap<>();
		nameAndType = new HashMap<>();
		
		for (int i = 0; i < clothes.length; i++) {
			name[i] = clothes[i][0];
			nameAndType.put(name[i], clothes[i][1]);
			clothType.put(clothes[i][1], 0);
		}
		
		Arrays.sort(name);
		
		count = 0;
		for (int i = 1; i < name.length+1; i++) {
			arr = new String[i];
			visited = new boolean[name.length];
			dfs(0, 0, i);
		}
	
		return count;
	}
	
	private static void dfs(int start, int depth, int r) {
		if (depth == r) {
			clothType.replaceAll((key, value) -> 0);
			
			if (!checkCount()) return;
			
			count++;
			return;
		}
		
		for (int i = start; i < name.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = name[i];
				dfs(i+1, depth+1, r);
				visited[i] = false;
			}
		}
	}
	
	private static boolean checkCount() {
		for (String val : arr) {
			String type = nameAndType.get(val);
			clothType.put(type, clothType.get(type)+1);
			
			if (clothType.get(type) > 1) {
				return false;
			}
		}
		return true;
	}
}
