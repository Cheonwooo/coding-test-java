package programmers;

/*
 * 아이디어
 * 순열을 이용해서 모든 경우의 수를 구하기
 */

public class Ex87946 {
	private static int length, max;
	private static int[] arr;
	private static boolean[] visited;
	

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80,20}, {50,40}, {30,10}};
		
		System.out.println(solution(k, dungeons));
	}

	public static int solution(int k, int[][] dungeons) {
		length = dungeons.length;
		arr = new int[length];
		visited = new boolean[length];
		
		max = Integer.MIN_VALUE;
		comb(k, dungeons, 0);
		
		return max;
	}
	
	public static void comb(int k, int[][] dungeons, int depth) {
		if (depth == length) {
			int fatigue = calculateFatigue(k, dungeons, arr);
			max = Math.max(fatigue, max);
			return;
		}
		
		for (int i = 0; i < length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				comb(k, dungeons, depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static int calculateFatigue(int k, int[][] dungeons, int[] arr) {
		int adventure = 0;
		for (int val : arr) {
			if (k < dungeons[val][0]) {
				break;
			}
			k -= dungeons[val][1];
			adventure++;
		}
		return adventure;
	}
}
