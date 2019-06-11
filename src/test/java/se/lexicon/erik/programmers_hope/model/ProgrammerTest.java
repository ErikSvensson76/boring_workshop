package se.lexicon.erik.programmers_hope.model;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProgrammerTest {
	
	private Programmer testObject;
	
	@Before
	public void setup() {
		testObject = new Programmer("Test", "Testsson","TestyTest87", LocalDate.parse("1999-01-01")); 
	}
	
	@Test
	public void givenNewLanguageShouldReturnTrue() {		 
		Language testLanguage = new Language("PHP");
		
		assertTrue(testObject.addLanguage(testLanguage));
		assertTrue(testObject.getLanguages().contains(testLanguage));
		assertTrue(testLanguage.getProgrammers().contains(testObject));		
	}
	
	@Test
	public void givenKnownLanguageToRemoveReturnTrue() {
		Language java = new Language("Java");
		Language cPlusPlus = new Language("C++");
		
		testObject.addLanguage(java);
		testObject.addLanguage(cPlusPlus);
		
		assertTrue(testObject.removeLanguage(cPlusPlus));
		assertFalse(testObject.getLanguages().contains(cPlusPlus));
		assertFalse(cPlusPlus.getProgrammers().contains(testObject));		
	}
	
	@Test
	public void removeNotKnownLanguageShouldReturnFalse() {
		Language java = new Language("Java");
		
		assertFalse(testObject.removeLanguage(java));
	}
	
	@Test
	public void addDuplicateShouldReturnFalse() {
		Language java = new Language("Java");
		
		testObject.addLanguage(java);
		assertFalse(testObject.addLanguage(java));
	}

}
