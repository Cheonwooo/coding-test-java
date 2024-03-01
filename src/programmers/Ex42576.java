package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 아이디어
 * HashMap 사용
 * 각 이름마다 Map<String, Integer> 저장
 * 참가자 이름 입력시 value+1, 완주자 입력시 value-1
 * Map을 순환하면서 value값이 1인 Key값 찾기
 * 
 * 시간복잡도
 * 100000 + 99999
 * 
 * 자료구조
 * 마라톤 선수와 수를 저장할 Map
 */

public class Ex42576 {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		System.out.println(solution(participant, completion));
	}
	
	private static String solution(String[] participant, String[] completion) {
		String loser = "";
		Map<String, Integer> participants = new HashMap<>();
		
		for (int i = 0; i < participant.length; i++) {
			participants.put(participant[i], participants.getOrDefault(participant[i], 0)+1);
		}
		
		for (int i = 0; i < completion.length; i++) {
			participants.put(completion[i], participants.get(completion[i])-1);
		}
		
		for (Entry<String, Integer> entry : participants.entrySet()) {
			String runner = entry.getKey();
			if (participants.get(runner) == 1) {
				loser = runner;
			}
		}
		return loser;
	}

}
