package com.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    public static double readDoubleValueFromConsoleAndVerify(String name) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        double result = 0;
        boolean flag = true;

        while (flag) {
            System.out.print("Enter double value: " + name + " = ");
            try {
                s = br.readLine();
                result = Double.parseDouble(s);
                flag = false;
            } catch (NumberFormatException e) {
                flag = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;

    }

}
