package se.lexicon.erik.programmers_hope.model;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import se.lexicon.erik.programmers_hope.data.ProgrammerRepo;
import se.lexicon.erik.programmers_hope.data.ProgrammerRepoImpl;
import static org.junit.Assert.*;

public class ProgrammerRepoTest {
	
	ProgrammerRepo underTest;
	private int p1Id;
	
	@Before
	public void setup() {
		underTest = new ProgrammerRepoImpl();
		ProgrammerRepoImpl.clear();
		Programmer p1 = new Programmer("Test", "Testsson", "Testy1", LocalDate.parse("2000-01-01"));
		p1Id = p1.getId();
		Programmer p2 = new Programmer("Test1", "Testsson", "Testy1", LocalDate.parse("2000-01-01"));
		Programmer p3 = new Programmer("Test2", "Testsson", "Testy2", LocalDate.parse("1990-01-01"));
		Programmer p4 = new Programmer("Test3", "Testsson", "Testy3", LocalDate.parse("1980-01-01"));
		Programmer p5 = new Programmer("Test4", "Testsson", "Testy4", LocalDate.parse("1979-01-01"));
		
		Language l1 = new Language("Java");
		Language l2 = new Language("C#");
		Language l3 = new Language("C++");
		Language l4 = new Language("Fortran");
		Language l5 = new Language("JavaScript");
		
		p1.addLanguage(l4);
		p2.addLanguage(l4);
		p3.addLanguage(l1);
		p3.addLanguage(l3);
		p5.addLanguage(l2);
		p4.addLanguage(l5);
		
		underTest.save(p1);
		underTest.save(p2);
		underTest.save(p3);
		underTest.save(p4);
		underTest.save(p5);
	}

	
	@Test
	public void givenP1IdShouldReturnProgrammer() {
		Programmer result = underTest.findById(p1Id);
		
		assertEquals(p1Id, result.getId());
	}
}
