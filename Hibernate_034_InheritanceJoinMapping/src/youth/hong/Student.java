package youth.hong;

import javax.persistence.Entity;

@Entity
public class Student extends Person {
	private double score;
	

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	
}
