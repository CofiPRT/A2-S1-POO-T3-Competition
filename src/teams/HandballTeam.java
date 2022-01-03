package teams;

import visitorstrategy.TeamVisitor;

/**
 * A team of handball players
 * @author Rares
 *
 */
public class HandballTeam extends Team {
	
	public HandballTeam() {}
	
	/**
	 * Accept a visitor for this type of team
	 */
	@Override
	public Double accept(TeamVisitor visitor) {
		return visitor.visit(this);
	}
}
