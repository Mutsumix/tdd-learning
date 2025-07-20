package com.example.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.*;

@DisplayName("StringCalculator Tests")
class StringCalculatorTest {
    
    private StringCalculator calculator = new StringCalculator();
    
    @Test
    @DisplayName("Should return 0 for empty string")
    void testEmptyString() {
        assertThat(calculator.add("")).isEqualTo(0);
    }
    
    @Test
    @DisplayName("Should return number itself for single number")
    void testSingleNumber() {
        assertThat(calculator.add("5")).isEqualTo(5);
        // このテストは失敗します（実装が間違っているため）
    }
    
    @Test
    @DisplayName("Should return sum for two numbers")
    void testTwoNumbers() {
        assertThat(calculator.add("1,2")).isEqualTo(3);
        // このテストも失敗します
    }
}