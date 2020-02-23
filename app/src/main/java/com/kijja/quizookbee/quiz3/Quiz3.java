package com.kijja.quizookbee.quiz3;

public class Quiz3 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 8, 2, 6, 5, 3, 5, 0};

        int[] getMaxTwo = GetMaxTwo(numbers);

        System.out.print(String.format("[%d,%d]", getMaxTwo[0], getMaxTwo[1]));
    }

    private static int[] GetMaxTwo(int[] numbers) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int x : numbers) {
            if (x > first) {
                second = first;
                first = x;
            } else if (x > second) {
                second = x;
            }
        }

        int[] maxNumbers = new int[2];
        maxNumbers[0] = first;
        maxNumbers[1] = second;

        return maxNumbers;
    }
}
