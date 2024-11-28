package it.unimi.di.prog2.e06;

public class Sum {
    
    /** Private constructor to prevent instantiation */
    private Sum() {}

    /**
     * method that compute the sum of all elements of a given array of {@code int} 
     * if {@code numbers} is empty, throws {@code IllegalArgumentException}
     * 
     * @param numbers array of {@code int}, must be non-empty
     * @return sum of the elements of the array
     */
    public static int sumOfArray(int[] numbers) {

        if (numbers.length == 0) {
            throw (new IllegalArgumentException("Array must be non-empty, method sumOfArray class Sum"));
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
