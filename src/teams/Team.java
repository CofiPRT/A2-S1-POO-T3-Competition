package teams;

import java.util.ArrayList;

import enums.Gender;
import visitorstrategy.TeamVisitor;

/**
 * A team waiting to partake in the comps
 * @author Rares
 *
 */
public abstract class Team implements Comparable<Team> {
	private String teamName;
	private Gender gender;
	private Integer numberOfPlayers;
	private ArrayList<Player> players;
	
	private Integer points;
	private Integer rank;
	
	public Team() {
		teamName = null;
		gender = null;
		numberOfPlayers = 0;
		players = new ArrayList<Player>();
		points = 0;
		rank = null;
	}
	
	public Team(String teamName, Gender gender) {
		this.teamName = teamName;
		this.gender = gender;
		numberOfPlayers = 0;
		players = new ArrayList<Player>();
		points = 0;
		rank = null;
	}
	
	/**
	 * Accept method (from Visitor pattern) to accept a type of visitor for
	 * this team
	 * @param visitor		The said visitor
	 * @return				The result of the visitor's action
	 */
	public abstract Double accept(TeamVisitor visitor);
	
	/**
	 * Observer method (from Observer pattern) to update this team about a
	 * change
	 * @param newRank	The new rank of the team
	 */
	public void update(Integer newRank) {
		rank = newRank;
	}
	
	/**
	 * Follow the format required by the task
	 * @return		The string representation of this team
	 */
	@Override
	public String toString() {
		return 	"{" +
				"teamName: " + teamName + ", " +
				"gender: " + gender + ", " +
				"numberOfPlayers: " + numberOfPlayers + ", " +
				"players: " + players +
				"}";
	}
	
	/**
	 * Compare the points of two teams
	 */
	@Override
	public int compareTo(Team otherTeam) {
		// reverse order
		
		if (this.getPoints() > otherTeam.getPoints()) {
			return -1;
		} else if (this.getPoints() < otherTeam.getPoints()) {
			return 1;
		}
		return 0;
	}
	
	// getters and setters
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Integer getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(Integer numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	
}
