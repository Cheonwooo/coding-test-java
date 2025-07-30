package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex33835 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] home = new int[n+1][2];
        double[] dist = new double[n+1];
        for (int i = 1; i < n+1; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	home[i][0] = Integer.parseInt(st.nextToken());
        	home[i][1] = Integer.parseInt(st.nextToken());
        }
        
    	for (int i = 2; i < n+1; i++) {
    		double dis = dist(home[i][0], home[i][1], home[i-1][0], home[i-1][1]);
    		dist[i] = dist[i-1] + dis;
    	}
        
        double min = dist[n];
        int start = 2;
        while (true) {
        	if (start == n+1) break;
        	
        	double dis = dist(home[1][0], home[1][1], home[start][0], home[start][1]);
        	if (dis <= dist[start]) {//부순 도로의 값으로 새로운 도로 생성
        		min = Math.min(dist[n] - dist[start] + dis, min);
        	}
        	start++;
        }
        System.out.printf("%.10f\n", min);
    }
    
    private static double dist(int x1, int y1, int x2, int y2) {
    	return Math.hypot(x1 - x2, y1 - y2);
    }
}
