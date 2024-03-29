package programmers;

import java.util.Arrays;

/*
 * 아이디어
 * 투포인터로 해결하기
 * 주어진 몸무게를 오름차순으로 정렬
 * 2명의 몸무게 합 > 무게제한 이라면 큰 값은 혼자서 보트에 태우고 보내는 걸로 카운트
 * 2명의 몸무게 합 <= 무게제한 이라면 포인터 값 바꾸기
 * 두 포인터의 값이 같다면 카운트+1
 * 두 포인터 값이 교차되면 break
 */

public class Ex42885 {

	public static void main(String[] args) {
		int[] people = {10,20,30,40,50,60,70,100,110,120};
		int limit = 100;
		
		System.out.println(solution(people, limit));
	}
	
	public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        int count = 0;
        while (left <= right) {
        	if (left == right) {
        		count++;
        		break;
        	}
   
        	int sum = people[left] + people[right];
        	
        	if (sum > limit) {
        		count++;
        		right--;
        	} else {
        		count++;
        		left++;
        		right--;
        	}
        }
       
        return count;
    }
}
