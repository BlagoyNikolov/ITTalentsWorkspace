package homework14.students;

public class StudentGroup {
	private static int INDEX = 0;
	
	private String groupSubject;
	private Student[] students;
	private int freePlaces;

	public String getGroupSubject() {
		return groupSubject;
	}

	public void setGroupSubject(String groupSubject) {
		if (!groupSubject.isEmpty() && groupSubject != null) {
			this.groupSubject = groupSubject;
		} else {
			System.out.println("Invalid group subject string");
		}
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		if (students != null) {
			this.students = students;
		} else {
			System.out.println("Invalid array of students");
		}
	}

	public int getFreePlaces() {
		return freePlaces;
	}

	public void setFreePlaces(int freePlaces) {
		if (freePlaces >= 0) {
			this.freePlaces = freePlaces;
		} else {
			System.out.println("Invalid input for free places");
		}
	}

	public StudentGroup() {
		this.setStudents(new Student[5]);
		this.setFreePlaces(5);
		// this.students = new Student[5];
		// this.freePlaces = 5;
	}
	
	public StudentGroup(String subject) {
		this();
		this.setGroupSubject(subject);
	}
	
	public void addStudentStatic(Student s) {
		if (s.getSubject().equals(this.getGroupSubject())) {
			if (this.getFreePlaces() <= 5 && INDEX < 5) {
				this.getStudents()[INDEX] = s;
				INDEX++;
				this.freePlaces -= 1;
			} else {
				System.out.println("No more free places in group");
			}
		} else {
			System.out.println("Student " + s.getName() + " subject does not match group subject");
		}
	}
	
	public void addStudent(Student s) {
		for (int i = 0; i < students.length; i++) {
			if (s != null && students[i] == null) {
				if (s.getSubject().equals(this.getGroupSubject())) {
					if (this.getFreePlaces() <= 5) {
						this.getStudents()[i] = s;
						this.freePlaces--;
						break;
					} else {
						System.out.println("No more free places in group");
					}
				}
			}
		}
	}
	
	public void emptyGroup() {
		this.setStudents(new Student[5]);
		this.setFreePlaces(5);
		INDEX = 0;
	}
	
	public Student theBestStudent() {
		double max = this.getStudents()[0].getGrade();
		Student best = this.getStudents()[0];
		for (int i = 0; i < this.getStudents().length; i++) {
			if (this.getStudents()[i] != null) {
				if (this.getStudents()[i].getGrade() > max) {
					max = this.getStudents()[i].getGrade();
					best = this.getStudents()[i];
				}
			}
		}
		return best;
	}
	
	public String printStudentsInGroup() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.getStudents().length; i++) {
			if (this.getStudents()[i] != null) {
				sb.append("Name: " + this.getStudents()[i].getName() + ", Subject: " + this.getStudents()[i].getSubject() + ", Grade: " + this.getStudents()[i].getGrade() + ", Year: " + this.getStudents()[i].getYearInCollege() + ", Age: " + this.getStudents()[i].getAge() + ", Graduated: " + this.getStudents()[i].isDegree() + ", Money: " + this.getStudents()[i].getMoney() + "\n");
			}	
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
