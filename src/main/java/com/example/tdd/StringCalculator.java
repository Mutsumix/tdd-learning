package com.example.tdd;

public class StringCalculator {
    
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        
        String[] nums = numbers.split(",");
        int sum = 0;
        
        for (String num : nums) {
            // バグ：意図的に間違った実装
            sum += Integer.parseInt(num.trim()) + 1; // +1は間違い
        }
        
        return sum;
    }
}