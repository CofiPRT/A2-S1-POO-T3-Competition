package visitorstrategy.formulas;

import java.util.ArrayList;

import teams.Player;

public class BasketballFormula implements ScoreFormula {
	
	public BasketballFormula() {}
	
	/**
	 * Calculates the score of this basketball team according to the task
	 * (Regardless of gender, calculate the average score of all players)
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
			// add every score
			totalScore += currentPlayer.getScore();
		}
		
		// compute the average
		return totalScore / players.size();
	}
}
