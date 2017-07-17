package homework14.students;

public class Student {
	private String name;
	private String subject;
	private double grade;
	private int yearInCollege;
	private int age;
	private boolean isDegree;
	private double money;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!name.isEmpty() && name != null) {
			this.name = name;
		} else {
			System.out.println("Invalid student name");
		}
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		if (!subject.isEmpty() && subject != null) {
			this.subject = subject;
		} else {
			System.out.println("Invalid subject name");
		}
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		if (grade >= 2 && grade <= 6) {
			this.grade = grade;
		} else {
			System.out.println("Invalid grade");
		}	
	}

	public int getYearInCollege() {
		return yearInCollege;
	}

	public void setYearInCollege(int yearInCollege) {
		if (yearInCollege > 0 && yearInCollege <= 4) {
			this.yearInCollege = yearInCollege;
		} else {
			System.out.println("Invalid year in college");
		}	
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		} else {
			System.out.println("Invalid age");
		}	
	}

	public boolean isDegree() {
		return isDegree;
	}

	public void setDegree(boolean isDegree) {
		this.isDegree = isDegree;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		if (money >= 0) {
			this.money = money;
		} else {
			System.out.println("Invalid money");
		}
	}

	public Student() {
		this.setGrade(4.0);
		this.setYearInCollege(1);
		this.setDegree(false);
		this.setMoney(0);
	}
	
	public Student(String name, String subject, int age) {
		this();
		this.setName(name);
		this.setSubject(subject);
		this.setAge(age);
	}

	public void upYear() {
		if (!isDegree()) {
			//this.yearInCollege += 1; 
			this.setYearInCollege(++this.yearInCollege);
		}
		if (this.getYearInCollege() > 4) {
			this.setDegree(true);
			System.out.println("Student has graduated!");
		}
	}
	
	public double receiveScholarship(double min, double amount) {
		if (this.getAge() <= 30 && this.getGrade() >= min) {
			this.setMoney(this.money + amount);
		}
		return this.getMoney();
	}
	
	public void printStudentInfo() {
		System.out.printf("Student name: %s, subject: %s, GPA: %.2f, year: %d, age: %d, graduated: %b, balance: %.2f\n", this.getName(), this.getSubject(), this.getGrade(), this.getYearInCollege(), this.getAge(), this.isDegree(), this.getMoney());
	}
}
