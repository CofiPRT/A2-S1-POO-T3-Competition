package factories;

import java.util.ArrayList;

import enums.*;
import teams.*;

/**
 * Factory for {@code Team} objects
 * @author Rares
 *
 */
public class TeamBuilder {
	/**
	 * Singleton field for the unique instance of this class
	 */
	private static TeamBuilder uniqueInstance = null;
	
	private Team newTeam;
	
	private TeamBuilder() {}
	
	/**
	 * Singleton method for the instantiation of this class
	 * @return	A new instance, if none was created, or the previously created
	 * instance
	 */
	public static TeamBuilder getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new TeamBuilder();
		}
		
		return uniqueInstance;
	}
	
	/**
	 * Factory method for starting the building of a new team, based on its
	 * type
	 * @param type	The type of the team, from {@code TeamType} Enum
	 * @return		{@code this} instance for method chaining
	 */
	public TeamBuilder build(TeamType type) {
		switch(type) {
		case FOOTBALL:
			newTeam = new FootballTeam();
			break;
		case BASKETBALL:
			newTeam = new BasketballTeam();
			break;
		case HANDBALL:
			newTeam = new HandballTeam();
			break;
		}
		
		return this;
	}
	
	/**
	 * Factory method for {@code teamName}
	 * @param teamName	The name of the team
	 * @return			{@code this} instance for method chaining.
	 */
	public TeamBuilder withTeamName(String teamName) {
		newTeam.setTeamName(teamName);
		return this;
	}
	
	/**
	 * Factory method for {@code gender}
	 * @param gender	The gender of the players in the team
	 * @return			{@code this} instance for method chaining.
	 */
	public TeamBuilder withGender(Gender gender) {
		newTeam.setGender(gender);
		return this;
	}
	
	/**
	 * Factory method for {@code numberOfPlayers}
	 * @param numberOfPlayers	The number of players in the team
	 * @return					{@code this} instance for method chaining.
	 */
	public TeamBuilder withNumberOfPlayers(Integer numberOfPlayers) {
		newTeam.setNumberOfPlayers(numberOfPlayers);
		return this;
	}
	
	/**
	 * Factory method for {@code players}
	 * @param players	A list of players that shall be associated to the team
	 * @return			{@code this} instance for method chaining.
	 */
	public TeamBuilder withPlayers(ArrayList<Player> players) {
		newTeam.setPlayers(players);
		return this;
	}
	
	/**
	 * Factory method for finishing the building of the team
	 * @return	The thereby generated team
	 */
	public Team finish() {
		return newTeam;
	}
}
