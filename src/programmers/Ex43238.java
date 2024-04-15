package programmers;

import java.util.Arrays;

public class Ex43238 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = 0; 
        long right = times[times.length-1]*(long)n;
        
        while (left < right) {
        	long mid = (left + right) / 2;
        	
        	long sum = 0;
        	for (int i = 0; i < times.length; i++) {
        		sum += mid/times[i];
        	}
        	
        	if (sum >= n) {
        		right = mid - 1;
        		answer = mid;
        	} else if (sum < n) {
        		left = mid + 1;
        	}
        }
        
        return answer;
    }

}
