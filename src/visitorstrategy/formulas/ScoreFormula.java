package visitorstrategy.formulas;

import java.util.ArrayList;

import teams.Player;

/**
 * The classes that implement this interface contain formulas used to calculate
 * the score of a specific type of player list.
 * @author Rares
 *
 */
public interface ScoreFormula {
	public Double applyOn(ArrayList<Player> players);
}
