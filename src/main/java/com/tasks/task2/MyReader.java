package com.tasks.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class MyReader {
    private final BufferedReader br;

    public MyReader(Reader in) {
        br = new BufferedReader(in);
    }

    public Map<String, Double> readDoubleValuesAndVerify(String[] names) throws IOException {
        Map<String, Double> result = new HashMap<String, Double>();
        String[] split;
        StringBuilder listOfNames = createListOfParameters(names);

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

    private StringBuilder createListOfParameters(String[] names) {
        StringBuilder listOfNames = new StringBuilder();

        for (String name : names) {
            listOfNames.append(name).append(", ");
        }

        listOfNames.deleteCharAt(listOfNames.length() - 2);
        return listOfNames;

    }
}
