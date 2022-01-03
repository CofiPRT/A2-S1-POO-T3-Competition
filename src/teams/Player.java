package teams;

/**
 * A player that's to be part of a team
 * @author Rares
 *
 */
public class Player implements Comparable<Player> {
	private String name;
	private Integer score;
	
	public Player() {
		name = null;
		score = 0;
	}
	
	public Player(String name) {
		this.name = name;
		score = 0;
	}
	
	/**
	 * Follow the format required by the task
	 * @return		The string representation of this player
	 */
	@Override
	public String toString() {
		return 	"{" +
				"name: " + name + ", " +
				"score: " + score +
				"}"; 
	}
	
	/**
	 * Compare the scores of two players
	 */
	@Override
	public int compareTo(Player otherPlayer) {
		if (this.getScore() > otherPlayer.getScore()) {
			return 1;
		} else if (this.getScore() < otherPlayer.getScore()) {
			return -1;
		}
		return 0;
	}
	
	// getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	
}
