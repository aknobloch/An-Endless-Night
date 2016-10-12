package Game;



public class Puzzle {

	private String description;

	private String solution;

	private boolean isSolved;

	private int attemptsMade;

	private String hint;

	private int puzzleID;

	private int attemptsAllowed;
	
	public Puzzle(String description, String solution, boolean isSolved, int attemptsMade, String hint, int puzzleID,
			int attemptsAllowed) {
		this.description = description;
		this.solution = solution;
		this.isSolved = isSolved;
		this.attemptsMade = attemptsMade;
		this.hint = hint;
		this.puzzleID = puzzleID;
		this.attemptsAllowed = attemptsAllowed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSolution() {
		return solution;
	}

	public boolean getIsSolved() {
		return isSolved;
	}

	

	public void setIsSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public int getPuzzleID() {
		return puzzleID;
	}

	public int getAttemptsMade() {
		return attemptsMade;
	}

	public void incrementAttemptsMade() {
		attemptsMade = attemptsMade + 1;
	}

	public int getAttemptsAllowed() {
		return attemptsAllowed;
	}

}
