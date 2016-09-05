package edu.dbubenheim.projecteuler;

import java.util.stream.IntStream;

/**
 * Problem 6
 *
 * Sum square difference
 *
 * The sum of the squares of the first ten natural numbers is,
 *
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 * @author daniel.bubenheim@gmail.com
 */
public class SumSquareDifference {

    public static void main(final String... args) {
        findSumSquareDifferenceOf(100);
    }

    public static void findSumSquareDifferenceOf(final int numbers) {

        final int sumOfSquares = IntStream.rangeClosed(1, numbers).map(a -> (int) Math.pow(a, 2)).sum();
        System.out.printf("sumOfSquares: %s%n", sumOfSquares);

        final int squareOfSums = (int) Math.pow(IntStream.rangeClosed(1, numbers).sum(), 2);
        System.out.printf("squareOfSums: %s%n", squareOfSums);

        final int difference = squareOfSums - sumOfSquares;
        System.out.printf("difference: %s%n", difference);
    }
}