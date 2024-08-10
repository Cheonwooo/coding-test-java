package swBtype.pro1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserSolution {
	private class HeroInfo {
		int x;
		int y;
		int mapNumber;

		public HeroInfo(int x, int y, int mapNumber) {
			this.x = x;
			this.y = y;
			this.mapNumber = mapNumber;
		}
	}
	
	private int[] unionCount;
	private int[][] soldiers, unionMap;
	private String[][] names;
	private Map<String, HeroInfo> code = new HashMap<>();
	private Map<Integer, List<Integer>> enemy = new HashMap<>();
	
	void init(int N, int mSoldier[][], char mMonarch[][][]) {
		unionCount = new int[626];
		soldiers = new int[N][N];
		unionMap = new int[N][N];
		names = new String[N][N];
		int index = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				unionMap[i][j] = index;
				unionCount[index]++;
				soldiers[i][j] = mSoldier[i][j];
				
				String name = getName(mMonarch[i][j]);
				
				names[i][j] = name;
				code.put(name, new HeroInfo(i, j, index));
				enemy.put(index++, Collections.emptyList());
			}
		}
		
	}

	void destroy() {

	}

	int ally(char mMonarchA[], char mMonarchB[]) {
		String nameA = getName(mMonarchA);
		String nameB = getName(mMonarchB);

		HeroInfo hero1 = code.get(nameA);
		HeroInfo hero2 = code.get(nameB);
		
		int mapNumberA = hero1.mapNumber;
		int mapNumberB = hero2.mapNumber;

		if (mapNumberA == mapNumberB) return -1;
		
		List<Integer> enemiesA = enemy.get(mapNumberA);
//		for (int val : enemiesA) {
//			System.out.print(val + " ");
//		}
//		System.out.println("==========");
		if (enemiesA != null && enemiesA.contains(mapNumberB)) return -2;
		
		unionHero(hero1, hero2);
		return 1;
	}
	
	private void unionHero(HeroInfo hero1, HeroInfo hero2) {
		int mapNumberA = unionMap[hero1.x][hero1.y];
		int mapNumberB = unionMap[hero2.x][hero2.y];
		
		int countA = unionCount[mapNumberA];
		int countB = unionCount[mapNumberB];
		
		if (countA > countB) {
			//b가 a에 합병
			//b를 enemy로 가지고 있던 mapNumber들을 다 바꿔줘야함
			for (int i = 0; i < unionMap.length; i++) {
				for (int j = 0; j < unionMap.length; j++) {
					if (unionMap[i][j] == mapNumberB) {
						unionMap[i][j] = mapNumberA;
						code.put(names[i][j], new HeroInfo(i, j, mapNumberA));
						unionCount[mapNumberA]++;
						unionCount[mapNumberB]--;
					}
				}
			}
		} else { //a가 b에 합병
			for (int i = 0; i < unionMap.length; i++) {
				for (int j = 0; j < unionMap.length; j++) {
					if (unionMap[i][j] == mapNumberA) {
						unionMap[i][j] = mapNumberB;
						code.put(names[i][j], new HeroInfo(i, j, mapNumberB));
						unionCount[mapNumberA]--;
						unionCount[mapNumberB]++;
					}
				}
			}
			unionMap[hero1.x][hero1.y]= mapNumberB;
			hero1.mapNumber = mapNumberB;
			unionCount[mapNumberA]--;
			unionCount[mapNumberB]++;
		}
	}

	int attack(char mMonarchA[], char mMonarchB[], char mGeneral[]) {
		String nameA = getName(mMonarchA);
		String nameB = getName(mMonarchB);
		String nameG = getName(mGeneral);
		
		HeroInfo hero1 = code.get(nameA);
		HeroInfo hero2 = code.get(nameB);
		if (hero1.mapNumber == hero2.mapNumber) return -1;
		else {
			int x = hero2.x;
			int y = hero2.y;
			int attack = 0;
			int shield = soldiers[x][y];

			int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
			int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
			
			boolean check = false;
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= soldiers.length || ny < 0 || ny >= soldiers.length) continue;
				
				if (unionMap[nx][ny] == hero1.mapNumber) {
					check = true;
					break;
				}
			}
			
			if (check) {
				for (int i = 0; i < 8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (nx < 0 || nx >= soldiers.length || ny < 0 || ny >= soldiers.length) continue;
					int soldierNumber = 0;
					if (soldiers[nx][ny] != 0) {
						soldierNumber = soldiers[nx][ny]/2;
					}
					
					if (unionMap[nx][ny] == hero1.mapNumber) {
						attack += soldierNumber;
						soldiers[nx][ny] -= soldierNumber;
					}
					
					if (unionMap[x][y] == unionMap[nx][ny]) {
						shield += soldierNumber;
						soldiers[nx][ny] -= soldierNumber;
					}
				}
				
				int remain = attack - shield;
				if (remain > 0) {
					code.put(nameG, new HeroInfo(x, y, hero1.mapNumber));
					names[x][y] = nameG;
					soldiers[x][y] = remain;
					unionMap[x][y] = hero1.mapNumber;
					
					List<Integer> enemiesA = new ArrayList<>(enemy.get(hero1.mapNumber));
					List<Integer> enemiesB = new ArrayList<>(enemy.get(hero2.mapNumber));
					
					//중간에 unionMap이 합병되는 경우가 있음
					enemiesA.add(hero2.mapNumber);
					enemiesB.add(hero1.mapNumber);
					
					enemy.put(hero1.mapNumber, enemiesA);
					enemy.put(hero2.mapNumber, enemiesB);
					
//					for (int i = 0; i < 4; i++) {
//						for (int j = 0; j < 4; j++) {
//							System.out.print(unionMap[i][j] + " ");
//						}
//						System.out.println();
//					}
					return 1;
				} else {
					List<Integer> enemiesA = new ArrayList<>(enemy.get(hero1.mapNumber));
					List<Integer> enemiesB = new ArrayList<>(enemy.get(hero2.mapNumber));
					
					enemiesA.add(hero2.mapNumber);
					enemiesB.add(hero1.mapNumber);
					
					enemy.put(hero1.mapNumber, enemiesA);
					enemy.put(hero2.mapNumber, enemiesB);
					
					if (remain != 0) {
						soldiers[x][y] = remain*(-1);
					}
				
					return 0;
				}
			}
			else return -2;
		}
	}

	int recruit(char mMonarch[], int mNum, int mOption) {
		String name = getName(mMonarch);
		HeroInfo hero = code.get(name);
		
		if (mOption == 0) {
			soldiers[hero.x][hero.y] += mNum;
			return soldiers[hero.x][hero.y];
		} else {
			int sum = 0;
			for (int i = 0; i < unionMap.length; i++) {
				for (int j = 0; j < unionMap[0].length; j++) {
					if (unionMap[i][j] == hero.mapNumber) {
						soldiers[i][j] += mNum;
//						System.out.println(names[i][j] + " " + soldiers[i][j]);
						sum += soldiers[i][j];
					}
				}
			}
			return sum;
		}
	}
	
	private String getName(char[] name) {
		String returnName = "";
		for (int i = 0; i < name.length; i++) {
			if (name[i] == '\0') break;
			returnName += String.valueOf(name[i]);
		}
		return returnName;
	}
}