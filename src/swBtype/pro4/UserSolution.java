package swBtype.pro4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class UserSolution {
	private int cursorIndex, height, width;
	private int[] alphabetCount;
	private List<Character> list;

	void init(int H, int W, char mStr[]) {
		height = H;// 3
		width = W;// 4
		alphabetCount = new int[26];
		cursorIndex = 0;

		list = new ArrayList<>();
		for (int i = 0; i < mStr.length; i++) {
			if (mStr[i] != '\0') {
				list.add(mStr[i]);
				alphabetCount[mStr[i] - 'a']++;
			}
		}
	}

	void insert(char mChar) {
		if (cursorIndex == list.size()) {
			list.add(mChar);
		} else {
			list.add(cursorIndex, mChar);
		}
		alphabetCount[mChar - 'a']++;
		cursorIndex++;

//		for (char c : list) {
//			System.out.print(c + " ");
//		}
//		System.out.println();
	}

	char moveCursor(int mRow, int mCol) {
//		System.out.println(list.size());
//		System.out.println(width * (mRow - 1) + mCol);
		if (list.size() < width * (mRow - 1) + mCol) {
			cursorIndex = list.size();
			return '$';
		}
		cursorIndex = width * (mRow - 1) + mCol - 1;
		return list.get(cursorIndex);
	}

	int countCharacter(char mChar) {
		if (cursorIndex == list.size()) {
			return 0;
		} else {
			List<Character> tempList = new ArrayList<>();
			if (cursorIndex <= list.size() / 2) {
				tempList = list.subList(0, cursorIndex);
				int characterCount = Collections.frequency(tempList, mChar);
				return alphabetCount[mChar - 'a'] - characterCount;
			}
			tempList = list.subList(cursorIndex, list.size());
			return Collections.frequency(tempList, mChar);
		}
	}
}