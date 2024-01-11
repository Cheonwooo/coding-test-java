package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 아이디어 : A+ ~ F까지 List에 저장 후 4.5부터 0.5씩 빼주면서 Map에 저장
 * 만약 P가 나오는 경우는 계산에서 제외한다.
 * (학점 * 과목평점) / 학점 총합
 * 
 * 시간복잡도 : 
 * 
 * 자료구조 : List, Map
 */

public class Ex25206 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> grade = List.of("A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F");
		Map<String, Double> gradeCard = new HashMap<String, Double>();
		double maxGrade = 4.5;
		
		for (int i = 0; i < grade.size(); i++) {
			if (i == grade.size()-1) {
				gradeCard.put(grade.get(i), 0.0);
				break;
			}
			gradeCard.put(grade.get(i), maxGrade);
			maxGrade -= 0.5;
		}
		
		double totalCredit = 0;
		double totalGrade = 0;
		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String subject = st.nextToken();
			double credit = Double.parseDouble(st.nextToken());
			String realGrade = st.nextToken();
			
			if(realGrade.equals("P")) {
				continue;
			}
			
			double score = gradeCard.get(realGrade);
			totalGrade += score * credit;
			totalCredit += credit;
		}
		
		System.out.println(totalGrade / totalCredit);
	}

}
