package edu.dbubenheim.projecteuler;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Problem 1
 *
 * Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * @author dbubenheim
 */
public class MultiplesBelow3And5 {

    public static void main2(String[] args) {
        sumMultiplesOf3AndFiveBelow(10);
        sumMultiplesOf3AndFiveBelow(100);
        sumMultiplesOf3AndFiveBelow(1000);

        wtf();

        withStreams();


        System.out.println(IntStream.range(1, 1000).filter(isMultiple()).sum());
    }

    public static long sumMultiplesOf3AndFiveBelow(final long number) {

        final long before = System.nanoTime();
        System.out.print("calculating sum of multiples of 3 and 5 below " + number + "...");
        long sum = 0;

        if (number <= 0) {
            return 0;
        }

        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.print(" finished. Answer is " + sum);
        final long after = System.nanoTime();
        System.out.println(". Took " + ((after - before)) + "ns");
        return sum;
    }

    public static void wtf() {
        final long before = System.nanoTime();
        int n;
        int i = 0;
        int d[] = new int[]{3, 2, 1, 3, 1, 2, 3};
        int t = 0;
        for (n = 0; n < 1000; n += d[i++ % 7]) {
            t += n;
        }
        System.out.print(String.format("Sum: %d", t));
        final long after = System.nanoTime();
        System.out.println(". Took " + ((after - before)) + "ns");
    }


    public static void withStreams() {
        final long before = System.nanoTime();
        final int sum = IntStream.range(1, 1000).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
        System.out.print(String.format("Sum is: %d", sum));
        final long after = System.nanoTime();
        System.out.println(". Time: " + ((after - before)) + "ns");
    }

//    private static IntPredicate isMultiple() {
//        return (i -> i % 3 == 0 || i % 5 == 0);
//    }


    public static void main(String... args) {
        final int sum = IntStream.range(1, 1000).filter(isMultiple()).sum();
        System.out.println(sum);
    }

    private static IntPredicate isMultiple() {
        return (i -> i % 3 == 0 || i % 5 == 0);
    }
}