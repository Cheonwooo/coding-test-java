package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex1493 {
	private static long max = 0;
	private static long[] arr, answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		arr = new long[20];
		answer = new long[20];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			arr[index] = value;
		}
		
		dfs(a, b, c);
//		System.out.println(Arrays.toString(answer));
		calculateAnswer();
		System.out.println(answer[0] > arr[0] ? -1 : max + answer[0]);
	}
	public static void dfs(int a, int b, int c) {
		if ((a == 0) || (b == 0) || (c == 0)) return;
		
		int min = findMin(a, b, c);
		int index = findNearNum(min);
		int nearNum = (int)Math.pow(2, index);
		
//		if ((a == 1) || (b == 1) || (c == 1)) {
//			answer[0] += a * b * c;
//			return;
//		}
		if ((a >= nearNum && b >= nearNum && c >= nearNum)) {
			answer[index] += (long)(a / nearNum) * (long)(b / nearNum) * (long)(c / nearNum);//가능한 많이 사용하기
			
		} 
		
		
//		dfs(nearNum, nearNum, nearNum);//정답으로 들어가는 정육면체
		//앞쪽
		dfs(a % nearNum, b - (b % nearNum), c - (c % nearNum));
		dfs(a % nearNum, b - (b % nearNum), c % nearNum);
		dfs(a - (a % nearNum), b - (b % nearNum), c % nearNum);
		//뒤쪽
		dfs(a - (a % nearNum), b % nearNum, c - (c % nearNum));
		dfs(a - (a % nearNum), b % nearNum, c % nearNum);
		dfs(a % nearNum, b % nearNum, c - (c % nearNum));
		dfs(a % nearNum, b % nearNum, c % nearNum);
		
//		List<Integer>[] list = new List[3];
//		for (int i = 0; i < 3; i++) {
//			list[i] = new ArrayList<>();
//		}
//		
//		int[] now = new int[] {a, b, c};
//		for (int i = 0; i < 3; i++) {
//			if ((now[i] - nearNum == 0)) {//2^n으로 나누어 떨어진다면
//				list[i].add(now[i]);
//			} else {
//				list[i].add(nearNum);
//				list[i].add(now[i] - nearNum);
//			}
//		}
//		
//		for (int i = 0; i < list[0].size(); i++) {
//			for (int j = 0; j < list[1].size(); j++) {
//				for (int k = 0; k < list[2].size(); k++) {
//					int ca = list[0].get(i);
//					int cb = list[1].get(j);
//					int cc = list[2].get(k);
//					
//					dfs(ca, cb, cc);
//				}
//			}
//		}
	}
	
	public static void calculateAnswer() {
		for (int i = 19; i > 0; i--) {
			if (answer[i] > arr[i]) {//가지고 있는 큐브의 수보다 많다면 다음 큐브로 *8해서 넘기기
				max += arr[i];
				answer[i] -= arr[i];
				answer[i-1] += answer[i]* 8;
			} else {
				max += answer[i];
			}
		}
	}

	
	public static int findMin(int na ,int nb ,int nc) {
		return (int)Math.min((int)Math.min(na, nb), nc);
	}
	
	public static int findNearNum(int min) {
		int number = 0;
		for (int i = 19; i > 0; i--) {
			if ((int)Math.pow(2, i) <= min) {
				number = i;
				break;
			}
		}
		return number;
	}
}
