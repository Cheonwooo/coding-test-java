package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex27111 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[200_001];
		Set<Integer> list = new HashSet<>();
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int opt = Integer.parseInt(st.nextToken());
			list.add(num);
			if (opt == 1) {//들어가기
				if (check[num]) {//이미 들어가있는데 나온 기록이 없다면
					answer++;
				} else {
					check[num] = true;
				}
			} else {//나오기
				if (!check[num]) {//나온 기록이 없는데 나왔다고 기록되어있다면
					answer++;
				} else {
					check[num] = false;
				}
				
			}
		}
		for (int num : list) {
			if (check[num]) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
