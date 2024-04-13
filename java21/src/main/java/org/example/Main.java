package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(System.out::println);
        System.out.println("Hello world!");
    }
}