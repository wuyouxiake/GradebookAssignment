package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the GRADEBOOK database table.
 * 
 */
@Entity
@NamedQuery(name="Gradebook.findAll", query="SELECT g FROM Gradebook g")
public class Gradebook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String assignment;

	private long grade;

	public Gradebook() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssignment() {
		return this.assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public long getGrade() {
		return this.grade;
	}

	public void setGrade(long grade) {
		this.grade = grade;
	}

}