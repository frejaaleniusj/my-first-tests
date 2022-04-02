package com.in28minutes.junit.helper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.Locale;

class StringTestTest {

    @BeforeAll
    static void beforeAll () {
        System.out.println("Initialize connection to database");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Close connections to database");
    }

    @BeforeEach
    void beforeEach(TestInfo info) {
        System.out.println("Initialize Test Data for " + info.getDisplayName());
    }

    @AfterEach
    void afterEach(TestInfo info){
        System.out.println("Clean up after Test Data for " + info.getDisplayName());
    }

    @Test
    @DisplayName ("Check if ABCD is 4 characters in length")
    void length_basic() {

        int actualLength = "ABCD".length();
        int excpectedLength = 4;

        assertEquals(excpectedLength, actualLength);
    }

    @Test
    @DisplayName("When null, throw an exception")
    void length_exception() {

       String str = null;
       assertThrows(NullPointerException.class,
               () -> {
                str.length();
               }
               );

    }

    @Test
    @DisplayName("Check if abcd turns to upper case = ABCD")
    void toUpperCase_basic() {
        String str = "abcd";
        String result = str.toUpperCase();
        assertEquals("ABCD", result);
        //assertNotNull(result);
        //assertNull(result);

    }

    @Test
    @DisplayName("Check if string abcdefgh contains characters ijk")
    void contains_basic() {
        String str = "abcdefgh";
        boolean result = str.contains("ijk");
        assertEquals(false, result);
        //assertFalse(result);
        //assertTrue(result);

    }

    @Test
    @DisplayName("Check if string is correctly split and inserted into an array")
    void split_basic (){
        String str = "abc def ghi";
        String actualresult[] = str.split(" ");
        String[] expectedResult = new String[] {"abc", "def", "ghi"};

        assertArrayEquals(expectedResult, actualresult);

    }

    @Test
    @DisplayName("Check if string is greater than zero")
    void length_greater_than_zero() {
        assertTrue("ABCD".length()>0);
        assertTrue("ABC".length()>0);
        assertTrue("A".length()>0);
        assertTrue("DEF".length()>0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABCD", "ABC", "A", "DEF"})
    @DisplayName("Check if string is greater than zero with parameterized test")
    void length_greater_than_zero_using_parameterized_test(String str) {
        assertTrue(str.length()>0);

    }

    @ParameterizedTest (name = "{0} toUpperCase is {1}")
    @CsvSource(value= {"abcd, ABCD", "abc, ABC", "'',''", "abcdefg, ABCDEFG"})
    void upperCase(String word, String capitalizedWord) {
        assertEquals(capitalizedWord, word.toUpperCase());

    }

    @ParameterizedTest(name = "{0} length is {1}")
    @CsvSource(value= {"abcd, 4", "abc, 3", "'',0", "abcdefg, 7"})
    void length(String word, int expectedLength) {
        assertEquals(expectedLength, word.length());

    }

    @Test
    @Disabled
    void performanceTest() {
        assertTimeout(Duration.ofSeconds(5),
                () -> {
                    for (int i = 0; i <= 1000000; i++) {
                        int j = i;
                        System.out.println(j);
                    }
                }
        );
    }

    @Nested
    @DisplayName("For an empty string")
    class EmptyStringTests {

        @BeforeEach
        void setToEmpty() {
            String str = "";
        }

        @Test
        @DisplayName("Length should be zero")
        void lengthIsZero() {
            String str = "";
            assertEquals(0, str.length());
        }

        @Test
        @DisplayName("Upper case is empty")
        void upperCaseIsEmpty () {
            String str = "";
            assertEquals("",str.toUpperCase());
        }
    }

    @Nested
    @DisplayName("For large strings")
    class LargeStringTests {

        @BeforeEach
        void setToALargeString() {
            String str = "hkrsjhfgdlfjhgldxrhgldrhg";
        }
        }

        @Test
        public void testArraySort_Ran() {
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);

        }
    }