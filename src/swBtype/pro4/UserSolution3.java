package swBtype.pro4;

import java.util.ArrayList;
import java.util.List;

class UserSolution3 {
	private int height, width, cursorIndex;
	private List<Character> sentence;
	private List<int[]> list;

	void init(int H, int W, char mStr[]) {
		sentence = new ArrayList<>();
		list = new ArrayList<>();
		
		height = H;
		width = W;
		cursorIndex = 0;
		
		int[] alphabetCount = new int[26];
		for (int i = 0; i < mStr.length; i++) {
			if (mStr[i] == '\0') break;
			sentence.add(mStr[i]);
			alphabetCount[mStr[i] - 'a']++;
		}
		
		list.add(alphabetCount);
		
		for (int i = 1; i < sentence.size(); i++) {
			int[] tempAlphabetCount = new int[26];
			System.arraycopy(list.get(i-1), 0, tempAlphabetCount, 0, tempAlphabetCount.length);
			
			tempAlphabetCount[sentence.get(i-1) - 'a']--;
			list.add(tempAlphabetCount);
		}
		
//		for (int[] arr : list) {
//			for (int val : arr) {
//				System.out.print(val + " ");
//			}
//			System.out.println();
//		}
	}

	void insert(char mChar) {
		int[] tempAlphabetCount = new int[26];
		if (cursorIndex == sentence.size()) {
			sentence.add(mChar);
		} else {
			tempAlphabetCount = list.get(cursorIndex).clone();
			sentence.add(cursorIndex, mChar);
		}
		list.add(cursorIndex, tempAlphabetCount);

		for (int i = 0; i <= cursorIndex; i++) {
			int[] alphabetCount = list.get(i);
			alphabetCount[mChar - 'a']++;
		}
//		
//		System.out.println("=====================");
//		for (int[] arr : list) {
//			for (int val : arr) {
//				System.out.print(val + " ");
//			}
//			System.out.println();
//		}
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
			int[] alphabetCount = list.get(cursorIndex);
			return alphabetCount[mChar - 'a'];
		}
	}
}