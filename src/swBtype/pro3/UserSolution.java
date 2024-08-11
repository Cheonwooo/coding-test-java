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
		//rank�� Map�̱� ������ �ʱⰪ�� ��������� null���� �߻�x
		
		for (int i = 0; i < 3; i++) {
			Map<Character, TreeSet<Student>> genders = new HashMap<>();
			for (int j = 0; j < 2; j++) {
				TreeSet<Student> scores = new TreeSet<>();
				genders.put(gender[j], scores);//��
			}
			rank.put(grade[i], genders);
		}
		
//		�Ʒ��� ���� �����ϰԵǸ� �ּҸ� �����ϰԵż� add()ȣ�� �� ���� ��ä�� ������
//		TreeSet<Student> scores = new TreeSet<>();
//		Map<Character, TreeSet<Student>> genders = new HashMap<>();
//		
//		genders.put('m', scores);//��
//		genders.put('f', scores);//��
//		
//		rank.put(1, genders);//1�г�
//		rank.put(2, genders);//2�г�
//		rank.put(3, genders);//3�г�
		return;
	}

	public int add(int mId, int mGrade, char mGender[], int mScore) {
		Student student = new Student(mId, mGrade, mGender[0], mScore);
		students.put(mId, student);
		
		//��ü rank���� �г�, ������ �ش��ϴ� TreeSet ��������
		Map<Character, TreeSet<Student>> gradeStudents = rank.get(mGrade);
		TreeSet<Student> genderStudents = gradeStudents.get(mGender[0]);
		genderStudents.add(student);
		
		//�ٽ� rank�� ����
		gradeStudents.put(mGender[0], genderStudents);
		rank.put(mGrade, gradeStudents);
		
		Student findStudent = rank.get(mGrade).get(mGender[0]).last();
		return findStudent.id;
	}

	public int remove(int mId) {
		//����� �л��� �߿� mId�� ���� �л��� ���ٸ� 0 ��ȯ 
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
		//�������� �ɷ��� �л��� �����ϱ� ���� TreeSet
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
		
		if (tempRank.size() == 0) return 0;//������ mScore �̻��� �л��� ���ٸ�
		return tempRank.first().id;
	}
}