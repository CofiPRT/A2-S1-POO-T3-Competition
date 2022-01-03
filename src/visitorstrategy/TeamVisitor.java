package visitorstrategy;

import teams.BasketballTeam;
import teams.FootballTeam;
import teams.HandballTeam;
import visitorstrategy.formulas.*;

/**
 * Use as Visitor class for Visitor pattern
 * @author Rares
 *
 */
public class TeamVisitor {
	
	public TeamVisitor() {}
	
	/**
	 * Regardless of gender, apply the formula for calculating the score
	 * of a basketball team
	 * @param team		The list of players
	 * @return			The thereby calculated score
	 */
	public Double visit(BasketballTeam team) {
		return new ScoreCalculator(new BasketballFormula())
					.applyFormula(team.getPlayers());
	}
	
	/**
	 * Apply the corresponding formula in order to calculate the score of
	 * a football team, according to gender
	 * @param team		The list of players
	 * @return			The thereby calculated score
	 */
	public Double visit(FootballTeam team) {
		switch (team.getGender()) {
		case MALE:
			return new ScoreCalculator(new FootballMaleFormula())
						.applyFormula(team.getPlayers());
			
		case FEMALE:
			return new ScoreCalculator(new FootballFemaleFormula())
						.applyFormula(team.getPlayers());
			
		default:
			// should not reach here
			return 0D;
		}
	}
	
	/**
	 * Apply the corresponding formula in order to calculate the score of
	 * a handball team, according to gender
	 * @param team		The list of players
	 * @return			The thereby calculated score
	 */
	public Double visit(HandballTeam team) {
		switch (team.getGender()) {
		case MALE:
			return new ScoreCalculator(new HandballMaleFormula())
						.applyFormula(team.getPlayers());
			
		case FEMALE:
			return new ScoreCalculator(new HandballFemaleFormula())
						.applyFormula(team.getPlayers());
			
		default:
			// should not reach here
			return 0D;
		}
	}
}
