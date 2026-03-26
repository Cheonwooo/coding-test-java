package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex2313 {
	
	private static class Jewel implements Comparable<Jewel> {
		int pre;
		int next;
		int sum;

		public Jewel(int pre, int next, int sum) {
			this.pre = pre;
			this.next = next;
			this.sum = sum;
		}
		
		public int compareTo(Jewel o) {
			if (this.sum == o.sum) {
				if ((this.next - this.pre) == (o.next - o.pre)) {
					if (this.pre == o.pre) {
						return this.next - o.next;
					}
					return this.pre - o.pre;
				}
				return (this.next - this.pre) - (o.next - o.pre);
			}
			return o.sum - this.sum;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		PriorityQueue<Jewel> jewels;
		for (int i = 0; i < n; i++) {
			jewels = new PriorityQueue<>();
			int l = Integer.parseInt(br.readLine());
			int[] arr = new int[l+1];
			int[] dp = new int[l+1];
			int[] sum = new int[l+1];
			
			Arrays.fill(dp, -10_000_001);
			Arrays.fill(sum, -10_000_001);
			
			int left = 1;
			int right = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < l+1; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
//				sum[j] = Math.max(sum[j-1] + arr[j], arr[j]);
				if (sum[j-1] + arr[j] <= arr[j]) {
					sum[j] = arr[j];
					left = j;
					right = j;
				} else {
					sum[j] = sum[j-1] + arr[j];
					right = j;
				}
				jewels.offer(new Jewel(left, right, sum[j]));
			}
			Jewel jewel = jewels.poll();
			answer += jewel.sum;
			sb.append(jewel.pre + " " + jewel.next + "\n");
		}
		System.out.println(answer);
		System.out.println(sb);
	}

}
