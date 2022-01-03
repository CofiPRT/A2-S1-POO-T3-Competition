package factories;

import teams.*;

import java.util.ArrayList;

import comps.Competition;
import enums.*;

/**
 * Factory for {@code Competition} objects
 * @author Rares
 *
 */
public class CompetitionBuilder {
	/**
	 * Singleton field for the unique instance of this class
	 */
	private static CompetitionBuilder uniqueInstance = null;
	
	private Competition newCompetition;
	
	private CompetitionBuilder() {}
	
	/**
	 * Singleton method for the instantiati*on of this class
	 * @return	A new instance, if none was created, or the previously created
	 * instance
	 */
	public static CompetitionBuilder getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new CompetitionBuilder();
		}
		
		return uniqueInstance;
	}
	
	/**
	 * Factory method for starting the building of a new comps, based on
	 * its type
	 * @return		{@code this} instance for method chaining
	 */
	public CompetitionBuilder build() {
		newCompetition = new Competition();
		return this;
	}
	
	/**
	 * Factory method for {@code type}
	 * @param type		The type of the comps
	 * @return			{@code this} instance for method chaining
	 */
	public CompetitionBuilder withTeamType(TeamType type) {
		newCompetition.setType(type);
		return this;
	}
	
	/**
	 * Factory method for {@code gender}
	 * @param gender	The gender of the players in the comps
	 * @return			{@code this} instance for method chaining
	 */
	public CompetitionBuilder withGender(Gender gender) {
		newCompetition.setGender(gender);
		return this;
	}
	
	/**
	 * Factory method for {@code teams}
	 * @param teams		The list of teams in the comps
	 * @return			{@code this} instance for method chaining
	 */
	public CompetitionBuilder withTeams(ArrayList<Team> teams) {
		newCompetition.setTeams(teams);
		return this;
	}
	
	/**
	 * Factory method for {@code ranking}
	 * @param ranking	The list of teams in the comps ordered by their
	 * rank
	 * @return			{@code this} instance for method chaining
	 */
	public CompetitionBuilder withRanking(ArrayList<Team> ranking) {
		newCompetition.setRanking(ranking);
		return this;
	}
	
	/**
	 * Factory method for finishing the building of the comps
	 * @return		The thereby generated comps
	 */
	public Competition finish() {
		return newCompetition;
	}
}
