package enums;

/**
 * Enum containing the genders used in the task, along with their corresponding
 * {@code String} translations
 * @author Rares
 *
 */
public enum Gender {
	MALE("masculin"),
	FEMALE("feminin");
	
	private String translation;
	
	private Gender(String translation) {
		this.translation = translation;
	}
	
	/**
	 * Get the corresponding {@code Gender} enum based on given string
	 * @param field		The string which {@code Gender} correspondent shall be
	 * searched
	 * @return			The thereby found {@code Gender}, or {@code null} if it
	 * hasn't been found
	 */
	public static Gender translate(String field) {
		// search through all the enums
		for (Gender gender : Gender.values()) {
			if (gender.translation.equals(field)) {
				return gender;
			}
		}
		
		// enum correspondent hasn't been found
		return null;
	}
	
	public String toString() {
		return this.translation;
	}
}
