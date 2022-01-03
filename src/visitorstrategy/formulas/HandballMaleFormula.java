package visitorstrategy.formulas;

import java.util.ArrayList;

import teams.Player;

public class HandballMaleFormula implements ScoreFormula {

	public HandballMaleFormula() {}
	
	/**
	 * Calculates the score of this handball team according to the task
	 * ({@code MALE} team: The sum of all scores)
	 * @param players	The list of players
	 * @return			The thereby calculated score
	 */
	@Override
	public Double applyOn(ArrayList<Player> players) {
		if (players.isEmpty()) {
			// no players, no score
			return 0D;
		}
		
		Double totalScore = 0D;
		
		for (Player currentPlayer : players) {
			// calculate the sum of all scores
			totalScore += currentPlayer.getScore();
		}
		
		return totalScore;
	}

}
