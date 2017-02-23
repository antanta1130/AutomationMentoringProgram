package com.tasks;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestDrive {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;


        while (flag) {
            System.out.println("Enter type of an equation which you would like to solve: linear/quadratic");
            try {
                String type = br.readLine();
                if ("linear".equalsIgnoreCase(type)) {
                    Tasks.task2();
                    flag = false;
                }

                if ("quadratic".equalsIgnoreCase(type)) {
                    Tasks.task1();
                    flag = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
