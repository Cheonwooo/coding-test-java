package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/*
 * 아이디어 : 큐를 이용
 * 1~n까지 큐에 넣기
 * 맨앞 수를 다시 뒤로 넣으면서 k번째 수는 빼기
 * 
 * 시간복잡도 : O(1)
 * 
 * 자료구조 : Queue, LinkedList 
 */

public class Ex1158 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		
		List<Integer> answer = new ArrayList<>();
		int count = 0;
		while (!q.isEmpty()) {
			count++;
			int firstNumber = q.poll();
			if (count == k) {
				answer.add(firstNumber);
				count = 0;
			} else {
				q.add(firstNumber);
			}
		}
		
		String arr = "<" + 
						answer.stream().
						map(String::valueOf).
						collect(Collectors.joining(", ")) + ">";
		
		System.out.println(arr);
	}

}
