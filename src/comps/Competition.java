package comps;

import java.util.ArrayList;
import java.util.Collections;

import enums.*;
import teams.*;
import visitorstrategy.TeamVisitor;

/**
 * Class representing a comps that's waiting to be played
 * @author Rares
 *
 */
public class Competition {
	private TeamType type;
	private Gender gender;
	private ArrayList<Team> teams;
	private ArrayList<Team> ranking;
	
	public Competition() {
		type = null;
		gender = null;
		teams = new ArrayList<Team>();
		ranking = new ArrayList<Team>();
	}
	
	public Competition(TeamType type, Gender gender) {
		this.type = type;
		this.gender = gender;
		teams = new ArrayList<Team>();
		ranking = new ArrayList<Team>();
	}
	
	/**
	 * Add a new team to the comps, only if the gender and the type of
	 * the team match the comps's
	 * @param newTeam	The team to be added
	 * @return			{@code true} if the team has been successfully added
	 */
	public boolean addTeam(Team newTeam) {
		if (newTeam.getGender() != getGender()) {
			// genders don't match, don't add the team
			return false;
		}
		
		switch (type) {
		// make sure the comps is made for the team type
		case FOOTBALL:
			if (!(newTeam instanceof FootballTeam)) {
				return false;
			}
			break;
			
		case BASKETBALL:
			if (!(newTeam instanceof BasketballTeam)) {
				return false;
			}
			break;
		
		case HANDBALL:
			if (!(newTeam instanceof HandballTeam)) {
				return false;
			}
			break;
		}
		
		// everything is good, add the team
		teams.add(newTeam);
		return true;
	}
	
	/**
	 * Play the comps by playing a round between each team once. The
	 * points get changed after every round. The ranking is also generated
	 */
	public void playCompetition() {
		generateRanking();
		
		for (int i = 0; i < teams.size(); i++) {
			for (int j = i + 1; j < teams.size(); j++) {
				playRound(teams.get(i), teams.get(j));
			}
		}
	}
	
	/**
	 * Print the final ranking of the teams according to the task
	 */
	public void printRanking() {
		Integer maxPrints = 3;
		
		// print the first maxPrints teams
		for (int i = 0; i < Math.min(ranking.size(), maxPrints); i++) {
			System.out.println(ranking.get(i).getTeamName());
		}
		
		// print the rank of every team that has played
		for (Team currentTeam : teams) {
			// team's rank is the index it is found in 'ranking' list + 1
			System.out.println("Echipa " +
								currentTeam.getTeamName() +
								" a ocupat locul " +
								currentTeam.getRank());
		}
	}
	
	/**
	 * Make a copy of the list of teams to use as ranking list, which will
	 * be sorted several times
	 */
	private void generateRanking() {
		for (Team currentTeam : teams) {
			// add every team to this other list
			ranking.add(currentTeam);
		}
	}
	
	/**
	 * Play a round between two given teams. The team with the highest score
	 * wins 3 points. Should a draw happen, each team wins 1 point
	 * @param team1		The first team
	 * @param team2		The second team
	 */
	private void playRound(Team team1, Team team2) {
		TeamVisitor scoreVisitor = new TeamVisitor();
		
		Double team1Score = team1.accept(scoreVisitor);
		Double team2Score = team2.accept(scoreVisitor);
		
		if (team1Score > team2Score) {
			// team 1 wins 3 points
			team1.setPoints(team1.getPoints() + 3);
		} else if (team1Score < team2Score) {
			// team 2 wins 3 points
			team2.setPoints(team2.getPoints() + 3);
		} else {
			// draw, each team wins 1 point
			team1.setPoints(team1.getPoints() + 1);
			team2.setPoints(team2.getPoints() + 1);
		}
		
		// at the end of the round, sort the teams and notify them about it
		Collections.sort(ranking);
		notifyObservers();
	}
	
	/**
	 * Subject method (from Observer pattern) to notify every observer about
	 * a change. All observers are already in the list of 'teams'.
	 */
	private void notifyObservers() {
		for (Team currentTeam : teams) {
			// update its rank as the place in the 'ranking' list
			currentTeam.update(ranking.indexOf(currentTeam) + 1);
		}
	}
	
	// getters and setters
	
	public TeamType getType() {
		return type;
	}
	public void setType(TeamType type) {
		this.type = type;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public ArrayList<Team> getTeams() {
		return teams;
	}
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	public ArrayList<Team> getRanking() {
		return ranking;
	}
	public void setRanking(ArrayList<Team> ranking) {
		this.ranking = ranking;
	}
	
	
}
