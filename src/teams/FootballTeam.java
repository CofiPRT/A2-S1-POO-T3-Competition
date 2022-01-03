package teams;

import visitorstrategy.TeamVisitor;

/**
 * A team of football players
 * @author Rares
 *
 */
public class FootballTeam extends Team {
	
	public FootballTeam() {}
	
	/**
	 * Accept a visitor for this type of team
	 */
	@Override
	public Double accept(TeamVisitor visitor) {
		return visitor.visit(this);
	}
}
