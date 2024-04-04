package programmers;

public class Ex43165 {
	private static int count;
	private static int[] operation = {0, 1}, arr;
	

	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		
		System.out.println(solution(numbers, target));
	}
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        
        arr = new int[numbers.length];
        count = 0;
        comb(numbers, target, 0, numbers.length);
        answer = count;
        
        return answer;
    }
	
	public static void comb(int[] numbers, int target, int depth, int r) {
		if (depth == r) {
			int sum = calculateSum(numbers, arr);
			
			if (sum == target) count++;
			return;
		}
		
		for (int i = 0; i < operation.length; i++) {
			arr[depth] = operation[i];
			comb(numbers, target, depth+1, r);
		}
	}
	
	public static int calculateSum(int[] numbers, int[] arr) {
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				if (arr[i] == 0) {
					sum = numbers[i] * (-1);
				} else {
					sum = numbers[i];
				}
			} else {
				if (arr[i] == 0) {
					sum -= numbers[i];
				} else {
					sum += numbers[i];
				}
			}
			
		}
		
		return sum;
	}

}
