package com.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    public static double readDoubleValueFromConsoleAndVerify(String name) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Enter double value: " + name + " = ");
            try {
                String s = br.readLine();
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
            }
        }

    }

}
