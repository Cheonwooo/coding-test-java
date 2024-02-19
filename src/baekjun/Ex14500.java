package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵��
 * 5���� ��Ʈ�ι̳븦 �迭�� ����
 * 90�� ȸ�� ��Ų �� 0,0���� n,m���� �� ���ϱ� 
 * ������ �� �������� 90�� ȸ�� ��Ų �� �� ���ϱ�
 * ��Ī�� �� �� ���� �Ȱ��� �ݺ�
 * 
 * �ð����⵵
 * n * m * 2 * 4 * 5
 * 
 * �ڷᱸ��
 * ��Ʈ�ι̳��� ��ǥ�� ������ int[][]
 * �Է°��� ������ int[][]
 * ���Ⱚ�� ������ int[] 2��
 * 
 */

public class Ex14500 {
	private static int n, m;
	prviate static int[][] arr;
	private static int[][][] tetromino = {
			{{0,0}, {0,1}, {0,2}, {0,3}},
			{{0,0}, {0,1}, {1,0}, {1,1}},
			{{0,0}, {1,0}, {2,0}, {2,1}},
			{{0,0}, {1,0}, {1,1}, {2,1}},
			{{0,0}, {0,1}, {0,2}, {1,1}}
	};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
	
	private static void moveTetro() {
		int max = 0;
		for (int i = 0; i < tetromino.length; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					int sum = calculateSum(i, j, k);
					max = Math.max(sum, max);
				}
			}
		}
	}
	
	private static int calculateSum(int seq, int x, int y) {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + tetromino[seq][i][0];
			int ny = y + tetromino[seq][i][1];
			
			sum += arr[nx][ny];
		} 
		return sum;
	}
}
