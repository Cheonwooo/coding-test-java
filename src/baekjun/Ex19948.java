package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex19948 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] contents = br.readLine().split("\\s+");
		int spaceCount = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[26];
		for (int i = 0; i < 26; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		if (spaceCount < contents.length - 1) {
			System.out.println(-1);
		} else {
			for (int i = 0; i < contents.length; i++) {
				char pre = ' ';
				for (int j = 0; j < contents[i].length(); j++) {
					char first = contents[i].charAt(j);
					if (first != pre) {//연속되는 같은 알파벳이 아니라면
						first = Character.toLowerCase(first);
						arr[first-'a']--;
					}
					
					if (arr[first-'a'] < 0) {
						System.out.println(-1);
						return;
					}
					pre = first;
				}
				if (arr[Character.toLowerCase(contents[i].charAt(0))-'a']-1 < 0) {
					System.out.println(-1);
					return;
				}
				arr[Character.toLowerCase(contents[i].charAt(0))-'a']--;
				sb.append(Character.toUpperCase(contents[i].charAt(0)));
			}
		}
		System.out.println(sb);
	}

}
