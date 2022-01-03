package visitorstrategy.formulas;

import java.util.ArrayList;

import teams.Player;

public class HandballFemaleFormula implements ScoreFormula {

	public HandballFemaleFormula() {}
	
	/**
	 * Calculates the score of this handball team according to the task
	 * ({@code FEMALE} team: The sum of all scores)
	 * @param players	The list of players
	 * @return			The thereby calculated score
	 */
	@Override
	public Double applyOn(ArrayList<Player> players) {
		if (players.isEmpty()) {
			// no players, no scores
			return 0D;
		}
		
		Double totalScore = 1D;
		
		for (Player currentPlayer : players) {
			// calculate the product of all scores
			totalScore *= currentPlayer.getScore();
		}
		
		return totalScore;
	}
}
