package com.exemple.testing;

import org.junit.jupiter.api.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
//AssertJ a framework to perform JUnit's Assertion

public class CalculatorTest {
    private Calculator calculatorUnderTest;
    private static Instant startedAt;

    @BeforeEach
    void initCalculator(){
        System.out.println("call before each test");
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    void undefCalculator(){
        System.out.println("Call after each test");
        calculatorUnderTest = null;
    }

    //check All test timeout
    @BeforeAll
    static void initStartTestTime(){
        System.out.println("Call Before All test");
        startedAt = Instant.now();
    }
    @AfterAll
    static void showTestDuration(){
        System.out.println("call after all test");
        Instant endAt = Instant.now();
        long duration = Duration.between(startedAt, endAt).toMillis();

        System.out.println(MessageFormat.format("Tests Duration : {0} ms",duration));
    }

    @Test
    void testAddPositiveNumbers(){
        //Arrange: Organise inputs
        int a = 2;
        int b = 3;
       // Calculator calculator = new Calculator();

        //Act: call class and/or methode to test
        int somme = calculatorUnderTest.add(a,b);

        //Assert: check output
        //assertEquals(5, somme); JUnit
        assertThat(somme).isEqualTo(5); //AssertJ
    }

    @Test
    void testMultiplyNumbers(){
        //Arrange
        int a = 10;
        int b = 2;
        //Calculator calculator = new Calculator();
        //Act
        int produit = calculatorUnderTest.multiply(a,b);
        //Assert
        //assertEquals(20,produit);
        assertThat(produit).isEqualTo(20);
    }

    //Manipulate input and output using parametrizedTest
    @ParameterizedTest(name = "{0} x 0 should be equal to 0")// optional , it improve the display format
    @ValueSource(ints = {1, 2, 42, 1000, 254752})
    void testMultiplyNumbersByZero(int arg){
        //Arrange - everything  is ready!!!

        //Act -- Multiply by Zero
        int actualResult = calculatorUnderTest.multiply(arg,0);

        //Assert -- it's always worth Zero
        //assertEquals(0, actualResult);
        assertThat(actualResult).isEqualTo(0);
    }

    //multiple parameter
    @ParameterizedTest(name ="{0} + {1} should equal to {2}")
    @CsvSource({"1,1,2", "5,3,8","0,100,100"})
    void testMultipleAddPositiveNumbers(int arg1, int arg2, int expectResult){
        //Arrange---  everything is OK
        //Act
        int actualResult = calculatorUnderTest.add(arg1,arg2);
        //Assert
        //assertEquals(expectResult,actualResult);
        assertThat(actualResult).isEqualTo(expectResult);
    }

    @Test
    void testDigitSetNumber(){
        //GIVEN
        int number = 95897;

        //WHEN
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);

        //THEN
        assertThat(actualDigits).containsExactlyInAnyOrder(5, 7, 8, 9);
    }

}
