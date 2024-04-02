package programmers;

/*
 * 아이디어
 * [i][0] = [i-1][0]
 * [i][i] = [i-1][i-1]
 * [i][j] = Math.max(+[i-1][j], +[i-1][j-1])
 */

public class Ex43105 {

	public static void main(String[] args) {
		
	}

	public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] d = new int[triangle.length][triangle.length];
        
        d[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
        	for (int j = 0; j <= i; j++) {
        		if (j == 0) {
        			d[i][0] = triangle[i][0] + d[i-1][0];
        		} else if (i == j) {
        			d[i][j] = triangle[i][j] + d[i-1][j-1];
        		} else {
        			int max = Math.max(d[i-1][j-1], d[i-1][j]);
        			d[i][j] = triangle[i][j] + max;
        		}
        	}
        }
        
        for (int i = 0; i < triangle.length; i++) {
        	answer = Math.max(answer, d[triangle.length-1][i]);
        }
        
        return answer;
    }
}
