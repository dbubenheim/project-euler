package edu.dbubenheim.projecteuler;

/**
 * @author dbubenheim@communicode.de
 */
public class LargestPalindromeProduct {

    public static void main(String[] args) {

        findLargestPalindromeProduct(1);
        findLargestPalindromeProduct(2);
        findLargestPalindromeProduct(3);
    }

    public static int findLargestPalindromeProduct(final int digits) {

        if (digits < 0) {
            throw new IllegalArgumentException("digits must ot be negative");
        }

        int currentProduct;
        int largestPalindromeProduct = 0;
        int upperLimit = (int) Math.pow(10, digits);
        int lowerLimit = (int) Math.pow(10, digits - 1);
        for (int i = lowerLimit; i < upperLimit; i++) {
            for (int j = lowerLimit; j < upperLimit; j++) {
                currentProduct = i * j;
                if (isPalindrome(currentProduct) && currentProduct > largestPalindromeProduct) {
                    largestPalindromeProduct = currentProduct;
                }
            }
        }
        System.out.println(String.format("largest palindrome product is %s", largestPalindromeProduct));
        return largestPalindromeProduct;
    }


    private static int length(final int i) {
        if (i < 0) {
            throw new IllegalArgumentException("must ot be negative");
        }

        int length = 1;

        if (i < 10) {
            return length;
        }

        int tmp = i;
        do {
            length++;
        } while ((tmp = (tmp / 10 )) > 9);

        return length;
    }

    private static boolean isPalindrome(final int sum) {

        final int length = length(sum);
        final int[] digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[i] = sum / (int) Math.pow(10, i) % 10;
        }

        for (int i = 0; i < length; i++) {

            if (i > length / 2) {
                break;
            }

            if (!(digits[i] == digits[length - i - 1])){
                return false;
            }
        }
        return true;
    }
}
