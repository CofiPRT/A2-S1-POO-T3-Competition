package visitorstrategy.formulas;

import java.util.ArrayList;
import java.util.Collections;

import teams.Player;

public class FootballMaleFormula implements ScoreFormula {

	public FootballMaleFormula() {}
	
	/**
	 * Calculates the score of this football team according to the task
	 * ({@code MALE} team : The score of the best player * 2 + the score of
	 * the other players)
	 * @param players	The list of players
	 * @return			The thereby calculated score
	 */
	@Override
	public Double applyOn(ArrayList<Player> players) {
		if (players.isEmpty()) {
			// no players, no score
			return 0D;
		}
		
		// get the player with the highest score
		Collections.sort(players);
		Player extremePlayer = players.get(players.size() - 1);
		
		// according to the task
		Double totalScore = 2D * extremePlayer.getScore();
		
		for (Player currentPlayer : players) {
			if (currentPlayer != extremePlayer) {
				// add every other score
				totalScore += currentPlayer.getScore();
			}
		}
		
		return totalScore;
	}
}
