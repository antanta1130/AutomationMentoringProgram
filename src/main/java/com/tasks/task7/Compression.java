package com.tasks.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.testng.internal.collections.Pair;

import com.tasks.task7.exeptions.InputValidationExeption;

public class Compression {

    public String compress(String inputString) throws InputValidationExeption {
        List<Pair<Character, Integer>> LettersAndItsQuantityList;
        StringBuilder outputString = new StringBuilder();

        inputStringValidationForCompression(inputString);
        LettersAndItsQuantityList = formMapForCompression(inputString);
        for (Pair<Character, Integer> entry : LettersAndItsQuantityList) {
            if (entry.second() == 1) {
                outputString.append(entry.first());
            } else if (entry.second() <= 9) {
                outputString.append(entry.second()).append(entry.first());
            } else {
                for (int i = 0; i < entry.second() / 9; i++) {
                    outputString.append(9).append(entry.first());
                }
                if (entry.second() % 9 != 0) {
                    outputString.append(entry.second() % 9).append(entry.first());
                }
            }
        }

        return outputString.toString();
    }

    public String decompress(String inputString) throws InputValidationExeption {
        StringBuilder outputString = new StringBuilder();
        inputStringValidationForDecompression(inputString);
        int c = 1;

        for (int i = 0; i < inputString.length(); i++) {
            char symbol = inputString.charAt(i);

            if (Character.isDigit(symbol)) {
                c = symbol - '0';
            } else {
                for (int j = 0; j < c; j++) {
                    outputString.append(symbol);
                }
                c = 1;
            }
        }

        return outputString.toString();
    }

    private void inputStringValidationForCompression(String inputString) throws InputValidationExeption {
        if (inputString.length() == 0) {
            throw new InputValidationExeption("Input string is empty");
        }

        for (int i = 0; i < inputString.length(); i++) {
            if (!Character.isLetter(inputString.charAt(i))) {
                throw new InputValidationExeption("Input string should contain only letters");
            }
        }
    }

    private void inputStringValidationForDecompression(String inputString) throws InputValidationExeption {
        if (inputString.length() == 0) {
            throw new InputValidationExeption("Input string is empty");
        }
        if (Pattern.compile("(\\d{2,}|\\d$|[^a-zA-Z0-9]+)").matcher(inputString).find()) {
            throw new InputValidationExeption("Input string should contain only [0-9a-zA-Z]");
        }
    }

    private List<Pair<Character, Integer>> formMapForCompression(String inputString) {
        List<Pair<Character, Integer>> LettersAndItsQuantityList = new ArrayList<Pair<Character, Integer>>();
        char letter = inputString.charAt(0);
        int occuranceOfCurrentLetter = 1;
        int length = inputString.length();

        for (int i = 1; i < length; i++) {
            letter = inputString.charAt(i);

            if (letter == inputString.charAt(i - 1)) {
                occuranceOfCurrentLetter++;
            } else {
                LettersAndItsQuantityList.add(Pair.create(inputString.charAt(i - 1), occuranceOfCurrentLetter));
                occuranceOfCurrentLetter = 1;
            }
        }

        LettersAndItsQuantityList.add(Pair.create(inputString.charAt(length - 1), occuranceOfCurrentLetter));
        return LettersAndItsQuantityList;
    }
}