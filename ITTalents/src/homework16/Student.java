package homework16;

public class Student extends Person {
	private double score;
	
	public double getScore() {
		return this.score;
	}
	
	public void setScore(double score) {
		if (score >= 2 && score <= 6) {
			this.score = score;
		} else {
			System.out.println("Invalid score");
		}
	}
	
	public Student() {
		
	}
	
	public Student(String name, int age, boolean isMale, double score) {
		super(name, age, isMale);
		this.setScore(score);
	}
	
	//equivalent to showStudentInfo() in the requirements
	public String toString() {
		return String.format("Student Name: %s, Age: %d, Male: %b, Score: %.2f", this.getName(), this.getAge(), this.isMale(), this.getScore());
	}
}
