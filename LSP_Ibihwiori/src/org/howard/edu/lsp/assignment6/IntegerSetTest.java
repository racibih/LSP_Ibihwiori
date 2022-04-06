package org.howard.edu.lsp.assignment6;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

	IntegerSet set1;
	IntegerSet set2;

	@BeforeEach
	void setUp() throws Exception {
		set1 = new IntegerSet();
		set2 = new IntegerSet();
	}
	
	@Test
	@DisplayName("Test case for clear")

	public void testClear() {
		set1.add(6);
		set1.add(3);
		set1.add(0);
		set1.clear();
		assertTrue(set1.isEmpty());
	}

	@Test
	@DisplayName("Test case for length")

	public void testLength() {
		set2.add(2);
		set2.add(4);
		assertEquals(2, set2.length());
	}

	@Test
	@DisplayName("Test case for equals")

	public void testEquals() {
	       set1.add(15);
	       set1.add(2);
	       set1.add(6);
	       
	       set2.add(6);
	       set2.add(2);
	       set2.add(15);

	       assertEquals(true, set1.equals(set2));

	
	
	}


	@Test
	@DisplayName("Test case for contains")

	public void testContains() {
 
	set2.add(24);
	set2.add(88);
	set2.add(14);
	assertEquals(false,set2.contains(12));
	}

	@Test
	@DisplayName("Test case for largest")

	public void testLargest() {
		set1.add(152);
	       set1.add(112);
	       set1.add(113);
	       int rightans = 0;
		try {
			rightans = set1.largest();
		} catch (IntegerSetException e) {
			e.printStackTrace();
		}
;	       assertEquals(152,rightans);
	}

	@Test
	@DisplayName("Test case for smallest")

	public void testSmallest() {
		 set1.add(19);
	       set1.add(20);
	       set1.add(3);
	       set1.add(5);
	       int expctd = 0;
			try {
				expctd = set1.smallest();
			} catch (IntegerSetException e) {
				e.printStackTrace();
			};
			assertEquals(3,expctd);
		
	}

	@Test
	@DisplayName("Test case for add")

	public void testAdd() {
	       set1.add(10);
	       set1.add(5);
	       set1.add(300);
	       set1.add(1);
	       set1.add(3638);
	       String set1string = set1.toString();
	       assertEquals("[10, 5, 300, 1, 3638]", set1string);
	       }

	@Test
	@DisplayName("Test case for remove")

	public void testRemove() {
		 
	       set1.add(5);
	       set1.add(30);
	       set1.add(1);
	       set1.add(10);
	       set1.add(36);
	       set1.remove(3);
	       
	       assertFalse(set1.contains(3));
		
		
		
	}

	@Test
	@DisplayName("Test case for union")
	public void testUnion() {
		 set1.add(90);
	       set1.add(511);
	       set1.add(3220);
	       set1.add(7);
	       set1.add(338);
	       set1.add(10);
	       set2.add(7);
	       set2.add(8);
	       set2.add(86);
	       set2.add(33);
	       set2.add(99);
	       set2.add(3);
	       
	       set1.union(set2);
	      assertTrue(set2.contains(86));
	}

	@Test
	@DisplayName("Test case for intersect")
	public void testIntersect() {
		 set1.add(90);
	       set1.add(511);
	       set1.add(3220);
	       set1.add(7);
	       set1.add(338);
	       set1.add(10);
	       set2.add(7);
	       set2.add(8);
	       set2.add(86);
	       set2.add(338);
	       set2.add(99);
	       set2.add(3);
	       
	       set2.intersect(set1);
	       assertFalse(set2.contains(99));
	       }

	@Test
	@DisplayName("Test case for difference")
	public void testDiff() {
		 set1.add(90);
	       set1.add(51);
	       set1.add(930);
	       set1.add(8);
	       set1.add(338);
	       set1.add(10);
	       set2.add(8);
	       set2.add(60);
	       set2.add(6);
	       set2.add(3);
	       set2.add(10);
	       set2.add(45);
	   
	       set2.union(set1);
	       set2.diff(set1);
	       assertFalse(set2.contains(338));
	}

	@Test	
	@DisplayName("Test case for isEmpty")
	
	public void testIsEmpty() {
		
		 set2.add(1000);
	       set2.add(9);
	       set2.add(3);
	       set2.clear();
	       assertTrue(set2.isEmpty());
	       }
	public void testIsEmpty2() {
		
		 set2.add(1000);
	       set2.add(9);
	       set2.add(3);
	       assertFalse(set2.isEmpty());
	       }

	@Test
	@DisplayName("Test case for toString")

	void testToString() {
	       set1.add(400);
	       set1.add(20);
	       set1.add(0);
	       String shldsay = "[400, 20, 0]";
	       assertEquals(shldsay, set1.toString());
	       }

}
