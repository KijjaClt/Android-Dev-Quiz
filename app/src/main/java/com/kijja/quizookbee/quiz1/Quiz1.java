package com.kijja.quizookbee.quiz1;

public class Quiz1 {
    public static void main(String[] args) {
        String s1 = new String("Test");
        String s2 = new String("Test");
        if (s1 == s2)
            System.out.println("Same");
        if (s1.equals(s2))
            System.out.println("Equals");
    }
}
