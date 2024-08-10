package swBtype.pro2;

import java.util.Iterator;
import java.util.TreeSet;

public class UserSolution {
	private class Player implements Comparable<Player> {
		int id;
		int ability;

		public Player(int id, int ability) {
			this.id = id;
			this.ability = ability;
		}

		@Override
		public int compareTo(Player o) {
			if (this.ability == o.ability) {
				return this.id - o.id;
			}
			return o.ability - this.ability;
		}
	}

	private int totalLeagueSize = 0;
	private int subLeagueSize = 0;
	private TreeSet<Player>[] set;

	void init(int N, int L, int mAbility[]) {
		set = new TreeSet[L];
		totalLeagueSize = L;
		subLeagueSize = N / L;
		
		setLeague(N, L, mAbility);
	}
	
	private void setLeague(int N, int L, int[] mAbility) {
		for (int i = 0; i < L; i++) {
			set[i] = new TreeSet<>();
			for (int j = (N / L) * i; j < (N / L) * (i + 1); j++) {
				set[i].add(new Player(j, mAbility[j]));
			}
		}

//		for (int i = 0; i < L; i++) {
//			for (Player player : set[i]) {
//				System.out.println(i + " " + player.id + " " + player.ability);
//			}
//		}
	}

	int move() {
		int sum = 0;
		for (int i = 1; i < totalLeagueSize; i++) {
			
			Player bestPlayer = set[i].pollFirst();//i번 리그의 제일 잘하는 선수
			Player worstPlayer = set[i-1].pollLast();//i-1번 리그의 제일 못하는 선수
			
//			System.out.println(bestPlayer.id + " " + worstPlayer.id);
			sum += bestPlayer.id + worstPlayer.id;
			
//			rank.put(bestPlayerSeq, worstPlayer);
//			rank.put(worstPlayerSeq, bestPlayer);
			
			set[i-1].add(bestPlayer);
//			set[i-1].remove(worstPlayer);
			set[i].add(worstPlayer);
//			set[i].remove(bestPlayer);
		}
		System.out.println("move==============");
		for (int i = 0; i < set.length; i++) {
			for (Player player : set[i]) {
				System.out.println(player.id + " " + player.ability + " " + i);
			}
		}
		System.out.println("move==============");
		
		return sum;
	}

	int trade() {
		int sum = 0;
		for (int i = 1; i < totalLeagueSize; i++) {
		
//			int bestPlayerSeq = subLeagueSize*i;
//			int middlePlayerSeq = firstMidNum + subLeagueSize*(i-1);
			
			//중간에 있는 선수 어떻게 고름?
			Player bestPlayer = set[i].pollFirst();//i번 리그의 제일 잘하는 선수
			
			Player middlePlayer = null;//i-1번 리그의 중간 선수
			Iterator<Player> iterator = set[i-1].iterator();
			
			int index = 0;
			while (index <= subLeagueSize/2) {
				index++;
				middlePlayer = iterator.next();
			}
			
			sum += bestPlayer.id + middlePlayer.id;
			
//			rank.put(bestPlayerSeq, worstPlayer);
//			rank.put(worstPlayerSeq, bestPlayer);
			
			set[i-1].add(bestPlayer);
			set[i-1].remove(middlePlayer);
			set[i].add(middlePlayer);
//			set[i].remove(bestPlayer);
		}
		
		System.out.println("change==============");
		for (int i = 0; i < set.length; i++) {
			for (Player player : set[i]) {
				System.out.println(player.id + " " + player.ability + " " + i);
			}
		}
		System.out.println("change==============");
		return sum;
	}

}