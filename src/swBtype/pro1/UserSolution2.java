package swBtype.pro1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserSolution2 {
	
	private class Monarch {
		int x;
		int y;
		int allianceNumber;
		
		public Monarch(int x, int y, int allianceNumber) {
			this.x = x;
			this.y = y;
			this.allianceNumber = allianceNumber;
		}
	}
	
	private int[][] soldiers, allianceNumbers;
	private String[][] monarchNames;
	private Map<Integer, List<String>> enemy, alliance;
	private Map<String, Monarch> monarches;
	
	void init(int N, int mSoldier[][], char mMonarch[][][]) {
		soldiers = new int[N][N];
		allianceNumbers = new int[N][N];
		monarchNames = new String[N][N];
		
		enemy = new HashMap<>();
		alliance = new HashMap<>();
		monarches = new HashMap<>();
		
		int number = 0;
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < N; j++) {
				soldiers[i][j] = mSoldier[i][j];
				allianceNumbers[i][j] = number;
				String name = getName(mMonarch[i][j]);
				monarchNames[i][j] = name;
				
				monarches.put(name, new Monarch(i, j, number));
				enemy.put(number, new ArrayList<>());
				alliance.put(number++, new ArrayList<>(Arrays.asList(name)));
			}
		}
	}

	void destroy() {

	}

	int ally(char mMonarchA[], char mMonarchB[]) {
		String nameA = getName(mMonarchA);
		String nameB = getName(mMonarchB);
		
		Monarch monarchA = monarches.get(nameA);
		Monarch monarchB = monarches.get(nameB);

		if (allianceNumbers[monarchA.x][monarchA.y] == allianceNumbers[monarchB.x][monarchB.y]) return -1;
		
		List<String> alliancesA = alliance.get(monarchA.allianceNumber);
		List<String> alliancesB = alliance.get(monarchB.allianceNumber);
		List<String> enemiesA = enemy.get(monarchA.allianceNumber);
		List<String> enemiesB = enemy.get(monarchB.allianceNumber);
		
		if (alliancesA != null) {
			for (String name : alliancesA) {
				if (enemiesB.contains(name)) return -2;
			}
		}
		
		if (alliancesB != null) {
			for (String name : alliancesB) {
				if (enemiesA.contains(name)) return -2;
			}
		}
		for (String name : alliancesB) {
			if (monarches.get(name).allianceNumber != -1) {
				makeAlliance(monarchA, alliancesA, name);
			}
		}
		
		enemiesA.addAll(enemiesB);
		enemy.put(monarchB.allianceNumber, enemiesA);
		for (int k : enemy.keySet()) {
			if (enemy.get(k).contains(monarchB.allianceNumber)) {
				List<String> list = enemy.get(k);
				list.add(nameA);
				list.remove(nameB);
			}
		}
		return 1;
	}

	private void makeAlliance(Monarch monarchA, List<String> alliancesA, String name) {
		Monarch m = monarches.get(name);
		allianceNumbers[m.x][m.y] = allianceNumbers[monarchA.x][monarchA.y];  
		alliancesA.add(name);
		alliance.put(monarchA.allianceNumber, alliancesA);
		monarches.put(name, new Monarch(m.x, m.y, allianceNumbers[m.x][m.y]));
	}

	int attack(char mMonarchA[], char mMonarchB[], char mGeneral[]) {
		String nameA = getName(mMonarchA);
		String nameB = getName(mMonarchB);
		String nameG = getName(mGeneral);
		
		Monarch monarchA = monarches.get(nameA);
		Monarch monarchB = monarches.get(nameB);
		
		if (allianceNumbers[monarchA.x][monarchA.y] == allianceNumbers[monarchB.x][monarchB.y]) return -1;
		
		List<String> enemiesB = enemy.get(monarchB.allianceNumber);
		List<String> enemiesA = enemy.get(monarchA.allianceNumber);
		
		int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
		
		int mBx = monarchB.x;
		int mBy = monarchB.y;
		int attackSoldiers = -1;
		int shieldSoldiers = soldiers[mBx][mBy];

		//공격하지 않는 경우 바로 다음에 나오는 for문에서 방어하는 팀의 병사 수 감소를 방지하기 위한 tempSoldiers
		int[][] tempSoldiers = new int[soldiers.length][soldiers.length];
		for (int i = 0; i < soldiers.length; i++) {
			System.arraycopy(soldiers[i], 0, tempSoldiers[i], 0, soldiers[0].length);
		}
		
		for (int i = 0; i < 8; i++) {
			int nx = mBx + dx[i];
			int ny = mBy + dy[i];
			
			if (nx < 0 || nx >= monarchNames.length || ny < 0 || ny >= monarchNames.length) continue;
			
			if (monarchA.allianceNumber == allianceNumbers[nx][ny]) { //적대 관계라면
				if (attackSoldiers == -1) attackSoldiers = 0;
				
				int addAttackSoldiers = tempSoldiers[nx][ny] / 2;
				attackSoldiers += addAttackSoldiers;
				tempSoldiers[nx][ny] -= addAttackSoldiers;
			} else if (monarchB.allianceNumber == allianceNumbers[nx][ny]) { //동맹 관계라면
				int addShieldSoldiers = tempSoldiers[nx][ny] / 2;
				shieldSoldiers += addShieldSoldiers;
				tempSoldiers[nx][ny] -= addShieldSoldiers;
			}
		}
		
		if (attackSoldiers == -1) return -2;
		else {
			for (int i = 0; i < soldiers.length; i++) {
				System.arraycopy(tempSoldiers[i], 0, soldiers[i], 0, soldiers[0].length);
			}
			
			enemiesA.add(nameB);
			enemiesB.add(nameA);
			enemy.put(monarchA.allianceNumber, enemiesA);
			enemy.put(monarchB.allianceNumber, enemiesB);
			
			int remainSoldiers = attackSoldiers - shieldSoldiers;
			if (remainSoldiers > 0) { //공격 성공
				soldiers[monarchB.x][monarchB.y] = remainSoldiers;
				
				List<String> alliancesA = alliance.get(monarchA.allianceNumber);
				alliancesA.add(nameG);
				alliance.put(monarchA.allianceNumber, alliancesA);
				allianceNumbers[monarchB.x][monarchB.y]= monarchA.allianceNumber;
				
				monarches.put(nameG, new Monarch(mBx, mBy, monarchA.allianceNumber));
				monarches.put(nameB, new Monarch(mBx, mBy, -1));
				return 1;
			} else { // 방어 성공
				soldiers[mBx][mBy] = remainSoldiers*(-1);
				return 0;
			}
		}
	}
	
	int[][] copySoldiers() {
		int[][] temp = new int[soldiers.length][soldiers.length];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				temp[i][j] = soldiers[i][j];
			}
		}
		return temp;
	}

	int recruit(char mMonarch[], int mNum, int mOption) {
		String nameM = getName(mMonarch);
		Monarch m = monarches.get(nameM);
		if (mOption == 0) {
			soldiers[m.x][m.y] += mNum;
			return soldiers[m.x][m.y];
		} else {
			int sum = 0;
			List<String> alliances = alliance.get(m.allianceNumber);
			
			for (String name : alliances) {
				Monarch tempM = monarches.get(name);
				if (tempM.allianceNumber == -1) continue;
				
				soldiers[tempM.x][tempM.y] += mNum;
				sum += soldiers[tempM.x][tempM.y];
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