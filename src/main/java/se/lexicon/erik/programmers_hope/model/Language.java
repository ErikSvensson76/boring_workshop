package se.lexicon.erik.programmers_hope.model;

import java.util.HashSet;
import java.util.Set;

public class Language {
	
	private String language;
	
	private Set<Programmer> programmers;

	public Language(String language) {
		this.language = language;
		this.programmers = new HashSet<>();
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Set<Programmer> getProgrammers() {
		return programmers;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Language other = (Language) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Language [language=");
		builder.append(language);
		builder.append("]");
		return builder.toString();
	}
}
