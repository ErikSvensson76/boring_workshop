package se.lexicon.erik.programmers_hope.data;

import java.util.Set;

import se.lexicon.erik.programmers_hope.model.Programmer;

public interface ProgrammerRepo {

	Programmer save(Programmer toSave);

	boolean remove(int id);

	Programmer findById(int id);

	Set<Programmer> findByAgeAboveEquals(int age);

	Set<Programmer> findByAgeBelowEquals(int age);

	Programmer findByGitHubRepo(String repo);

}