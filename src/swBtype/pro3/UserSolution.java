package swBtype.pro3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class UserSolution {
	
	private class Student implements Comparable<Student> {
		int id;
		int grade;
		char gender;//'m','f'
		int score;

		public Student(int id, int grade, char gender, int score) {
			this.id = id;
			this.grade = grade;
			this.gender = gender;
			this.score = score;
		}

		public int compareTo(Student other) {
			if (this.score == other.score) {
				return this.id - other.id;
			}
			return this.score - other.score;
		}
	}

	private Map<Integer, Student> students = new HashMap<>(); 
	private Map<Integer, Map<Character, TreeSet<Student>>> rank = new HashMap<>();
	
	public void init() {
		char[] gender = {'m', 'f'};
		int[] grade = {1, 2, 3};
		//rank는 Map이기 떄문에 초기값을 설정해줘야 null에러 발생x
		
		for (int i = 0; i < 3; i++) {
			Map<Character, TreeSet<Student>> genders = new HashMap<>();
			for (int j = 0; j < 2; j++) {
				TreeSet<Student> scores = new TreeSet<>();
				genders.put(gender[j], scores);//남
			}
			rank.put(grade[i], genders);
		}
		
//		아래와 같이 선언하게되면 주소를 공유하게돼서 add()호출 시 같은 객채를 가져옴
//		TreeSet<Student> scores = new TreeSet<>();
//		Map<Character, TreeSet<Student>> genders = new HashMap<>();
//		
//		genders.put('m', scores);//남
//		genders.put('f', scores);//남
//		
//		rank.put(1, genders);//1학년
//		rank.put(2, genders);//2학년
//		rank.put(3, genders);//3학년
		return;
	}

	public int add(int mId, int mGrade, char mGender[], int mScore) {
		Student student = new Student(mId, mGrade, mGender[0], mScore);
		students.put(mId, student);
		
		//전체 rank에서 학년, 성별에 해당하는 TreeSet 가져오기
		Map<Character, TreeSet<Student>> gradeStudents = rank.get(mGrade);
		TreeSet<Student> genderStudents = gradeStudents.get(mGender[0]);
		genderStudents.add(student);
		
		//다시 rank에 저장
		gradeStudents.put(mGender[0], genderStudents);
		rank.put(mGrade, gradeStudents);
		
		Student findStudent = rank.get(mGrade).get(mGender[0]).last();
		return findStudent.id;
	}

	public int remove(int mId) {
		//저장된 학생들 중에 mId를 가진 학생이 없다면 0 반환 
		if (!students.containsKey(mId)) {
			return 0;
		}
		
		Student findStudent = students.get(mId);
		TreeSet<Student> students = rank.get(findStudent.grade).get(findStudent.gender);
	
		students.remove(findStudent);
		if (students.size() == 0) {
			return 0;
		}
		return students.first().id;
	}

	public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
		//조건으로 걸러진 학생을 저장하기 위한 TreeSet
		TreeSet<Student> tempRank = new TreeSet<>();
		
		for (int i = 0; i < mGradeCnt; i++) {
			Map<Character, TreeSet<Student>> genderStudents = rank.get(mGrade[i]);
			
			for (int j = 0; j < mGenderCnt; j++) {
				TreeSet<Student> scores = genderStudents.get(mGender[j][0]);
				Student tempStudent = new Student(0, mGrade[i], mGender[j][0], mScore);
				Student findStudent = scores.ceiling(tempStudent);
				
				if (findStudent != null) {
					tempRank.add(findStudent);
				}
			}
		}
		
		if (tempRank.size() == 0) return 0;//점수가 mScore 이상인 학생이 없다면
		return tempRank.first().id;
	}
}