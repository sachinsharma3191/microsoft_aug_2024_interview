package org.example.hashing;

import java.util.HashMap;
import java.util.Map;

public class WordNumberSum {

    private static final Map<String, Integer> numberMap = new HashMap<>();

    static {
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
    }

    public static int sumOfNumbersInString(String str) {
        int result = 0;
        int currentNumber = 0;
        boolean negative = false;
        StringBuilder currentWord = new StringBuilder();
        String lastOperation = "plus"; // Default to addition

        for (int i = 0; i < str.length(); i++) {
            currentWord.append(str.charAt(i));

            if (currentWord.toString().endsWith("minus")) {
                negative = true;
                currentWord.setLength(0); // Clear the current word
                lastOperation = "minus";
            } else if (currentWord.toString().endsWith("plus")) {
                currentWord.setLength(0);
                lastOperation = "plus";
            } else if (currentWord.toString().endsWith("times")) {
                currentWord.setLength(0);
                lastOperation = "times";
            } else if (currentWord.toString().endsWith("dividedby")) {
                currentWord.setLength(0);
                lastOperation = "dividedby";
            }

            if (numberMap.containsKey(currentWord.toString())) {
                currentNumber = numberMap.get(currentWord.toString());
                if (negative) {
                    currentNumber = -currentNumber;
                    negative = false;
                }

                switch (lastOperation) {
                    case "plus":
                        result += currentNumber;
                        break;
                    case "minus":
                        result -= currentNumber;
                        break;
                    case "times":
                        result *= currentNumber;
                        break;
                    case "dividedby":
                        if (currentNumber != 0) {
                            result /= currentNumber;
                        } else {
                            System.out.println("Division by zero encountered!");
                            return 0; // Early return or handle appropriately
                        }
                        break;
                }

                currentWord.setLength(0); // Clear the current word after using it
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "onetwoplusthreefourminusfiveonetimesfourdividedbytwo";
        int result = sumOfNumbersInString(str);
        System.out.println("The result of the operations in the string is: " + result);
    }
}

