package enums;

/**
 * Enum containing the team types used in the task, along with their
 * corresponding {@code String} translations
 * @author Rares
 *
 */
public enum TeamType {
	FOOTBALL("football"),
	BASKETBALL("basketball"),
	HANDBALL("handball");
	
	private String translation;
	
	private TeamType(String translation) {
		this.translation = translation;
	}
	
	/**
	 * Get the corresponding {@code TeamType} enum based on given string
	 * @param field		The string which {@code TeamType} correspondent shall
	 * be searched
	 * @return			The thereby found {@code TeamType}, or {@code null} if
	 * it hasn't been found
	 */
	public static TeamType translate(String field) {
		// search through all the enums
		for (TeamType type : TeamType.values()) {
			if (type.translation.equals(field)) {
				return type;
			}
		}
		
		// enum correspondent hasn't been found
		return null;
	}
	
	public String toString() {
		return this.translation;
	}
}
