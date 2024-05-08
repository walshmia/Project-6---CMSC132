package tests;

import org.junit.*;

import bslt.BSLT;
import bslt.EmptyBSLT;
import bslt.EmptyBSLTException;
import bslt.NonemptyBSLT;

import static org.junit.Assert.*;

import java.util.Arrays;

public class StudentTests {

  @Test public void testingInsertion() {
	  
	  try {
		  TestData.sampleTree1().insertKeyWithValue(null, null);
		  TestData.sampleTree1().insertKeyWithValue(12, null);
	  } catch (IllegalArgumentException e) {
		  System.out.println(e.getMessage());
	  }
	  
	 assertEquals("1+d 5+o 6+l 7+p 11+h 13+i 14+m 17+n ", 
			 TestData.sampleTree1().insertKeyWithValue(14, 'm').toString());
	 assertEquals(8,
			 TestData.sampleTree1().insertKeyWithValue(14, 'm').sizeOfTree());
	 
	 assertEquals("1+g 5+o 6+l 7+p 11+h 13+i 17+n ", 
			 TestData.sampleTree1().insertKeyWithValue(1, 'g').toString());
  }
  
  @Test public void testingLookup() {
	  
	  assertTrue('p' == TestData.sampleTree1().lookupValueForKey(7));
	  
	  assertTrue(TestData.sampleTree1().lookupValueForKey(22) == null);
	  
	  assertTrue(TestData.sampleTree1().lookupValueForKey(6) == 'l');
	  
	  try {
		  TestData.sampleTree1().lookupValueForKey(null);
	  } catch (IllegalArgumentException e) {
		  System.out.println(e.getMessage());
	  }
  }

  @Test public void testingGetSmallAndLarge() {
	  try {
		  assertTrue(TestData.sampleTree1().largestKey() == 17);
		  
		  assertTrue(TestData.sampleTree1().smallestKey() == 1);
	  } catch (EmptyBSLTException e) {
		  System.out.println("no max or min");
	  }
	  
	  BSLT tree = EmptyBSLT.getInstance();
	  try {
		  tree.smallestKey();
	  } catch (EmptyBSLTException e) {
		  System.out.println("tree is empty!");
	  }
  }
  
  @Test public void testingParent() {
	  
	  assertTrue(EmptyBSLT.getInstance().parent(17) == null);
	  
	  try {
		  TestData.sampleTree1().parent(null);
	  } catch (IllegalArgumentException e) {
		  System.out.println(e.getMessage());
	  }
	  
	  assertTrue(TestData.sampleTree1().parent(1) == 5);
	  
	  assertTrue(TestData.sampleTree1().parent(11) == 13);
  }
  
  @Test public void testingRemove() {
	  assertEquals("1+d 5+o 7+p 11+h 13+i 17+n ", 
				 TestData.sampleTree1().removeKeyWithValue(6).toString());
	  
	  assertEquals("1+d 5+o 6+l 7+p 11+h 17+n ", 
			  TestData.sampleTree1().removeKeyWithValue(13).toString());
	  
	  try {
		  TestData.sampleTree1().removeKeyWithValue(null);
	  } catch (IllegalArgumentException e) {
		  System.out.println(e.getMessage());
	  }
	  
	  BSLT tree = TestData.createBSLT(Arrays.asList(7, 13, 11, 17),
              Arrays.asList('p', 'o', 'i', 'd'));
	  assertEquals("7+p 11+i 17+d ", tree.removeKeyWithValue(13).toString());
  }
}
