package com.workoutwarrior.payload;

public class ExerciseNote {
	
	private String name;		//name of the exercise such as: biceps curl
	private int setCount;		//number of sets that are done by the user
	private int repCountInASet;	//number of reps in the set
	private String additionalNote;	//user might have an additional information 
									//to remind himself when he checks the past exercises
	
	public ExerciseNote() {
	// TODO Auto-generated constructor stub
	}

	public ExerciseNote(String name, int setCount, int repCountInASet, String additionalNote) {
		super();
		this.name = name;
		this.setCount = setCount;
		this.repCountInASet = repCountInASet;
		this.additionalNote = additionalNote;
	}

	public ExerciseNote(String name, int setCount, int repCountInASet) {
		super();
		this.name = name;
		this.setCount = setCount;
		this.repCountInASet = repCountInASet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSetCount() {
		return setCount;
	}

	public void setSetCount(int setCount) {
		this.setCount = setCount;
	}

	public int getRepCountInASet() {
		return repCountInASet;
	}

	public void setRepCountInASet(int repCountInASet) {
		this.repCountInASet = repCountInASet;
	}

	public String getAdditionalNote() {
		return additionalNote;
	}

	public void setAdditionalNote(String additionalNote) {
		this.additionalNote = additionalNote;
	}

	@Override
	public String toString() {
		return "ExerciseNote [name=" + name + ", setCount=" + setCount + ", repCountInASet=" + repCountInASet
				+ ", additionalNote=" + additionalNote + "]";
	}
	
}
