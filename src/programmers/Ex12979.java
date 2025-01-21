package programmers;

public class Ex12979 {

	public static void main(String[] args) {
		int n = 13;
		int[] arr = {3, 7, 11};
		int w = 1;
		
		System.out.println(solution(n, arr, w));
	}
	
	public static  int solution(int n, int[] stations, int w) {
        int answer = 0;

        int mod = 2 * w + 1;
        int start = 1;
        for (int i = 0; i < stations.length; i++) {
        	int left = stations[i]-w;
        	if (left > start) {
        		answer += (left - start) / mod;
        		if ((left - start) % mod != 0) answer += 1;
        	}
        	start = stations[i] + (w+1);
        }
        
        if (start <= n) {
        	answer += (n-start+1) / mod;
    		if ((n-start+1) % mod != 0) answer += 1;
        }
        
        return answer;
    }

}


