package org.howard.edu.lsp.finalExam;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class MapUtilitiesTest {
	//to test MapUtilities's commonKeyValuePairs method, we will find how many times students got the same final grade each semester in a school year
	//each "gradebook" contains a map of student names as keys and their grades as values
	//the two semester gradebooks will then be compared to find common pairs.
	
	//first initializing the two maps as global variables for all tests
	HashMap<String,String> semesterOneGradebook;
	HashMap<String,String> semesterTwoGradebook;
	
	
	
	//before each test it clears and instantiates each map
	@BeforeEach
	void setUp() throws Exception {
		semesterOneGradebook = new HashMap<>();
		semesterTwoGradebook = new HashMap<>();
	}

	
	//tests if the common pairs function works with two valid maps
	@Test
	@DisplayName("Test for map with valid entries")
	void pairsTest() throws NullMapException {
		semesterOneGradebook.put("Mallory", "72");
		semesterOneGradebook.put("Rob", "80");
		semesterOneGradebook.put("Kim", "95");
		semesterOneGradebook.put("Tim", "86");
		semesterOneGradebook.put("Stacy", "100");
		semesterTwoGradebook.put("Tim", "70");
		semesterTwoGradebook.put("Stacy", "100");
		semesterTwoGradebook.put("Kim", "95");
		semesterTwoGradebook.put("Rob", "79");
		semesterTwoGradebook.put("Mallory", "72");
		//should return 3 common pairs
		Assertions.assertEquals(3,MapUtilities.commonKeyValuePairs(semesterOneGradebook, semesterTwoGradebook));
	}
	
	//each map needs to have the same keys for there to be commonKeyValuePairs 
	@Test
	@DisplayName("Test for map with invalid entries")
	void invalidTest() {
		semesterOneGradebook.put("Mallory", "72");
		semesterOneGradebook.put("Rob", "80");
		semesterOneGradebook.put("Kim", "95");
		semesterOneGradebook.put("Tim", "86");
		semesterOneGradebook.put("Stacy", "100");
		semesterTwoGradebook.put("John", "88");
		semesterTwoGradebook.put("Keith", "60");
		semesterTwoGradebook.put("Kim", "95");
		semesterTwoGradebook.put("Rob", "79");
		semesterTwoGradebook.put("Mallry", "72");
		Assertions.assertFalse(semesterOneGradebook.entrySet().containsAll(semesterTwoGradebook.entrySet()));

	}
	
	//tests if NullMapException was thrown
	@Test
	@DisplayName("Test for map with null entries")
	void nullTest() {
		semesterOneGradebook.put(null, null);
		semesterTwoGradebook.put("Kim", "95");
		semesterTwoGradebook.put("Rob", "79");

		NullMapException thrown = Assertions.assertThrows(NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(semesterOneGradebook, semesterTwoGradebook);
		} );
		Assertions.assertEquals("One or both maps are null!", thrown.getMessage());
	
	}
	
	//tests if one of the maps is empty/becomes empty
	@Test
	@DisplayName("Test for maps that are empty")
	void emptyTest() throws NullMapException {
		semesterOneGradebook.put("Mallory", "72");
		semesterOneGradebook.put("Jon", "80");
		semesterOneGradebook.put("Claire", "95");
		semesterOneGradebook.put("Steve", "86");
		semesterTwoGradebook.put("Mallory", "72");
		semesterTwoGradebook.put("Jon", "72");
		semesterTwoGradebook.put("Claire", "95");
		semesterTwoGradebook.put("Steve", "86");
		semesterOneGradebook.clear();
		assertEquals(semesterTwoGradebook.isEmpty()||semesterOneGradebook.isEmpty(), true);

	}
	//tests if the common pair count updates when maps are altered
	@Test
	@DisplayName("Test for common pairs after entries are altered")
	void deletedEntryTest() throws NullMapException {
		int count1 = 0;
		int count2 = 0;
		semesterOneGradebook.put("Jane", "72");
		semesterOneGradebook.put("Lauren", "70");
		semesterOneGradebook.put("Kim", "95");
		semesterOneGradebook.put("Tim", "86");
		semesterOneGradebook.put("Stacy", "100");
		semesterTwoGradebook.put("Tim", "86");
		semesterTwoGradebook.put("Stacy", "100");
		semesterTwoGradebook.put("Kim", "95");
		semesterTwoGradebook.put("Lauren", "80");
		semesterTwoGradebook.put("Jane", "72");
		count1 = MapUtilities.commonKeyValuePairs(semesterOneGradebook, semesterTwoGradebook);
		semesterOneGradebook.replace("Tim","50");
		semesterTwoGradebook.remove("Jane","72");
		count2 = MapUtilities.commonKeyValuePairs(semesterOneGradebook, semesterTwoGradebook);

		Assertions.assertNotEquals(count1,count2);
	}
	

}
