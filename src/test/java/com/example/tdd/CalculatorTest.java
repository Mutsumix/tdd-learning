package com.example.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Calculator Tests")
class CalculatorTest {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {
        
        @Test
        @DisplayName("Should add two positive numbers correctly")
        void testAddPositiveNumbers() {
            // Given
            int a = 5;
            int b = 3;
            
            // When
            int result = calculator.add(a, b);
            
            // Then
            assertThat(result).isEqualTo(8);
        }
        
        @Test
        @DisplayName("Should add negative numbers correctly")
        void testAddNegativeNumbers() {
            // Given
            int a = -5;
            int b = -3;
            
            // When
            int result = calculator.add(a, b);
            
            // Then
            assertThat(result).isEqualTo(-8);
        }
        
        @Test
        @DisplayName("Should add zero correctly")
        void testAddWithZero() {
            // Given
            int a = 5;
            int b = 0;
            
            // When
            int result = calculator.add(a, b);
            
            // Then
            assertThat(result).isEqualTo(5);
        }
    }
    
    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {
        
        @Test
        @DisplayName("Should subtract two numbers correctly")
        void testSubtract() {
            // Given
            int a = 10;
            int b = 4;
            
            // When
            int result = calculator.subtract(a, b);
            
            // Then
            assertThat(result).isEqualTo(6);
        }
        
        @Test
        @DisplayName("Should handle negative results")
        void testSubtractNegativeResult() {
            // Given
            int a = 3;
            int b = 5;
            
            // When
            int result = calculator.subtract(a, b);
            
            // Then
            assertThat(result).isEqualTo(-2);
        }
    }
    
    @Nested
    @DisplayName("Multiplication Tests")
    class MultiplicationTests {
        
        @Test
        @DisplayName("Should multiply two positive numbers")
        void testMultiplyPositive() {
            // Given
            int a = 4;
            int b = 3;
            
            // When
            int result = calculator.multiply(a, b);
            
            // Then
            assertThat(result).isEqualTo(12);
        }
        
        @Test
        @DisplayName("Should multiply by zero")
        void testMultiplyByZero() {
            // Given
            int a = 5;
            int b = 0;
            
            // When
            int result = calculator.multiply(a, b);
            
            // Then
            assertThat(result).isEqualTo(0);
        }
        
        @Test
        @DisplayName("Should multiply negative numbers")
        void testMultiplyNegative() {
            // Given
            int a = -4;
            int b = -3;
            
            // When
            int result = calculator.multiply(a, b);
            
            // Then
            assertThat(result).isEqualTo(12);
        }
    }
    
    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {
        
        @Test
        @DisplayName("Should divide two numbers correctly")
        void testDivide() {
            // Given
            int a = 10;
            int b = 2;
            
            // When
            double result = calculator.divide(a, b);
            
            // Then
            assertThat(result).isEqualTo(5.0);
        }
        
        @Test
        @DisplayName("Should handle division with decimal result")
        void testDivideDecimal() {
            // Given
            int a = 7;
            int b = 2;
            
            // When
            double result = calculator.divide(a, b);
            
            // Then
            assertThat(result).isEqualTo(3.5);
        }
        
        @Test
        @DisplayName("Should throw exception when dividing by zero")
        void testDivideByZero() {
            // Given
            int a = 10;
            int b = 0;
            
            // When & Then
            assertThrows(IllegalArgumentException.class, () -> {
                calculator.divide(a, b);
            });
            
            // Alternative using AssertJ
            assertThatThrownBy(() -> calculator.divide(a, b))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Division by zero is not allowed");
        }
    }
    
    @Nested
    @DisplayName("Power Tests")
    class PowerTests {
        
        @Test
        @DisplayName("Should calculate power correctly")
        void testPower() {
            assertThat(calculator.power(2, 3)).isEqualTo(8);
            assertThat(calculator.power(5, 2)).isEqualTo(25);
            assertThat(calculator.power(10, 0)).isEqualTo(1);
        }
        
        @Test
        @DisplayName("Should throw exception for negative exponent")
        void testNegativeExponent() {
            assertThatThrownBy(() -> calculator.power(2, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Negative exponents are not supported");
        }
    }
}