package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex7490 {

	private static int n;
	private static int[] arr, temp;
	private static Deque<String> dq = new ArrayDeque<>();
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = i+1;
			}
			temp = new int[n-1];
			
			comb(0);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void comb(int depth) {
		if (depth == temp.length) {
			makeForm();
			calculateForm();
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			temp[depth] = i;
			comb(depth+1);
		}
	}
	
	private static void makeForm() {
		int index = n + n - 1;
		int arrIdx = 0;
		int tempIdx = 0;
		while (index-- > 0) {
			if (index % 2 == 0) {//수 넣기
				if (dq.isEmpty()) {
					dq.add(String.valueOf(arr[arrIdx]));
					arrIdx++;
					continue;
				}
				if (dq.peekLast().equals(" ")) {
					dq.pollLast();
					String peek = dq.pollLast();
					peek += String.valueOf(arr[arrIdx]);
					dq.add(peek);
				} else {
					dq.add(String.valueOf(arr[arrIdx]));
				}
				arrIdx++;
			} else {//수식 넣기
				if (temp[tempIdx] == 0) {
					dq.add(" ");
				} else if (temp[tempIdx] == 1) {
					dq.add("+");
				} else {
					dq.add("-");
				}
				tempIdx++;
			}
		}
	}
	
	private static void calculateForm() {
		String next = dq.pollFirst();
		int sum = Integer.parseInt(next);
		while (!dq.isEmpty()) {
			next = dq.pollFirst();
			if (next.equals("+")) {
				String num = dq.pollFirst();
				sum += Integer.parseInt(num);
			} else if (next.equals("-")) {
				String num = dq.pollFirst();
				sum -= Integer.parseInt(num);
			}
		}
		
		if (sum == 0) {
			String form = transForm();
			sb.append(form + "\n");
		}
	}
	
	private static String transForm() {
		int index = n + n - 1;
		int arrIdx = 0;
		int tempIdx = 0;
		String form = "";
		while (index-- > 0) {
			if (index % 2 == 0) {
				form += String.valueOf(arr[arrIdx++]);
			} else {
				if (temp[tempIdx] == 0) {
					form += " ";
				} else if (temp[tempIdx] == 1) {
					form += "+";
				} else {
					form += "-";
				}
				tempIdx++;
			}
		}
		
		return form;
	}
}
