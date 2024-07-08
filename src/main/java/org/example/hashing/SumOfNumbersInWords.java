package org.example.hashing;

import java.util.HashMap;
import java.util.Map;

public class SumOfNumbersInWords {

    public static void main(String[] args) {
        String input = "rwffonewofnwthreeonefourfrnwnminusonesix";
        int result = sumOfNumbersInWords(input);
        System.out.println("Sum of all numbers: " + result);
    }

    public static int sumOfNumbersInWords(String s) {
        // Map of number words to their integer values
        Map<String, Integer> numberMap = new HashMap<>();
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);

        int sum = 0;
        boolean negative = false;
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            word.append(s.charAt(i));

            // Check for "minus"
            if (word.toString().equals("minus")) {
                negative = true;
                word.setLength(0);
            } else if (numberMap.containsKey(word.toString())) {
                int number = numberMap.get(word.toString());
                sum += negative ? -number : number;
                word.setLength(0);
                negative = false;
            }
        }
        return sum;
    }
}
