package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex9017 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] rank = new int[n];
			int[] prize = new int[n];
			
			boolean[] isExacted = new boolean[201];
			int[] playerCount = new int[201];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			//각 팀별 인원수 세기
			for (int i = 0; i < n; i++) {
				rank[i] = Integer.parseInt(st.nextToken());
				playerCount[rank[i]]++;
			}
			
			//6명이 안되는 팀 체크
			for (int i = 0; i < 201; i++) {
				if (playerCount[i] != 6) {
					isExacted[i] = true;
				}
			}
			
			//6명이 안되는 팀이 속한 랭킹은 0점 처리
			List<Integer> teamNumber = new ArrayList<>();
			int score = 1;
			for (int i = 0; i < n; i++) {
				if (isExacted[rank[i]]) {
					prize[i] = 0;
				} else {
					if (!teamNumber.contains(rank[i])) {
						teamNumber.add(rank[i]);
					}
					prize[i] = score++;
				}
			}
			
			//점수 매기기
			Map<Integer, Integer> result = new HashMap<>();
			for (int i = 0; i < n; i++) {
				if (playerCount[rank[i]] == 2) continue;
				if (prize[i] != 0) {
					result.put(rank[i], result.getOrDefault(rank[i], 0) + prize[i]);
					playerCount[rank[i]]--;
				}
			}
			
			List<Integer> finalTeam = new ArrayList<>();
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < teamNumber.size(); i++) {
				if (min > result.get(teamNumber.get(i))) {
					min = result.get(teamNumber.get(i));
					finalTeam.removeAll(finalTeam);
					finalTeam.add(teamNumber.get(i));
				} else if (min == result.get(teamNumber.get(i))) {
					finalTeam.add(teamNumber.get(i));
				}
//				System.out.println("Team : " + teamNumber.get(i) + ", Score : " + result.get(teamNumber.get(i)));
			}
			
			if (finalTeam.size() > 1) {
				playerCount = new int[201];
				boolean isFinished = false;
				for (int i = 0; i < n; i++) {
					playerCount[rank[i]]++;
					for (int j = 0; j < finalTeam.size(); j++) {
						if (playerCount[finalTeam.get(j)] == 5) {
							System.out.println(finalTeam.get(j));
							isFinished = true;
						}
					}
					if (isFinished) break;
				}
			} else {
				System.out.println(finalTeam.get(0));
			}
//			System.out.println(finalTeam);
//			System.out.println(Arrays.toString(prize));
		}
	}

}
