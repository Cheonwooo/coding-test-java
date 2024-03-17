package programmers;

import java.util.Arrays;
import java.util.Comparator;

/*
 * ���̵��
 * ����/���� �� ���� ū �� ã�� - 1��
 * ��� ���� ��ȸ�ϸ鼭 ���� ���鸸 max������ �����ϱ� - 2��
 * 
 * 1��*2���� ����
 */

public class Ex86491 {

	public static void main(String[] args) {
//		int[][] sizes = {{60,50}, {30,70}, {60,30}, {80,40}};
		int[][] sizes = {{10,7}, {12,3}, {8,15}, {14,7}, {5,15}};
//		int[][] sizes = {{14,4}, {19,6}, {6,16}, {18,7}, {7,11}};
		
		System.out.println(solution(sizes));
	}
	
	public static int solution(int[][] sizes) {
		int firstMax = Integer.MIN_VALUE;
		
		Arrays.sort(sizes, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		
		firstMax = Math.max(firstMax, sizes[0][0]);
		
		Arrays.sort(sizes, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		
		firstMax = Math.max(firstMax, sizes[0][1]);
		
		int secondMax = Integer.MIN_VALUE;
		for (int i = 0; i < sizes.length; i++) {
			int width = sizes[i][0];
			int length = sizes[i][1];
			
			int min = Math.min(width, length);
			secondMax = Math.max(secondMax, min);
		}
		
		return firstMax * secondMax;
	}

}
