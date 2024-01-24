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
 * ���̵�� : ť�� �̿�
 * 1~n���� ť�� �ֱ�
 * �Ǿ� ���� �ٽ� �ڷ� �����鼭 k��° ���� ����
 * 
 * �ð����⵵ : O(1)
 * 
 * �ڷᱸ�� : Queue, LinkedList 
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
