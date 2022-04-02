package com.in28minutes.junit.helper;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StringTestTest2 {
    StringTest helper = new StringTest();

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Tests are starting");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests completed");
    }

    @AfterEach
    public  void confirmTestIsDone() {
        System.out.println("Test is done");
    }


    @Test
    @DisplayName("Test if A is removed if A is in the 2 first positions")
    public void testTruncateAInFirst2Positions() {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));

    }

    @Test
    @DisplayName("Test if A is removed if A is in the 2 first positions #2")
    public void testTruncateAInFirst2Positions2() {
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    @DisplayName("Test if the first and last two characters are the same")
    public void testAreFirstAndLastTwoCharactersTheSame_basicNegativeScenario() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }

    @Test
    @DisplayName("Test if the first and last two characters are the same #2")
    public void testAreFirstAndLastTwoCharactersTheSame_basicTrueScenario() {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }

}