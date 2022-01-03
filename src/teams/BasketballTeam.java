package teams;

import visitorstrategy.TeamVisitor;

/**
 * A team of basketball players
 * @author Rares
 *
 */
public class BasketballTeam extends Team {
	
	public BasketballTeam() {}
	
	/**
	 * Accept a visitor for this type of team
	 */
	@Override
	public Double accept(TeamVisitor visitor) {
		return visitor.visit(this);
	}
}
