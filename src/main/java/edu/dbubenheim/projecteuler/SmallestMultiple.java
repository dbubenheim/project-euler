package edu.dbubenheim.projecteuler;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Problem 5
 *
 * Smallest multiple
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * @author daniel.bubenheim@gmail.com
 */
public class SmallestMultiple {

    public static void main(String[] args) {
        smallesMultipleOf(10);
        smallesMultipleOf(11);
        smallesMultipleOf(12);
        smallesMultipleOf(13);
        smallesMultipleOf(14);
        smallesMultipleOf(15);
        smallesMultipleOf(16);
        smallesMultipleOf(17);
        smallesMultipleOf(18);
        smallesMultipleOf(19);
        smallesMultipleOf(20);
    }

    public static int smallesMultipleOf(final int limit) {
        int smallestMultiple = limit;
        while (isNotDivisible(smallestMultiple, limit)) {
            smallestMultiple++;
        }
        System.out.printf("smallest multiple of %s is: %s%n", limit, smallestMultiple);
        return smallestMultiple;
    }

    private static boolean isNotDivisible(final int currentMultiple, final int limit) {
        return IntStream.rangeClosed(1, limit).anyMatch(isNotDivisible(currentMultiple));
    }

    public static final IntPredicate isNotDivisible(final int currentMultiple) {
        return i -> (currentMultiple % i != 0);
    }
}
