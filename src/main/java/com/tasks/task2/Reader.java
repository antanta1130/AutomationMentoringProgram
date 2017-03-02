package com.tasks.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Reader {
    public static Map<String, Double> readDoubleValueFromConsoleAndVerify(String[] names) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder listOfNames = new StringBuilder();
        Map<String, Double> result = new HashMap<String, Double>();
        String[] split;

        for (String name : names) {
            listOfNames.append(name).append(", ");
        }

        listOfNames.deleteCharAt(listOfNames.length() - 2);

        while (true) {
            System.out.println("Enter " + names.length + " double values separated by , in such sequence: " + listOfNames);
            try {
                String s = br.readLine();
                split = s.split(",");
                for (int i = 0; i < names.length; i++) {
                    result.put(names[i], Double.parseDouble(split[i]));
                }
                return result;

            } catch (NumberFormatException e) {
            }
        }
    }
}
