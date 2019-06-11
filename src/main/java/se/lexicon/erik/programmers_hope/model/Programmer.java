package se.lexicon.erik.programmers_hope.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

public class Programmer {
	private static int counter;
	
	private int id;
	private String firstName;
	private String lastName;
	private String gitHub;
	private LocalDate birthDate;
	
	private Set<Language> languages;
	
	public Programmer(String firstName, String lastName, String gitHub, LocalDate birthDate, Set<Language> languages) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gitHub = gitHub;
		this.birthDate = birthDate;
		this.languages = languages;
		id = ++counter;
	}

	public Programmer(String firstName, String lastName, String gitHub, LocalDate birthDate) {
		this(firstName, lastName, gitHub, birthDate, new HashSet<>());
	}

	public int getAge() {
		LocalDate now = LocalDate.now();
		Period p = Period.between(birthDate, now);
		return p.getYears();
	}
	
	public boolean addLanguage(Language toAdd) {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		if(languages.add(toAdd)) {
			toAdd.getProgrammers().add(this);
			return true;
		}
		return false;		
	}
	
	public boolean removeLanguage(Language toRemove) {
		if (toRemove == null) {
			throw new NullPointerException();
		}
		if(languages.remove(toRemove)) {
			toRemove.getProgrammers().remove(this);
			return true;
		}
		
		return false;	
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGitHub() {
		return gitHub;
	}

	public void setGitHub(String gitHub) {
		this.gitHub = gitHub;
	}

	public Set<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}

	public static int getCounter() {
		return counter;
	}

	public int getId() {
		return id;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + id;
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
		Programmer other = (Programmer) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Programmer [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", gitHub=");
		builder.append(gitHub);
		builder.append("]");
		return builder.toString();
	}
}
