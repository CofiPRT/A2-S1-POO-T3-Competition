package factories;

import teams.Player;

/*
 * Factory for {@code Player} objects
 */
public class PlayerBuilder {
	/**
	 * Singleton field for the unique instance of this class
	 */
	private static PlayerBuilder uniqueInstance;
	
	private Player newPlayer;
	
	private PlayerBuilder() {}
	
	/**
	 * Singleton method for the instantiation of this class
	 * @return	A new instance, if none was created, or the previously created
	 * instance
	 */
	public static PlayerBuilder getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new PlayerBuilder();
		}
		
		return uniqueInstance;
	}
	
	/**
	 * Factory method for starting the building of a new player
	 * @return	{@code this} instance for method chaining
	 */
	public PlayerBuilder build() {
		newPlayer = new Player();
		return this;
	}
	
	/**
	 * Factory method for {@code name}
	 * @param name	The name of the player
	 * @return		{@code this} instance for method chaining
	 */
	public PlayerBuilder withName(String name) {
		newPlayer.setName(name);
		return this;
	}
	
	/**
	 * Factory method for {@code score}
	 * @param score		The score of the player
	 * @return			{@code this} instance for method chaining
	 */
	public PlayerBuilder withScore(Integer score) {
		newPlayer.setScore(score);
		return this;
	}
	
	/**
	 * Factory method for finishing the building of the player
	 * @return	The thereby generated player 
	 */
	public Player finish() {
		return newPlayer;
	}
}
