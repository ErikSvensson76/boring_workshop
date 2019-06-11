package se.lexicon.erik.programmers_hope.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import se.lexicon.erik.programmers_hope.model.Programmer;

public class ProgrammerRepoImpl implements ProgrammerRepo {
	
	private static List<Programmer> programmers = new ArrayList<>();
	
	public Programmer save(Programmer toSave) {
		if(!programmers.contains(toSave)) {
			programmers.add(toSave);
		}
		return toSave;
	}
	
	public boolean remove(int id) {
		
		Programmer programmer = findById(id);
		if (programmer == null) {
			return false;
		}
		
		return programmers.remove(programmer);
		
	}
	
	public Programmer findById(int id) {
		
		for (Programmer p : programmers) {
			if(p.getId() == id) {
				return p;
			}
			
		}
		return null;
	}
	
	public Set<Programmer> findByAgeAboveEquals(int age) {
		Set<Programmer> result = new HashSet<>();
		
		for (Programmer p : programmers) {
			if(p.getAge() >= age)
				result.add(p);
		}		
		return result;		
	}
	
	public Set<Programmer> findByAgeBelowEquals(int age) {
		Set<Programmer> result = new HashSet<>();
		
		for (Programmer p : programmers) {
			if(p.getAge() <= age)
				result.add(p);
		}
		
		return result;		
	}
	
	public Programmer findByGitHubRepo(String repo) {
		
		for (Programmer p : programmers) {
			if(p.getGitHub().equalsIgnoreCase(repo)) {
				return p;
			}
			
		}
		return null;
	}
	
	public static void clear() {
		programmers.clear();
	}

}







