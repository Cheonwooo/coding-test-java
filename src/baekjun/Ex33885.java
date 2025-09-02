package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex33885 {
	
	private static int n, m;
	private static boolean isAnswer = false;;
	private static int[] temp;
	private static String[] input;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new String[n];
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			input[i] = br.readLine();
		}
		
		for (int i = 1; i <= n; i++) {
			temp = new int[i];
			check(0, 0, i);
			if (isAnswer) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}
	
	private static void check(int depth, int start, int r) {
		if (depth == r) {
			if (makeSchedule()) {
				isAnswer = true;
			}
			return;
		}
		
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				temp[depth] = i;
				visited[i] = true;
				check(depth+1, i, r);
				visited[i] = false;
			}
			
		}
	}
	
	private static boolean makeSchedule() {
		Set<String> schedule = new HashSet<>();
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
			String[] arr = input[temp[i]].split(" ");
			
			int credit = Integer.parseInt(arr[0]);
			int count = Integer.parseInt(arr[1]);
			int index = 2;
			for (int j = 0; j < count; j++,index+=2) {
				String time = arr[index] + arr[index+1];
				
				if (schedule.contains(time)) {
					return false;
				}
				
				schedule.add(time);
			}
			sum += credit;
		}
		if (sum >= m) {
			return true;
		}
		return false;
	}
}
