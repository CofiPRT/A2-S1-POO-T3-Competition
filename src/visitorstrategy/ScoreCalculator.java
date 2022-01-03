package visitorstrategy;

import java.util.ArrayList;

import teams.Player;
import visitorstrategy.formulas.ScoreFormula;

/**
 * Use as Context class for Strategy pattern
 * @author Rares
 *
 */
public class ScoreCalculator {
	private ScoreFormula formula;
	
	public ScoreCalculator() {
		formula = null;
	}
	
	public ScoreCalculator(ScoreFormula formula) {
		this.formula = formula;
	}
	
	/**
	 * Apply the selected formula for this list of players
	 * @param players	The said list of players
	 * @return			The score that's been calculated accordingly
	 */
	public Double applyFormula(ArrayList<Player> players) {
		return formula.applyOn(players);
	}

	public ScoreFormula getFormula() {
		return formula;
	}

	public void setFormula(ScoreFormula formula) {
		this.formula = formula;
	}
	
	
}
