package swBtype.pro4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserSolution2 {
	private int height, width, cursorIndex;
	private List<Character> sentence;
	private Map<Integer, int[]> alphabetCountOfIndex;

	void init(int H, int W, char mStr[]) {
		sentence = new ArrayList<>();
		alphabetCountOfIndex = new HashMap<>();
		
		height = H;
		width = W;
		cursorIndex = 0;
		
		int[] alphabetCount = new int[26];
		for (int i = 0; i < mStr.length; i++) {
			if (mStr[i] == '\0') break;
			sentence.add(mStr[i]);
			alphabetCount[mStr[i] - 'a']++;
		}
		
		alphabetCountOfIndex.put(0, alphabetCount);
		
		for (int i = 1; i < sentence.size(); i++) {
			int[] tempAlphabetCount = new int[26];
			System.arraycopy(alphabetCountOfIndex.get(i-1), 0, tempAlphabetCount, 0, tempAlphabetCount.length);
			
			tempAlphabetCount[sentence.get(i-1) - 'a']--;
			alphabetCountOfIndex.put(i, tempAlphabetCount);
		}
		
//		alphabetCountOfIndex.forEach((k, v) -> {
//			int[] temp = alphabetCountOfIndex.get(k);
//			System.out.println(k);
//			for (int val : temp) {
//				System.out.print(val + " ");
//			}
//			System.out.println();
//		});
	}

	void insert(char mChar) {
		if (cursorIndex == sentence.size()) {
			int[] alphabetCount = new int[26];
			alphabetCountOfIndex.put(cursorIndex, alphabetCount);
			sentence.add(mChar);
		} else {
			sentence.add(cursorIndex, mChar);
		}
		
		//커서가 있는 위치에서 뒤에있는 인덱스들을 하나씩 밀어주기
		for (int i = sentence.size()-1; i > cursorIndex; i--) {
			int[] tempAlphabetCount = new int[26];
			System.arraycopy(alphabetCountOfIndex.get(i-1), 0, tempAlphabetCount, 0, 26);
			alphabetCountOfIndex.put(i, tempAlphabetCount);
		}
		
		//처음부터 커서가 있는 위치까지 map 갱신하기
		for (int i = 0; i <= cursorIndex; i++) {
			int[] alphabetCount = alphabetCountOfIndex.get(i);
			
			alphabetCount[mChar - 'a']++;
			alphabetCountOfIndex.put(i, alphabetCount);
		}
		
//		System.out.println("=====================");
//		alphabetCountOfIndex.forEach((k, v) -> {
//			int[] temp = alphabetCountOfIndex.get(k);
//			System.out.println(k);
//			for (int val : temp) {
//				System.out.print(val + " ");
//			}
//			System.out.println();
//		});
		cursorIndex++;
	}

	char moveCursor(int mRow, int mCol) {
		if (sentence.size() < width * (mRow-1) + mCol) {
			cursorIndex = sentence.size();
			return '$';
		} else {
			cursorIndex = width * (mRow-1) + mCol -1;
			return sentence.get(cursorIndex);
		}
	}

	int countCharacter(char mChar) {
		if (cursorIndex == sentence.size()) {
			return 0;
		} else {
			int[] alphabetCount = alphabetCountOfIndex.get(cursorIndex);
			return alphabetCount[mChar - 'a'];
		}
	}
}